package com.project;


import java.util.List;
import java.util.Optional;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import com.project.entity.Car;
import com.project.repository.Carrepository;
@DataJpaTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@AutoConfigureTestDatabase
public class CaerepositoryTest {
	
	@Autowired
	private Carrepository carrepository;
	
	@Test
	@Order(1)
	@Rollback(value = false)
	
	public void saveCarTest() {
		Car car=new Car();
		car.setCar_make("maruti_suzuki");
		car.setModel_name("alto-800");
		car.setCar_registration_number("1234567");
		car.setCar_chassis_number(323232);
		car.setKnown_issue("wheelalignment");
		car.setCost(8000);
		//car.setGiven_date("2022-11-25T09:45:00.00");
		//car.setExpected_delivery_date("2022-11-25T09:45:00.00");
		//car.setCreated_date("2022-11-25T09:45:00.00");
		//car.setUpdated_date("2022-11-25T09:45:00.00");
		car.setAddress("Beed");
		car.setPhone_number(12345678);
		
		carrepository.save(null);
		Assertions.assertThat(car.getId()).isGreaterThan(1);
		
	}
	
	@Test
	@Order(2)
	@Rollback(value=false)
	public void getAllCarsTest() {
		List<Car> car = carrepository.findAll();
		Assertions.assertThat(car.size()).isGreaterThan(0);
	}
	
	@Test
	@Order(3)
	@Rollback(value=false)
	public void getCarByIdTest() {
	  Car car=carrepository.findById((long) 1).get();
	  Assertions.assertThat(car.getId()).isEqualTo(0);
	}
	
	@Test
	@Order(4)
	@Rollback(value=false)
	public void updateCarTest() {
		Car car = carrepository.findById((long) 1).get();
		car.setCar_make("maruti_suzuki");
		car.setModel_name("alto-800");
		car.setCar_registration_number("1234567");
		car.setCar_chassis_number(323232);
		car.setKnown_issue("wheelalignment");
		car.setCost(8000);
		//car.setGiven_date("2022-11-25T09:45:00.00");
		//car.setExpected_delivery_date("2022-11-25T09:45:00.00");
		//car.setCreated_date("2022-11-25T09:45:00.00");
		//car.setUpdated_date("2022-11-25T09:45:00.00");
		car.setAddress("Beed");
		car.setPhone_number(12345678);
		
		Car carUpdated= carrepository.save(car);
		Assertions.assertThat(carUpdated.getCar_make()).isEqualTo("maruti_suzuki");
		Assertions.assertThat(carUpdated.getModel_name()).isEqualTo("alto-800");
		Assertions.assertThat(carUpdated.getCar_registration_number()).isEqualTo("1234567");
		Assertions.assertThat(carUpdated.getCar_chassis_number()).isEqualTo(323232);
		Assertions.assertThat(carUpdated.getKnown_issue()).isEqualTo("323232");
		Assertions.assertThat(carUpdated.getCost()).isEqualTo(8000);
		//Assertions.assertThat(carUpdated.getGiven_date()).isEqualToIgnoringHours("2022-11-25T09:45:00.00");
		//Assertions.assertThat(carUpdated.getExpected_delivery_date()).isEqualToIgnoringHours("2022-11-25T09:45:00.00");
		//Assertions.assertThat(carUpdated.getCreated_date()).isEqualToIgnoringHours("2022-11-25T09:45:00.00");
		//Assertions.assertThat(carUpdated.getUpdated_date()).isEqualToIgnoringHours("2022-11-25T09:45:00.00");
		Assertions.assertThat(carUpdated.getAddress()).isEqualTo("Beed");
		Assertions.assertThat(carUpdated.getPhone_number()).isEqualTo(12345678);
	
	}
	@Test
	@Order(5)
	@Rollback(value=false)
	public void deleteCarTest() {
		Car car =carrepository.findById((long) 1).get();
		carrepository.delete(car);
		
		Car newCar = null;
		
		Optional<Car> caroptional= carrepository.findById((long) 1);
		
		if(caroptional.isPresent()) {
			newCar= caroptional.get();
		}
		Assertions.assertThat(newCar).isNull();
	}
	

}
