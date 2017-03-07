package com.pawlak.main;

import java.io.File;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.EnumSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.function.Predicate;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import com.pawlak.classes.CARRIAGETYPE;
import com.pawlak.classes.Car;
import com.pawlak.classes.CarSalon;
import com.pawlak.classes.ENGINETYPE;
import com.pawlak.classes.EQUIPMENT;

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
		filterByUserConfiguration(salon.getCars()).forEach(System.out::println);
		;
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

		String patternForDouble = "[0-9]+(\\.){0,1}[0-9]*";
		System.out.println("Enter the minimum price:");
		String minPriceStr = sc.next();
		while (!Pattern.matches(patternForDouble, minPriceStr)) {
			System.out.println("Wrong price, please try again. Example: '35000'.");
			minPriceStr = sc.next();
		}
		double minPrice = Double.parseDouble(minPriceStr);

		System.out.println("Enter the maximum price:");
		String maxPriceStr = sc.next();
		while (!Pattern.matches(patternForDouble, maxPriceStr) || Double.valueOf(maxPriceStr) < minPrice) {
			System.out.println("Wrong price, please try again. Example '60000' and must be higher than minimum price.");
			maxPriceStr = sc.next();
		}
		double maxPrice = Double.parseDouble(maxPriceStr);

		System.out.println("Enter the engine type: PETROL or DIESEL");
		String engineType = sc.next();
		while (!engineType.equals("PETROL") && !engineType.equals("DIESEL")) {
			System.out.println("Wrong engine type, please try again. Choose between PETROL or DIESEL.");
			engineType = sc.next();
		}
		System.out.println("Enter the minimum engine capacity: ");
		String minEngineCapacityStr = sc.next();
		while (!Pattern.matches(patternForDouble, minEngineCapacityStr)) {
			System.out.println("Wrong engine capacity, please try again. Example: '1.5' or '2'.");
			minEngineCapacityStr = sc.next();
		}
		double minEngineCapacity = Double.parseDouble(minEngineCapacityStr);

		System.out.println("Enter the maximum engine capacity: ");
		String maxEngineCapacityStr = sc.next();
		while (!Pattern.matches(patternForDouble, maxEngineCapacityStr)
				|| Double.valueOf(maxEngineCapacityStr)<minEngineCapacity) {
			System.out.println(
					"Wrong engine capacity, please try again. Example: '1.5' or '2' and must be higher than minimum capacity.");
			maxEngineCapacityStr = sc.next();
		}
		double maxEngineCapacity = Double.parseDouble(maxEngineCapacityStr);
		System.out.println("Available equipment:");
		List<EQUIPMENT> equipmentList = new ArrayList<EQUIPMENT>(EnumSet.allOf(EQUIPMENT.class));
		equipmentList.forEach(System.out::println);
		
		System.out.println("Enter the required equipment: ");
		String equipment = sc.next();

		sc.close();

		List<Car> filteredByUserChoice = cars.stream()
				.filter(e -> e.getBasicPrice() > minPrice && e.getBasicPrice() < maxPrice)
				.filter(e -> {
					ENGINETYPE type = null;
					if (e.getEngine().getType().toString().equals("DIESEL")) {
						type = ENGINETYPE.DIESEL;
					} else if (e.getEngine().getType().toString().equals("PETROL")) {
						type = ENGINETYPE.PETROL;
					}
					return e.getEngine().getType() == type;
				})
				.filter(e -> e.getEngine().getEngineCapacity() > minEngineCapacity
						&& e.getEngine().getEngineCapacity() < maxEngineCapacity)
				.filter(e -> {
					for (EQUIPMENT equip : e.getCarriage().getEquipment()) {
						if (equipment.equals(equip.toString())) {
							return true;
						}
					}
					return false;})
				.collect(Collectors.toList());

		if (filteredByUserChoice.isEmpty()) {
			System.out.println("There are no cars which match your criteria.");
		}
		return filteredByUserChoice;

	}

}
