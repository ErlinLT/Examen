package com.mycompany.dao;

import java.util.ArrayList;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
/**
 *
 * @author ERLIN
 */
public class ClaseDao {
    public static void setup() {
        String sqlCrearTabla = "CREATE TABLE IF NOT EXISTS USUARIO "
                + "(ID INTEGER PRIMARY KEY AUTOINCREMENT,"
                + "NOMBRE TEXT, "
                + "ESTADO TEXT, "
                + "EMAIL TEXT, "
                + "PASSWORD TEXT, "
                + "AVATAR TEXT, "
                + "FCHINGRESO TEXT);";
        try {
            Statement comando = Conexion.getConexion().createStatement();
            int resultado = comando.executeUpdate(sqlCrearTabla);
            comando.close();
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
            System.exit(1);
        }
    }
    public static ArrayList<Clase> Obtener(){
        String sqlObtenerTodo = "SELECT * FROM USUARIO;";
        ArrayList<Clase> clases = new ArrayList<>();
        try{
            Statement comando = Conexion.getConexion().createStatement();
            ResultSet categoriasRows = comando.executeQuery(sqlObtenerTodo);
            while (categoriasRows.next()){
                Clase clase = new Clase();
                clase.setId(categoriasRows.getInt("ID"));
                clase.setNombre(categoriasRows.getString("NOMBRE"));
                clase.setEstado(categoriasRows.getString("ESTADO")); 
                clase.setEmail(categoriasRows.getString("EMAIL"));
                clase.setPassword(categoriasRows.getString("PASSWORD"));
                clase.setAvatar(categoriasRows.getString("AVATAR"));
                clase.setFchIngreso(categoriasRows.getString("FCHINGRESO"));
                clases.add(clase);
            }
            comando.close();
            return clases;
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
            System.exit(1);
            return null;
        }
    }
    public static Clase Anuevo (Clase muevaClase) {
        String sqlInsertCategoria = "INSERT INTO USUARIO (NOMBRE, ESTADO, EMAIL, PASSWORD, AVATAR, FCHINGRESO) VALUES (?, ?, ?, ?, ?, ?); ";
        try {
            PreparedStatement comando = Conexion.getConexion().prepareStatement(sqlInsertCategoria);
            comando.setString(1, muevaClase.getNombre());
            comando.setString(2, muevaClase.getEstado());
            comando.setString(3, muevaClase.getEmail());
            comando.setString(4, muevaClase.getPassword());
            comando.setString(5, muevaClase.getAvatar());
            comando.setString(6, muevaClase.getFchIngreso());
            
            int registroAgregado = comando.executeUpdate();
            comando.close();
            return muevaClase;
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
            System.exit(1);
            return null;
        }
    }
    
    public static Clase actualizar(Clase upClase) {
        String sqlUpdateCategoria = "UPDATE USUARIO set NOMBRE=? , ESTADO=?, EMAIL=?, PASSWORD=?, AVATAR=?, FCHINGRESO=? where ID=?;";
        try {
            PreparedStatement comando = Conexion.getConexion().prepareStatement(sqlUpdateCategoria);
            
            comando.setString(1, upClase.getNombre());
            comando.setString(2, upClase.getEstado());
            comando.setString(3, upClase.getEmail());
            comando.setString(4, upClase.getPassword());
            comando.setString(5, upClase.getAvatar());
            comando.setString(6, upClase.getFchIngreso());
            
            comando.setInt(7, upClase.getId());
            
            int registroActualizado = comando.executeUpdate();
            comando.close();
            return upClase;
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
            System.exit(1);
            return null;
        }
        
    }
    
    public static int eliminarClase (int EliminarSegunCodigo) {
        String sqlEliminarClase = "DELETE FROM USUARIO WHERE ID=?;";
        try {
            PreparedStatement comando = Conexion.getConexion().prepareStatement(sqlEliminarClase);
            comando.setInt(1, EliminarSegunCodigo);
            int Bin = comando.executeUpdate();
            comando.close();
            return Bin;
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
            System.exit(1);
            return 0;
        }
    
    }
    
}
