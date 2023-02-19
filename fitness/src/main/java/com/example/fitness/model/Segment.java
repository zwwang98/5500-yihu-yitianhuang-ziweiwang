package com.example.fitness.model;

public class Segment {

	String activity;
	String group;
	String manual;
	String startTimeX;
	String endTimeX;
	Double duration;
	Double distance;
	Double steps;
	Double calories;
	Integer activityId;
	String type;
	String startTimeY;
	String endTimeY;
	Integer place;
	String lastUpdate;
	Integer recordId;
	Integer segmentId;

	public Segment() {}

	private Segment(Builder builder) {
		this.activity = builder.activity;
		this.group = builder.group;
		this.manual = builder.manual;
		this.startTimeX = builder.startTimeX;
		this.endTimeX = builder.endTimeX;
		this.duration = builder.duration;
		this.distance = builder.distance;
		this.steps = builder.steps;
		this.calories = builder.calories;
		this.activityId = builder.activityId;
		this.type = builder.type;
		this.startTimeY = builder.startTimeY;
		this.endTimeY = builder.endTimeY;
		this.place = builder.place;
		this.lastUpdate = builder.lastUpdate;
		this.recordId = builder.recordId;
		this.segmentId = builder.segmentId;
	}

	public static class Builder {
		private String activity;
		private String group;
		private String manual;
		private String startTimeX;
		private String endTimeX;
		private Double duration;
		private Double distance;
		private Double steps;
		private Double calories;
		private Integer activityId;
		private String type;
		private String startTimeY;
		private String endTimeY;
		private Integer place;
		private String lastUpdate;
		private Integer recordId;
		private Integer segmentId;

		public Builder setActivity(String activity) {
			this.activity = activity;
			return this;
		}

		public Builder setGroup(String group) {
			this.group = group;
			return this;
		}

		public Builder setManual(String manual) {
			this.manual = manual;
			return this;
		}

		public Builder setStartTimeX(String startTimeX) {
			this.startTimeX = startTimeX;
			return this;
		}

		public Builder setEndTimeX(String endTimeX) {
			this.endTimeX = endTimeX;
			return this;
		}

		public Builder setDuration(Double duration) {
			this.duration = duration;
			return this;
		}

		public Builder setDistance(Double distance) {
			this.distance = distance;
			return this;
		}

		public Builder setSteps(Double steps) {
			this.steps = steps;
			return this;
		}

		public Builder setCalories(Double calories) {
			this.calories = calories;
			return this;
		}

		public Builder setActivityId(Integer activityId) {
			this.activityId = activityId;
			return this;
		}

		public Builder setType(String type) {
			this.type = type;
			return this;
		}

		public Builder setStartTimeY(String startTimeY) {
			this.startTimeY = startTimeY;
			return this;
		}

		public Builder setEndTimeY(String endTimeY) {
			this.endTimeY = endTimeY;
			return this;
		}

		public Builder setPlace(Integer place) {
			this.place = place;
			return this;
		}

		public Builder setLastUpdate(String lastUpdate) {
			this.lastUpdate = lastUpdate;
			return this;
		}

		public Builder setRecordId(Integer recordId) {
			this.recordId = recordId;
			return this;
		}

		public Builder setSegmentId(Integer segmentId) {
			this.segmentId = segmentId;
			return this;
		}

		public Segment build() {
			return new Segment(this);
		}

	}


}
