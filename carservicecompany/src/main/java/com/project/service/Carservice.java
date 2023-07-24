package com.project.service;

import java.util.List;
import com.project.entity.Car;

public interface Carservice {
	Car saveCar(Car car);
	List<Car> getAllCars();
	Car getCarById(long id);
	Car updateCar(Car car,long id);
	void deleteCar(long id);

}
