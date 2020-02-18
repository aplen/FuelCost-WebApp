package io.github.plindzek.fuelcost;

import io.github.plindzek.Trip;
import io.github.plindzek.car.Car;
import io.github.plindzek.util.AvgFuelPricesScrapper;

/**
 * @author Adam
 */
class PbCost implements FuelCost {

    private double pbCost;

    @Override
    public double calculateFuelCost(Car car, Trip trip) {

        pbCost =  (Math.round((car.getPbOn100Km() * AvgFuelPricesScrapper.getAvgPbPrice()* trip.getKmOnPb() / 100) * 100.0))
                / 100.0;

        return pbCost;
    }




}
