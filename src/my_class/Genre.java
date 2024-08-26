/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package my_class;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import java.sql.ResultSet;
import java.util.HashMap;

/**
 *
 * @author snamiracle
 */
public class Genre {
    
    private int id;
    private String name;
    
    public Genre(){};
    
    //constructor
    public Genre(int _id, String _name){
        this.id = _id;
        this.name = _name;
    }

    //getter setter
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setId(int _id) {
        this.id = _id;
    }

    public void setName(String _name) {
        this.name = _name;
    }
    
    my_class.Func_Class func = new Func_Class();

        
    //add
    public void addGenre(String _name){
        
        String insertQuery = "INSERT INTO book_genres(name) VALUES (?)";
        try {
            PreparedStatement ps = DB.openConnection().prepareStatement(insertQuery);
            ps.setString(1, _name);
            
            if(ps.executeUpdate() != 0){
                JOptionPane.showMessageDialog(null, "Genre Added", "add genre" ,1);
            }else{
                JOptionPane.showMessageDialog(null, "Genre Not Added", "add genre", 2);
            }
            
        } catch (SQLException | IOException ex) {
            Logger.getLogger(Genre.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    }
    
    //update
    public void editGenre(int _id, String _name) {
    String editQuery = "UPDATE book_genres SET name = ? WHERE id = ?";
    try {
        PreparedStatement ps = DB.openConnection().prepareStatement(editQuery);
        
        // Correct the order of setting parameters
        ps.setString(1, _name); // First placeholder is for the name (string)
        ps.setInt(2, _id);      // Second placeholder is for the id (integer)
        
        if (ps.executeUpdate() != 0) {
            JOptionPane.showMessageDialog(null, "Genre Edited", "edit genre", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "Genre Not Edited", "edit genre", JOptionPane.WARNING_MESSAGE);
        }
        
    } catch (SQLException | IOException ex) {
        Logger.getLogger(Genre.class.getName()).log(Level.SEVERE, null, ex);
    }
}
    
    //remove
    public void removeGenre(int _id) {
    String removeQuery = "DELETE from book_genres WHERE id = ?";
    try {
        PreparedStatement ps = DB.openConnection().prepareStatement(removeQuery);
        
        ps.setInt(1, _id);      // Second placeholder is for the id (integer)
        
        if (ps.executeUpdate() != 0) {
            JOptionPane.showMessageDialog(null, "Genre Deleted", "Remove", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "Genre Not Deleted", "Remove", JOptionPane.WARNING_MESSAGE);
        }
        
    } catch (SQLException | IOException ex) {
        Logger.getLogger(Genre.class.getName()).log(Level.SEVERE, null, ex);
    }
}
    
    public ArrayList<Genre> genreList(){
        ArrayList<Genre> glist = new ArrayList<>();

        try {
            ResultSet rs = func.getData("SELECT * FROM book_genres");
            
            Genre genre;
            
            while(rs.next()){
            genre = new Genre(rs.getInt("id"), rs.getString("name"));
            glist.add(genre);
            }
            
            
        } catch (SQLException ex) {
            Logger.getLogger(Genre.class.getName()).log(Level.SEVERE, null, ex);
        }
        return glist;
    }

    public HashMap<String, Integer> getGenresMap(){
        HashMap<String, Integer> map = new HashMap<>();
        
        try {
            ResultSet rs = func.getData("SELECT * FROM book_genres");
            
            Genre genre;
            
            while(rs.next()){
            genre = new Genre(rs.getInt("id"), rs.getString("name"));
            map.put(genre.getName(), genre.getId());
            }
            
            
        } catch (SQLException ex) {
            Logger.getLogger(Genre.class.getName()).log(Level.SEVERE, null, ex);
        }
        return map;
    }
    
    public Genre getGenreById(Integer id){
        ResultSet rs = func.getData("SELECT * FROM book_genres WHERE id ="+id);
            
            Genre genre = null;
            
        try {
            if(rs.next()){
                genre = new Genre(rs.getInt("id"), rs.getString("name"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Genre.class.getName()).log(Level.SEVERE, null, ex);
        }
            return genre;
    }
    
}