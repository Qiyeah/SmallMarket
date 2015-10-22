package com.huayu.A11_3.DAO;

import java.sql.*;

/**
 * Created by Qiyeah on 2015/10/16.
 */
public class BaseDAO {
    private String Driver = "oracle.jdbc.driver.OracleDriver";
    private String URL = "jdbc:oracle:thin://@192.168.2.105:1521/orcl";
    private String User = "market";
    private String Pass = "mr";
    private Connection conn = null;
    private PreparedStatement prestat = null;
    private ResultSet rs = null;
    public Connection getConn(){
        try {
            Class.forName(Driver);
            conn = DriverManager.getConnection(URL, User, Pass);
            return conn;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    public ResultSet doQuery(String sql,Object... para){
        conn = getConn();
        try {
            prestat = conn.prepareStatement(sql);
            for (int i = 1; i <= para.length; i++) {
                prestat.setObject(i,para[i-1]);
            }
            rs = prestat.executeQuery();
            return rs;
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            closeAll();
        }
        return null;
    }
    public boolean doUpdate(String sql,Object... para){
        conn = getConn();
        try {
            prestat = conn.prepareStatement(sql);
            for (int i = 1; i <=para.length ; i++) {
                prestat.setObject(i,para[i-1]);
            }
            int rows = prestat.executeUpdate();
            if (rows!=0){
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            closeAll();
        }
        return false;
    }
    public void closeAll(){
        /*if (null == rs){
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }*/
        if (null == prestat){
            try {
                prestat.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (null == conn){
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
