/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package my_class;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class Author {
    
    private int id;
    private String firstName;
    private String lastname;
    private String field_Of_Expertise;
    private String about;
    
    public Author(){}
    
    public Author(int _id, String _fname, String _lname, String _expertise, String _about){
        this.id = _id;
        this.firstName = _fname;
        this.lastname = _lname;
        this.field_Of_Expertise = _expertise;
        this.about = _about;
        
    }
    
    my_class.Func_Class func = new Func_Class();

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastname() {
        return lastname;
    }

    public String getField_Of_Expertise() {
        return field_Of_Expertise;
    }

    public String getAbout() {
        return about;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public void setField_Of_Expertise(String field_Of_Expertise) {
        this.field_Of_Expertise = field_Of_Expertise;
    }

    public void setAbout(String about) {
        this.about = about;
    }
    
    //add
    public void addAuthor(String _fname, String _lname, String _expertise, String _about){
        
        String insertQuery = "INSERT INTO author(firstname, lastname, expertise, about) VALUES (?,?,?,?)";
        try {
            PreparedStatement ps = DB.openConnection().prepareStatement(insertQuery);
            ps.setString(1, _fname);
            ps.setString(2, _lname);
            ps.setString(3, _expertise);
            ps.setString(4, _about);
            
            if(ps.executeUpdate() != 0){
                JOptionPane.showMessageDialog(null, "Author Added", "add author" ,1);
            }else{
                JOptionPane.showMessageDialog(null, "Author Not Added", "add author", 2);
            }
            
        } catch (SQLException | IOException ex) {
            Logger.getLogger(Author.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    }
    
    //edit
    public void editAuthor(int _id, String _fname, String _lname, String _expertise, String _about) {
    String editQuery = "UPDATE author SET firstname = ?, lastname = ?, expertise = ?, about = ? WHERE id = ?";
    try {
        PreparedStatement ps = DB.openConnection().prepareStatement(editQuery);

        ps.setString(1, _fname);
        ps.setString(2, _lname);
        ps.setString(3, _expertise);
        ps.setString(4, _about);
        ps.setInt(5, _id);
        
        if (ps.executeUpdate() != 0) {
            JOptionPane.showMessageDialog(null, "Author Edited", "edit author", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "Author Not Edited", "edit author", JOptionPane.WARNING_MESSAGE);
        }
        
    } catch (SQLException | IOException ex) {
        Logger.getLogger(Author.class.getName()).log(Level.SEVERE, null, ex);
    }
}

    
    //remove
    public void removeAuthor(int _id) {
    String removeQuery = "DELETE from author WHERE id = ?";
    try {
        PreparedStatement ps = DB.openConnection().prepareStatement(removeQuery);
        
        ps.setInt(1, _id);      // Second placeholder is for the id (integer)
        
        if (ps.executeUpdate() != 0) {
            JOptionPane.showMessageDialog(null, "Author Deleted", "Remove", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "Author Not Deleted", "Remove", JOptionPane.WARNING_MESSAGE);
        }
        
    } catch (SQLException | IOException ex) {
        Logger.getLogger(Author.class.getName()).log(Level.SEVERE, null, ex);
    }
}
 
    public ArrayList<Author> authorsList(){
        ArrayList<Author> alist = new ArrayList<>();
        
        try {
            ResultSet rs = func.getData("SELECT * FROM author");
            
            Author author;
            
            while(rs.next()){
            author = new Author(rs.getInt("id"), rs.getString("firstname"),rs.getString("lastname"),rs.getString("expertise"),rs.getString("about"));
            alist.add(author);
            }
            
            
        } catch (SQLException ex) {
            Logger.getLogger(Author.class.getName()).log(Level.SEVERE, null, ex);
        }
        return alist;
    }

    public Author getAuthorById(Integer id){
        ResultSet rs = func.getData("SELECT * FROM author WHERE id ="+id);
            
            Author author = null;
            
        try {
            if(rs.next()){
                author = new Author(rs.getInt("id"), rs.getString("firstname"),rs.getString("lastname"),rs.getString("expertise"),rs.getString("about"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Author.class.getName()).log(Level.SEVERE, null, ex);
        }
            return author;
    }
    
}
