package io.github.plindzek;

public class Trip {

    private double kmOnLpg, kmOnPb, kmOnOn;


    public double getKmOnLpg() {
        return kmOnLpg;
    }

     public void setKmOnLpg(double kmOnLpg) throws IllegalArgumentException {
        if (kmOnLpg < 0) {
            throw new IllegalArgumentException();
        } else {
            this.kmOnLpg = kmOnLpg;
        }

    }

    public double getKmOnPb() {
        return kmOnPb;
    }

    public void setKmOnPb(double kmOnPb) throws IllegalArgumentException {
        if (kmOnPb < 0) {
            throw new IllegalArgumentException();
        } else {
            this.kmOnPb = kmOnPb;
        }
    }

    public double getKmOnOn() {
        return kmOnOn;
    }

    public void setKmOnOn(double kmOnOn) throws IllegalArgumentException {
        if (kmOnOn < 0) {
            throw new IllegalArgumentException();
        } else {
            this.kmOnOn = kmOnOn;
        }
    }
}
