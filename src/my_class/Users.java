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

/**
 *
 * @author snamiracle
 */
public class Users {
    
    private int id;
    private String firstname;
    private String lastname;
    private String username;
    private String password;
    private String userType;

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public String getUserType() {
        return userType;
    }

    public int getId() {
        return id;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Users() {
    }

    public Users(int _id, String _firstname, String _lastname, String _username, String _password, String _user_type) {
        this.id = _id;
        this.firstname = _firstname;
        this.lastname = _lastname;
        this.username = _username;
        this.password = _password;
        this.userType = _user_type;
    }
    
    my_class.Func_Class func = new my_class.Func_Class();
    
    //add
    public void addUser(String _fname, String _lname, String _username, String _password, String _user_type){
        
        String insertQuery = "INSERT INTO users_table (firstname, lastname, username, password, user_type) VALUES (?, ?, ?, ?, ?)";
        try {
            PreparedStatement ps = DB.openConnection().prepareStatement(insertQuery);
            ps.setString(1, _fname);
            ps.setString(2, _lname);
            ps.setString(3, _username);
            ps.setString(4, _password);
            ps.setString(5, _user_type);
            
            if(ps.executeUpdate() != 0){
                JOptionPane.showMessageDialog(null, "User Added", "add user" ,1);
            }else{
                JOptionPane.showMessageDialog(null, "User Not Added", "add user", 2);
            }
            
        } catch (SQLException | IOException ex) {
            Logger.getLogger(Users.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    }
    
    //edit
    public void editUser(int _id, String _fname, String _lname, String _username, String _password, String _user_type) {
    String editQuery = "UPDATE users_table SET firstname = ?, lastname = ?, username = ?, password = ?, user_type = ? WHERE id = ?";
    try {
        PreparedStatement ps = DB.openConnection().prepareStatement(editQuery);

        ps.setString(1, _fname);
        ps.setString(2, _lname);
        ps.setString(3, _username);
        ps.setString(4, _password);
        ps.setString(5, _user_type);
        ps.setInt(6, _id);
        
        if (ps.executeUpdate() != 0) {
            JOptionPane.showMessageDialog(null, "User Edited", "edit user", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "User Not Edited", "edit user", JOptionPane.WARNING_MESSAGE);
        }
        
    } catch (SQLException | IOException ex) {
        Logger.getLogger(Users.class.getName()).log(Level.SEVERE, null, ex);
    }
}
    
     //remove
    public void removeUser(int _id) {
    String removeQuery = "DELETE from users_table WHERE id = ?";
    try {
        PreparedStatement ps = DB.openConnection().prepareStatement(removeQuery);
        
        ps.setInt(1, _id);      // Second placeholder is for the id (integer)
        
        if (ps.executeUpdate() != 0) {
            JOptionPane.showMessageDialog(null, "User Deleted", "Remove user", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "User Not Deleted", "Remove user", JOptionPane.WARNING_MESSAGE);
        }
        
    } catch (SQLException | IOException ex) {
        Logger.getLogger(Users.class.getName()).log(Level.SEVERE, null, ex);
    }
}
    
    public boolean checkUsernameExists(int _id, String _username){
        ResultSet rs = func.getData("SELECT * FROM users_table WHERE username ='" + _username + "'AND id <>" + _id);
        boolean exits = false;    
            
        try {
            if(rs.next()){
                exits = true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(Author.class.getName()).log(Level.SEVERE, null, ex);
        }
            return exits;
    }
    
    
    public ArrayList<Users> usersList(){
        ArrayList<Users> ulist = new ArrayList<>();
        
        try {
            ResultSet rs = func.getData("SELECT * FROM users_table WHERE user_type <> 'owner'");
            
            Users user;
            
            while(rs.next()){
            user = new Users(rs.getInt("id"), rs.getString("firstname"),rs.getString("lastname"),rs.getString("username"),rs.getString("password"),rs.getString("user_type"));
            ulist.add(user);
            }
            
            
        } catch (SQLException ex) {
            Logger.getLogger(Users.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ulist;
    }
    
    public Users tryLogin(String _username, String _password){
        
        ResultSet rs = func.getData("SELECT * FROM users_table WHERE username = '" + _username + "' AND password = '" + _password + "'");
            
            Users user = null;
            
        try {
            if(rs.next()){
                user = new Users(rs.getInt("id"),rs.getString("firstname"),rs.getString("lastname"),rs.getString("username"),rs.getString("password"),rs.getString("user_type"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Author.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return user;
    }
    
}
