/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simplestockjavafx.controller.home;

/*import Getway.CurrentProductGetway;
import dataBase.DBConnection;
import dataBase.DBProperties;*/
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.text.Text;
import simplestockjavafx.bo.ControlStock;
import simplestockjavafx.service.ControlStockSvc;
import simplestockjavafx.service.LoginSvc;
import simplestockjavafx.service.impl.ControlStockSvcImpl;

/**
 * FXML Controller class
 *
 * @author rifat
 */
public class HomeController implements Initializable {

    @FXML
    private Label lblTotalItem;
    @FXML
    private Label lblStockValue;
    @FXML
    private Label lblTotalSupplyer;
    @FXML
    private Label lblTotalEmployee;

    // DBConnection dbCon = new DBConnection();
    Connection con;
    PreparedStatement pst;
    ResultSet rs;
    @FXML
    private Label lblTotalSell;
    @FXML
    private Label lblSellValue;
    @FXML
    private Label lblOrgName;
    @FXML
    private Text txtOrgAddress;
    @FXML
    private Text txtorgPhoneNumber;

    private ControlStockSvc controlStockSvc;

    //  DBProperties dBProperties = new DBProperties();
    // String db = dBProperties.loadPropertiesFile();
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        controlStockSvc = new ControlStockSvcImpl();
        printControlStock();

    }

    private void printControlStock() {

        ControlStock controlStock = controlStockSvc.getControlStock();

        lblStockValue.setText(controlStock.getStockValue().toString());
        lblTotalSell.setText(controlStock.getTotalSeller().toString());
        lblTotalSupplyer.setText(controlStock.getTotalSupplyer().toString());
        lblTotalItem.setText(controlStock.getTotalProduct().toString());
        lblSellValue.setText(controlStock.getSellerValue().toString());
        lblTotalEmployee.setText(controlStock.getTotalEmploye().toString());

        //  pst =con.prepareStatement("select * from "+db+".Organize where Id=1");
//            rs = pst.executeQuery();
//            while(rs.next()){
//                lblOrgName.setText(rs.getString(2));
//                txtOrgAddress.setText(rs.getString(5));
//                txtorgPhoneNumber.setText(rs.getString(4));
    }
}
