package io.github.plindzek.fuelcost;

import io.github.plindzek.Trip;
import io.github.plindzek.car.Car;

class FuelCostService {
Car car;
Trip Trip;
    private FuelCost fuelCost;

    FuelCostService() {
           }

    double calcCost() {

            if (car.isLpgPowered()) {
               fuelCost= new LpgCost();
            } else if (car.getOnOn100Km() > 0) {
                fuelCost = new OnCost();
            } else fuelCost =  new PbCost();
        };}

}
