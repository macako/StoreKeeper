/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simplestockjavafx.controller;

import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.Hyperlink;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javafx.beans.binding.BooleanBinding;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import simplestockjavafx.resources.media.userNameMedia;
import javafx.scene.image.Image;
import javafx.stage.StageStyle;
import simplestockjavafx.bo.Users;
import simplestockjavafx.constants.ApplicationPath;
import simplestockjavafx.service.LoginSvc;
import simplestockjavafx.service.impl.LoginSvcImpl;
import simplestockjavafx.utils.Alerts;
import simplestockjavafx.utils.CustomPf;
import simplestockjavafx.utils.CustomTf;
import simplestockjavafx.utils.Misc;

/**
 * FXML Controller class
 *
 * @author rifat
 */
public class LoginController implements Initializable {

    CustomTf cTF = new CustomTf();
    CustomPf cPF = new CustomPf();
    private PreparedStatement pst;
    private Connection con;
    private ResultSet rs;
    private LoginSvc loginSvc;

    @FXML
    private TextField tfUserName;
    @FXML
    private Button btnUserNameTfClear;
    @FXML
    private Button btnPassFieldClear;
    @FXML
    private PasswordField pfUserPassword;
    @FXML
    private Button btnLogin;
    @FXML
    private Hyperlink hlCreateAccount;
    @FXML
    private AnchorPane apMother;
    @FXML
    private AnchorPane apDesignPane;

//    DBProperties dBProperties = new DBProperties();
//    String db = dBProperties.loadPropertiesFile();
    @FXML
    private Hyperlink hlDatabase;

    /**
     * Initializes the controller class.
     *
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        loginSvc = new LoginSvcImpl();
        loginSvc.createAdminUser();
        
        tfUserName.setText("admin"); 
        pfUserPassword .setText("admin");

        cTF.clearTextFieldByButton(tfUserName, btnUserNameTfClear);
        cPF.clearPassFieldByButton(pfUserPassword, btnPassFieldClear);
        BooleanBinding boolenBinding = tfUserName.textProperty().isEmpty()
                  .or(pfUserPassword.textProperty().isEmpty());

        btnLogin.disableProperty().bind(boolenBinding);

    }

    @FXML
    private void hlCreateAnAccount(ActionEvent event) throws IOException {
        //  DBConnection dbCon = new DBConnection();
        con = null;//dbCon.geConnection();
        if (con != null) {
            try {
                //    pst = con.prepareStatement("SELECT Id FROM " + db + ".User ORDER BY Id ASC LIMIT 1");
                rs = pst.executeQuery();
                if (rs.next()) {
                    apMother.setOpacity(0.7);
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Error");
                    alert.setHeaderText("Error");
                    alert.setContentText("You can't create an account without admin \n permission");
                    alert.initStyle(StageStyle.UNDECORATED);
                    Optional<ButtonType> result = alert.showAndWait();
                    if (result.isPresent() && result.get() == ButtonType.OK) {
                        apMother.setOpacity(1.0);
                    }
                    return;
                }
                con.close();
                pst.close();
                rs.close();
                loadRegistration();

            } catch (SQLException ex) {
                Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            /* Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Error : Server Not Found");
            alert.setContentText("Make sure your mysql is Start properly, \n");
            alert.initStyle(StageStyle.UNDECORATED);
            alert.showAndWait();*/
            Alerts.showAlert(Alert.AlertType.ERROR, "Error", "Error : Server Not Found", "Make sure your mysql is Start properly, \n");
        }

    }

    @FXML
    private void btnLogin(ActionEvent event) throws IOException {
        if (loginSvc.isDbConnected()) {
            userNameMedia media = new userNameMedia();
            ApplicationController apController = new ApplicationController();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource(ApplicationPath.VIEW_FXML + "/Application.fxml"));
            loader.load();
            Parent parent = loader.getRoot();
            Scene adminPanelScene = new Scene(parent);
            Stage adminPanelStage = new Stage();
            adminPanelStage.setMaximized(true);
            if (isValidCondition()) {
                Users userLogin = loginSvc.getLogin(tfUserName.getText(), pfUserPassword.getText());
                if (userLogin != null) {                   
                    ApplicationController apControl = loader.getController();
                    apControl.setUser(userLogin);
                    apControl.btnHomeOnClick(event);
                    apControl.viewDetails();
                    apControl.permission();
                    adminPanelStage.setScene(adminPanelScene);
                    adminPanelStage.getIcons().add(Misc.getImage("icon.png"));
                    adminPanelStage.setTitle(userLogin.getFullName());
                    adminPanelStage.show();

                    Stage stage = (Stage) btnLogin.getScene().getWindow();
                    stage.close();
                } else {
                    System.out.println("Password Not Match");
                    /* Alert alert = new Alert(Alert.AlertType.ERROR);
                        alert.setTitle("Password Not Match");
                        alert.setHeaderText("Error : Name or Pass Not matched");
                        alert.setContentText("User Name or Password not matched \ntry Again");
                        alert.initStyle(StageStyle.UNDECORATED);
                        alert.showAndWait();*/
                    Alerts.showAlert(Alert.AlertType.ERROR, "Password Not Match", "Error : Name or Pass Not matched", "User Name or Password not matched \ntry Again");
                }
            }
        } else {
            /*Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Error : Server Not Found");
            alert.setContentText("Make sure your mysql is Start properly, \n");
            alert.initStyle(StageStyle.UNDECORATED);
            alert.showAndWait();*/
            Alerts.showAlert(Alert.AlertType.ERROR, "Error", "Error : Server Not Found", "Make sure your mysql is Start properly, \n");
        }
    }

    private boolean isValidCondition() {
        boolean validCondition = false;
        if (tfUserName.getText().trim().isEmpty()
                  || pfUserPassword.getText().isEmpty()) {
            /*  Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("WARNING :");
            alert.setHeaderText("WARNING !!");
            alert.setContentText("Please Fill Text Field And Password Properly");
            alert.initStyle(StageStyle.UNDECORATED);
            alert.showAndWait();*/
            Alerts.showAlert(Alert.AlertType.WARNING, "WARNING :", "WARNING !!", "Please Fill Text Field And Password Properly");

            validCondition = false;
        } else {
            validCondition = true;
        }
        return validCondition;
    }

    @FXML
    private void pfUserNameOnHitEnter(ActionEvent event) {
        try {
            btnLogin(event);
        } catch (IOException ex) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void pfUserPassOnHitEnter(ActionEvent event) {
        try {
            btnLogin(event);
        } catch (IOException ex) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void loadRegistration() {
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource(ApplicationPath.VIEW_FXML + "/Registration.fxml"));
            Scene scene = new Scene(root);
            Stage nStage = new Stage();
            nStage.setScene(scene);
            nStage.setMaximized(true);
            nStage.setTitle("Registration -StoreKeeper");
            nStage.show();
            Stage stage = (Stage) hlCreateAccount.getScene().getWindow();
            stage.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @FXML
    private void hlDbOnAction(ActionEvent event) {
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource(ApplicationPath.VIEW_FXML + "/Server.fxml"));
            Scene scene = new Scene(root);
            Stage nStage = new Stage();
            nStage.setScene(scene);
            nStage.setMaximized(false);
            nStage.setTitle("Server Status -StoreKeeper");
            nStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void setLoginSvc(LoginSvc loginSvc) {
        this.loginSvc = loginSvc;
    }

}
