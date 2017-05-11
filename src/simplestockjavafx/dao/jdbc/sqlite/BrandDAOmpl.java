/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simplestockjavafx.dao.jdbc.sqlite;

import java.util.List;
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

}
