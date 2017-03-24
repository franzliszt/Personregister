/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package personregister;



import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import static java.lang.Math.*;
import javafx.event.EventHandler;

/**
 *
 * @author stianreistadrogeberg
 */
public class RegistreringGUI {
    
    private static final int HEIGHT = 400;
    private static final int WIDTH = 400;
    private final TextField navnefelt;
    private final TextField nummerfelt;
    private final Label navn;
    private final Label nummer;
    private final TextArea utskrift;
    private Button ny;
    private Button vis;
    private Button finn;
    private Button fjern;
    private final Personregister register;
    
    
    public RegistreringGUI(Stage stage) {
        System.out.println(PI);
        EventHandler<ActionEvent> listener = new ButtonListener();
        stage.setTitle("Persondata");
        register = new Personregister();
        GridPane root = new GridPane();
        root.setPadding(new Insets(10, 10, 10, 10));
        root.setVgap(5);
        root.setHgap(5);
        navn = new Label("Navn: ");
        GridPane.setConstraints(navn, 0, 0);
        navnefelt = new TextField();
        navnefelt.setPromptText("Skriv inn navn");
        GridPane.setConstraints(navnefelt, 1, 0);
        nummer = new Label("Nummer: ");
        GridPane.setConstraints(nummer, 0, 1);
        nummerfelt = new TextField();
        nummerfelt.setPromptText("Ditt nummer");
        GridPane.setConstraints(nummerfelt, 1, 1);
        createButtons();
        ny.setOnAction(listener);
        vis.setOnAction(listener);
        finn.setOnAction(listener);
        fjern.setOnAction(listener);
        GridPane.setConstraints(ny, 0, 2);
        GridPane.setConstraints(vis, 0, 3);
        GridPane.setConstraints(finn, 0, 4);
        GridPane.setConstraints(fjern, 0, 5);
        utskrift = new TextArea();
        final VBox container = new VBox();
        container.setAlignment(Pos.CENTER);
        container.getChildren().add(utskrift);
        GridPane.setConstraints(container, 0, 6, 2, 1);
        root.getChildren().addAll(navn, navnefelt, nummer, nummerfelt, 
                ny, vis, finn, fjern, container);
        
        Scene scene = new Scene(root, WIDTH, HEIGHT);
        stage.setScene(scene);
    } // End constructor
    
    private void createButtons() {
        ny = new Button("Registrer ny person");
        ny.prefHeight(20);
        vis = new Button("Vis alle registrerte personer");
        vis.prefHeight(20);
        finn = new Button("Finn person med gitt nummer");
        finn.prefHeight(20);
        fjern = new Button("Slett person med gitt navn");
        fjern.prefHeight(20);
    } // End constructor
    
    private class ButtonListener implements EventHandler<ActionEvent> {

        @Override
        public void handle(ActionEvent e) {
            if (e.getSource() == ny) {
                nyPerson();
                clear();
            } else if (e.getSource() == vis) {
                visRegister();
                clear();
            } else if (e.getSource() == finn) {
                finnPerson();
                clear();
            } else if (e.getSource() == fjern) {
                fjernPerson();
                clear();
            }
        }
    } // End inner class
    
    private void clear() {
        navnefelt.setText("");
        nummerfelt.setText("");
    }
    
    public void fjernPerson() {
        String _navn = navnefelt.getText();
        if (register.fjernPerson(_navn)) {
            navnefelt.setText("");
            utskrift.setText(_navn + " er slettet.");
        }
    }
    
    public void nyPerson() {
        String _navn = navnefelt.getText();
        int nr = Integer.parseInt(nummerfelt.getText());
        Person p = new Person(_navn, nr);
        boolean ok = register.nyPerson(p);
        if (ok)
            utskrift.setText(_navn + " ble registrert.");
        else
            utskrift.setText("Ingen registrering, fullt register.");
    }
    
    public void visRegister() {
        utskrift.setText("Registrerte personer:\n");
        utskrift.appendText(register.visAlleNavn());
    }
    
    public void finnPerson() {
        int nr = Integer.parseInt(nummerfelt.getText());
        String data = register.visPerson(nr);
        if (data != null)
            utskrift.setText(data);
        else
            utskrift.setText("Personen finnes ikke i registeret.");
    }
} // End class RegistreringGUI
