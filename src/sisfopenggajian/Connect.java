/*
 * Program untuk menghubungkan database dbgaji dengan Program Java
 * Lewat Driver Connector
 * Perangkat Lunak Penggajian Pegawai
 */
package sisfopenggajian;
import java.sql.*;
/**
 *
 * @author Husen
 */

public class Connect {
    public Connect(){
        
    }
        public Connection OpenConnect() throws SQLException {
            Connection con1 = null;
            try {
                Class.forName("com.mysql.jdbc.Driver");
                con1 = DriverManager.getConnection("jdbc:mysql://localhost:3306/dbgaji"
                ,"root","");
                return con1;
            }
            catch (SQLException se){
                System.out.println("Perintah SQL Salah !");
                return null;
            }
            catch (Exception ex){
                System.out.println("Driver Tidak Terhubung !");
                return null;
            }
        }
    }


