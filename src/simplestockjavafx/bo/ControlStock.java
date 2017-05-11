/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simplestockjavafx.bo;

import java.math.BigDecimal;

/**
 *
 * @author macako
 */
public class ControlStock {

    Double stockValue;
    Double sellerValue;
    Integer totalSeller;
    Integer totalSupplyer;
    Integer totalProduct;
    Integer totalEmploye;

    public Double getStockValue() {
        return stockValue;
    }

    public void setStockValue(Double stockValue) {
        this.stockValue = stockValue;
    }

    public Double getSellerValue() {
        return sellerValue;
    }

    public void setSellerValue(Double sellerValue) {
        this.sellerValue = sellerValue;
    }

    public Integer getTotalSeller() {
        return totalSeller;
    }

    public void setTotalSeller(Integer totalSeller) {
        this.totalSeller = totalSeller;
    }

    public Integer getTotalSupplyer() {
        return totalSupplyer;
    }

    public void setTotalSupplyer(Integer totalSupplyer) {
        this.totalSupplyer = totalSupplyer;
    }

    public Integer getTotalProduct() {
        return totalProduct;
    }

    public void setTotalProduct(Integer totalProduct) {
        this.totalProduct = totalProduct;
    }

    public Integer getTotalEmploye() {
        return totalEmploye;
    }

    public void setTotalEmploye(Integer totalEmploye) {
        this.totalEmploye = totalEmploye;
    } 
    

}
