package simplestockjavafx.bo;

import javafx.scene.image.Image;
import java.sql.*;

/**
 * Created by macako
 */
public class UserPermission extends ExtraInfo {

    private Integer id;
    private String addProduct;
    private String addSupplyer;
    private String addBrand;
    private String addCatagory;
    private String addUnit;
    private String addCustomer;
    private String updateProduct;
    private String updateSupplyer;
    private String updateBrand;
    private String updateCatagory;
    private String updateUnit;
    private String updateCustomer;
    private String rmaManage;
    private String sellProduct;
    private String provideDiscount;
    private String employeManage;
    private String orgManage;
    private String changeOwnPass;
    private Integer userSeqId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAddProduct() {
        return addProduct;
    }

    public void setAddProduct(String addProduct) {
        this.addProduct = addProduct;
    }

    public String getAddSupplyer() {
        return addSupplyer;
    }

    public void setAddSupplyer(String addSupplyer) {
        this.addSupplyer = addSupplyer;
    }

    public String getAddBrand() {
        return addBrand;
    }

    public void setAddBrand(String addBrand) {
        this.addBrand = addBrand;
    }

    public String getAddCatagory() {
        return addCatagory;
    }

    public void setAddCatagory(String addCatagory) {
        this.addCatagory = addCatagory;
    }

    public String getAddUnit() {
        return addUnit;
    }

    public void setAddUnit(String addUnit) {
        this.addUnit = addUnit;
    }

    public String getAddCustomer() {
        return addCustomer;
    }

    public void setAddCustomer(String addCustomer) {
        this.addCustomer = addCustomer;
    }

    public String getUpdateProduct() {
        return updateProduct;
    }

    public void setUpdateProduct(String updateProduct) {
        this.updateProduct = updateProduct;
    }

    public String getUpdateSupplyer() {
        return updateSupplyer;
    }

    public void setUpdateSupplyer(String updateSupplyer) {
        this.updateSupplyer = updateSupplyer;
    }

    public String getUpdateBrand() {
        return updateBrand;
    }

    public void setUpdateBrand(String updateBrand) {
        this.updateBrand = updateBrand;
    }

    public String getUpdateCatagory() {
        return updateCatagory;
    }

    public void setUpdateCatagory(String updateCatagory) {
        this.updateCatagory = updateCatagory;
    }

    public String getUpdateUnit() {
        return updateUnit;
    }

    public void setUpdateUnit(String updateUnit) {
        this.updateUnit = updateUnit;
    }

    public String getUpdateCustomer() {
        return updateCustomer;
    }

    public void setUpdateCustomer(String updateCustomer) {
        this.updateCustomer = updateCustomer;
    }

    public String getRmaManage() {
        return rmaManage;
    }

    public void setRmaManage(String rmaManage) {
        this.rmaManage = rmaManage;
    }

    public String getSellProduct() {
        return sellProduct;
    }

    public void setSellProduct(String sellProduct) {
        this.sellProduct = sellProduct;
    }

    public String getProvideDiscount() {
        return provideDiscount;
    }

    public void setProvideDiscount(String provideDiscount) {
        this.provideDiscount = provideDiscount;
    }

    public String getEmployeManage() {
        return employeManage;
    }

    public void setEmployeManage(String employeManage) {
        this.employeManage = employeManage;
    }

    public String getOrgManage() {
        return orgManage;
    }

    public void setOrgManage(String orgManage) {
        this.orgManage = orgManage;
    }

    public String getChangeOwnPass() {
        return changeOwnPass;
    }

    public void setChangeOwnPass(String changeOwnPass) {
        this.changeOwnPass = changeOwnPass;
    }

    public Integer getUserSeqId() {
        return userSeqId;
    }

    public void setUserSeqId(Integer userSeqId) {
        this.userSeqId = userSeqId;
    }
    
    

}
