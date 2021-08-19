package com.codingdojo_phone;

public class Galaxy extends Phone implements Ringable {
    public Galaxy(String versionNumber, int batteryPercentage, String carrier, String ringTone) {
        super(versionNumber, batteryPercentage, carrier, ringTone);
    }
    @Override
    public String ring() {
    	return "Galaxy "+this.getVersionNumber()+" dice: "+this.getRingTone();
    }
    
    @Override
    public String unlock() {
    	return "unlocking via finger print";
    }
    @Override
    public void displayInfo() {
        System.out.println("IPhone "+this.getVersionNumber()+" from "+this.getCarrier());
    }
}
