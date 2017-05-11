/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simplestockjavafx.service.impl;

import simplestockjavafx.bo.UserPermission;
import simplestockjavafx.service.*;
import simplestockjavafx.bo.Users;
import simplestockjavafx.constants.DB;
import simplestockjavafx.dao.DAOAbstractFactory;
import simplestockjavafx.dao.DAOFactory;
import simplestockjavafx.dao.UserDAO;
import simplestockjavafx.dao.UserPermissionDAO;

/**
 *
 * @author macako
 */
public class LoginSvcImpl implements LoginSvc {

    private final UserDAO userDao;
    private final UserPermissionDAO userPermissionDao;

    public LoginSvcImpl() {
        DAOFactory daoFactory = DAOAbstractFactory.getInstance(DB.DAO_FACTORY);
        this.userDao = daoFactory.getUserDao();
        this.userPermissionDao = daoFactory.getUserPermissionDao();
    }

    public boolean isDbConnected() {

        return userDao.isDbConnected();

    }

    @Override
    public boolean isLogin(String sso, String pwd) {

        return userDao.isLogin(sso, pwd);

    }

    @Override
    public Users getLogin(String sso, String pwd) {
        return userDao.getLogin(sso, pwd);
    }

    @Override
    public void createAdminUser() {
        userDao.createAdminUser();
    }

    @Override
    public UserPermission permission(Integer userSeqId) {
        return userPermissionDao.permission(userSeqId);
    }

}
