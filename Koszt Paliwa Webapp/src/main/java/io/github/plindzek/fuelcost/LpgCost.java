package io.github.plindzek.fuelcost;

import io.github.plindzek.car.Car;
import io.github.plindzek.Trip;
import io.github.plindzek.util.AvgFuelPricesScrapper;

/**
 * @author Adam
 */
class LpgCost implements FuelCost {

    private double lpgCost;

    @Override
    public double calculateFuelCost(Car car, Trip trip) {
        lpgCost =  (Math.round((car.getLpgOn100Km() * AvgFuelPricesScrapper.getAvgLpgPrice()* trip.getKmOnLpg() / 100) * 100.0))
                / 100.0;
        return lpgCost;
    }




}
