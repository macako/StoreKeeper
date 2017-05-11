/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simplestockjavafx.controller;

//import DAL.Users;
//import Getway.UsersGetway;
//import controller.application.EmployeController;
//import controller.application.SellController;
//import controller.application.SettingsController;
//import controller.application.StockController;
//import controller.application.home.HomeController;
//import dataBase.DBConnection;
//import dataBase.DBProperties;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.ToggleButton;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.util.Duration;
import simplestockjavafx.bo.UserPermission;
import simplestockjavafx.bo.Users;
import simplestockjavafx.constants.ApplicationPath;
import simplestockjavafx.resources.media.userNameMedia;
import simplestockjavafx.service.LoginSvc;
import simplestockjavafx.service.impl.LoginSvcImpl;
import simplestockjavafx.utils.Misc;

/**
 * FXML Controller class
 *
 * @author rifat
 */
public class ApplicationController implements Initializable {

    @FXML
    private StackPane acContent;
    @FXML
    private ScrollPane leftSideBarScroolPan;
    @FXML
    private ToggleButton sideMenuToogleBtn;
    @FXML
    private ImageView imgMenuBtn;
    @FXML
    private BorderPane appContent;
    @FXML
    private Button btnLogOut;
    @FXML
    private MenuItem miPopOver;
    @FXML
    private AnchorPane acDashBord;
    @FXML
    private AnchorPane acHead;
    @FXML
    private AnchorPane acMain;
    @FXML
    private MenuButton mbtnUsrInfoBox;
    @FXML
    private Button btnHome;
    @FXML
    private ImageView imgHomeBtn;
    @FXML
    private Button btnStore;
    @FXML
    private ImageView imgStoreBtn;
    @FXML
    private Button btnEmplopye;
    @FXML
    private ImageView imgEmployeBtn;
    @FXML
    private Button btnSell;
    @FXML
    private ImageView imgSellBtn;
    @FXML
    private Button btnSettings;
    @FXML
    private ImageView imgSettingsBtn;
    @FXML
    private Button btnAbout;
    @FXML
    private ImageView imgAboutBtn;
    @FXML
    private Label lblUsrName;
    @FXML
    private Label lblUsrNamePopOver;
    @FXML
    private Label lblFullName;
    @FXML
    private Label lblRoleAs;
    @FXML
    private Hyperlink hlEditUpdateAccount;
    @FXML
    private Circle imgUsrTop;
    @FXML
    private Circle circleImgUsr;
    @FXML
    private Label lblUserId;

    private LoginSvc loginSvc;

    private String usrName;
    private String id;
    private Users user;
    private userNameMedia usrNameMedia;

    /*DBConnection dbCon = new DBConnection();
    Connection con;
    PreparedStatement pst;
    ResultSet rs;*/

    //DBProperties dBProperties = new DBProperties();
    //String db = dBProperties.loadPropertiesFile();

   // UsersGetway usersGetway = new UsersGetway();



    public userNameMedia getUsrNameMedia() {
        return usrNameMedia;
    }

    public void setUsrNameMedia(userNameMedia usrNameMedia) {

    }

    Image menuImage = Misc.getIcon("menu.png");
    Image menuImageRed = Misc.getIcon("menuRed.png");
    Image image;

    String defultStyle = "-fx-border-width: 0px 0px 0px 5px;"
              + "-fx-border-color:none";

    String activeStyle = "-fx-border-width: 0px 0px 0px 5px;"
              + "-fx-border-color:#FF4E3C";

    Image home = Misc.getIcon("home.png");
    Image homeRed = Misc.getIcon("homeRed.png");
    Image stock = Misc.getIcon("stock.png");
    Image stockRed = Misc.getIcon("stockRed.png");
    Image sell = Misc.getIcon("sell2.png");
    Image sellRed = Misc.getIcon("sell2Red.png");
    Image employee = Misc.getIcon("employe.png");
    Image employeeRed = Misc.getIcon("employeRed.png");
    Image setting = Misc.getIcon("settings.png");
    Image settingRed = Misc.getIcon("settingsRed.png");
    Image about = Misc.getIcon("about.png");
    Image aboutRed = Misc.getIcon("aboutRed.png");

    /**
     * Initializes the controller class.
     *
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        loginSvc = new LoginSvcImpl();
        imgMenuBtn.setImage(menuImage);
        Image usrImg = Misc.getImage("rifat.jpg");
        imgUsrTop.setFill(new ImagePattern(usrImg));
        circleImgUsr.setFill(new ImagePattern(usrImg));

    }

    @FXML
    private void sideMenuToogleBtnOnCLick(ActionEvent event) throws IOException {
        if (sideMenuToogleBtn.isSelected()) {
            imgMenuBtn.setImage(menuImageRed);
            TranslateTransition sideMenu = new TranslateTransition(Duration.millis(200.0), acDashBord);
            sideMenu.setByX(-130);
            sideMenu.play();
            acDashBord.getChildren().clear();
        } else {
            imgMenuBtn.setImage(menuImage);
            TranslateTransition sideMenu = new TranslateTransition(Duration.millis(200.0), acDashBord);
            sideMenu.setByX(130);
            sideMenu.play();
            acDashBord.getChildren().add(leftSideBarScroolPan);
        }
    }

    @FXML
    private void btnLogOut(ActionEvent event) throws IOException {
        acContent.getChildren().clear();
        acContent.getChildren().add(FXMLLoader.load(getClass().getResource(ApplicationPath.VIEW_FXML + "/Login.fxml")));
        acDashBord.getChildren().clear();
        acHead.getChildren().clear();
        acHead.setMaxHeight(0.0);
    }

    @FXML
    private void acMain(KeyEvent event) {
        if (event.getCode() == KeyCode.F11) {
            Stage stage = (Stage) acMain.getScene().getWindow();
            stage.setFullScreen(true);
        }
    }

    @FXML
    public void btnHomeOnClick(ActionEvent event) {
        homeActive();
        FXMLLoader fxmlLoader = new FXMLLoader();
        try {
            fxmlLoader.load(getClass().getResource(ApplicationPath.VIEW_FXML + "/home/Home.fxml").openStream());
        } catch (IOException e) {

        }
        AnchorPane root = fxmlLoader.getRoot();
        acContent.getChildren().clear();
        acContent.getChildren().add(root);

        System.out.println(lblUsrName.getText());
        System.out.println(lblUserId.getText());

    }

    @FXML
    private void btnStoreOnClick(ActionEvent event) throws IOException {
        sotreActive();
        StockController sc = new StockController();
        userNameMedia nm = new userNameMedia();
        FXMLLoader fXMLLoader = new FXMLLoader();
        fXMLLoader.load(getClass().getResource(ApplicationPath.VIEW_FXML +"/Stock.fxml").openStream());
        nm.setId(id);
        StockController stockController = fXMLLoader.getController();
        stockController.bpStore.getStylesheets().add(ApplicationPath.RESOURCES_PATH + "/style/MainStyle.css");
        stockController.setUserId(usrNameMedia);
        stockController.btnStockOnAction(event);
        stockController.settingPermission();
        AnchorPane acPane = fXMLLoader.getRoot();

        acContent.getChildren().clear();

        acContent.getChildren().add(acPane);
    }

    @FXML
    private void btnEmplopyeOnClick(ActionEvent event) throws IOException {
        /*employeeActive();
        EmployeController ec = new EmployeController();
        userNameMedia nm = new userNameMedia();
        FXMLLoader fXMLLoader = new FXMLLoader();
        fXMLLoader.load(getClass().getResource("/view/application/Employe.fxml").openStream());
        nm.setId(id);
        EmployeController employeController = fXMLLoader.getController();
        employeController.bpContent.getStylesheets().add("/style/MainStyle.css");
        employeController.setNameMedia(usrNameMedia);
        employeController.btnViewEmployeeOnAction(event);

        AnchorPane acPane = fXMLLoader.getRoot();

        acContent.getChildren().clear();

        acContent.getChildren().add(acPane);*/

    }

    @FXML
    private void btnSettingsOnClick(ActionEvent event) throws IOException {
       /* settingsActive();
        //inithilize Setting Controller
        SettingsController settingController = new SettingsController();
        //inithilize UserNameMedia
        userNameMedia usrMedia = new userNameMedia();
        // Define a loader to inithilize Settings.fxml controller
        FXMLLoader settingLoader = new FXMLLoader();
        //set the location of Settings.fxml by fxmlloader
        settingLoader.load(getClass().getResource("/view/application/Settings.fxml").openStream());

        //Send id to userMedia
        usrMedia.setId(id);
        //take control of settingController elements or node
        SettingsController settingControl = settingLoader.getController();
        settingControl.bpSettings.getStylesheets().add("/style/MainStyle.css");

        settingControl.setUsrMedia(usrMedia);
        settingControl.miMyASccountOnClick(event);
        settingControl.settingPermission();

        AnchorPane acPane = settingLoader.getRoot();
        //acContent clear and make useul for add next node
        acContent.getChildren().clear();
        //add a node call "acPane" to acContent
        acContent.getChildren().add(acPane);*/

    }

    @FXML
    private void btnAboutOnClick(ActionEvent event) {

       /* try {
            aboutActive();
            FXMLLoader fXMLLoader = new FXMLLoader();
            fXMLLoader.load(getClass().getResource("/view/application/about/AboutMe.fxml").openStream());

//            SellController sellController = fXMLLoader.getController();
//            sellController.acMainSells.getStylesheets().add("/style/MainStyle.css");
//            sellController.tbtnSellOnAction(event);
            AnchorPane anchorPane = fXMLLoader.getRoot();
            acContent.getChildren().clear();
            acContent.getChildren().add(anchorPane);
        } catch (IOException ex) {
            Logger.getLogger(ApplicationController.class.getName()).log(Level.SEVERE, null, ex);
        }*/
    }

    @FXML
    private void btnSellOnClick(ActionEvent event) {
      /*  sellActive();
        SellController controller = new SellController();
        userNameMedia nm = new userNameMedia();
        try {

            FXMLLoader fXMLLoader = new FXMLLoader();
            fXMLLoader.load(getClass().getResource("/view/application/Sell.fxml").openStream());
            nm.setId(id);
            SellController sellController = fXMLLoader.getController();
            sellController.setNameMedia(usrNameMedia);
            sellController.acMainSells.getStylesheets().add("/style/MainStyle.css");
            sellController.tbtnSellOnAction(event);
            AnchorPane anchorPane = fXMLLoader.getRoot();
            acContent.getChildren().clear();
            acContent.getChildren().add(anchorPane);
        } catch (IOException ex) {
            Logger.getLogger(ApplicationController.class.getName()).log(Level.SEVERE, null, ex);
        }*/

    }

    @FXML
    private void hlUpdateAccount(ActionEvent event) {

    }

    @FXML
    private void mbtnOnClick(ActionEvent event) {

    }

    @FXML
    private void acMainOnMouseMove(MouseEvent event) {

    }

    public void permission() {

        UserPermission userPermission = loginSvc.permission(new Integer(id));

        if (userPermission != null) {
            if (userPermission.getSellProduct().equalsIgnoreCase("N")) {
                btnSell.setDisable(true);
            }
            if (userPermission.getEmployeManage().equalsIgnoreCase("N")) {
                btnEmplopye.setDisable(true);
            }

        }

    }

    private void homeActive() {
        imgHomeBtn.setImage(homeRed);
        imgStoreBtn.setImage(stock);
        imgSellBtn.setImage(sell);
        imgEmployeBtn.setImage(employee);
        imgSettingsBtn.setImage(setting);
        imgAboutBtn.setImage(about);
        btnHome.setStyle(activeStyle);
        btnStore.setStyle(defultStyle);
        btnSell.setStyle(defultStyle);
        btnEmplopye.setStyle(defultStyle);
        btnSettings.setStyle(defultStyle);
        btnAbout.setStyle(defultStyle);
    }

    private void sotreActive() {
        imgHomeBtn.setImage(home);
        imgStoreBtn.setImage(stockRed);
        imgSellBtn.setImage(sell);
        imgEmployeBtn.setImage(employee);
        imgSettingsBtn.setImage(setting);
        imgAboutBtn.setImage(about);
        btnHome.setStyle(defultStyle);
        btnStore.setStyle(activeStyle);
        btnSell.setStyle(defultStyle);
        btnEmplopye.setStyle(defultStyle);
        btnSettings.setStyle(defultStyle);
        btnAbout.setStyle(defultStyle);
    }

    private void sellActive() {
        imgHomeBtn.setImage(home);
        imgStoreBtn.setImage(stock);
        imgSellBtn.setImage(sellRed);
        imgEmployeBtn.setImage(employee);
        imgSettingsBtn.setImage(setting);
        imgAboutBtn.setImage(about);
        btnHome.setStyle(defultStyle);
        btnStore.setStyle(defultStyle);
        btnSell.setStyle(activeStyle);
        btnEmplopye.setStyle(defultStyle);
        btnSettings.setStyle(defultStyle);
        btnAbout.setStyle(defultStyle);
    }

    private void employeeActive() {
        imgHomeBtn.setImage(home);
        imgStoreBtn.setImage(stock);
        imgSellBtn.setImage(sell);
        imgEmployeBtn.setImage(employeeRed);
        imgSettingsBtn.setImage(setting);
        imgAboutBtn.setImage(about);
        btnHome.setStyle(defultStyle);
        btnStore.setStyle(defultStyle);
        btnSell.setStyle(defultStyle);
        btnEmplopye.setStyle(activeStyle);
        btnSettings.setStyle(defultStyle);
        btnAbout.setStyle(defultStyle);
    }

    private void settingsActive() {
        imgHomeBtn.setImage(home);
        imgStoreBtn.setImage(stock);
        imgSellBtn.setImage(sell);
        imgEmployeBtn.setImage(employee);
        imgSettingsBtn.setImage(settingRed);
        imgAboutBtn.setImage(about);
        btnHome.setStyle(defultStyle);
        btnStore.setStyle(defultStyle);
        btnSell.setStyle(defultStyle);
        btnEmplopye.setStyle(defultStyle);
        btnSettings.setStyle(activeStyle);
        btnAbout.setStyle(defultStyle);
    }

    private void aboutActive() {
        imgHomeBtn.setImage(home);
        imgStoreBtn.setImage(stock);
        imgSellBtn.setImage(sell);
        imgEmployeBtn.setImage(employee);
        imgSettingsBtn.setImage(setting);
        imgAboutBtn.setImage(aboutRed);
        btnHome.setStyle(defultStyle);
        btnStore.setStyle(defultStyle);
        btnSell.setStyle(defultStyle);
        btnEmplopye.setStyle(defultStyle);
        btnSettings.setStyle(defultStyle);
        btnAbout.setStyle(activeStyle);
    }

    public void viewDetails() {
    if (user.getUserImage()!= null) {
        ByteArrayInputStream byteArrayInputStream = null;
        try {
            byteArrayInputStream = new ByteArrayInputStream(user.getUserImage().getBytes(1, (int) user.getUserImage().length()));
            user.setImage(new Image(byteArrayInputStream));
        } catch (SQLException ex) {
            Logger.getLogger(ApplicationController.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                byteArrayInputStream.close();
            } catch (IOException ex) {
                Logger.getLogger(ApplicationController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    } else {
        user.setImage(Misc.getImage("rifat.jpg"));
    }
        image = user.getImage();
        circleImgUsr.setFill(new ImagePattern(image));
        imgUsrTop.setFill(new ImagePattern(image));
        lblFullName.setText(user.getFullName());
        lblUsrNamePopOver.setText(user.getUserName());
        
        id = user.getId().toString();        
        lblUserId.setText(id);  
        lblUsrName.setText(user.getUserName());
        usrName = user.getUserName();      
        usrNameMedia = new userNameMedia(user.getId().toString(), user.getUserName());
//        users.id = id;
//        usersGetway.selectedView(users);
//        image = users.image;
//        circleImgUsr.setFill(new ImagePattern(image));
//        imgUsrTop.setFill(new ImagePattern(image));
//        lblFullName.setText(users.fullName);
//        lblUsrNamePopOver.setText(users.userName);
    }


    public void setUser(Users user) {
        this.user = user;
    }   
    
    
}
