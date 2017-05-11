package simplestockjavafx.bo;


//import List.ListCatagory;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 * Created by rifat on 8/2/15.
 */
public class Category {

    private Integer id;
    private String categoryName;
    private String categoryDescription;
    private Integer brandId;
    private Integer supplyerId;
    

//    public ObservableList<ListCatagory> catagoryDetails = FXCollections.observableArrayList();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getCategoryDescription() {
        return categoryDescription;
    }

    public void setCategoryDescription(String categoryDescription) {
        this.categoryDescription = categoryDescription;
    }

    
    public Integer getBrandId() {
        return brandId;
    }

    public void setBrandId(Integer brandId) {
        this.brandId = brandId;
    }


    public Integer getSupplyerId() {
        return supplyerId;
    }

    public void setSupplyerId(Integer supplyerId) {
        this.supplyerId = supplyerId;
    }

}