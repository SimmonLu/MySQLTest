package com.company;

import java.sql.*;

/**
 * Created by simon on 10/4/15.
 */
public class MySQL {

    private String dbDriver = "com.mysql.jdbc.Driver";
    private String dbUrl = "jdbc:mysql://";

    private String dbUser = "root";
    private String dbPass = "";

    public MySQL(String ip, String port, String db) {
        this.dbUrl = this.dbUrl + ip + ":" + port + "/" + db;
    }


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

    public int insert(String table, String[] columns, String[] values) {
        int i = 0;
        String sql = "insert into '" + table + "'(?,?) values (?,?)";

        Connection conn = getConn();


        try {
            PreparedStatement preStmt = conn.prepareStatement(sql);
            //column names
            preStmt.setString(1, columns[0]);
            preStmt.setString(2, columns[1]);
            //values
            preStmt.setString(3, values[0]);
            preStmt.setString(4, values[1]);

            i = preStmt.executeUpdate();
        }

        catch (SQLException e) {
            e.printStackTrace();
        }

        return i;
    }

    public String select(String table, String column, String value) {
        String sql = "select * from " + table + " where ? = ?";
        Connection conn = getConn();

        try {
            PreparedStatement prestmt = conn.prepareStatement(sql);
            prestmt.setString(1, column);
            prestmt.setString(2, value);
            ResultSet rs = prestmt.executeQuery();

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
