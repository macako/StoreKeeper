/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simplestockjavafx.controller.stock;

//import BLL.CurrentProductBLL;
//import DAL.CurrentProduct;
//import Getway.CurrentProductGetway;
//import controller.application.sell.NewSellController;
//import controller.application.sell.ViewCustomerController;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
//import List.ListProduct;
//import controller.application.SettingsController;
//import dataBase.DBConnection;
//import dataBase.DBProperties;
//import dataBase.SQL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.input.ScrollEvent;
import javafx.scene.layout.AnchorPane;
import simplestockjavafx.bo.StoredProduct;
import simplestockjavafx.bo.Supplyer;
import simplestockjavafx.bo.UserPermission;
import simplestockjavafx.constants.ApplicationPath;
import simplestockjavafx.resources.media.userNameMedia;
import simplestockjavafx.service.ControlStockSvc;
import simplestockjavafx.service.LoginSvc;
import simplestockjavafx.service.impl.ControlStockSvcImpl;
import simplestockjavafx.service.impl.LoginSvcImpl;
import simplestockjavafx.utils.KeyValuePair;

/**
 * FXML Controller class
 *
 * @author rifat
 */
public class CurrentStoreController implements Initializable {

//    CurrentProduct productCurrent = new CurrentProduct();
//    CurrentProductGetway currentProductGetway = new CurrentProductGetway();
//    CurrentProductBLL currentProductBLL = new CurrentProductBLL();
    // DBProperties dBProperties = new DBProperties();
    //  String db = dBProperties.loadPropertiesFile();
    private String usrId;

    private userNameMedia media;
    @FXML
    public StackPane spProductContent;
    @FXML
    private TextField tfSearch;
    @FXML
    private ComboBox<KeyValuePair> cbSoteViewSupplyer;
    @FXML
    private ComboBox<String> cbSoteViewBrands;
    @FXML
    private ComboBox<String> cbSoteViewCatagory;
    @FXML
    private ComboBox<String> cbSoteViewRMA;
    @FXML
    private Button btnAddNew;
    @FXML
    private Button btnUpdate;
    @FXML
    private Button btnDelete;
    @FXML
    private TableView<StoredProduct> tblViewCurrentStore;
    @FXML
    private TableColumn<Object, Object> tblClmProductId;
    @FXML
    private TableColumn<Object, Object> tblClmProductName;
    @FXML
    private TableColumn<Object, Object> tblClmProductquantity;
    @FXML
    private TableColumn<Object, Object> tblClmProductUnit;
    @FXML
    private TableColumn<Object, Object> tblClmProductRMA;
    @FXML
    private TableColumn<Object, Object> tblClmProductSupplyer;
    @FXML
    private TableColumn<Object, Object> tblClmProductBrand;
    @FXML
    private TableColumn<Object, Object> tblClmProductCatagory;
    @FXML
    private TableColumn<Object, Object> tblClmProductPursesPrice;
    @FXML
    private TableColumn<Object, Object> tblClmProductSellPrice;
    @FXML
    private TableColumn<Object, Object> tblClmProductdate;
    @FXML
    private TableColumn<Object, Object> tblClmProductAddBy;
    @FXML
    private TableColumn<Object, Object> tblClmProductdescription;
    @FXML
    private MenuItem miSellSelected;

    String suplyerId;
    String suplyerName;
    String brandId;
    String brandName;
    String catagoryId;
    String catagoryName;
    String rmaID;
    String rmaName;
    private LoginSvc loginSvc;
    private ControlStockSvc controlStockSvc;
    private ObservableList<StoredProduct> currentStoredProductList;

//    SQL sql = new SQL();
    @FXML
    private Button btnRefresh;
    @FXML
    public AnchorPane apCombobox;

    public userNameMedia getMedia() {
        return media;
    }

    public void setMedia(userNameMedia media) {
        usrId = media.getId();
        this.media = media;
    }

//    DBConnection dbCon = null;//new DBConnection();
    Connection con = null;//dbCon.geConnection();
    PreparedStatement pst;
    ResultSet rs;

    /**
     * Initializes the controller class.
     *
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        loginSvc = new LoginSvcImpl();
        controlStockSvc = new ControlStockSvcImpl();
        currentStoredProductList = FXCollections.observableArrayList();
    }

    @FXML
    private void tfSearchOnKeyRelese(KeyEvent event) {
//        productCurrent.productId = tfSearch.getText();
        //       productCurrent.productName = tfSearch.getText();
        //       currentProductGetway.searchView(productCurrent);

    }

    @FXML
    private void cbSoteViewSupplyerOnClick(MouseEvent event) {
        //   con = dbCon.geConnection();
        cbSoteViewSupplyer.getItems().clear();
        cbSoteViewSupplyer.getItems().removeAll();
        cbSoteViewBrands.setPromptText("Select Brand");
        cbSoteViewCatagory.setPromptText("Select Category");

        List<Supplyer> supplyerList = controlStockSvc.getSupplyerList();

        for (Supplyer supplyer : supplyerList) {
            cbSoteViewSupplyer.getItems().add(new KeyValuePair(supplyer.getId(), supplyer.getSupplyerName()));
        }
    
    }

    @FXML
    private void cbSoteViewBrandOnClick(MouseEvent event) {
//        con = dbCon.geConnection();
//        cbSoteViewBrands.getItems().clear();
//        suplyerName = cbSoteViewSupplyer.getSelectionModel().getSelectedItem();
//        suplyerId = sql.getIdNo(suplyerName, suplyerId, "Supplyer", "SupplyerName");
//
//        try {
//            pst = con.prepareStatement("select * from Brands where SupplyerId=?");
//            pst.setString(1, suplyerId);
//            rs = pst.executeQuery();
//            while (rs.next()) {
//                cbSoteViewBrands.getItems().add(rs.getString(2));
//            }
//            rs.close();
//            con.close();
//            pst.close();
//        } catch (SQLException ex) {
//            Logger.getLogger(CurrentStoreController.class.getName()).log(Level.SEVERE, null, ex);
//        }

    }

    @FXML
    private void cbSoteViewCatagoryOnClick(MouseEvent event) {
//        con = dbCon.geConnection();
//        cbSoteViewCatagory.getItems().clear();
//        suplyerName = cbSoteViewSupplyer.getSelectionModel().getSelectedItem();
//        suplyerId = sql.getIdNo(suplyerName, suplyerId, "Supplyer", "SupplyerName");
//        brandId = sql.getBrandID(suplyerId, brandId, brandName);
//        try {
//            pst = con.prepareStatement("select * from Catagory where SupplyerId=? and BrandId=?");
//            pst.setString(1, suplyerId);
//            pst.setString(2, brandId);
//            rs = pst.executeQuery();
//            while (rs.next()) {
//                cbSoteViewCatagory.getItems().add(rs.getString(2));
//            }
//            rs.close();
//            con.close();
//            pst.close();
//        } catch (SQLException ex) {
//            Logger.getLogger(CurrentStoreController.class.getName()).log(Level.SEVERE, null, ex);
//        }

    }

    @FXML
    private void cbSoteViewRMAOnClick(MouseEvent event) {
//        cbSoteViewRMA.getItems().clear();
//        con = dbCon.geConnection();
//        try {
//            pst = con.prepareStatement("select * from RMA");
//            rs = pst.executeQuery();
//            while (rs.next()) {
//                cbSoteViewRMA.getItems().add(rs.getString(2));
//            }
//            rs.close();
//            con.close();
//            pst.close();
//        } catch (SQLException ex) {
//            Logger.getLogger(CurrentStoreController.class.getName()).log(Level.SEVERE, null, ex);
//        }
    }

    @FXML
    private void btnAddNewOnAction(ActionEvent event) {
        AddProductController apc = new AddProductController();
        userNameMedia media = new userNameMedia();
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource(ApplicationPath.VIEW_FXML + "/stock/AddProduct.fxml"));
        try {
            fxmlLoader.load();
            Parent parent = fxmlLoader.getRoot();
            Scene scene = new Scene(parent);
            scene.setFill(new Color(0, 0, 0, 0));
            AddProductController addProductController = fxmlLoader.getController();
            media.setId(usrId);
            addProductController.setNameMedia(media);
            addProductController.lblHeader.setText("Add PRODUCT");
            addProductController.btnUpdate.setVisible(false);
            Stage nStage = new Stage();
//            addProductController.addSupplyerStage(nStage);----va omitido desde antes
            nStage.setScene(scene);
            nStage.initModality(Modality.APPLICATION_MODAL);
            nStage.initStyle(StageStyle.TRANSPARENT);
            nStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void btnUpdateOnAction(ActionEvent event) {
        if (!tblViewCurrentStore.getSelectionModel().isEmpty()) {
            viewSelected();
        } else {
            System.out.println("EMPTY SELECTION");
        }
    }

    @FXML
    private void btnDeleteOnAction(ActionEvent event) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Login Now");
        alert.setHeaderText("Confirm");
        alert.setContentText("Are you sure to delete this item \n to Confirm click ok");
        alert.initStyle(StageStyle.UNDECORATED);
        Optional<ButtonType> result = alert.showAndWait();
        if (result.isPresent() && result.get() == ButtonType.OK) {
            StoredProduct product = tblViewCurrentStore.getSelectionModel().getSelectedItem();
            controlStockSvc.deleteProduct(product);
            btnRefreshOnACtion(event);
        }

    }

    @FXML
    private void tblViewCurrentStoreOnClick(MouseEvent event
    ) {
        if (event.getClickCount() == 2) {
            if (!tblViewCurrentStore.getSelectionModel().isEmpty()) {
                viewSelected();
            } else {
                System.out.println("EMPTY SELECTION");
            }
        } else {
            tblViewCurrentStore.setOnMouseClicked(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {
                    tblViewCurrentStore.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
                }
            });

        }
    }

    public void viewDetails() {
        tblViewCurrentStore.setItems(currentStoredProductList);
        tblClmProductId.setCellValueFactory(new PropertyValueFactory<>("productId"));
        tblClmProductName.setCellValueFactory(new PropertyValueFactory<>("productName"));
        tblClmProductquantity.setCellValueFactory(new PropertyValueFactory<>("quantity"));
        tblClmProductdescription.setCellValueFactory(new PropertyValueFactory<>("description"));
        tblClmProductSupplyer.setCellValueFactory(new PropertyValueFactory<>("supplierName"));
        tblClmProductBrand.setCellValueFactory(new PropertyValueFactory<>("brandName"));
        tblClmProductCatagory.setCellValueFactory(new PropertyValueFactory<>("categoryName"));
        tblClmProductUnit.setCellValueFactory(new PropertyValueFactory<>("unitName"));
        tblClmProductPursesPrice.setCellValueFactory(new PropertyValueFactory<>("pursesPrice"));
        tblClmProductSellPrice.setCellValueFactory(new PropertyValueFactory<>("sellPrice"));
        tblClmProductRMA.setCellValueFactory(new PropertyValueFactory<>("rmaName"));
        tblClmProductAddBy.setCellValueFactory(new PropertyValueFactory<>("userName"));
        tblClmProductdate.setCellValueFactory(new PropertyValueFactory<>("createdOn"));
        currentStoredProductList.clear();
        currentStoredProductList.addAll(controlStockSvc.getStoredProductPagedList(10));

    }

    private void viewSelected() {
        AddProductController apc = new AddProductController();
        userNameMedia userMedia = new userNameMedia();
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource(ApplicationPath.VIEW_FXML + "/stock/AddProduct.fxml"));
        try {
            fxmlLoader.load();
            Parent parent = fxmlLoader.getRoot();
            Scene scene = new Scene(parent);
            scene.setFill(new Color(0, 0, 0, 0));
            AddProductController addProductController = fxmlLoader.getController();
            userMedia.setId(usrId);
            addProductController.setNameMedia(userMedia);
            addProductController.lblHeader.setText("PRODUCT DETAILS");
            addProductController.btnUpdate.setVisible(true);
            addProductController.btnSave.setVisible(false);
            addProductController.id = tblViewCurrentStore.getSelectionModel().getSelectedItem().getId().toString();
            addProductController.viewSelected(tblViewCurrentStore.getSelectionModel().getSelectedItem());
            Stage nStage = new Stage();
            nStage.setScene(scene);
            nStage.initModality(Modality.APPLICATION_MODAL);
            nStage.initStyle(StageStyle.TRANSPARENT);
            nStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void miSellSelectedOnAction(ActionEvent event) {
//        if (tblViewCurrentStore.getSelectionModel().getSelectedItem() != null) {
//            String item = tblViewCurrentStore.getSelectionModel().getSelectedItem().getProductId();
//            NewSellController acc = new NewSellController();
//            userNameMedia media = new userNameMedia();
//            FXMLLoader fXMLLoader = new FXMLLoader();
//            fXMLLoader.setLocation(getClass().getResource("/view/application/sell/NewSell.fxml"));
//            try {
//                fXMLLoader.load();
//                Parent parent = fXMLLoader.getRoot();
//                Scene scene = new Scene(parent);
//                scene.setFill(new Color(0, 0, 0, 0));
//                NewSellController newSellController = fXMLLoader.getController();
//                newSellController.tfProductId.setText(item);
//                newSellController.tfProductIdOnAction(event);
//                media.setId(usrId);
//                newSellController.setNameMedia(media);
//                newSellController.genarateSellID();
//                Stage stage = new Stage();
//                stage.setScene(scene);
//                stage.initModality(Modality.APPLICATION_MODAL);
//                stage.initStyle(StageStyle.TRANSPARENT);
//                stage.show();
//            } catch (IOException ex) {
//                Logger.getLogger(ViewCustomerController.class.getName()).log(Level.SEVERE, null, ex);
//            }
//        } else {
//
//        }
    }

    @FXML
    private void cbSoteViewSupplyerOnAction(ActionEvent event) {
        if (cbSoteViewSupplyer.getSelectionModel().getSelectedItem() != null) {

            suplyerName = cbSoteViewSupplyer.getSelectionModel().getSelectedItem().toString();
            Integer supplyerId = cbSoteViewSupplyer.getSelectionModel().getSelectedItem().getKey();
            currentStoredProductList.clear();
            currentStoredProductList.addAll(controlStockSvc.getStoredProductBySupplyerId(supplyerId));

        }

    }

    @FXML
    private void cbSoteViewBrandOnAction(ActionEvent event) {

        if (cbSoteViewBrands.getSelectionModel().getSelectedItem() == null) {

        } else {
            brandName = cbSoteViewBrands.getSelectionModel().getSelectedItem();
            suplyerName = cbSoteViewSupplyer.getPromptText();
//            productCurrent.supplierName = suplyerName;
            //          productCurrent.brandName = brandName;
            //           currentProductGetway.searchByBrand(productCurrent);
        }
    }

    @FXML
    private void cbSoteViewCatagoryOnAction(ActionEvent event) {
        if (cbSoteViewCatagory.getSelectionModel().getSelectedItem() == null) {

        } else {
            brandName = cbSoteViewBrands.getSelectionModel().getSelectedItem();
            suplyerName = cbSoteViewSupplyer.getPromptText();
            catagoryName = cbSoteViewCatagory.getSelectionModel().getSelectedItem();
//            productCurrent.supplierName = suplyerName;
//            productCurrent.brandName = brandName;
//            productCurrent.catagoryName = catagoryName;
//            currentProductGetway.searchByCatagory(productCurrent);
        }
    }

    public void settingPermission() {
        UserPermission userPermission = loginSvc.permission(new Integer(usrId));

        if (userPermission != null) {
            if (userPermission.getSellProduct().equals("N")) {
                miSellSelected.setDisable(true);
            }
        }
//        con = dbCon.geConnection();
//        try {
//            pst = con.prepareStatement("select * from "+db+".UserPermission where id=?");
//            pst.setString(1, usrId);
//            rs = pst.executeQuery();
//            while (rs.next()) {
//                if (rs.getInt(8) == 0) {
//                    btnUpdate.setDisable(true);
//                    btnDelete.setDisable(true);
//                }
//                if (rs.getInt(3) == 0) {
//                    btnAddNew.setDisable(true);
//                }
//                if (rs.getInt("SellProduct") == 0) {
//                    miSellSelected.setDisable(true);
//                } else {
//
//                }
//            }
//        } catch (SQLException ex) {
/////            Logger.getLogger(SettingsController.class.getName()).log(Level.SEVERE, null, ex);
//        }
    }

    @FXML
    private void btnRefreshOnACtion(ActionEvent event) {
//        productCurrent.currentProductList.clear();
        tfSearch.clear();
        cbSoteViewRMA.getItems().clear();
        cbSoteViewSupplyer.getItems().clear();
        cbSoteViewBrands.getItems().clear();
        cbSoteViewCatagory.getItems().clear();
        cbSoteViewSupplyer.setPromptText("Select supplier");
        cbSoteViewBrands.setPromptText("select brands");
        cbSoteViewCatagory.setPromptText("select category");
        cbSoteViewRMA.setPromptText("select rma");

//        tblViewCurrentStore.setItems(productCurrent.currentProductList);
        tblClmProductId.setCellValueFactory(new PropertyValueFactory<>("productId"));
        tblClmProductName.setCellValueFactory(new PropertyValueFactory<>("productName"));
        tblClmProductquantity.setCellValueFactory(new PropertyValueFactory<>("quantity"));
        tblClmProductdescription.setCellValueFactory(new PropertyValueFactory<>("description"));
        tblClmProductSupplyer.setCellValueFactory(new PropertyValueFactory<>("suppliedBy"));
        tblClmProductBrand.setCellValueFactory(new PropertyValueFactory<>("brand"));
        tblClmProductCatagory.setCellValueFactory(new PropertyValueFactory<>("catagory"));
        tblClmProductUnit.setCellValueFactory(new PropertyValueFactory<>("unit"));
        tblClmProductPursesPrice.setCellValueFactory(new PropertyValueFactory<>("pursesPrice"));
        tblClmProductSellPrice.setCellValueFactory(new PropertyValueFactory<>("sellPrice"));
        tblClmProductRMA.setCellValueFactory(new PropertyValueFactory<>("rma"));
        tblClmProductAddBy.setCellValueFactory(new PropertyValueFactory<>("user"));
        tblClmProductdate.setCellValueFactory(new PropertyValueFactory<>("createdOn"));
//        currentProductGetway.view(productCurrent);

    }

    @FXML
    private void cbSoteViewRMAOnAction(ActionEvent event) {
//        con = dbCon.geConnection();
//        rmaName = cbSoteViewRMA.getSelectionModel().getSelectedItem();
//        System.out.println("Rma Name " + rmaName);
//        try {
//            pst = con.prepareStatement("select * from "+db+".RMA where RMAName=?");
//            pst.setString(1, rmaName);
//            rs = pst.executeQuery();
//            while (rs.next()) {
//                System.out.println("in the loop" + rs.getString(1));
//                rmaID = rs.getString(1);
//                System.out.println("Print rma id" + rmaID);
//            }
//        } catch (SQLException ex) {
//            Logger.getLogger(CurrentStoreController.class.getName()).log(Level.SEVERE, null, ex);
//        }
//
//        productCurrent.rmaId = rmaID;
//        currentProductGetway.searchByRMA(productCurrent);
    }

    @FXML
    private void tblViewCurrentStoreOnScroll(ScrollEvent event) {
        if (event.isInertia()) {
            System.out.println("ALT DOWN");
        } else {
            System.out.println("Noting");
        }
    }

}
