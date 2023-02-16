import json
import pandas as pd

with open('storyline.json') as f:
    data = json.load(f)
data_df = pd.DataFrame(data)
data_df['record_id'] = data_df.reset_index().iloc[:, 0] + 1

########### process main primary key table
data_pk = data_df.iloc[:, [0, 3, 4, 5]]
# print(data_pk)
# [date, summary, segments, caloriesIdle, lastUpdate, record_id]

########### process summary column
dict_summary = []
for i in range(data_df.shape[0]):
    cur_dict = data_df.iloc[i,1]
    if not cur_dict or len(cur_dict) == 0:
        continue
    for j in range(len(cur_dict)):
        cur_dict[j]["record_id"] = data_df.iloc[i,5]
        dict_summary.append(cur_dict[j])
data_summary = pd.DataFrame(dict_summary)
# print(data_summary)

########### process segment column
dict_segment = []
dict_place = []

for i in range(data_df.shape[0]):
    cur_dict = data_df.iloc[i,2]
    if not cur_dict or len(cur_dict) == 0:
        continue

    for j in range(len(cur_dict)):
        cur_dict[j]["record_id"] = data_df.iloc[i,5]
        cur_dict[j]["segment_id"] = j
        
        # create place table
        if "place" in cur_dict[j]:
            if type(cur_dict[j]["place"]) == dict:
                dict_place.append(cur_dict[j]["place"])
                cur_dict[j]["place"] = str(cur_dict[j]["place"]['id'])

        dict_segment.append(cur_dict[j])
        
data_segment = pd.DataFrame(dict_segment)
data_place = pd.DataFrame(dict_place)

# print(data_segment)
# print(data_place)

########### process activity table
dict_activity = []
dict_segment_update = []
for i in range(data_segment.shape[0]):
    if data_segment.loc[i, "activities"] and type(data_segment.loc[i, "activities"]) != float:
        for j in data_segment.loc[i, "activities"]:
            cur_loc = len(dict_activity) + 1
            j["activity_id"] = cur_loc
            dict_activity.append(j)
            
            # change activity column in segment table
            segment_copy = data_segment.loc[i].to_dict()
            segment_copy["activity_id"] = cur_loc
            dict_segment_update.append(segment_copy)
            
data_activity = pd.DataFrame(dict_activity)
# print(data_activity)
data_segment = pd.DataFrame(dict_segment_update)

# merge segment table and activity table by activity_id
merged_segment_activity = pd.merge(data_activity, data_segment, on='activity_id')
merged_segment_activity = merged_segment_activity.drop('activities', axis=1)
merged_segment_activity = merged_segment_activity.drop('trackPoints', axis=1)

########### process place table
data_place['lat'] = ''
data_place['lon'] = ''

for i in range(data_place.shape[0]):
    cur_location = data_place.loc[i, 'location']
    if 'lat' in cur_location and 'lon' in cur_location:
        data_place.loc[i, 'lat'] = cur_location['lat']
        data_place.loc[i, 'lon'] = cur_location['lon']
        
data_place = data_place.drop('location', axis=1)
data_place = data_place.drop('foursquareCategoryIds', axis=1)
data_place = data_place.drop('facebookPlaceId', axis=1)

########### save only useful table
# data_pk, data_summary, merged_segment_activity, data_place, 
data_pk.to_csv('main.csv', index=False)
data_summary.to_csv('summary.csv', index=False)
merged_segment_activity.to_csv('segment.csv', index=False)
data_place.to_csv('place.csv', index=False)
