/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simplestockjavafx.service.impl;

import simplestockjavafx.dao.UnitDAO;
import simplestockjavafx.dao.CategoryDAO;
import simplestockjavafx.dao.BrandDAO;
import simplestockjavafx.dao.RmaDAO;
import java.util.List;
import simplestockjavafx.bo.Brand;
import simplestockjavafx.bo.Category;
import simplestockjavafx.constants.DB;
import simplestockjavafx.bo.ControlStock;
import simplestockjavafx.bo.RMA;
import simplestockjavafx.bo.StoredProduct;
import simplestockjavafx.bo.Supplyer;
import simplestockjavafx.bo.Unit;
import simplestockjavafx.dao.ControlStockDAO;
import simplestockjavafx.dao.DAOAbstractFactory;
import simplestockjavafx.dao.DAOFactory;
import simplestockjavafx.service.ControlStockSvc;
import simplestockjavafx.dao.ProductDAO;
import simplestockjavafx.dao.SupplyerDAO;

/**
 *
 * @author macako
 */
public class ControlStockSvcImpl implements ControlStockSvc {

    private final ControlStockDAO controlStockDao;
    private final ProductDAO productDao;
    private final SupplyerDAO supplyerDao;
    private final UnitDAO unitDao;
    private final RmaDAO rmaDao;
    private final BrandDAO brandDao;
    private final CategoryDAO categoryDao;

    public ControlStockSvcImpl() {
        DAOFactory daoFactory = DAOAbstractFactory.getInstance(DB.DAO_FACTORY);
        controlStockDao = daoFactory.getControlStockDAO();
        productDao = daoFactory.getProductDAO();
        supplyerDao = daoFactory.getSupplyerDAO();
        unitDao = daoFactory.getUnitDAO();
        rmaDao = daoFactory.getRmaDAO();
        brandDao = daoFactory.getBranDAO();
        categoryDao = daoFactory.getCategoryDAO();

    }

    @Override
    public ControlStock getControlStock() {
        return controlStockDao.getControlStock();
    }

    @Override
    public ControlStock getOrganize() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<StoredProduct> getStoredProductPagedList(int size) {
        return productDao.getStoredProductPagedList(size);
    }

    @Override
    public List<Supplyer> getSupplyerList() {
        return supplyerDao.findAll();
    }

    @Override
    public Supplyer getSupplyerByID(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Supplyer getSupplyerByName(String name) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void saveProduct(StoredProduct product) {
        productDao.save(product);
    }

    @Override
    public List<Unit> getUnitList() {
        return unitDao.findAll();
    }

    @Override
    public List<RMA> getRmaList() {
        return rmaDao.findAll();
    }

    @Override
    public List<Brand> getBrandListBySupplyerId(Integer SupplyerId) {
        return brandDao.findByParameter(SupplyerId);
    }

    @Override
    public List<Category> getCategoryListBySupplyerAndBrandId(Integer supplyerId, Integer brandId) {
        Object [] params = {supplyerId, brandId};
        return categoryDao.findByParameters(params);
    }

    @Override
    public void saveSupplyer(Supplyer supplyer) {
        supplyerDao.save(supplyer);
    }

    @Override
    public void updateSupplyer(Supplyer product) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void saveBrand(Brand brand) {
        brandDao.save(brand);
    }


    @Override
    public void deleteProduct(StoredProduct product) {
        productDao.delete(product);
    }

    @Override
    public List<StoredProduct> getStoredProductBySupplyerId(Integer supplyerId) {
        return productDao.findByParameter(supplyerId);
    }

}
