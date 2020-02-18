package io.github.plindzek.fuelcost;

import io.github.plindzek.Trip;
import io.github.plindzek.car.Car;
import io.github.plindzek.util.AvgFuelPricesScrapper;

/**
 * @author Adam
 */
class OnCost implements FuelCost {

    private double onCost;

    @Override
    public double calculateFuelCost(Car car, Trip trip) {
        onCost =  (Math.round((car.getOnOn100Km() * AvgFuelPricesScrapper.getAvgOnPrice()* trip.getKmOnOn() / 100) * 100.0))
                / 100.0;
        return onCost;
    }




}
