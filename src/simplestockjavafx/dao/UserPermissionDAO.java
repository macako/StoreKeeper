/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simplestockjavafx.dao;

import simplestockjavafx.bo.UserPermission;

/**
 *
 * @author macako
 */
public interface UserPermissionDAO {
    UserPermission permission(Integer userSeqId );
}
