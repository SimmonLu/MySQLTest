package com.company;

import java.sql.*;

/**
 * Created by simon on 10/4/15.
 */
public class MySQL {

    private String dbDriver = "com.mysql.jdbc.Driver";
    private String dbUrl = "jdbc:mysql://127.0.0.1:[port]/[database]";
    private String dbUser = "root";
    private String dbPass = "";


    public Connection getConn() {
        Connection conn = null;
        try {
            Class.forName(dbDriver);
        }

        catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try {
            conn = DriverManager.getConnection(dbUrl, dbUser, dbPass);
        }

        catch (SQLException e) {
            e.printStackTrace();
        }

        return conn;
    }

    public int insert() {
        int i = 0;
        String sql = "insert into ? (?,?) values(?,?)";
        Connection conn = getConn();


        try {
            PreparedStatement preStmt = conn.prepareStatement(sql);
            //table name
            preStmt.setString(1,"");
            //column name
            preStmt.setString(2, "");
            preStmt.setString(3, "");
            //value
            preStmt.setString(4, "");
            preStmt.setString(5, "");
            i = preStmt.executeUpdate();
        }

        catch (SQLException e) {
            e.printStackTrace();
        }

        return i;
    }

    public String select() {
        String sql = "select * from ? where (column name) = (value)";
        Connection conn = getConn();

        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            if(rs.next()) {
                int m1 = rs.getInt(1);
                String m2 = rs.getString(2);
            }
        }

        catch (SQLException e) {
            e.printStackTrace();
        }

        return " ";
    }

    public int delete() {
        String sql = "delete from (table name) wherer (column name) = (value) ";
        int i = 0;
        Connection conn = getConn();
        try {
            Statement stmt = conn.createStatement();
            i = stmt.executeUpdate(sql);
        }

        catch (SQLException e) {
            e.printStackTrace();
        }

        return i;
    }

}
