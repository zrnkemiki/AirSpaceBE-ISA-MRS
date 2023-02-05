package com.smv.AirSpace.dto;

import com.smv.AirSpace.model.Hotel;

public class HotelFrontDTO {

		private String name;
		private int stars;
		private String description;
		private String street;
		private String city;
		private String state;
		private double rating;
		
		
		public HotelFrontDTO(Hotel hotel) {
			this.name =  hotel.getName();
			this.stars = hotel.getStars();
			this.description = hotel.getDescription();
			this.street = hotel.getLocation().getAddress().getStreet();
			this.city = hotel.getLocation().getAddress().getCity();
			this.state = hotel.getLocation().getAddress().getState();
			this.rating = hotel.getRating();
			
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public int getStars() {
			return stars;
		}
		public void setStars(int stars) {
			this.stars = stars;
		}
		public String getDescription() {
			return description;
		}
		public void setDescription(String description) {
			this.description = description;
		}
		public String getStreet() {
			return street;
		}
		public void setStreet(String street) {
			this.street = street;
		}
		public String getCity() {
			return city;
		}
		public void setCity(String city) {
			this.city = city;
		}
		public String getState() {
			return state;
		}
		public void setState(String state) {
			this.state = state;
		}
		public double getRating() {
			return rating;
		}
		public void setRating(double rating) {
			this.rating = rating;
		}
		
		  

	}
