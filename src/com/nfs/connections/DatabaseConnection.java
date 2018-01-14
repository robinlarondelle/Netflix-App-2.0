package com.nfs.connections;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class DatabaseConnection {
    final String serverAdres = "multiplicity.softether.net";
    final int serverPort = 6667;
    final String dbUserName = "sa";
    final String dbPassword = "MarlBoroq17";
    final String databaseName = "NFS";
   // final String connectionUrl = "jdbc:sqlserver://" + serverAdres + ":" + serverPort + ";databaseName=" + databaseName + ";user=" + dbUserName + ";password=" + dbPassword;

    private final String connectionUrl = "jdbc:sqlserver://localhost\\SQLEXPRESS;databaseName=NFS;integratedsecurity=true;";

    private Connection con = null;
    private Statement stmt = null;
    private ResultSet rs = null;


    public void runSQL(String SQL){
        openConnection();

        try{
            stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
            this.stmt.execute(SQL);
            System.out.println(SQL);

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            closeConnection();
        }

    }

    public ResultSet getData(String SQL) {
        try {
            openConnection();
            stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
            this.rs = this.stmt.executeQuery(SQL);
            return this.rs;

        } catch (Exception e) {
            e.printStackTrace();
            return null;

        } finally {
            while (this.con != null) {
                System.out.println(SQL);
                closeConnection();
            }
        }
    }

    private void openConnection() {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            this.con = DriverManager.getConnection(this.connectionUrl);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void closeConnection() {
        if (this.con != null || this.stmt != null || this.con != null) {
            this.stmt = null;
            this.rs = null;
            this.con = null;
        }

    }

    public Connection getCon() {
        return con;
    }

}