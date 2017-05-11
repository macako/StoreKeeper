/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simplestockjavafx.dao.jdbc.sqlite;

import java.util.List;
import simplestockjavafx.bo.RMA;
import simplestockjavafx.dao.RmaDAO;

/**
 *
 * @author macako
 */
public class RmaDAOImpl extends GenericDAOJDBCImpl<RMA, Integer> implements RmaDAO {

    @Override
    public List<RMA> findAll() {
        String sql = "SELECT RMA_SEQ_ID id , "
                  + "        RMA_NAME rmaName , "
                  + "        RMA_DAYS rmaDays,  "
                  + "        COMMENTS rmaComment  "
                  + EXTRA_INFO
                  + "FROM  T_RMA;";

        List<RMA> Rmas = find(RMA.class, sql);

        return Rmas;
    }

}
