package com.codingdojo_phone;

public class Iphone extends Phone implements Ringable {
    public Iphone(String versionNumber, int batteryPercentage, String carrier, String ringTone) {
        super(versionNumber, batteryPercentage, carrier, ringTone);
    }
    @Override
    public String ring() {
    	return "IPhone "+this.getVersionNumber()+" dice: "+this.getRingTone();
    }
    
    @Override
    public String unlock() {
    	return "unlocking via facial recognition";
    }
    @Override
    public void displayInfo() {
        System.out.println("IPhone "+this.getVersionNumber()+" from "+this.getCarrier());
    }
}
