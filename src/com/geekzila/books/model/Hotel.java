package com.geekzila.books.model;

public class Hotel extends BaseEntity {

	private String name;
	private String numberOfRooms;
	private String address;
	private Double price;

	/**
	 * @param name
	 * @param numberOfRooms
	 * @param address
	 * @param price
	 */
	public Hotel(String name, String numberOfRooms, String address, Double price) {
		super();
		this.name = name;
		this.numberOfRooms = numberOfRooms;
		this.address = address;
		this.price = price;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the numberOfRooms
	 */
	public String getNumberOfRooms() {
		return numberOfRooms;
	}

	/**
	 * @param numberOfRooms the numberOfRooms to set
	 */
	public void setNumberOfRooms(String numberOfRooms) {
		this.numberOfRooms = numberOfRooms;
	}

	/**
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * @param address the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * @return the price
	 */
	public Double getPrice() {
		return price;
	}

	/**
	 * @param price the price to set
	 */
	public void setPrice(Double price) {
		this.price = price;
	}

}