package sample;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.Timer;
import java.util.TimerTask;

public class AEXBanner extends Application {
    public static final int WIDTH = 1000;
    public static final int HEIGHT = 110;
    public static final int NANO_TICKS = 20000000;
    // FRAME_RATE = 1000000000/NANO_TICKS = 50;

    private Text text;
    private double textLength;
    private double textPosition;
    private Controller controller;
    private AnimationTimer animationTimer;

    @Override
    public void start(Stage primaryStage) throws Exception {
        controller = new Controller(this);

        Font font = new Font("Arial", HEIGHT-10);
        text = new Text();
        text.setFont(font);
        text.setFill(Color.WHEAT);

        Pane root = new Pane();
        root.getChildren().add(text);
        Scene scene = new Scene(root, WIDTH, HEIGHT);
        scene.setFill(Color.BLACK);

        primaryStage.setTitle("AEX banner");
        primaryStage.setScene(scene);
        primaryStage.show();
        primaryStage.toFront();


        // Start animation: text moves from right to left
        animationTimer = new AnimationTimer() {
            private long prevUpdate;

            @Override
            public void handle(long now) {
                long lag = now - prevUpdate;
                if (lag >= NANO_TICKS) {
                    // calculate new location of text
                    textPosition = textPosition - 8;
                    text.relocate(textPosition, 0);
                    prevUpdate = now;
                }
            }

            @Override
            public void start() {
                prevUpdate = System.nanoTime();
                textPosition = WIDTH;
                text.relocate(textPosition, 0);
                //setKoersen("Nothing to display");
                setKoersen(controller.updateKoersen());
                super.start();
            }
        };
        animationTimer.start();
    }

    public void setKoersen(String koersen) {
        text.setText(koersen);
        textLength = text.getLayoutBounds().getWidth();
    }

    @Override
    public void stop() throws InterruptedException {
        animationTimer.stop();
        controller.stop();
    }
}