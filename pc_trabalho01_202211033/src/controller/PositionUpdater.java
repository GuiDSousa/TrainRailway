package controller;

public class PositionUpdater implements Runnable {
    private TrainController trainController;
    private volatile boolean running;

    public PositionUpdater(TrainController trainController) {
        this.trainController = trainController;
        this.running = true;
    }

    @Override
    public void run() {
        while (running) {
            try {
                Thread.sleep(16); // Atualização a cada 16ms para aproximar 60FPS
                trainController.updateTrainPositions(); // Correção aqui
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void stop() {
        running = false;
    }
}
