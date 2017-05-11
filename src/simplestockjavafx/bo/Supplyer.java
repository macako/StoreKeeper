package simplestockjavafx.bo;

//import List.ListSupplyer;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 * Created by rifat on 8/1/15.
 */
public class Supplyer extends ExtraInfo {

    private Integer id;
    private String supplyerName;
    private String supplyerContactNumber;
    private String supplyerAddress;
    private String supplyerDescription;

//    public List<ListSupplyer> rowSupplyer;
//    public ObservableList<ListSupplyer> supplyerDetails = FXCollections.observableArrayList();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSupplyerName() {
        return supplyerName;
    }

    public void setSupplyerName(String supplyerName) {
        this.supplyerName = supplyerName;
    }

    public String getSupplyerContactNumber() {
        return supplyerContactNumber;
    }

    public void setSupplyerContactNumber(String supplyerContactNumber) {
        this.supplyerContactNumber = supplyerContactNumber;
    }

    public String getSupplyerAddress() {
        return supplyerAddress;
    }

    public void setSupplyerAddress(String supplyerAddress) {
        this.supplyerAddress = supplyerAddress;
    }

    public String getSupplyerDescription() {
        return supplyerDescription;
    }

    public void setSupplyerDescription(String supplyerDescription) {
        this.supplyerDescription = supplyerDescription;
    }

}
