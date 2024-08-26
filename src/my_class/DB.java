/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package my_class;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author snamiracle
 */
public class DB {
    public static Connection con = null;
    
    public static String getConnectionString() throws IOException{
        File f = new File("conn.txt");
        if(!f.exists()){
            f.createNewFile();
            FileWriter wf = new FileWriter(f);
            wf.write("jdbc:postgresql://localhost:5432/lil sys?user=admin&password=123");
            wf.close();
        }
        
        FileReader fr = new FileReader(f);
        BufferedReader br = new BufferedReader(fr);
        String conStr = br.readLine();
        System.out.println(conStr);
        br.close();
        fr.close();
        return conStr;
    }
    
    public static Connection openConnection() throws IOException{
        try {
            if(con != null){
                if(!con.isClosed()){
                    return con;
                }
            }
            
            con = DriverManager.getConnection(DB.getConnectionString());
            //System.out.println("Con : Connected to the PostgreSQL server successfully.");
            return con;

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        
        return null;
    }
    
}
