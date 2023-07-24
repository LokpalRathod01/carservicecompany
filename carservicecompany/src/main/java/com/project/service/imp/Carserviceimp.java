package com.project.service.imp;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.project.entity.Car;
import com.project.exception.ResourcesNotFoundException;
import com.project.repository.Carrepository;
import com.project.service.Carservice;

@Service
public class Carserviceimp implements Carservice {
	
	@Autowired
   private Carrepository carrepository;
   
	
	@Override
	public Car saveCar(Car car) {
		return carrepository.save(car);
	}

	@Override
	public List<Car> getAllCars() {
		return carrepository.findAll();
	}

	@Override
	public Car getCarById(long id) {
//		Optional<Car> car = carrepository.findById(id);
//		if(car.isPresent()){
//			return car.get();
//		}
//		else{
//			throw new ResourcesNotFoundException("Car","id",id);
//		}

		return carrepository.findById(id).orElseThrow(()->
		new ResourcesNotFoundException("Car","id",id));
	}

	@Override
	public Car updateCar(Car car, long id) {
		Car existingCar=carrepository.findById(id).orElseThrow(()->
		new ResourcesNotFoundException("Car","id",id));
		existingCar.setCar_make(car.getCar_make());
		existingCar.setModel_name(car.getModel_name());
		existingCar.setCar_registration_number(car.getCar_registration_number());
		existingCar.setCar_chassis_number(car.getCar_chassis_number());
		existingCar.setKnown_issue(car.getKnown_issue());
		existingCar.setCost(car.getCost());
		existingCar.setGiven_date(car.getGiven_date());
		existingCar.setExpected_delivery_date(car.getExpected_delivery_date());
		existingCar.setCreated_date(car.getCreated_date());
		existingCar.setUpdated_date(car.getUpdated_date());
		existingCar.setAddress(car.getAddress());
		existingCar.setPhone_number(car.getPhone_number());
		carrepository.save(existingCar);
		return existingCar;
	}

	@Override
	public void deleteCar(long id) {
		carrepository.findById(id).orElseThrow(()-> 
		new ResourcesNotFoundException("Car","id",id));
		carrepository.deleteById(id);
		
	}
	
	
	

}
