package com.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.project.entity.Car;
import com.project.service.Carservice;

@RestController
@RequestMapping("/carservice")
public class Carcontroller {
	@Autowired
	private Carservice carservice;

	// build create car REST API
	@PostMapping()
	public ResponseEntity<Car> saveCar(@RequestBody Car car){
		return new ResponseEntity<Car>(carservice.saveCar(car), HttpStatus.CREATED);
	}
	
	//build get all car REST API
	@GetMapping()
	public List<Car> getAllCars(){
	  return carservice.getAllCars();
		}
	
	//build get car by id REST API
	@GetMapping("{id}")
	public ResponseEntity<Car> getCarById(@PathVariable("id") long id){
		return new ResponseEntity<Car>(carservice.getCarById(id), HttpStatus.OK);
		}
	
	//build update REST API
	@PutMapping("{id}")
	public ResponseEntity<Car> updateCar(@PathVariable("id") long id,@RequestBody Car car){
		return new ResponseEntity<Car>(carservice.updateCar(car, id), HttpStatus.CREATED);
		}
	
	//build delete REST API
	@DeleteMapping("{id}")
	public ResponseEntity<String> deleteCar(@PathVariable("id") long id){
		carservice.deleteCar(id);
		return new ResponseEntity<String>("car details deleted succesfully",HttpStatus.ACCEPTED);
	}
	
	

}
