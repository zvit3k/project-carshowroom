package com.pawlak.classes;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class CarSalon {
	private Set<Car> cars;
	
	public CarSalon(List<Car> carList){
		Set<Car> cars = carList.stream().sorted((e1,e2)-> {return e1.getModel().compareTo(e2.getModel());}).collect(Collectors.toSet());
		this.cars=cars;
	}

	public Set<Car> getCars() {
		return cars;
	}

	public void setCars(Set<Car> cars) {
		this.cars = cars;
	}

	@Override
	public String toString() {
		return "CarSalon [cars=" + cars + "]";
	}
	
	
}
