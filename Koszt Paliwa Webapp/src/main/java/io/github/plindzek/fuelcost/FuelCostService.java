package io.github.plindzek.fuelcost;

import io.github.plindzek.car.Car;

class FuelCostService {

    private FuelCost fuelCost;

    public double calcCost(Car car, Trip trip) {
        if (car.isOnPowered()) {
            fuelCost = new OnCost();
        } else {
            if (car.isLpgPowered()) {
                fuelCost = new LpgCost();
            } else {
                fuelCost = new PbCost();
            }
        }
        return fuelCost.calculateFuelCost(car, trip);
    }
}


