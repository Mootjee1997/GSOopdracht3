package sample;
import java.util.Timer;

public class Controller {
    private AEXBanner banner;
    private IEffectenBeurs effectenbeurs;
    private Timer pollingTimer;

    public Controller(AEXBanner banner) throws InterruptedException {
        this.banner = banner;
        this.effectenbeurs = new MockEffectenBeurs();

        // Start polling timer: update banner every two seconds
        pollingTimer = new Timer();
        banner.setKoersen(effectenbeurs.getKoersen().toString());
        pollingTimer.wait(2000);
    }

    // Stop banner controller
    public void stop() throws InterruptedException {
        pollingTimer.cancel();
        // Stop simulation timer of Effectenbeurs
        effectenbeurs.wait();
    }

}
