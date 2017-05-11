/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simplestockjavafx.dao;


/**
 *
 * @author macako
 */
public abstract class DAOAbstractFactory {

    public static DAOFactory getInstance(String type) {
        if (type.equalsIgnoreCase("Hibernate")) {
            return new DAOHibernateFactory();
        } else if (type.equalsIgnoreCase("Jpa")) {
            return new DAOJPAFactory();
        } else if (type.equalsIgnoreCase("JdbcSqlite")) {
            return new DAOSqliteJDBCFactory();
        } else if (type.equalsIgnoreCase("JdbcMySql")) {
            return new DAOMySqlJDBCFactory();
        } else {
            return new DAOSqliteJDBCFactory();
        }
    }
}
