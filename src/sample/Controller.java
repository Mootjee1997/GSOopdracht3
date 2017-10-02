package sample;
import java.util.Timer;
import java.util.TimerTask;

public class Controller {
    private AEXBanner banner;

    public IEffectenBeurs getEffectenbeurs() {
        return effectenbeurs;
    }

    private IEffectenBeurs effectenbeurs;
    private Timer pollingTimer;

    public Controller(AEXBanner banner) throws Exception {
        this.banner = banner;
        this.effectenbeurs = new MockEffectenBeurs();

        // Start polling timer: update banner every two seconds
        pollingTimer = new Timer();
        pollingTimer.schedule(new TimerTask() {
            @Override
            public void run() {
                //TODO: Gets and Sets the new banner.
                updateKoersen();
            }
        },0,2000);
    }

    public String updateKoersen(){
        return effectenbeurs.getKoersen().toString();
    }

    // Stop banner controller
    public void stop() throws InterruptedException {
        pollingTimer.cancel();
        // Stop simulation timer of Effectenbeurs
        // effectenbeurs.wait();
    }

}
