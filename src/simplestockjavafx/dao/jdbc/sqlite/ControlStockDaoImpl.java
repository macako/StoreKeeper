/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simplestockjavafx.dao.jdbc.sqlite;

import java.util.List;
import java.util.Map;
import simplestockjavafx.bo.ControlStock;
import simplestockjavafx.dao.ControlStockDAO;

/**
 *
 * @author macako
 */
public class ControlStockDaoImpl extends GenericDAOJDBCImpl<ControlStock, Integer> implements ControlStockDAO {

    @Override
    public ControlStock getControlStock() {

        String sql = "SELECT ROUND(IFNULL(STOCK_VALUE,0),2) stockValue, ROUND(IFNULL(SELLER_VALUE,0),2) sellerValue, TOTAL_SELLER totalSeller, TOTAL_SUPPLYER totalSupplyer, TOTAL_PRODUCT totalProduct,TOTAL_EMPLOYE totalEmploye from V_CONTROL_STOCK";

        ControlStock controlStock = findFirst(ControlStock.class, sql);

        return controlStock;
    }

}
