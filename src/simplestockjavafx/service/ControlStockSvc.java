/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simplestockjavafx.service;

import java.util.List;
import simplestockjavafx.bo.Brand;
import simplestockjavafx.bo.Category;
import simplestockjavafx.bo.ControlStock;
import simplestockjavafx.bo.RMA;
import simplestockjavafx.bo.StoredProduct;
import simplestockjavafx.bo.Supplyer;
import simplestockjavafx.bo.Unit;

/**
 *
 * @author macako
 */
public interface ControlStockSvc {

    ControlStock getControlStock();

    ControlStock getOrganize();

    List<StoredProduct> getStoredProductPagedList(int size);

    List<Supplyer> getSupplyerList();

    List<Unit> getUnitList();

    List<RMA> getRmaList();

    List<Brand> getBrandListBySupplyerId(Integer SupplyerId);

    List<Category> getCategoryListBySupplyerAndBrandId(Integer supplyerId, Integer brandId);

    Supplyer getSupplyerByID(Integer id);

    Supplyer getSupplyerByName(String name);

    void saveProduct(StoredProduct product);

    void saveSupplyer(Supplyer supplyer);

    void saveBrand(Brand brand);

    void updateSupplyer(Supplyer supplyer);

    void deleteProduct(StoredProduct selectedItem);

    List<StoredProduct> getStoredProductBySupplyerId(Integer supplyerId);

}
