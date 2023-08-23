package model;

import view.TrainView;

public class Train {
    private double trainLaranja;
    private double trainAzul;
    private double trainSpeed;
    private double initialXLaranja;
    private double initialYLaranja;
    private double initialXAzul;
    private double initialYAzul;
    private double trainYLaranja; // Adicionado
    private double trainYAzul; // Adicionado

    private TrainView trainView;

    public Train(double initialXLaranja, double initialYLaranja, double initialXAzul, double initialYAzul, double initialSpeed, TrainView trainView) {
        this.initialXLaranja = initialXLaranja;
        this.initialYLaranja = initialYLaranja;
        this.initialXAzul = initialXAzul;
        this.initialYAzul = initialYAzul;
        this.trainLaranja = initialXLaranja;
        this.trainAzul = initialXAzul;
        this.trainYLaranja = initialYLaranja; // Inicialização
        this.trainYAzul = initialYAzul; // Inicialização
        this.trainSpeed = initialSpeed;
        this.trainView = trainView;

        updateTrainViewPosition();
    }

    public void updatePosition() {
        trainLaranja += trainSpeed;
        trainAzul += trainSpeed;
        trainYLaranja -= trainSpeed; // Subtrair aqui
        trainYAzul -= trainSpeed; // Subtrair aqui
        updateTrainViewPosition();
    }
    

    public void increaseSpeed(double incrementValue) {
        trainSpeed += incrementValue;
    }

    public void decreaseSpeed(double decrementValue) {
        trainSpeed -= decrementValue;
        if (trainSpeed < 0) {
            trainSpeed = 0;
        }
    }

    public void resetTrainPosition() {
        trainLaranja = initialXLaranja;
        trainAzul = initialXAzul;
        trainYLaranja = initialYLaranja; // Reinicialização
        trainYAzul = initialYAzul; // Reinicialização
        trainSpeed = 0;
        updateTrainViewPosition();
    }

    public void updateTrainViewPosition() {
        trainView.updatePosition(trainLaranja, trainYLaranja, trainAzul, trainYAzul); // Atualização
    }

    public double getTrainLaranja() {
        return trainLaranja;
    }

    public void setTrainLaranja(double trainLaranja) {
        this.trainLaranja = trainLaranja;
    }

    public double getTrainAzul() {
        return trainAzul;
    }

    public void setTrainAzul(double trainAzul) {
        this.trainAzul = trainAzul;
    }

    public double getTrainSpeed() {
        return trainSpeed;
    }

    public void setTrainSpeed(double trainSpeed) {
        this.trainSpeed = trainSpeed;
    }

    public TrainView getTrainView() {
        return trainView;
    }

    public void setTrainView(TrainView trainView) {
        this.trainView = trainView;
    }
    
    // Métodos adicionados para obter as posições Y dos trens
    public double getTrainYLaranja() {
        return trainYLaranja;
    }

    public double getTrainYAzul() {
        return trainYAzul;
    }
}