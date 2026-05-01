package Model;
import interfaces.Laptop;

public class Toshiba implements Laptop {
    private int volume;
    boolean is_powe_on;

    public Toshiba(){
        this.volume = 50;
    }

    @Override
    public void powerOn(){
        is_powe_on = true;
        System.out.println("laptop is on");
        System.out.println("toshiba");
    }
    @Override
    public void powerOff(){
        is_powe_on = false;
        System.out.println("shutdowm is process...");
    }
    @Override
    public void volumeUp(){
        if(is_powe_on){
            if(this.volume == MAX_VOL){
                System.out.println("VOLUME IS FULL");
            }else{
                this.volume += 10;
                System.out.println("volume is : " + this.getVolume());
            }
        }
    }
    @Override 
    public void volumeDown(){
        if(is_powe_on){
            if(this.volume == MIN_VOL){
                System.out.println("volume is 0%");
            }else{
                this.volume -= 10;
                System.out.println("volume is : " + this.getVolume());
            }
        }
    }
    public int getVolume(){
        return this.volume;
    }
}
