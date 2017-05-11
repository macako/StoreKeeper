/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simplestockjavafx.dao.jdbc.sqlite;

import java.util.List;
import simplestockjavafx.bo.UserPermission;
import simplestockjavafx.bo.Users;
import simplestockjavafx.dao.UserPermissionDAO;

/**
 *
 * @author macako
 */
public class UserPermissionDAOImpl extends GenericDAOJDBCImpl<UserPermission, Integer> implements UserPermissionDAO {

    @Override
    public UserPermission permission(Integer userSeqId) {
      
        String sql = "SELECT EMPLOYE_MANAGE employeManage , SELL_PRODUCT sellProduct, ADD_SUPPLYER addSupplyer, ADD_BRAND addBrand, ADD_CATEGORY addCatagory, ADD_UNIT addUnit, UPDATE_SUPPLYER updateSupplyer, UPDATE_CATEGORY updateCatagory, UPDATE_UNIT updateUnit, UPDATE_BRAND updateBrand, RMA_MANAGE rmaManage FROM T_USER_PERMISSION WHERE USER_SEQ_ID = ?";

        UserPermission userPermissions = findFirst(UserPermission.class, sql, userSeqId);

        return userPermissions;
    }

}
