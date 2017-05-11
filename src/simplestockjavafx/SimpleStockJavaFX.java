/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simplestockjavafx;

import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import org.apache.log4j.Logger;
import simplestockjavafx.constants.ApplicationPath;
import static javafx.application.Application.launch;
import simplestockjavafx.dao.DAOAbstractFactory;
import simplestockjavafx.dao.DAOFactory;
import simplestockjavafx.service.DBSetUpSvc;
import simplestockjavafx.service.impl.DBSetUpSrvImpl;
import static javafx.application.Application.launch;

/**
 *
 * @author macako
 */
public class SimpleStockJavaFX extends Application {

    private static final Logger LOG = Logger.getLogger(SimpleStockJavaFX.class
              .getPackage().getName());

    public SimpleStockJavaFX() {
        DBSetUpSvc dbSetUpSvc = new  DBSetUpSrvImpl();
       // dbSetUpSvc.createDataBase();  
    }    
    

    @Override
    public void start(Stage primaryStage) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource(ApplicationPath.VIEW_FXML + "/Login.fxml"));
            Scene scene = new Scene(root);
            primaryStage.setScene(scene);
            primaryStage.setTitle("Welcome to SimpleStock -Login");
            primaryStage.getIcons().add(new Image(ApplicationPath.IMAGES_PATH + "/icon.png")); 
            primaryStage.setMaximized(false);
            primaryStage.setMinHeight(500.0);
            primaryStage.setMinWidth(850.0);
            primaryStage.show();
        } catch (IOException ex) {
            LOG.error("The application can not initialize:", ex);
        }catch (Exception ex){
            LOG.error("The application can not initialize:", ex);
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
