/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simplestockjavafx.service.impl;

import simplestockjavafx.constants.DB;
import simplestockjavafx.dao.DAOAbstractFactory;
import simplestockjavafx.dao.DAOFactory;
import simplestockjavafx.dao.LookUpDAO;
import simplestockjavafx.service.DBSetUpSvc;

/**
 *
 * @author macako
 */
public class DBSetUpSrvImpl implements DBSetUpSvc {

    private final LookUpDAO lookUpDAO;

    public DBSetUpSrvImpl() {
        DAOFactory daoFactory = DAOAbstractFactory.getInstance(DB.DAO_FACTORY);
        this.lookUpDAO = daoFactory.getLookUpDAO();
    }

    @Override
    public void createDataBase() {
        lookUpDAO.createDataBase();
    }

}
