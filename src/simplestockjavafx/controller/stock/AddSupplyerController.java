/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simplestockjavafx.controller.stock;

//import Getway.SupplyerGetway;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
//import DAL.Supplyer;
import javafx.scene.control.Alert;
import javafx.stage.StageStyle;
import simplestockjavafx.bo.Supplyer;
import simplestockjavafx.resources.media.userNameMedia;
import simplestockjavafx.service.ControlStockSvc;
import simplestockjavafx.service.impl.ControlStockSvcImpl;
import simplestockjavafx.utils.EffectUtility;

/**
 * FXML Controller class
 *
 * @author rifat
 */
public class AddSupplyerController implements Initializable {

    private String usrId;

    public String supplyerId;

    private userNameMedia media;
    @FXML
    private TextField tfSupplyerName;
    @FXML
    private TextArea taSupplyerAddress;
    @FXML
    private TextArea taSupplyerDescription;
    @FXML
    public Button btnSave;
    @FXML
    private TextArea taContactNumbers;
    @FXML
    public Button btnUpdate;
    @FXML
    public Button btnClose;
    @FXML
    public Label lblCaption;

    private Stage primaryStage;
    @FXML
    private AnchorPane apContent;

    private ControlStockSvc controlStockSvc;

    public userNameMedia getMedia() {
        return media;
    }

    public void setMedia(userNameMedia media) {
        usrId = media.getId();
        this.media = media;
    }

//    SupplyerGetway supplyerGetway = new SupplyerGetway();
    /**
     * Initializes the controller class.
     *
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        controlStockSvc = new ControlStockSvcImpl();
    }

    @FXML
    private void btnSaveOnAction(ActionEvent event) {
        if (isNotNull()) {
            Supplyer oSupplier = new Supplyer();
            oSupplier.setSupplyerName(tfSupplyerName.getText());
            oSupplier.setSupplyerContactNumber(taContactNumbers.getText());
            oSupplier.setSupplyerAddress(taSupplyerAddress.getText());
            oSupplier.setSupplyerDescription(taSupplyerDescription.getText());
            oSupplier.setCreatedBy(usrId);
            oSupplier.setUpdatedBy(usrId);
            controlStockSvc.saveSupplyer(oSupplier);

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("error");
            alert.setHeaderText("Sucess : save sucess ");
            alert.setContentText("Supplayer added successfully");
            alert.initStyle(StageStyle.UNDECORATED);
            alert.showAndWait();

            clrAll();
        }
    }

    public boolean isNotNull() {
        boolean isNotNull;
        if (tfSupplyerName.getText().trim().isEmpty()
                  || tfSupplyerName.getText().trim().isEmpty()
                  || taSupplyerAddress.getText().trim().isEmpty()
                  || taSupplyerAddress.getText().trim().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("error");
            alert.setHeaderText("ERROR : NULL FOUND");
            alert.setContentText("Please fill all require field");
            alert.initStyle(StageStyle.UNDECORATED);
            alert.showAndWait();

            isNotNull = false;

        } else {
            isNotNull = true;
        }
        return isNotNull;
    }

    private void clrAll() {
        tfSupplyerName.clear();
        taContactNumbers.clear();
        taSupplyerAddress.clear();
        taSupplyerDescription.clear();
    }

    @FXML
    private void btnUpdateOnAction(ActionEvent event) {
        if (isNotNull()) {
            Supplyer oSupplier = new Supplyer();
            oSupplier.setSupplyerName(tfSupplyerName.getText().trim());
            oSupplier.setSupplyerContactNumber(taContactNumbers.getText().trim());
            oSupplier.setSupplyerAddress(taSupplyerAddress.getText().trim());
            oSupplier.setSupplyerDescription(taSupplyerDescription.getText().trim());
            oSupplier.setUpdatedBy(usrId);
            controlStockSvc.updateSupplyer(oSupplier);
//            supplyerGetway.update(oSupplier);
//            takeHistoy();
//            tfSearchOnType(event);
        }
    }

    @FXML
    private void btnCloseOnAction(ActionEvent event) {
        Stage stage = (Stage) btnUpdate.getScene().getWindow();
        stage.close();
    }

    public void showDetails() {
//        oSupplier.id = supplyerId;
//        supplyerGetway.selectedView(oSupplier);
//        tfSupplyerName.setText(oSupplier.supplyerName);
//        taContactNumbers.setText(oSupplier.supplyerContactNumber);
//        taSupplyerAddress.setText(oSupplier.supplyerAddress);
//        taSupplyerDescription.setText(oSupplier.supplyerDescription);
    }

    @FXML
    private void apOnMouseDragged(MouseEvent event) {

    }

    @FXML
    private void apOnMousePressed(MouseEvent event) {

    }

    public void addSupplyerStage(Stage stage) {
        EffectUtility.makeDraggable(stage, apContent);
    }

}
