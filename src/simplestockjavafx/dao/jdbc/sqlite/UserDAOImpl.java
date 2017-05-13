/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simplestockjavafx.dao.jdbc.sqlite;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;
import org.apache.log4j.Logger;
import simplestockjavafx.bo.Users;
import simplestockjavafx.dao.UserDAO;

/**
 *
 * @author macako
 */
public class UserDAOImpl extends GenericDAOJDBCImpl<Users, Integer> implements UserDAO {

    private static final Logger LOG = Logger.getLogger(UserDAOImpl.class
              .getPackage().getName());

    @Override
    public boolean isDbConnected() {

        return JDBCSqliteHelper.getConnector() != null;
    }

    @Override
    public boolean isLogin(String sso, String pwd) {
        String sql = "SELECT USER_SEQ_ID id, USER_NAME userName FROM T_USER WHERE USER_NAME = ? AND PASSWORD = ? AND IS_ACTIVE='Y'";

        Object[] params = {sso, pwd};

        Users user = findFirst(Users.class, sql, params);

        return user != null;

    }

    @Override
    public Users getLogin(String sso, String pwd) {

        String sql = "SELECT USER_SEQ_ID id, USER_NAME userName FROM T_USER WHERE USER_NAME = ? AND PASSWORD = ? AND IS_ACTIVE='Y'";

        Object[] params = {sso, pwd};

        Users user = findFirst(Users.class, sql, params);

        return user;
    }

    @Override
    public void createAdminUser() {
        String sql = "SELECT USER_SEQ_ID FROM T_USER WHERE USER_NAME = 'admin'";

        int count = getCount(sql);

        if (count == 0) {
            try {
                sql = "INSERT INTO T_USER (USER_NAME, PASSWORD, IS_ACTIVE, SSO) VALUES('admin','admin','Y', '111111111');";
                insert(sql);
            } catch (SQLException ex) {
                LOG.error("Can not create the admin user", ex);
            }
        }

    }

}
