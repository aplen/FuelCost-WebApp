package io.github.plindzek.fuelcost;

import io.github.plindzek.car.Car;
import io.github.plindzek.Trip;

interface FuelCost {

    double calculateFuelCost(Car car, Trip trip);
}
