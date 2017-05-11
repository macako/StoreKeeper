package simplestockjavafx.bo;



import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 * Created by rifat on 8/2/15.
 */
public class RMA extends ExtraInfo{



    private Integer id;
    private String rmaName;
    private String rmaDays;
    private String rmaComment;
    
    

  //  public ObservableList<ListRma> rmaDetails = FXCollections.observableArrayList();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRmaName() {
        return rmaName;
    }

    public void setRmaName(String rmaName) {
        this.rmaName = rmaName;
    }

    public String getRmaDays() {
        return rmaDays;
    }

    public void setRmaDays(String rmaDays) {
        this.rmaDays = rmaDays;
    }

    public String getRmaComment() {
        return rmaComment;
    }

    public void setRmaComment(String rmaComment) {
        this.rmaComment = rmaComment;
    }




}