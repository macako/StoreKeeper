/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simplestockjavafx.dao.jdbc.sqlite;

import java.util.List;
import simplestockjavafx.bo.Unit;
import simplestockjavafx.dao.UnitDAO;

/**
 *
 * @author macako
 */
public class UnitDAOImpl extends GenericDAOJDBCImpl<Unit, Integer> implements UnitDAO {

    @Override
    public List<Unit> findAll() {
        String sql = "SELECT UNIT_SEQ_ID id , "
                  + "        UNIT_NAME unitName , "
                  + "        UNIT_DESCRIPTION unitDescription  "
                  + EXTRA_INFO
                  + "FROM    T_UNIT;";

        List<Unit> units = find(Unit.class, sql);

        return units;
    }
}
