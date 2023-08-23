package view;

import controller.TrainController;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Slider;
import javafx.scene.image.ImageView;

public class TrainView {

    @FXML
    private Slider speedSliderLaranja;

    @FXML
    private Slider speedSliderAzul;

    @FXML
    private Button resetButton;

    @FXML
    private ImageView tremAzulImageView;

    @FXML
    private ImageView tremLaranjaImageView;

    private TrainController trainController;

    private Thread animationThread; // Thread para animação dos trens

    public void setTrainController(TrainController trainController) {
        this.trainController = trainController;
    }

    @FXML
    private void handleReset() {
        trainController.reset();
    }

    @FXML
    private void initialize() {
        setupAnimationThread();

        // Associe os sliders aos métodos de controle de velocidade
        speedSliderLaranja.valueProperty().addListener((observable, oldValue, newValue) -> {
            if (trainController != null) {
                trainController.setSpeedLaranja(newValue.doubleValue());
                System.out.println("Slider laranja movimentado: " + newValue);
            }
        });

        speedSliderAzul.valueProperty().addListener((observable, oldValue, newValue) -> {
            if (trainController != null) {
                trainController.setSpeedAzul(newValue.doubleValue());
                System.out.println("Slider azul movimentado: " + newValue);
            }
        });

        // Adicione eventos aos sliders para quando forem movimentados
        speedSliderLaranja.setOnMouseDragged(event -> {
            if (trainController != null) {
                double newValue = speedSliderLaranja.getValue();
                trainController.setSpeedLaranja(newValue);
                System.out.println("Slider laranja movimentado: " + newValue);
            }
        });

        speedSliderAzul.setOnMouseDragged(event -> {
            if (trainController != null) {
                double newValue = speedSliderAzul.getValue();
                trainController.setSpeedAzul(newValue);
                System.out.println("Slider azul movimentado: " + newValue);
            }
        });
    }

    private void setupAnimationThread() {
        animationThread = new Thread(() -> {
            while (true) {
                try {
                    Thread.sleep(16); // Atualização a cada 16ms para aproximar 60FPS
                    Platform.runLater(() -> {
                        trainController.updateTrainPositions();
                        updatePosition(trainController.getTrainLaranjaX(), trainController.getTrainLaranjaY(),
                                trainController.getTrainAzulX(), trainController.getTrainAzulY());
                    });
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        animationThread.setDaemon(true);
        animationThread.start();
    }

    public void updatePosition(double trainLaranjaX, double trainLaranjaY, double trainAzulX, double trainAzulY) {
        // Atualize apenas as posições X das imagens dos trens
        tremLaranjaImageView.setLayoutY(trainLaranjaY);
        tremAzulImageView.setLayoutY(trainAzulY);
    }
    
}
