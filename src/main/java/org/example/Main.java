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
        // Se asigna el título de la ventana principal (tiene una falta de ortografía: "Fomurlario")
        stage.setTitle("Formulario ComboBox");

        // Se crea un panel de cuadrícula (GridPane) para organizar los elementos
        GridPane gridPane = new GridPane();
        // Se establece el espacio horizontal entre columnas: 10 píxeles
        gridPane.setHgap(10);
        // Se establece el espacio vertical entre filas: 10 píxeles
        gridPane.setVgap(10);

        // Se crea una etiqueta "Pais:" (con falta de tilde, debería ser "País")
        Label paisLabel = new Label("Pais:");
        // Se crea un ComboBox con tipo String para seleccionar un país
        ComboBox<String> paisComboBox = new ComboBox<>();
        // Se agregan tres opciones al ComboBox: España, Venezuela, Brazil (Brasil falta la 's')
        paisComboBox.getItems().addAll("España", "Venezuela", "Brazil");

        // Se añade la etiqueta en la columna 0, fila 0
        gridPane.add(paisLabel, 0, 0);
        // Se añade el ComboBox en la columna 1, fila 0
        gridPane.add(paisComboBox, 1, 0);

        // Se crea un botón con el texto "Enviar"
        Button boton = new Button("Enviar");

        // Se asigna una acción al botón cuando es presionado
        boton.setOnAction(e -> {
            // Se obtiene el país seleccionado del ComboBox
            String pais = paisComboBox.getSelectionModel().getSelectedItem();

            // Se verifica si hay un país seleccionado (no es null)
            if(pais != null){
                // Se crea una alerta de tipo INFORMATION (información)
                Alert mensaje = new Alert(Alert.AlertType.INFORMATION);
                // Se establece el título de la alerta
                mensaje.setTitle("Mensaje");
                // Se establece el texto del encabezado
                mensaje.setHeaderText("Pais seleccionado");
                // Se establece el contenido con el país seleccionado
                mensaje.setContentText(paisComboBox.getValue());
                // Se muestra la alerta y se espera a que el usuario la cierre
                mensaje.showAndWait();
            } else {
                // Si no hay país seleccionado, se crea una alerta de tipo WARNING (advertencia)
                Alert mesanje = new Alert(Alert.AlertType.WARNING);
                // Se establece el título de la alerta
                mesanje.setTitle("Mensaje");
                // Se establece el texto del encabezado indicando que no se seleccionó ningún país
                mesanje.setHeaderText("Pais no seleccionado");
                // Se muestra la alerta de advertencia
                mesanje.showAndWait();
            }
        });

        // Se añade el botón en la columna 1, fila 1
        gridPane.add(boton, 1, 1);

        // Se crea la escena con el GridPane como raíz (tamaño automático)
        Scene scene = new Scene(gridPane);
        // Se asigna la escena a la ventana
        stage.setScene(scene);
        // Se hace visible la ventana
        stage.show();
    }

    public static void main(String[] args) {
        // Lanza la aplicación JavaFX
        launch(args);
    }
}
