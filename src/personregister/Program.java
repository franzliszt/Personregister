/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package personregister;

import javafx.application.Application;
import javafx.stage.Stage;

/**
 *
 * @author stianreistadrogeberg
 */
public class Program extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        RegistreringGUI gui = new RegistreringGUI(primaryStage);
        primaryStage.show();
    }
}
