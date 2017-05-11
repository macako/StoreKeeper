/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simplestockjavafx.dao;

import simplestockjavafx.dao.jdbc.sqlite.BrandDAOmpl;
import simplestockjavafx.dao.jdbc.sqlite.CategoryDAOImpl;
import simplestockjavafx.dao.jdbc.sqlite.ControlStockDaoImpl;
import simplestockjavafx.dao.jdbc.sqlite.LookUpDAOImpl;
import simplestockjavafx.dao.jdbc.sqlite.ProductDAOImpl;
import simplestockjavafx.dao.jdbc.sqlite.RmaDAOImpl;
import simplestockjavafx.dao.jdbc.sqlite.SupplyerDAOImpl;
import simplestockjavafx.dao.jdbc.sqlite.UnitDAOImpl;
import simplestockjavafx.dao.jdbc.sqlite.UserDAOImpl;
import simplestockjavafx.dao.jdbc.sqlite.UserPermissionDAOImpl;

/**
 *
 * @author macako
 */
class DAOSqliteJDBCFactory implements DAOFactory {

    public DAOSqliteJDBCFactory() {
    }

    @Override
    public UserDAO getUserDao() {
        return new UserDAOImpl();
    }

    @Override
    public LookUpDAO getLookUpDAO() {
        return new LookUpDAOImpl();
    }

    @Override
    public UserPermissionDAO getUserPermissionDao() {
        return new UserPermissionDAOImpl();
    }

    @Override
    public ControlStockDAO getControlStockDAO() {
        return new ControlStockDaoImpl();
    }

    @Override
    public ProductDAO getProductDAO() {
        return new ProductDAOImpl();
    }

    @Override
    public SupplyerDAO getSupplyerDAO() {
        return new SupplyerDAOImpl();
    }

    @Override
    public UnitDAO getUnitDAO() {
        return new UnitDAOImpl();
    }

    @Override
    public RmaDAO getRmaDAO() {
        return new RmaDAOImpl();
    }

    @Override
    public BrandDAO getBranDAO() {
        return new BrandDAOmpl();
    }

    @Override
    public CategoryDAO getCategoryDAO() {
        return new CategoryDAOImpl();
    }

}
