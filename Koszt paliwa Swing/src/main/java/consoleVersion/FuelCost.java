package consoleVersion;

public class FuelCost {


    private double cost;
    public double getCost() {
        return cost;
    }
    public void setCost(double cost) {
        this.cost = cost;
    }

    /**
     * oblicza i zwraca koszt paliwa dla obiektu klasy Trip
     * 
     * @return cost
     */
    public  double calculateFuelCost(Trip trip) {
	cost =  (Math.round((trip.getLpgOn100km() *trip.getLpgPrice()* trip.getKmOnLPG() / 100 + trip.getPb95On100km() * trip.getPb95Price()
		* trip.getKmOnPB95() / 100) * 100.0))
		/ 100.0;
	
	return cost;
    }

    
}
