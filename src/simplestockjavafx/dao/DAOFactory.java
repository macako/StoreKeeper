/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simplestockjavafx.dao;

/**
 *
 * @author macako
 */
public interface DAOFactory {

    UserDAO getUserDao();

    UserPermissionDAO getUserPermissionDao();

    LookUpDAO getLookUpDAO();

    ControlStockDAO getControlStockDAO();

    ProductDAO getProductDAO();

    SupplyerDAO getSupplyerDAO();

    UnitDAO getUnitDAO();

    RmaDAO getRmaDAO();

    BrandDAO getBranDAO();

    CategoryDAO getCategoryDAO();
}
