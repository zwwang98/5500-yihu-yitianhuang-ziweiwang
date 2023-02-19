package com.example.fitness.model;

public class Summary {

	String activity;
	String group;
	Double duration;
	Double distance;
	Double steps;
	Double calories;
	Integer recordId;

	public Summary() {
	}

	private Summary(Builder builder) {
		this.activity = builder.activity;
		this.group = builder.group;
		this.duration = builder.duration;
		this.distance = builder.distance;
		this.steps = builder.steps;
		this.calories = builder.calories;
		this.recordId = builder.recordId;
	}

	public static class Builder {
		private String activity;
		private String group;
		private Double duration;
		private Double distance;
		private Double steps;
		private Double calories;
		private Integer recordId;

		public Builder setActivity(String activity) {
			this.activity = activity;
			return this;
		}

		public Builder setGroup(String group) {
			this.group = group;
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

		public Builder setRecordId(Integer recordId) {
			this.recordId = recordId;
			return this;
		}

		public Summary build() {
			return new Summary(this);
		}


	}

}
