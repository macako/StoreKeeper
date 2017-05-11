/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simplestockjavafx.dao.jdbc.sqlite;

import java.util.List;
import simplestockjavafx.bo.Category;
import simplestockjavafx.dao.CategoryDAO;

/**
 *
 * @author macako
 */
public class CategoryDAOImpl extends GenericDAOJDBCImpl<Category, Integer> implements CategoryDAO {

    @Override
    public List<Category> findByParameters(Object[] params) {
        String sql = "SELECT CATEGORY_SEQ_ID id , "
                  + "        CATEGORY_NAME categoryName , "
                  + "        CATEGORY_DESCRIPTION categoryDescription , "
                  + "        SUPPLYER_SEQ_ID supplyerId, "
                  + "        BRAND_SEQ_ID brandId "
                  + EXTRA_INFO
                  + "FROM  T_CATEGORY "
                  + "WHERE SUPPLYER_SEQ_ID = ? AND BRAND_SEQ_ID = ? ";
        List<Category> categories = find(Category.class, sql, params);

        return categories;
    }

}
