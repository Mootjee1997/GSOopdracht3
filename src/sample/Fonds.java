package sample;

import java.util.Random;
import java.util.Set;
import java.util.Timer;
import java.util.TimerTask;

public class Fonds implements IFonds  {

    private String naam;
    private double koers;
    private Random random = new Random();
    private Timer timer = new Timer();


    public Fonds(String naam, double koers) {
        this.naam = naam;
        this.koers = koers;
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                SetKoers();
            }
        },0,1500);
    }

    @Override
    public String getNaam() {
        return naam;
    }

    @Override
    public double getKoers() {
        return koers;
    }

    private double SetKoers(){
        return random.nextInt(100);
    }

    public String toString(){
        return naam +" "+ koers;
    }
}
