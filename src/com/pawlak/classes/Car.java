package com.pawlak.classes;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Car {
	private String model;
	private double basicPrice;
	private Engine engine;
	private Wheel wheel;
	private Carriage carriage;

	public Car() {

	}

	public Car(String fileName) {
		File file = new File(fileName);
		List<String> car = new ArrayList<>();
		try {
			Scanner scanner = new Scanner(file);
			while (scanner.hasNext()) {
				car.add(scanner.nextLine());

			}
			scanner.close();
			for (int i = 0; i < car.size(); i++) {
				if (i == 0) {

					String[] tab = car.get(i).split(" ");
					this.model = tab[0];
					this.basicPrice = Double.parseDouble(tab[1]);
				} else if (i == 1) {
					String[] tab = car.get(i).split(" ");
					Engine engine = new Engine();
					if (tab[0].equals("DIESEL")) {
						engine.setType(ENGINETYPE.DIESEL);
					} else if (tab[0].equals("PETROL")) {
						engine.setType(ENGINETYPE.PETROL);
					}

					engine.setEngineCapacity(Double.parseDouble(tab[1]));
					engine.setFuelConsumption(0.0);
					this.engine = engine;

				} else if (i == 2) {
					String [] tab = car.get(i).split(" ");
					Carriage carriage = new Carriage();
					if(tab[0].equals("BLACK")){
						carriage.setColor(COLOR.BLACK);
					} else if(tab[0].equals("SILVER")){
						carriage.setColor(COLOR.SILVER);
					}else if(tab[0].equals("WHITE")){
						carriage.setColor(COLOR.WHITE);
					}else if(tab[0].equals("RED")){
						carriage.setColor(COLOR.RED);
					}else if(tab[0].equals("BLUE")){
						carriage.setColor(COLOR.BLUE);
					}else if(tab[0].equals("GREEN")){
						carriage.setColor(COLOR.GREEN);
					}
					
					if(tab[1].equals("SEDAN")){
						carriage.setType(CARRIAGETYPE.SEDAN);
					}else if(tab[1].equals("HATCHBACK")){
						carriage.setType(CARRIAGETYPE.HATCHBACK);
					}else if(tab[1].equals("WAGON")){
						carriage.setType(CARRIAGETYPE.WAGON);
					}
					String [] equipmentTemp = tab[2].split(";");
					List<EQUIPMENT> equipment = new ArrayList<>();
					for(int k=0;k<equipmentTemp.length;k++){
						if(equipmentTemp[k].equals("AIR_CONDITIONING")){
							equipment.add(EQUIPMENT.AIR_CONDITIONING);
						} else if(equipmentTemp[k].equals("ALARM")){
							equipment.add(EQUIPMENT.ALARM);
						} else if(equipmentTemp[k].equals("AUDIO")){
							equipment.add(EQUIPMENT.AUDIO);
						}else if(equipmentTemp[k].equals("ANTIFOG_LIGHTS")){
							equipment.add(EQUIPMENT.ANTIFOG_LIGHTS);
						}else if(equipmentTemp[k].equals("BACKDOOR")){
							equipment.add(EQUIPMENT.BACKDOOR);
						}else if(equipmentTemp[k].equals("ELECTRIC_MIRRORS")){
							equipment.add(EQUIPMENT.ELECTRIC_MIRRORS);
						}else if(equipmentTemp[k].equals("ELECTRIC_WINDSHIELD")){
							equipment.add(EQUIPMENT.ELECTRIC_WINDSHIELD);
						}else if(equipmentTemp[k].equals("LEATHER")){
							equipment.add(EQUIPMENT.LEATHER);
						}
					}
					carriage.setEquipment(equipment);
					this.carriage=carriage;
					
				} else if (i == 3) {
					String [] tab = car.get(i).split(" ");
					Wheel wheel = new Wheel();
					wheel.setProducer(tab[0]);
					wheel.setSize(Integer.parseInt(tab[1]));
					if(tab[2].equals("WINTER")){
						wheel.setTire(TIRETYPE.WINTER);
					}else if(tab[2].equals("SUMMER")){
						wheel.setTire(TIRETYPE.SUMMER);
					}
					
					this.wheel=wheel;
				}
			}

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			
		}

	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public double getBasicPrice() {
		return basicPrice;
	}

	public void setBasicPrice(double basicPrice) {
		this.basicPrice = basicPrice;
	}

	public Engine getEngine() {
		return engine;
	}

	public void setEngine(Engine engine) {
		this.engine = engine;
	}

	public Wheel getWheel() {
		return wheel;
	}

	public void setWheel(Wheel wheel) {
		this.wheel = wheel;
	}

	public Carriage getCarriage() {
		return carriage;
	}

	public void setCarriage(Carriage carriage) {
		this.carriage = carriage;
	}

	@Override
	public String toString() {
		return "Car [model=" + model + ", basicPrice=" + basicPrice + ", engine=" + engine + ", wheel=" + wheel
				+ ", carriage=" + carriage + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(basicPrice);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((carriage == null) ? 0 : carriage.hashCode());
		result = prime * result + ((engine == null) ? 0 : engine.hashCode());
		result = prime * result + ((model == null) ? 0 : model.hashCode());
		result = prime * result + ((wheel == null) ? 0 : wheel.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Car other = (Car) obj;
		if (Double.doubleToLongBits(basicPrice) != Double.doubleToLongBits(other.basicPrice))
			return false;
		if (carriage == null) {
			if (other.carriage != null)
				return false;
		} else if (!carriage.equals(other.carriage))
			return false;
		if (engine == null) {
			if (other.engine != null)
				return false;
		} else if (!engine.equals(other.engine))
			return false;
		if (model == null) {
			if (other.model != null)
				return false;
		} else if (!model.equals(other.model))
			return false;
		if (wheel == null) {
			if (other.wheel != null)
				return false;
		} else if (!wheel.equals(other.wheel))
			return false;
		return true;
	}

}
