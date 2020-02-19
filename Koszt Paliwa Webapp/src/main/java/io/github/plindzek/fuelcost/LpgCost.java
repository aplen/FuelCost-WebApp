package io.github.plindzek.fuelcost;

import io.github.plindzek.car.Car;
import io.github.plindzek.util.AvgFuelPricesScrapper;

/**
 * @author Adam
 */
class LpgCost implements FuelCost {

    @Override
    public double calculateFuelCost(Car car, Trip trip) {
       return  ((Math.round((car.getLpgOn100Km() * AvgFuelPricesScrapper.getAvgLpgPrice()* trip.getKmOnLpg() / 100) * 100.0))
       + (Math.round((car.getPbOn100Km() * AvgFuelPricesScrapper.getAvgPbPrice()* trip.getKmOnPb() / 100) * 100.0)))
                / 100.0;
    }
}
