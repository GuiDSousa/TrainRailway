package view;

import controller.TrainController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.Train;

public class Principal extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        // Carregar a visualização
        FXMLLoader loader = new FXMLLoader(getClass().getResource("UserInterface.fxml"));
        Parent root = loader.load();
        
        // Criar modelos e controladores
        TrainView trainView = loader.getController();
        Train trainLaranja = new Train(246, 604, 369, 604, 0, trainView);
        Train trainAzul = new Train(246, 604, 369, 604, 0, trainView);
        TrainController trainController = new TrainController(trainLaranja, trainAzul, null, null);
        
        // Configurar controlador da visualização
        trainView.setTrainController(trainController);

        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.setTitle("Nos Trilhos");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
