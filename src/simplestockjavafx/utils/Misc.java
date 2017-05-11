/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simplestockjavafx.utils;

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

}
