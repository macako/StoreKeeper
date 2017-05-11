/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simplestockjavafx.dao.jdbc.sqlite;

import simplestockjavafx.bo.LookUp;
import simplestockjavafx.dao.LookUpDAO;

/**
 *
 * @author macako
 */
public class LookUpDAOImpl extends GenericDAOJDBCImpl<LookUp, Integer> implements LookUpDAO {
    
    private final String CONTROL_COLUMNS = ", CREATED_ON DATE NOT NULL DEFAULT current_timestamp, UPDATED_ON DATE NOT NULL DEFAULT current_timestamp, CREATED_BY VARCHAR(9) NOT NULL DEFAULT 111111111 , UPDATED_BY VARCHAR(9) NOT NULL DEFAULT 111111111";

    @Override
    public void createDataBase() {
        String sql = "CREATE TABLE IF NOT EXISTS T_USER "
                  + "(USER_SEQ_ID INTEGER PRIMARY KEY  AUTOINCREMENT UNIQUE, "
                  + "USER_NAME VARCHAR(20) NOT NULL UNIQUE, "
                  + "SSO VARCHAR(9) NOT NULL UNIQUE, "
                  + "FULL_NAME VARCHAR(100) , "
                  + "EMAIL_ADDRESS VARCHAR(100) , "
                  + "CONTACT_NUMBER VARCHAR(100) , "
                  + "SALARY DOUBLE DEFAULT 0.0, "
                  + "ADDRESS TEXT, "
                  + "PASSWORD VARCHAR(45) NOT NULL, "
                  + "IS_ACTIVE CHAR NOT NULL DEFAULT N, "
                  + "USER_IMAGE BLOB "
                  + CONTROL_COLUMNS
                  +");";
        executeSql(sql); 

        sql = "CREATE INDEX IF NOT EXISTS USER_INDEXLOGIN ON T_USER (USER_NAME, PASSWORD);";
        executeSql(sql);

        sql = "CREATE TABLE IF NOT EXISTS T_USER_PERMISSION "
                  + "(USER_PERMISSION_SEQ_ID INTEGER PRIMARY KEY  AUTOINCREMENT UNIQUE, "
                  + "ADD_PRODUCT CHAR NOT NULL DEFAULT N, "
                  + "ADD_SUPPLYER CHAR NOT NULL DEFAULT N, "
                  + "ADD_BRAND CHAR NOT NULL DEFAULT N, "
                  + "ADD_CATEGORY CHAR NOT NULL DEFAULT N, "
                  + "ADD_UNIT CHAR NOT NULL DEFAULT N, "
                  + "ADD_CUSTOMER CHAR NOT NULL DEFAULT N, "
                  + "UPDATE_PRODUCT CHAR NOT NULL DEFAULT N, "
                  + "UPDATE_SUPPLYER CHAR NOT NULL DEFAULT N, "
                  + "UPDATE_BRAND CHAR NOT NULL DEFAULT N, "
                  + "UPDATE_CATEGORY CHAR NOT NULL DEFAULT N, "
                  + "UPDATE_UNIT CHAR NOT NULL DEFAULT N, "
                  + "UPDATE_CUSTOMER CHAR NOT NULL DEFAULT N, "
                  + "RMA_MANAGE CHAR NOT NULL DEFAULT N, "
                  + "SELL_PRODUCT CHAR NOT NULL DEFAULT N, "
                  + "PROVIDE_DISCOUNT CHAR NOT NULL DEFAULT N, "
                  + "EMPLOYE_MANAGE CHAR NOT NULL DEFAULT N, "
                  + "ORG_MANAGE CHAR NOT NULL DEFAULT N,"
                  + "CHANGE_OWN_PASS CHAR NOT NULL DEFAULT N, "
                  + "USER_SEQ_ID INTEGER NOT NULL"
                  + CONTROL_COLUMNS
                  +");";
        executeSql(sql);

        sql = "CREATE TABLE IF NOT EXISTS T_ORGANIZE "
                  + "(ORGANIZE_SEQ_ID INTEGER PRIMARY KEY  AUTOINCREMENT UNIQUE, "
                  + "ORG_NAME VARCHAR(100), "
                  + "ORG_WEB VARCHAR(100), "
                  + "ORG_CONTACT_NUMBERS TEXT, "
                  + "ORG_CONTACT_ADDRESS TEXT, "
                  + "ORG_LOGO BLOB, "
                  + "USER_SEQ_ID INTEGER NOT NULL"
                  + CONTROL_COLUMNS
                  +");";
        executeSql(sql);

        sql = "CREATE TABLE IF NOT EXISTS T_SUPPLYER "
                  + "(SUPPLYER_SEQ_ID INTEGER PRIMARY KEY  AUTOINCREMENT UNIQUE, "
                  + "SUPPLYER_NAME VARCHAR(100), "
                  + "SUPPLYER_PHONE_NUMBER TEXT, "
                  + "SUPPLYER_ADDRESS TEXT, "
                  + "SUPPLYER_DESCRIPTION TEXT"
                  + CONTROL_COLUMNS
                  +");";
        executeSql(sql);

        sql = "CREATE TABLE IF NOT EXISTS T_BRAND "
                  + "(BRAND_SEQ_ID INTEGER PRIMARY KEY  AUTOINCREMENT UNIQUE, "
                  + "BRAND_NAME VARCHAR(100), "
                  + "BRAND_DESCRIPTION TEXT, "
                  + "SUPPLYER_SEQ_ID INTEGER NOT NULL"
                  + CONTROL_COLUMNS
                  +");";
        executeSql(sql);

        sql = "CREATE TABLE IF NOT EXISTS T_CATEGORY "
                  + "(CATEGORY_SEQ_ID INTEGER PRIMARY KEY  AUTOINCREMENT UNIQUE, "
                  + "CATEGORY_NAME VARCHAR(100), "
                  + "CATEGORY_DESCRIPTION TEXT, "
                  + "SUPPLYER_SEQ_ID INTEGER NOT NULL, "
                  + "BRAND_SEQ_ID INTEGER NOT NULL"
                  + CONTROL_COLUMNS
                  +");";
        executeSql(sql);

        sql = "CREATE TABLE IF NOT EXISTS T_UNIT "
                  + "(UNIT_SEQ_ID INTEGER PRIMARY KEY  AUTOINCREMENT UNIQUE, "
                  + "UNIT_NAME VARCHAR(100), "
                  + "UNIT_DESCRIPTION TEXT"
                  + CONTROL_COLUMNS
                  +");";
        executeSql(sql);

        sql = "CREATE TABLE IF NOT EXISTS T_RMA "
                  + "(RMA_SEQ_ID INTEGER PRIMARY KEY  AUTOINCREMENT UNIQUE, "
                  + "RMA_NAME VARCHAR(100), "
                  + "RMA_DAYS VARCHAR(11), "
                  + "COMMENTS TEXT"
                  + CONTROL_COLUMNS
                  +");";
        executeSql(sql);

        sql = "CREATE TABLE IF NOT EXISTS T_PRODUCT "
                  + "(PRODUCT_SEQ_ID INTEGER PRIMARY KEY  AUTOINCREMENT UNIQUE, "
                  + "PRODUCT_ID VARCHAR(20), "
                  + "PRODUCT_NAME VARCHAR(100), "
                  + "QUANTITY INTEGER NOT NULL DEFAULT 0, "
                  + "PRODUCT_DESCRIPTION TEXT, "
                  + "SUPPLYER_SEQ_ID INTEGER NOT NULL, "
                  + "BRAND_SEQ_ID INTEGER NOT NULL, "
                  + "CATEGORY_SEQ_ID INTEGER NOT NULL, "
                  + "UNIT_SEQ_ID INTEGER NOT NULL, "
                  + "RMA_SEQ_ID INTEGER NOT NULL, "
                  + "USER_SEQ_ID INTEGER NOT NULL, "
                  + "PURSES_PRICE VARCHAR(100), "
                  + "SELLER_PRICE VARCHAR(100)"
                  + CONTROL_COLUMNS
                  +");";
        executeSql(sql);

        sql = "CREATE TABLE IF NOT EXISTS T_BUYER "
                  + "(BUYER_SEQ_ID INTEGER PRIMARY KEY  AUTOINCREMENT UNIQUE, "
                  + "BUYER_NAME VARCHAR(200), "
                  + "BUYER_CONT_NO VARCHAR(200), "
                  + "BUYER_ADDRESS TEXT, "
                  + "TOTAL_BUY VARCHAR(50)"
                  + CONTROL_COLUMNS
                  +");";
        executeSql(sql);
        
        sql = "CREATE TABLE IF NOT EXISTS T_SELLER "
                  + "(SELLER_SEQ_ID INTEGER PRIMARY KEY  AUTOINCREMENT UNIQUE, "
                  + "SELLER_ID VARCHAR(10), "
                  + "PRODUCT_SEQ_ID INTEGER NOT NULL, "
                  + "SELLER_NAME VARCHAR(200), "
                  + "SELLER_CONT_NO VARCHAR(200), "
                  + "SELLER_ADDRESS TEXT, "
                  + "TOTAL_PRICE DOUBLE, "
                  + "SELLER_PRICE VARCHAR(100), "
                  + "QUANTITY INTEGER NOT NULL DEFAULT 0"
                  + CONTROL_COLUMNS
                  +");";
        executeSql(sql);
   
    }

}
