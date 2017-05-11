/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simplestockjavafx.controller.stock;

//import BLL.BrandBLL;
//import dataBase.DBConnection;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

//import DAL.Brands;
//import Getway.BrandsGetway;
//import dataBase.DBProperties;
import javafx.scene.control.Alert;
import simplestockjavafx.bo.Brand;
import simplestockjavafx.bo.Supplyer;
import simplestockjavafx.constants.ApplicationPath;
import simplestockjavafx.resources.media.userNameMedia;
import simplestockjavafx.service.ControlStockSvc;
import simplestockjavafx.service.impl.ControlStockSvcImpl;
import simplestockjavafx.utils.KeyValuePair;

/**
 * FXML Controller class
 *
 * @author rifat
 */
public class AddBrandController implements Initializable {

    public Button btnAddSupplyer;
    private userNameMedia media;
//
//    Brands brands = new Brands();
//    BrandsGetway brandsGetway = new BrandsGetway();
//    BrandBLL brandBLL = new BrandBLL();

    public String brandId;
    private String usrId;
    private String supplyerName;
    private String supplyerId;

//    DBConnection dbCon = new DBConnection();
    Connection con;
    PreparedStatement pst;
    ResultSet rs;
    
//    DBProperties dBProperties = new DBProperties();
//    String db = dBProperties.loadPropertiesFile();

    @FXML
    public Button btnUpdate;
    @FXML
    public Label lblHeader;
    @FXML
    public Button btnClose;

    @FXML
    private ComboBox<KeyValuePair> cbSupplyer;
    @FXML
    private TextField tfBrandName;
    @FXML
    private TextArea taDiscription;
    @FXML
    public Button btnAddBrand;
    
    private ControlStockSvc controlStockSvc;

    public userNameMedia getMedia() {
        return media;
    }

    public void setMedia(userNameMedia media) {
        usrId = media.getId();
        this.media = media;
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
         controlStockSvc = new ControlStockSvcImpl();
    }

    @FXML
    private void btnAddBrandOnAction(ActionEvent event) {
        
        if (isNotNull()) {
            Brand brand = new Brand();
            brand.setBrandName(tfBrandName.getText());
            brand.setSupplyerId(cbSupplyer.getSelectionModel().getSelectedItem().getKey());
            brand.setBrandComment(taDiscription.getText());
            controlStockSvc.saveBrand(brand);
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("error");
            alert.setHeaderText("Sucess : save sucess ");
            alert.setContentText("brand added successfully");
            alert.initStyle(StageStyle.UNDECORATED);
            alert.showAndWait();
        }

    }

    @FXML
    private void cbSupplyerOnAction(ActionEvent event) {

    }

    @FXML
    private void cbSupplyerOnClick(MouseEvent event) {
        cbSupplyer.getItems().clear();
//        con = dbCon.geConnection();
//        try {
//            pst = con.prepareStatement("select * from "+db+".Supplyer order by SupplyerName");
//            rs = pst.executeQuery();
//            while (rs.next()) {
//                supplyerName = rs.getString(2);
//
//                cbSupplyer.getItems().add(supplyerName);
//            }
//        } catch (SQLException ex) {
//            Logger.getLogger(AddBrandController.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        
         List<Supplyer> supplyerList = controlStockSvc.getSupplyerList();

        for (Supplyer supplyer : supplyerList) {
            cbSupplyer.getItems().add(new KeyValuePair(supplyer.getId(), supplyer.getSupplyerName()));
        }
    }

    @FXML
    private void btnUpdateOnAction(ActionEvent event) {
//        System.out.println();
//        if (isNotNull()) {
//            brands.id = brandId;
//            if (!cbSupplyer.getSelectionModel().isEmpty()) {
//                brands.supplyerName = cbSupplyer.getSelectionModel().getSelectedItem();
//            } else if (!cbSupplyer.getPromptText().isEmpty()) {
//                brands.supplyerName = cbSupplyer.getPromptText();
//            }
//
//            brands.brandName = tfBrandName.getText().trim();
//            brands.brandComment = taDiscription.getText();
//            brandBLL.update(brands);
//        }
    }

    @FXML
    private void btnCloseOnAction(ActionEvent event) {
        Stage stage = (Stage) btnClose.getScene().getWindow();
        stage.close();
    }

    public boolean isNotNull() {
        System.out.println(cbSupplyer.getPromptText());
//        System.out.println(cbSupplyer.getSelectionModel().getSelectedItem().isEmpty());
        System.out.println(tfBrandName.getText());
        boolean isNotNull;
        if (tfBrandName.getText().trim().isEmpty()
                || cbSupplyer.getSelectionModel().isEmpty()
                && cbSupplyer.getPromptText().isEmpty()) {
            
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("error");
            alert.setHeaderText("Error : null found ");
            alert.setContentText("Please full all requre field");
            alert.initStyle(StageStyle.UNDECORATED);
            alert.showAndWait();
            
            isNotNull = false;

        } else {
            isNotNull = true;
        }
        return isNotNull;
    }

    public void showDetails() {
//        brands.id = brandId;
//        brandsGetway.selectedView(brands);
//        tfBrandName.setText(brands.brandName);
//        taDiscription.setText(brands.brandComment);
//        cbSupplyer.setPromptText(brands.supplyerName);
    }

    public void btnAddSupplyerOnAction(ActionEvent actionEvent) {
        AddSupplyerController addSupplyerController = new AddSupplyerController();
        userNameMedia media = new userNameMedia();
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource(ApplicationPath.VIEW_FXML + "/stock/AddSupplier.fxml"));
        try {
            fxmlLoader.load();
            Parent parent = fxmlLoader.getRoot();
            Scene scene = new Scene(parent);
            scene.setFill(new Color(0, 0, 0, 0));
            AddSupplyerController supplyerController = fxmlLoader.getController();
            media.setId(usrId);
            supplyerController.setMedia(media);
            supplyerController.lblCaption.setText("Add Item");
            supplyerController.btnUpdate.setVisible(false);
            Stage nStage = new Stage();
            supplyerController.addSupplyerStage(nStage);
            nStage.setScene(scene);
            nStage.initModality(Modality.APPLICATION_MODAL);
            nStage.initStyle(StageStyle.TRANSPARENT);
            nStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
