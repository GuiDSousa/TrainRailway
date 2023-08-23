package controller;

import javafx.animation.AnimationTimer;
import javafx.scene.control.Slider;
import model.Train;
import view.TrainView;

public class TrainController {
    private Train trainLaranja;
    private Train trainAzul;
    private AnimationTimer animationTimer;
    private Slider speedSliderLaranja;
    private Slider speedSliderAzul;
    private TrainView trainView; // Adicione a referência à TrainView

    private final double INITIAL_X_LARANJA = 246;
    private final double INITIAL_Y_LARANJA = 604;
    private final double INITIAL_X_AZUL = 369;
    private final double INITIAL_Y_AZUL = 604;

    public TrainController(Train trainLaranja, Train trainAzul, Slider speedSliderLaranja, Slider speedSliderAzul) {
        this.trainLaranja = trainLaranja;
        this.trainAzul = trainAzul;
        this.speedSliderLaranja = speedSliderLaranja;
        this.speedSliderAzul = speedSliderAzul;

        setupAnimation();
    }

    public void setTrainView(TrainView trainView) {
        this.trainView = trainView;
    }

    private void setupAnimation() {
        animationTimer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                try {
                    double laranjaSpeed = speedSliderLaranja.getValue();
                    double azulSpeed = speedSliderAzul.getValue();
    
                    /*
                     * Atualizar a velocidade dos trens com base nos sliders
                     */
                    trainLaranja.setTrainSpeed(laranjaSpeed);
                    trainAzul.setTrainSpeed(azulSpeed);
    
                    /*
                     * Atualizar a posição dos trens
                     */
                    updateTrainPositions();
    
                    /*
                     * Imprimir as posições atuais dos trens
                     */
                    System.out.println("Posição atual do trem laranja: " + trainLaranja.getTrainLaranja() + ", " + trainLaranja.getTrainYLaranja());
                    System.out.println("Posição atual do trem azul: " + trainAzul.getTrainAzul() + ", " + trainAzul.getTrainYAzul());
    
                    /*
                     * Verificar se os trens chegaram na posição final e reiniciar o percurso
                     */
                    if (trainLaranja.getTrainLaranja() <= 0 || trainLaranja.getTrainLaranja() >= INITIAL_X_LARANJA
                            || trainLaranja.getTrainYLaranja() <= 0 || trainLaranja.getTrainYLaranja() >= INITIAL_Y_LARANJA) {
                        trainLaranja.resetTrainPosition();
                    }
    
                    if (trainAzul.getTrainAzul() <= 0 || trainAzul.getTrainAzul() >= INITIAL_X_AZUL
                            || trainAzul.getTrainYAzul() <= 0 || trainAzul.getTrainYAzul() >= INITIAL_Y_AZUL) {
                        trainAzul.resetTrainPosition();
                    }
                } catch (Exception e) {
                    // Lidar com exceções aqui (ex: Log, mensagem de erro)
                    e.printStackTrace();
                }
            }
        };
    }

    public void startLaranja() {
        try {
            trainLaranja.increaseSpeed(10); // Ação para iniciar o trem laranja
            animationTimer.start();
        } catch (Exception e) {
            // Lidar com exceções aqui (ex: Log, mensagem de erro)
            e.printStackTrace();
        }
    }

    public void startAzul() {
        try {
            trainAzul.increaseSpeed(10); // Ação para iniciar o trem azul
            animationTimer.start();
        } catch (Exception e) {
            // Lidar com exceções aqui (ex: Log, mensagem de erro)
            e.printStackTrace();
        }
    }

    public void stop() {
        try {
            animationTimer.stop();
        } catch (Exception e) {
            // Lidar com exceções aqui (ex: Log, mensagem de erro)
            e.printStackTrace();
        }
    }

    public void reset() {
        try {
            trainLaranja.resetTrainPosition();
            trainAzul.resetTrainPosition();
        } catch (Exception e) {
            // Lidar com exceções aqui (ex: Log, mensagem de erro)
            e.printStackTrace();
        }
    }

    public void setSpeedLaranja(double speed) {
        try {
            trainLaranja.setTrainSpeed(speed);
        } catch (Exception e) {
            // Lidar com exceções aqui (ex: Log, mensagem de erro)
            e.printStackTrace();
        }
    }

    public void setSpeedAzul(double speed) {
        try {
            trainAzul.setTrainSpeed(speed);
        } catch (Exception e) {
            // Lidar com exceções aqui (ex: Log, mensagem de erro)
            e.printStackTrace();
        }
    }

    public void updateTrainPositions() {
        trainLaranja.updatePosition();
        trainAzul.updatePosition();
    }

    public double getTrainLaranjaX() {
        return trainLaranja.getTrainLaranja();
    }

    public double getTrainLaranjaY() {
        return trainLaranja.getTrainYLaranja();
    }

    public double getTrainAzulX() {
        return trainAzul.getTrainAzul();
    }

    public double getTrainAzulY() {
        return trainAzul.getTrainYAzul();
    }
}
