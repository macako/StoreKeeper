/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simplestockjavafx.service;

import simplestockjavafx.bo.UserPermission;
import simplestockjavafx.bo.Users;

/**
 *
 * @author macako
 */
public interface LoginSvc {

    boolean isDbConnected();

    boolean isLogin(String sso, String pwd);

    Users getLogin(String sso, String pwd);

    UserPermission permission(Integer userSeqId);

    void createAdminUser();
}
