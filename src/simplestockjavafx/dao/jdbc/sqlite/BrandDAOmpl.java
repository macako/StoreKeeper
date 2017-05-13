/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simplestockjavafx.dao.jdbc.sqlite;

import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import simplestockjavafx.bo.Brand;
import simplestockjavafx.dao.BrandDAO;

/**
 *
 * @author macako
 */
public class BrandDAOmpl extends GenericDAOJDBCImpl<Brand, Integer> implements BrandDAO {

    @Override
    public List<Brand> findByParameter(Object param) {
        String sql = "SELECT BRAND_SEQ_ID id , "
                  + "        BRAND_NAME brandName , "
                  + "        BRAND_DESCRIPTION brandComment , "
                  + "        SUPPLYER_SEQ_ID supplyerid "
                  + EXTRA_INFO
                  + "FROM  T_BRAND "
                  + "WHERE SUPPLYER_SEQ_ID = ? ";

        List<Brand> brands = find(Brand.class, sql, param);

        return brands;
    }

    @Override
    public void save(Brand objeto) {
        try {
            String sql = "INSERT INTO T_BRAND (BRAND_NAME, BRAND_DESCRIPTION, SUPPLYER_SEQ_ID)"
                      + " VALUES (?,?,?)";

            Object[] params = {objeto.getBrandName(), objeto.getBrandComment(), objeto.getSupplyerId()};

            insert(sql, params);

        } catch (SQLException ex) {
            Logger.getLogger(BrandDAOmpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    

}
