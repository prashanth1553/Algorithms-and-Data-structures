package com.designpatterns.factory;

public class VehicleFactory {

	public static Vehicle getVehicle(VehicleType type) {

		switch (type) {
		case BIKE:
			return new Bike();
		case CAR:
			return new Car();

		}
		return null;
	}

	public static void main(String args[]) {

		Vehicle vehicle = getVehicle(VehicleType.BIKE);
		vehicle.drive();

		vehicle = getVehicle(VehicleType.CAR);
		vehicle.drive();

		vehicle = getVehicle(null);
		System.out.println(vehicle);
	}
}
