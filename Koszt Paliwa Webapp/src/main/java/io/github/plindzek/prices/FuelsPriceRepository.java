package io.github.plindzek.prices;

import java.util.HashMap;

class FuelsPriceRepository {

    HashMap<String, String> prices;

    HashMap<String, String> getPrices() {
        prices = new HashMap<>();
        prices.put("lpgPrice", FuelsPriceScrapper.getAvgLpgPrice());
        prices.put("pbPrice", FuelsPriceScrapper.getAvgPbPrice());
        prices.put("pbPremiumPrice", FuelsPriceScrapper.getAvgPbPrice());
        prices.put("onPrice", FuelsPriceScrapper.getAvgOnPrice());
System.out.println(prices);
        return prices;
    }



}
