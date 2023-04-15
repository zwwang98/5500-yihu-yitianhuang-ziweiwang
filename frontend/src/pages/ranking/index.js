import React from "react";
import Tabs from "@mui/material/Tabs";
import Tab from "@mui/material/Tab";
import Box from "@mui/material/Box";
import { TabPanel, a11yProps } from "../tabs/index.js";
import RankActivityByFreq from "./rank-activity-by-freq.js";
import RankActivityByCalories from "./rank-activity-by-calories.js";
import RankLocation from "./rank-location.js";

const Ranking = () => {
  const [value, setValue] = React.useState(0);
  const handleChange = (event, newValue) => {
    setValue(newValue);
  };

  return (
    <>
      <h1>Ranking</h1>
      <Box sx={{ width: "100%" }}>
        <Box sx={{ borderBottom: 1, borderColor: "divider" }}>
          <Tabs
            value={value}
            onChange={handleChange}
            aria-label="basic tabs example"
          >
            <Tab label="Frequency" {...a11yProps(0)} />
            <Tab label="Calories" {...a11yProps(1)} />
            <Tab label="Location" {...a11yProps(2)} />
          </Tabs>
        </Box>
        <TabPanel value={value} index={0}>
          <RankActivityByFreq />
        </TabPanel>
        <TabPanel value={value} index={1}>
          <RankActivityByCalories />
        </TabPanel>
        <TabPanel value={value} index={2}>
          <RankLocation />
        </TabPanel>
      </Box>
    </>
  );
};

export default Ranking;
