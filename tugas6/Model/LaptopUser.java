package Model;

import interfaces.Laptop;

public class LaptopUser {
    private Laptop laptop;

    public LaptopUser(Laptop laptop){
        this.laptop = laptop;
    }
    public void turnOnlaptop(){
        this.laptop.powerOn();
    }
    public void turnOfflaptop(){
        this.laptop.powerOff();
    }
    public void makeLaptopLouder(){
        this.laptop.volumeUp();
    }
    public void makeLaptopSilence(){
        this.laptop.volumeDown();
    }
}
