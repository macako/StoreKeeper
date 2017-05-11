/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simplestockjavafx.utils;

import javafx.scene.control.Alert;
import javafx.stage.StageStyle;

/**
 *
 * @author macako
 */
public class Alerts {
    public static void showAlert(Alert.AlertType type, String title, String header, String text){
            Alert alert = new Alert(type);
            alert.setTitle(title);
            alert.setHeaderText(header);
            alert.setContentText(text);
            alert.initStyle(StageStyle.UNDECORATED);
            alert.showAndWait();    
    }
}
