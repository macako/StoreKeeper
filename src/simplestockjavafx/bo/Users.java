package simplestockjavafx.bo;

//import List.ListEmployee;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.image.Image;
import java.sql.*;

/**
 * Created by rifat on 8/2/15.
 */
public class Users extends ExtraInfo{

    public ObservableList<String> allUser = FXCollections.observableArrayList();

    private Integer id;
    private String userName;
    private String sso;
    private String fullName;
    private String emailAddress;
    private String contactNumber;
    private String salary;
    private String address;
    private String password;
    private String status;
    private String imagePath;
    private Blob   userImage;
    private String date;
    private String creatorId;
    private Image image;
    private String isActive;

//    public ObservableList<ListEmployee> employeeLists = FXCollections.observableArrayList();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public Blob getUserImage() {
        return userImage;
    }

    public void setUserImage(Blob userImage) {
        this.userImage = userImage;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getCreatorId() {
        return creatorId;
    }

    public void setCreatorId(String creatorId) {
        this.creatorId = creatorId;
    }  

    public String getSso() {
        return sso;
    }

    public void setSso(String sso) {
        this.sso = sso;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public String getIsActive() {
        return isActive;
    }

    public void setIsActive(String isActive) {
        this.isActive = isActive;
    }     
   
    
}
