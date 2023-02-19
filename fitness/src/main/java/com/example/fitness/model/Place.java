package com.example.fitness.model;

public class Place {
	Integer id;
	String name;
	String type;
	String foursquareId;
	String lat;
	String lon;

	public Place() {}

	private Place(Builder builder) {
		this.id = builder.id;
		this.name = builder.name;
		this.type = builder.type;
		this.foursquareId = builder.foursquareId;
		this.lat = builder.lat;
		this.lon = builder.lon;
	}

	public static class Builder {
		private Integer id;
		private String name;
		private String type;
		private String foursquareId;
		private String lat;
		private String lon;
		public Builder setId(Integer id) {
			this.id = id;
			return this;
		}

		public Builder setName(String name) {
			this.name = name;
			return this;
		}

		public Builder setType(String type) {
			this.type = type;
			return this;
		}

		public Builder setFoursqaureId(String foursqaureId) {
			this.foursquareId = foursqaureId;
			return this;
		}

		public Builder setLat(String lat) {
			this.lat = lat;
			return this;
		}

		public Builder setLon(String lon) {
			this.lon = lon;
			return this;
		}

		public Place build() {
			return new Place(this);
		}
	}

}
