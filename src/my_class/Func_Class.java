/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package my_class;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.sql.Statement;
import java.io.File;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.filechooser.FileNameExtensionFilter;


/**
 *
 * @author snamiracle
 */
public class Func_Class {
    
    public void displayImage(int width, int height, byte[] imagebyte, String imagePath, JLabel label){
        
        ImageIcon imagIco;
        if(imagebyte != null){
            imagIco = new ImageIcon(imagebyte);
        }else{
            try{
                imagIco = new ImageIcon(getClass().getResource(imagePath));
            }catch(Exception ex){
                imagIco = new ImageIcon(imagePath);
            }
            
        }
        
        
        Image image = imagIco.getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH);
        
        label.setIcon(new ImageIcon(image));
    }
    
    public ResultSet getData(String query){
        
        PreparedStatement ps;
        ResultSet rs = null;
        
        try {
            ps = DB.openConnection().prepareStatement(query);
            rs = ps.executeQuery();
            
            }
            catch (IOException | SQLException ex) {
            Logger.getLogger(Func_Class.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return rs;
    }
    
    public void customTable(JTable table){
        table.setSelectionBackground(new Color(249,105,14));
        table.setSelectionForeground(Color.white);
        table.setRowHeight(35);
        table.setShowGrid(false);
        table.setBackground(new Color(248,248,248));
        table.setShowHorizontalLines(true);
        table.setGridColor(new Color(28,34,38));
    }
    
    public void customTableHeader(JTable table,Color back_Color, Integer fontSize){
        table.getTableHeader().setBackground(back_Color);
        table.getTableHeader().setForeground(Color.WHITE);
        table.getTableHeader().setFont(new Font("Helvetica Neue", Font.BOLD, fontSize));
        table.getTableHeader().setOpaque(false);
    }
    
    public String selectImage(){
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Select Profile Picture ");
        
        fileChooser.setCurrentDirectory(new File("/Users/snamiracle/Desktop/profile"));
        
        FileNameExtensionFilter extensionFilter = new FileNameExtensionFilter("Image", ".png",".jpg","jpeg");
        fileChooser.addChoosableFileFilter(extensionFilter);
        
        int fileState = fileChooser.showSaveDialog(null);
        String path = "";
        
        if(fileState == JFileChooser.APPROVE_OPTION){
            path = fileChooser.getSelectedFile().getAbsolutePath();
        }
        return path;
    }
 
    public int countData(String tableName){
        int total = 0;
        ResultSet rs;
        Statement st;
        
        try {
            st = DB.openConnection().createStatement();
            rs = st.executeQuery("SELECT COUNT(*) AS TOTAL FROM "+ tableName +"");
            if(rs.next()){
                total = rs.getInt("total");
            }
        } catch (Exception ex) {
            Logger.getLogger(Func_Class.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return total;
    }
    
    
}
    
    