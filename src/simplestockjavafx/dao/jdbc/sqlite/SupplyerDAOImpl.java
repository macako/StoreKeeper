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
import simplestockjavafx.bo.Supplyer;
import simplestockjavafx.dao.SupplyerDAO;

/**
 *
 * @author macako
 */
public class SupplyerDAOImpl extends GenericDAOJDBCImpl<Supplyer, Integer> implements SupplyerDAO {

    @Override
    public List<Supplyer> findAll() {
        String sql = "SELECT  SUPPLYER_SEQ_ID id , "
                  + "        SUPPLYER_NAME supplyerName , "
                  + "        SUPPLYER_PHONE_NUMBER supplyerContactNumber , "
                  + "        SUPPLYER_ADDRESS supplyerAddress , "
                  + "        SUPPLYER_DESCRIPTION supplyerDescription  "
                  + EXTRA_INFO
                  + "FROM    T_SUPPLYER;";

        List<Supplyer> supplyers = find(Supplyer.class, sql);

        return supplyers;
    }

    @Override
    public void save(Supplyer objeto) {
        try {
            String sql = "INSERT INTO T_SUPPLYER (SUPPLYER_NAME, SUPPLYER_PHONE_NUMBER, SUPPLYER_ADDRESS, SUPPLYER_DESCRIPTION)"
                      + " VALUES (?,?,?,?)";

            Object[] params = {objeto.getSupplyerName(), objeto.getSupplyerContactNumber(), objeto.getSupplyerAddress(), objeto.getSupplyerDescription()};

            insert(sql, params);

        } catch (SQLException ex) {
            Logger.getLogger(SupplyerDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
