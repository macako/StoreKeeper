package simplestockjavafx.bo;


//import List.ListUnit;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 * Created by rifat on 8/2/15.
 */
public class Unit extends ExtraInfo {



    private Integer id;
    private String unitName;
    private String unitDescription;
      

//    public ObservableList<ListUnit> unitDetails = FXCollections.observableArrayList();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUnitName() {
        return unitName;
    }

    public void setUnitName(String unitName) {
        this.unitName = unitName;
    }

    public String getUnitDescription() {
        return unitDescription;
    }

    public void setUnitDescription(String unitDescription) {
        this.unitDescription = unitDescription;
    }
    
}