package consoleVersion;

public class Trip {

    private double lpgOn100km, lpgPrice, kmOnLPG, pb95On100km, pb95Price, kmOnPB95;

    public double getLpgOn100km() {
	return lpgOn100km;
    }

    public void setLpgOn100km(double lpgOn100km) throws IllegalArgumentException {

	if (lpgOn100km < 0) {
	    throw new IllegalArgumentException();
	} else {
	    this.lpgOn100km = lpgOn100km;
	}
    }

    public double getLpgPrice() {
	return lpgPrice;
    }

    public void setLpgPrice(double lpgPrice) throws IllegalArgumentException{
	if (lpgPrice < 0) {
	    throw new IllegalArgumentException();
	} else {
	    this.lpgPrice = lpgPrice;
	}

    }

    public double getKmOnLPG() {
	return kmOnLPG;
    }

    public void setKmOnLPG(double kmOnLPG) throws IllegalArgumentException{
	if (kmOnLPG < 0) {
	    throw new IllegalArgumentException();
	} else {
	    this.kmOnLPG = kmOnLPG;
	}

    }

    public double getPb95On100km() {
	return pb95On100km;
    }

    public void setPb95On100km(double pb95On100km) throws IllegalArgumentException{
	if (pb95On100km < 0) {
	    throw new IllegalArgumentException();
	} else {
	    this.pb95On100km = pb95On100km;
	}
    }

    public double getPb95Price() {
	return pb95Price;
    }

    public void setPb95Price(double pb95Price) throws IllegalArgumentException{
	if (pb95Price < 0) {
	    throw new IllegalArgumentException();
	} else {
	    this.pb95Price = pb95Price;
	}
    }

    public double getKmOnPB95() {
	return kmOnPB95;
    }

    public void setKmOnPB95(double kmOnPB95) throws IllegalArgumentException{
	if (kmOnPB95 < 0) {
	    throw new IllegalArgumentException();
	} else {
	    this.kmOnPB95 = kmOnPB95;
	}
    }

}
