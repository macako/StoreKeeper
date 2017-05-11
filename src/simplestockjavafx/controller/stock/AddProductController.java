/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simplestockjavafx.controller.stock;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ResourceBundle;

//import BLL.CurrentProductBLL;
//import DAL.CurrentProduct;
//import Getway.CurrentProductGetway;
//import dataBase.DBConnection;
//import dataBase.DBProperties;
//import dataBase.SQL;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import simplestockjavafx.bo.Brand;
import simplestockjavafx.bo.Category;
import simplestockjavafx.bo.RMA;
import simplestockjavafx.bo.StoredProduct;
import simplestockjavafx.bo.Supplyer;
import simplestockjavafx.bo.Unit;
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
public class AddProductController implements Initializable {

    public ComboBox<KeyValuePair> cmbBrand;
    public ComboBox<KeyValuePair> cmbCatagory;
    public Button btnAddSupplier;
    public Button btnAddBrand;
    public Button btnAddCatagory;
    public Button btnAddUnit;
    public Button btnAddRma;
    @FXML
    private RadioButton rbStatic;
    @FXML
    private RadioButton rbSeq;

    private String usrId;
    private userNameMedia nameMedia;

    //CurrentProductBLL currentProductBLL = new CurrentProductBLL();
    //CurrentProductGetway currentProductGetway = new CurrentProductGetway();
    // SQL sql = new SQL();
    //DBConnection dbCon = new DBConnection();
    Connection con = null;//dbCon.geConnection();
    PreparedStatement pst;
    ResultSet rs;

    //DBProperties dBProperties = new DBProperties();
    String db = null;//dBProperties.loadPropertiesFile();

    @FXML
    private Button btnClose;
    @FXML
    private TextField tfProductId;
    @FXML
    private TextField tfProductName;
    @FXML
    private TextField tfProductQuantity;
    @FXML
    private TextField tfProductPursesPrice;
    @FXML
    private TextField tfProductSellPrice;
    @FXML
    private TextArea taProductDescription;
    @FXML
    private ComboBox<KeyValuePair> cbUnit;
    @FXML
    private ComboBox<KeyValuePair> cbRMA;
    @FXML
    private DatePicker dpDate;
    @FXML
    public Button btnSave;
    @FXML
    private TextField tfValue;

    public String id;
    private String supplyerName;
    private Integer supplyerId;
    private String brandName;
    private Integer brandId;
    private String catagoryName;
    private Integer catagoryId;
    private Integer unitId;
    private Integer rmaId;

    private ControlStockSvc controlStockSvc;

    @FXML
    private ComboBox<KeyValuePair> cbSupplyer;
    @FXML
    public Button btnUpdate;
    @FXML
    public Label lblHeader;

    public userNameMedia getNameMedia() {
        return nameMedia;
    }

    public void setNameMedia(userNameMedia nameMedia) {
        usrId = nameMedia.getId();
        this.nameMedia = nameMedia;
    }

    /**
     * Initializes the controller class.
     *
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        controlStockSvc = new ControlStockSvcImpl();

        ToggleGroup firstRedioBtn = new ToggleGroup();
        rbSeq.setToggleGroup(firstRedioBtn);
        rbStatic.setSelected(true);
        rbStatic.setToggleGroup(firstRedioBtn);
        tfValue.setVisible(false);

    }

    @FXML
    private void btnCloseOnAction(ActionEvent event) {
        Stage stage = (Stage) btnClose.getScene().getWindow();
        stage.close();
    }

    @FXML
    private void btnSaveOnAction(ActionEvent event) {
        if (isNotNull()) {
//            unitId = sql.getIdNo(cbUnit.getSelectionModel().getSelectedItem(), unitId, "Unit", "UnitName");
//            rmaId = sql.getIdNo(cbRMA.getSelectionModel().getSelectedItem(), rmaId, "RMA", "RMAName");
            if (!tfValue.getText().trim().isEmpty()) {
                String value = tfValue.getText();
                int foo = Integer.parseInt(value);

                for (int i = 1; i <= foo; ++i) {
                    StoredProduct currentProduct = new StoredProduct();
                    currentProduct.setProductId(tfProductId.getText().trim() + i);
                    currentProduct.setProductName(tfProductName.getText().trim());
                    currentProduct.setQuantity(tfProductQuantity.getText().trim());
                    currentProduct.setPursesPrice(tfProductPursesPrice.getText().trim());
                    currentProduct.setSellPrice(tfProductSellPrice.getText().trim());
                    currentProduct.setDescription(taProductDescription.getText().trim());
                    currentProduct.setSupplierId(supplyerId);
                    currentProduct.setBrandId(brandId);
                    currentProduct.setCatagoryId(catagoryId);
                    currentProduct.setUnitId(unitId);
                    currentProduct.setRmaId(rmaId);
                    currentProduct.setUserId(new Integer(usrId));
                    currentProduct.setDate(dpDate.getValue().toString());
//                    currentProductBLL.save(currentProduct);
                    controlStockSvc.saveProduct(currentProduct);

                }

                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("error");
                alert.setHeaderText("Sucess : save sucess ");
                alert.setContentText("Product added successfully");
                alert.initStyle(StageStyle.UNDECORATED);
                alert.showAndWait();

            } else {
                StoredProduct currentProduct = new StoredProduct();
                currentProduct.setProductId(tfProductId.getText().trim());
                currentProduct.setProductName(tfProductName.getText().trim());
                currentProduct.setQuantity(tfProductQuantity.getText().trim());
                currentProduct.setPursesPrice(tfProductPursesPrice.getText().trim());
                currentProduct.setSellPrice(tfProductSellPrice.getText().trim());
                currentProduct.setDescription(taProductDescription.getText().trim());
                currentProduct.setSupplierId(supplyerId);
                currentProduct.setBrandId(brandId);
                currentProduct.setCatagoryId(catagoryId);
                currentProduct.setUnitId(unitId);
                currentProduct.setRmaId(rmaId);
                currentProduct.setUserId(new Integer(usrId));
                currentProduct.setDate(dpDate.getValue().toString());
                controlStockSvc.saveProduct(currentProduct);
//                currentProductBLL.save(currentProduct);
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("error");
                alert.setHeaderText("Sucess : save sucess ");
                alert.setContentText("Product added successfully");
                alert.initStyle(StageStyle.UNDECORATED);
                alert.showAndWait();

            }
        }
    }

    @FXML
    private void rbSeqOnClick(MouseEvent event) {
        if (rbSeq.isSelected()) {
            tfValue.setVisible(true);
        } else if (!rbSeq.isSelected()) {
            tfValue.setVisible(false);
        }
    }

    @FXML
    private void rbSeqOnAction(ActionEvent event) {

    }

    @FXML
    private void rbStaticOnClicked(MouseEvent event) {
        if (rbStatic.isSelected()) {
            tfValue.setVisible(false);
            tfValue.clear();
        } else if (!rbStatic.isSelected()) {
            tfValue.setVisible(true);
        }
    }

    @FXML
    private void rbStaticOnAction(ActionEvent event) {

    }

    @FXML
    private void cbSupplyerOnClicked(MouseEvent event) {
        cbSupplyer.getSelectionModel().clearSelection();
        cbSupplyer.getItems().clear();
        cmbBrand.getSelectionModel().clearSelection();
        cmbBrand.getItems().clear();
        cmbBrand.getItems().removeAll();

        List<Supplyer> supplyerList = controlStockSvc.getSupplyerList();

        for (Supplyer supplyer : supplyerList) {
            cbSupplyer.getItems().add(new KeyValuePair(supplyer.getId(), supplyer.getSupplyerName()));
        }

    }

    @FXML
    private void cbSupplyerOnAction(ActionEvent event) {
        supplyerId = cbSupplyer.getSelectionModel().getSelectedItem().getKey();
    }

    @FXML
    public void cmbBrandOnClick(Event event) {
        cmbBrand.getItems().clear();
        cmbCatagory.getItems().clear();
        cmbCatagory.getItems().removeAll();
        cmbCatagory.setPromptText(null);

        List<Brand> brandsList = controlStockSvc.getBrandListBySupplyerId(supplyerId);

        for (Brand brand : brandsList) {
            cmbBrand.getItems().add(new KeyValuePair(brand.getId(), brand.getBrandName()));
        }
    }

    @FXML
    public void cmbCatagoryOnClick(Event event) {
        cmbCatagory.getItems().clear();

        List<Category> categoryList = controlStockSvc.getCategoryListBySupplyerAndBrandId(supplyerId, brandId);

        for (Category category : categoryList) {
            cmbCatagory.getItems().add(new KeyValuePair(category.getId(), category.getCategoryName()));
        }
    }

    @FXML
    private void cmbBrandOnAction(ActionEvent event) {
        brandId = cmbBrand.getSelectionModel().getSelectedItem().getKey();
    }

    @FXML
    public void cmbCatagoryOnAction(ActionEvent actionEvent) {
        catagoryId = cmbCatagory.getSelectionModel().getSelectedItem().getKey();
    }

    @FXML
    private void cbUnitOnClick(MouseEvent event) {

        cbUnit.getItems().clear();

        List<Unit> unitList = controlStockSvc.getUnitList();

        for (Unit unit : unitList) {
            cbUnit.getItems().add(new KeyValuePair(unit.getId(), unit.getUnitName()));
        }

    }

    @FXML
    private void cbRMAOnClick(MouseEvent event) {
        cbRMA.getItems().clear();

        List<RMA> rmaList = controlStockSvc.getRmaList();

        for (RMA rma : rmaList) {
            cbRMA.getItems().add(new KeyValuePair(rma.getId(), rma.getRmaName()));
        }

    }

    private boolean isNotNull() {
        boolean insNotNull = false;
        if (cbSupplyer.getSelectionModel().getSelectedItem() == null
                  && cbSupplyer.getPromptText().isEmpty()
                  || cmbBrand.getSelectionModel().getSelectedItem() == null
                  && cmbBrand.getPromptText().isEmpty()
                  || cmbCatagory.getSelectionModel().isEmpty()
                  && cmbCatagory.getPromptText().isEmpty()
                  || tfProductId.getText().isEmpty()
                  || tfProductName.getText().isEmpty()
                  || tfProductQuantity.getText().isEmpty()
                  || tfProductPursesPrice.getText().isEmpty()) {

            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("error");
            alert.setHeaderText("ERROR : NULL FOUND");
            alert.setContentText("Please fill all require field");
            alert.initStyle(StageStyle.UNDECORATED);
            alert.showAndWait();

            insNotNull = false;
        } else {
            insNotNull = true;
        }
        return insNotNull;
    }

    @FXML
    private void btnUpdateOnAction(ActionEvent event) {
//        System.out.println(cbSupplyer.getSelectionModel().getSelectedItem());
//        System.out.println(cbSupplyer.getPromptText());
        if (isNotNull()) {
            System.out.println(supplyerId + brandId + brandId + unitId + rmaId + usrId);

//            currentProduct.productId = tfProductId.getText();
//            currentProduct.productName = tfProductName.getText();
//            currentProduct.quantity = tfProductQuantity.getText();
//            currentProduct.pursesPrice = tfProductPursesPrice.getText();
//            currentProduct.sellPrice = tfProductSellPrice.getText();
//            currentProduct.supplierId = supplyerId;
//            currentProduct.brandId = brandId;
//            currentProduct.catagoryId = catagoryId;
//            currentProduct.unitId = unitId;
//            currentProduct.rmaId = rmaId;
//            currentProduct.id = id;
//            currentProductBLL.update(currentProduct);
            refreshProductList();
        }

    }

    public void viewSelected(StoredProduct currentProduct) {

//        currentProductGetway.selectedView(currentProduct);
        tfProductId.setText(currentProduct.getProductId());
        tfProductName.setText(currentProduct.getProductName());
        tfProductQuantity.setText(currentProduct.getQuantity());
        tfProductPursesPrice.setText(currentProduct.getPursesPrice());
        tfProductSellPrice.setText(currentProduct.getSellPrice());
        taProductDescription.setText(currentProduct.getDescription());
        dpDate.setValue(LocalDate.parse(currentProduct.getDate().substring(0, 10)));
        supplyerId = currentProduct.getSupplierId();
        brandId = currentProduct.getBrandId();
        catagoryId = currentProduct.getCatagoryId();
        unitId = currentProduct.getUnitId();
        rmaId = currentProduct.getRmaId();
        cbSupplyer.setPromptText(currentProduct.getSupplierName());
        cmbBrand.setPromptText(currentProduct.getBrandName());
        cmbCatagory.setPromptText(currentProduct.getCategoryName());
        cbUnit.setPromptText(currentProduct.getUnitName());
        cbRMA.setPromptText(currentProduct.getRmaName());
    }

    @FXML
    private void cbUnitOnAction(ActionEvent event) {
        unitId = cbUnit.getSelectionModel().getSelectedItem().getKey();
    }

    @FXML
    private void cbRMAOnAction(ActionEvent event) {
        rmaId = cbRMA.getSelectionModel().getSelectedItem().getKey();
    }

    public void btnAddSupplierOnAction(ActionEvent actionEvent) {
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
            supplyerController.lblCaption.setText("Add Supplyer");
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

    public void btnAddBrandOnAction(ActionEvent actionEvent) {
        AddBrandController addSupplyerController = new AddBrandController();
        userNameMedia media = new userNameMedia();
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource(ApplicationPath.VIEW_FXML + "/stock/AddBrand.fxml"));
        try {
            fxmlLoader.load();
            Parent parent = fxmlLoader.getRoot();
            Scene scene = new Scene(parent);
            scene.setFill(new Color(0, 0, 0, 0));
            AddBrandController supplyerController = fxmlLoader.getController();
            media.setId(usrId);
            supplyerController.setMedia(media);
            supplyerController.lblHeader.setText("Add Brand");
            supplyerController.btnUpdate.setVisible(false);
            Stage nStage = new Stage();
            nStage.setScene(scene);
            nStage.initModality(Modality.APPLICATION_MODAL);
            nStage.initStyle(StageStyle.TRANSPARENT);
            nStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void btnAddCatagoryOnAction(ActionEvent actionEvent) {
//        AddCatagoryController addCatagoryController = new AddCatagoryController();
//        userNameMedia media = new userNameMedia();
//        FXMLLoader fxmlLoader = new FXMLLoader();
//        fxmlLoader.setLocation(getClass().getResource(ApplicationPath.VIEW_FXML + "/stock/AddCategory.fxml"));
//        try {
//            fxmlLoader.load();
//            Parent parent = fxmlLoader.getRoot();
//            Scene scene = new Scene(parent);
//            scene.setFill(new Color(0, 0, 0, 0));
//            AddCatagoryController catagoryController = fxmlLoader.getController();
//            media.setId(usrId);
//            catagoryController.setMedia(media);
//            catagoryController.lblHeaderContent.setText("Add Item");
//            catagoryController.btnUpdate.setVisible(false);
//            Stage nStage = new Stage();
//            nStage.setScene(scene);
//            nStage.initModality(Modality.APPLICATION_MODAL);
//            nStage.initStyle(StageStyle.TRANSPARENT);
//            nStage.show();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
    }

    public void btnAddUnitOnAction(ActionEvent actionEvent) {
//        AddUnitController addUnitController = new AddUnitController();
//        userNameMedia media = new userNameMedia();
//        FXMLLoader fxmlLoader = new FXMLLoader();
//        fxmlLoader.setLocation(getClass().getResource(ApplicationPath.VIEW_FXML + "/stock/AddUnit.fxml"));
//        try {
//            fxmlLoader.load();
//            Parent parent = fxmlLoader.getRoot();
//            Scene scene = new Scene(parent);
//            scene.setFill(new Color(0, 0, 0, 0));
//            AddUnitController unitController = fxmlLoader.getController();
//            media.setId(usrId);
//            unitController.setNameMedia(media);
//            unitController.lblContent.setText("ADD UNIT");
//            unitController.btnUpdate.setVisible(false);
//            Stage nStage = new Stage();
//            nStage.setScene(scene);
//            nStage.initModality(Modality.APPLICATION_MODAL);
//            nStage.initStyle(StageStyle.TRANSPARENT);
//            nStage.show();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
    }

    public void btnAddRmaOnAction(ActionEvent actionEvent) {
//        AddRMAController addRMAController = new AddRMAController();
//        userNameMedia media = new userNameMedia();
//        FXMLLoader fxmlLoader = new FXMLLoader();
//        fxmlLoader.setLocation(getClass().getResource(ApplicationPath.VIEW_FXML + "/stock/AddRMA.fxml"));
//        try {
//            fxmlLoader.load();
//            Parent parent = fxmlLoader.getRoot();
//            Scene scene = new Scene(parent);
//            scene.setFill(new Color(0, 0, 0, 0));
//            AddRMAController rmaController = fxmlLoader.getController();
//            media.setId(usrId);
//            rmaController.setMedia(media);
//            rmaController.lblContent.setText("ADD RMA");
//            rmaController.btnUpdate.setVisible(false);
//            Stage nStage = new Stage();
//            nStage.setScene(scene);
//            nStage.initModality(Modality.APPLICATION_MODAL);
//            nStage.initStyle(StageStyle.TRANSPARENT);
//            nStage.show();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
    }

    public void refreshProductList() {
        try {
            CurrentStoreController asc = new CurrentStoreController();
            FXMLLoader fXMLLoader = new FXMLLoader();
            fXMLLoader.load(getClass().getResource(ApplicationPath.VIEW_FXML + "/stock/CurrentStore.fxml").openStream());
            CurrentStoreController currentStoreController = fXMLLoader.getController();
            currentStoreController.viewDetails();
        } catch (IOException ex) {
            Logger.getLogger(AddProductController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
