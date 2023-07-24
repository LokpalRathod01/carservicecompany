package com.project.entity;

import java.sql.Date;
import java.sql.Timestamp;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Car {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
  private long id;
  private String car_make;
  private String model_name;
  private String car_registration_number;
  private double car_chassis_number;
  private String known_issue;
  private long cost;
  private Timestamp given_date;
  private Date expected_delivery_date;
  private Timestamp created_date;
  private Timestamp updated_date;
  private String address;
  private int phone_number;
  
public Car(long id, String car_make, String model_name, String car_registration_number, double car_chassis_number,
		String known_issue, long cost, Timestamp given_date, Date expected_delivery_date, Timestamp created_date,
		Timestamp updated_date, String address, int phone_number) {
	super();
	this.id = id;
	this.car_make = car_make;
	this.model_name = model_name;
	this.car_registration_number = car_registration_number;
	this.car_chassis_number = car_chassis_number;
	this.known_issue = known_issue;
	this.cost = cost;
	this.given_date = given_date;
	this.expected_delivery_date = expected_delivery_date;
	this.created_date = created_date;
	this.updated_date = updated_date;
	this.address = address;
	this.phone_number = phone_number;
}


public Car() {
	super();
}


public long getId() {
	return id;
}
public void setId(long id) {
	this.id = id;
}
public String getCar_make() {
	return car_make;
}
public void setCar_make(String car_make) {
	this.car_make = car_make;
}
public String getModel_name() {
	return model_name;
}
public void setModel_name(String model_name) {
	this.model_name = model_name;
}
public String getCar_registration_number() {
	return car_registration_number;
}
public void setCar_registration_number(String car_registration_number) {
	this.car_registration_number = car_registration_number;
}
public double getCar_chassis_number() {
	return car_chassis_number;
}
public void setCar_chassis_number(double car_chassis_number) {
	this.car_chassis_number = car_chassis_number;
}
public String getKnown_issue() {
	return known_issue;
}
public void setKnown_issue(String known_issue) {
	this.known_issue = known_issue;
}
public long getCost() {
	return cost;
}
public void setCost(long cost) {
	this.cost = cost;
}
public Timestamp getGiven_date() {
	return given_date;
}
public void setGiven_date(Timestamp given_date) {
	this.given_date = given_date;
}
public Date getExpected_delivery_date() {
	return expected_delivery_date;
}
public void setExpected_delivery_date(Date expected_delivery_date) {
	this.expected_delivery_date = expected_delivery_date;
}
public Timestamp getCreated_date() {
	return created_date;
}
public void setCreated_date(Timestamp created_date) {
	this.created_date = created_date;
}
public Timestamp getUpdated_date() {
	return updated_date;
}
public void setUpdated_date(Timestamp updated_date) {
	this.updated_date = updated_date;
}
public String getAddress() {
	return address;
}
public void setAddress(String address) {
	this.address = address;
}
public int getPhone_number() {
	return phone_number;
}
public void setPhone_number(int phone_number) {
	this.phone_number = phone_number;
}
  
}
