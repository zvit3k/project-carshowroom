package com.pawlak.main;

import java.io.File;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import com.pawlak.classes.CARRIAGETYPE;
import com.pawlak.classes.Car;
import com.pawlak.classes.CarSalon;
import com.pawlak.classes.ENGINETYPE;

public class Main {

	public static void main(String[] args) {
		// Car c1 = new Car("c:/files/cars1.txt");
		List<String> filePathList = getCarsFromFiles(4);
		List<Car> carsFromFiles = new ArrayList<>();

		for (int i = 0; i < filePathList.size(); i++) {
			carsFromFiles.add(new Car(filePathList.get(i)));
		}

		CarSalon salon = new CarSalon(carsFromFiles);

		// sortByPrice(salon.getCars()).forEach(System.out::println);
		// sortByModel(salon.getCars()).forEach(System.out::println);
		// sortByColor(salon.getCars()).forEach(System.out::println);
		// sortByCarriage(salon.getCars()).forEach(System.out::println);
		// filterByCarriageAndPrice(salon.getCars(), CARRIAGETYPE.HATCHBACK, 0,
		// 100000).forEach(System.out::println);
		// filterByFuel(salon.getCars(),
		// ENGINETYPE.DIESEL).forEach(System.out::println);
		salon.getCars().forEach(System.out::println);
		System.out.println("--------------");

	}

	public static List<String> getCarsFromFiles(int files) {
		List<String> cars = new ArrayList<>();
		for (int i = 0; i < files; i++) {
			File f = new File("c:/files/car" + i + ".txt");
			cars.add(f.getPath());
		}
		return cars;
	}

	public static List<Car> sortByPrice(Set<Car> cars) {
		List<Car> sortedByPrice = cars.stream().sorted((p1, p2) -> {
			return Double.compare(p1.getBasicPrice(), p2.getBasicPrice());
		}).collect(Collectors.toList());
		return sortedByPrice;
	}

	public static List<Car> sortByModel(Set<Car> cars) {

		Comparator<Car> sortingByModel = new Comparator<Car>() {

			@Override
			public int compare(Car c1, Car c2) {
				return c1.getModel().compareTo(c2.getModel());
			}
		};

		List<Car> sortedByModel = cars.stream().sorted(sortingByModel).collect(Collectors.toList());

		return sortedByModel;

	}

	public static List<Car> sortByColor(Set<Car> cars) {
		Comparator<Car> sortingByColor = new Comparator<Car>() {

			@Override
			public int compare(Car c1, Car c2) {
				return c2.getCarriage().getColor().compareTo(c1.getCarriage().getColor());
			}
		};

		List<Car> sortedByColor = cars.stream().sorted(sortingByColor).collect(Collectors.toList());

		return sortedByColor;

	}

	public static List<Car> sortByCarriage(Set<Car> cars) {
		Comparator<Car> sortingByCarriage = new Comparator<Car>() {

			@Override
			public int compare(Car c1, Car c2) {
				return c2.getCarriage().getType().compareTo(c1.getCarriage().getType());
			}
		};

		List<Car> sortedByCarriage = cars.stream().sorted(sortingByCarriage).collect(Collectors.toList());

		return sortedByCarriage;

	}

	public static List<Car> filterByCarriageAndPrice(Set<Car> cars, CARRIAGETYPE type, double minPrice,
			double maxPrice) {

		Predicate<Car> carriageType = new Predicate<Car>() {

			@Override
			public boolean test(Car c) {
				return c.getCarriage().getType() == type;
			}
		};

		Predicate<Car> price = new Predicate<Car>() {

			@Override
			public boolean test(Car c) {
				return c.getBasicPrice() > minPrice && c.getBasicPrice() < maxPrice;
			}

		};
		List<Car> filteredByCarriageAndPrice = cars.stream().filter(carriageType).filter(price)
				.collect(Collectors.toList());

		return filteredByCarriageAndPrice;

	}

	public static List<Car> filterByFuel(Set<Car> cars, ENGINETYPE type) {

		Predicate<Car> fuel = new Predicate<Car>() {

			@Override
			public boolean test(Car c) {
				return c.getEngine().getType() == type;
			}

		};
		List<Car> filteredByFuel = cars.stream().filter(fuel).collect(Collectors.toList());

		return filteredByFuel;

	}

	public static List<Car> filterByUserConfiguration(Set<Car> cars) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the minimum price:");
		double minPrice = sc.nextDouble();
		sc.nextLine();
		System.out.println("Enter the maximum price:");
		double maxPrice = sc.nextDouble();
		sc.nextLine();
		System.out.println("Enter the engine type: PETROL/DIESEL");
		String engineType = sc.nextLine();
		System.out.println("Enter the minimum engine capacity: ");
		double minEngineCapacity = sc.nextDouble();
		sc.nextLine();
		System.out.println("Enter the maximum engine capacity: ");
		double maxEngineCapacity = sc.nextDouble();
		sc.nextLine();
		System.out.println("Enter the required equipment: ");
		String equipment = sc.nextLine();
		sc.close();
		
		Predicate<Car> pricePred = (Car c)-> c.getBasicPrice()>minPrice && c.getBasicPrice()<maxPrice;
		Predicate<Car> enginePred = new Predicate<Car>(){

			@Override
			public boolean test(Car c) {
				
				return false;
			}
			
		};
			
		return null;

	}

}
