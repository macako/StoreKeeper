/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simplestockjavafx.utils;

import javafx.scene.control.Alert;
import javafx.scene.image.Image;
import simplestockjavafx.constants.ApplicationPath;

/**
 *
 * @author macako
 */
public class Misc {

    public static Image getImage(String image) {
        return new Image(ApplicationPath.IMAGES_PATH + image);
    }

    public static Image getIcon(String icon) {
        return new Image(ApplicationPath.ICON_PATH + icon);
    }

    public static boolean isNotNull(String... textFields) {
        
        for (int i = 0; i < textFields.length; i++) {
            String field = textFields[i];
            
            if (field.trim().isEmpty()) {
                Alerts.showAlert(Alert.AlertType.ERROR, "error", "ERROR : NULL FOUND", "Please fill all require field");
                return false;
            }

        }

        return true;

    }

}
