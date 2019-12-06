package consoleVersion;

public class FuelCost implements CostCalculator {

    public double calculateCost() {

	return (Math.round((lpgOn100km * lpgPrice * kmOnLPG / 100 + pb95On100km * pb95Price * kmOnPB95 / 100) * 1000.0))
		/ 1000.0;
    }

    double lpgOn100km, lpgPrice, kmOnLPG, pb95On100km, pb95Price, kmOnPB95;

    public double getLpgOn100km() {
	return lpgOn100km;
    }

    public void setLpgOn100km(double lpgOn100km) {
	this.lpgOn100km = lpgOn100km;
    }

    public double getLpgPrice() {
	return lpgPrice;
    }

    public void setLpgPrice(double lpgPrice) {
	this.lpgPrice = lpgPrice;
    }

    public double getKmOnLPG() {
	return kmOnLPG;
    }

    public void setKmOnLPG(double kmOnLPG) {
	this.kmOnLPG = kmOnLPG;
    }

    public double getPb95On100km() {
	return pb95On100km;
    }

    public void setPb95On100km(double pb95On100km) {
	this.pb95On100km = pb95On100km;
    }

    public double getPb95Price() {
	return pb95Price;
    }

    public void setPb95Price(double pb95Price) {
	this.pb95Price = pb95Price;
    }

    public double getKmOnPB95() {
	return kmOnPB95;
    }

    public void setKmOnPB95(double kmOnPB95) {
	this.kmOnPB95 = kmOnPB95;
    }
}
