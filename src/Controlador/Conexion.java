/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author jonatan
 */
public class Conexion {
    
    public String bd = "BD_Coesicydet";
    public String login = "root";
    public String password = "";
    public String url = "jdbc:mysql://localhost/" + bd;
    Connection conn ;
    Statement sentencia = null;
    boolean isEmpyConection;
    
    public Conexion(){}
    
    public Connection conctarDB(){
         conn = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(url,login,password);
        } catch (ClassNotFoundException | SQLException e) {
            JOptionPane.showMessageDialog(null, "problema al conetar"+e);
        }
        return conn;
    }
    public void conectar(){
        try {
            String controlador = "com.mysql.jdbc.Driver";
            Class.forName(controlador).newInstance();
            
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
            System.out.println("Error de controlador posiblemente no tenga esta libreria");
        }
        try {
            String DSN = url;
            String user = login;
            conn =DriverManager.getConnection(DSN,user,password);
        } catch (Exception e) {
            System.out.println("No esta activa la conexion");
        }
        try {
            sentencia = (Statement) conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
            ResultSet.CONCUR_READ_ONLY);
            //notify.notifyConection("Conexion ", "Conexion exitosa",true);
        } catch (Exception e) {
            String er="se produjo un problema al conectar con la base de datos";
            
        }
    }
    
    /***
     * 
     * @return la conexion en falso o verdadero
     */
    public boolean isEmpyConexion(){
           return isEmpyConection;
    }
    /***
     * 
     * me desconecta de la base de datos
     */
    public void Desconectar(){
        conn = null;
    }
    /***
     * 
     * @return el Statement
     */
    public Statement getStatement(){
        return sentencia;
    }
    /***
     * 
     * @return la Connection
     */
    public Connection getConnection(){
        return  conn;
    }
}
