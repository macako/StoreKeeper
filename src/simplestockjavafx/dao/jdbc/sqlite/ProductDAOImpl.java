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
import simplestockjavafx.bo.StoredProduct;
import simplestockjavafx.dao.ProductDAO;

/**
 *
 * @author macako
 */
public class ProductDAOImpl extends GenericDAOJDBCImpl<StoredProduct, Integer> implements ProductDAO {
    
    private final String SELECT_TABLE = "SELECT P.PRODUCT_SEQ_ID id ,"
                  + "        P.PRODUCT_ID productId ,"
                  + "        P.PRODUCT_NAME productName ,"
                  + "        P.QUANTITY quantity ,"
                  + "        P.PRODUCT_DESCRIPTION description ,"
                  + "        P.SUPPLYER_SEQ_ID supplierId ,"
                  + "        P.BRAND_SEQ_ID brandId ,"
                  + "        P.CATEGORY_SEQ_ID catagoryId ,"
                  + "        P.UNIT_SEQ_ID unitId ,"
                  + "        P.PURSES_PRICE pursesPrice ,"
                  + "        P.SELLER_PRICE sellPrice ,"
                  + "        P.RMA_SEQ_ID rmaId ,"
                  + "        P.USER_SEQ_ID userId ,"
                  + "        S.SUPPLYER_NAME supplierName ,"
                  + "        B.BRAND_NAME brandName ,"
                  + "        C.CATEGORY_NAME categoryName ,"
                  + "        U.UNIT_NAME unitName ,"
                  + "        R.RMA_NAME rmaName ,"
                  + "        U.USER_NAME userName, "
                  + "        P.CREATED_ON createdOn,"
                  + "        P.CREATED_BY createdBy, "
                  + "        P.UPDATED_ON updatedOn, "
                  + "        P.UPDATED_BY updatedBy "
                  + "FROM    T_PRODUCT P "
                  + "        INNER JOIN T_SUPPLYER S ON S.SUPPLYER_SEQ_ID = P.SUPPLYER_SEQ_ID "
                  + "        INNER JOIN T_BRAND B ON B.BRAND_SEQ_ID = P.BRAND_SEQ_ID  "
                  + "        INNER JOIN T_CATEGORY C ON C.CATEGORY_SEQ_ID = P.CATEGORY_SEQ_ID "
                  + "        INNER JOIN T_UNIT U ON U.UNIT_SEQ_ID = P.UNIT_SEQ_ID "
                  + "        INNER JOIN T_RMA R ON R.RMA_SEQ_ID = P.RMA_SEQ_ID "
                  + "        INNER JOIN T_USER U ON U.USER_SEQ_ID = P.USER_SEQ_ID";

    @Override
    public List<StoredProduct> getStoredProductPagedList(int size) {
        String sql = SELECT_TABLE;

        List<StoredProduct> storedProduct = find(StoredProduct.class, sql, 1, size);

        return storedProduct;
    }
    
    @Override
    public void save(StoredProduct objeto) {
        try {
            String sql = "INSERT INTO T_PRODUCT (PRODUCT_ID, PRODUCT_NAME, QUANTITY, PRODUCT_DESCRIPTION, SUPPLYER_SEQ_ID, BRAND_SEQ_ID, CATEGORY_SEQ_ID, UNIT_SEQ_ID, RMA_SEQ_ID, USER_SEQ_ID, PURSES_PRICE, SELLER_PRICE)"
                      + " VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";

            Object[] params = {objeto.getProductId(), objeto.getProductName(), objeto.getQuantity(), objeto.getDescription(), objeto.getSupplierId(), objeto.getBrandId(), objeto.getCatagoryId(), objeto.getUnitId(), objeto.getRmaId(), objeto.getUserId(), objeto.getPursesPrice(), objeto.getSellPrice()};

            insert(sql, params);
        } catch (SQLException ex) {
            Logger.getLogger(ProductDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public void delete(StoredProduct product) {
        try {
            String sql = "DELETE FROM T_PRODUCT WHERE PRODUCT_SEQ_ID = ?";
            update(sql, product.getId());
        } catch (SQLException ex) {
            Logger.getLogger(ProductDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    }
    
    @Override
    public List<StoredProduct> findByParameter(Object param) {
        String sql = SELECT_TABLE 
                  + " WHERE S.SUPPLYER_SEQ_ID = ? ";

        List<StoredProduct> storedProducts = find(StoredProduct.class, sql, param);

        return storedProducts;
    }

}
