package org.example;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("Fomurlario ComboBox");
        GridPane gridPane = new GridPane();
        gridPane.setHgap(10);
        gridPane.setVgap(10);

        Label paisLabel = new Label("Pais:");
        ComboBox<String> paisComboBox = new ComboBox<>();
        paisComboBox.getItems().addAll("España", "Venezuela", "Brazil");
        paisComboBox.getSelectionModel().select(0);

        gridPane.add(paisLabel, 0, 0);
        gridPane.add(paisComboBox, 1, 0);

        Button boton = new Button("Enviar");
        boton.setOnAction(e -> {
            Alert mesanje = new Alert(Alert.AlertType.INFORMATION);
            mesanje.setTitle("Mensaje");
            mesanje.setHeaderText("Pais seleccionado");
            mesanje.setContentText(paisComboBox.getValue());
            mesanje.showAndWait();
            return;
        });
        gridPane.add(boton, 1, 1);
        Scene scene = new Scene(gridPane);
        stage.setScene(scene);
        stage.show();

    }
    public static void main(String[] args) {
        launch(args);
    }
}
