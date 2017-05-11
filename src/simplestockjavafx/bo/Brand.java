package simplestockjavafx.bo;


//import List.ListBrands;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 * Created by rifat on 8/2/15.
 */
public class Brand extends ExtraInfo {

    private Integer id;
    private String brandName;
    private String brandComment;
    private Integer supplyerId;
     

//    public ObservableList<ListBrands> brandDitails = FXCollections.observableArrayList();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public String getBrandComment() {
        return brandComment;
    }

    public void setBrandComment(String brandComment) {
        this.brandComment = brandComment;
    }

    public Integer getSupplyerId() {
        return supplyerId;
    }

    public void setSupplyerId(Integer supplyerId) {
        this.supplyerId = supplyerId;
    }    


}