package my_class;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class Member {
    
    private int id;
    private String firstName;
    private String lastname;
    private String phone;
    private String email;
    private String gender;
    private byte[] picture;
    
    public Member(){}
    
    public Member(int _id, String _fname, String _lname, String _phone, String _email, String _gender, byte[] _picture){
        this.id = _id;
        this.firstName = _fname;
        this.lastname = _lname;
        this.phone = _phone;
        this.email = _email;
        this.gender = _gender;
        this.picture = _picture;
        
    }

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastname() {
        return lastname;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    public String getGender() {
        return gender;
    }

    public byte[] getPicture() {
        return picture;
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

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setPicture(byte[] picture) {
        this.picture = picture;
    }
    
    
    //add
    public void addMember(String _fname, String _lname, String _phone, String _email, String _gender, byte[] _pic){
        
        String insertQuery = "INSERT INTO members (firstname, lastname, phone, email, gender, picture) VALUES (?,?,?,?,?,?)";
        try {
            PreparedStatement ps = DB.openConnection().prepareStatement(insertQuery);
            ps.setString(1, _fname);
            ps.setString(2, _lname);
            ps.setString(3, _phone);
            ps.setString(4, _email);
            ps.setString(5, _gender);
            ps.setBytes(6, _pic);

            
            if(ps.executeUpdate() != 0){
                JOptionPane.showMessageDialog(null, "Member Added", "add member" ,1);
            }else{
                JOptionPane.showMessageDialog(null, "Member Not Added", "add member", 2);
            }
            
        } catch (SQLException | IOException ex) {
            Logger.getLogger(Member.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    }
    
      //edit
    public void editMember(Integer _id, String _fname, String _lname, String _phone, String _email, String _gender, byte[] _pic) {
    String editQuery = "UPDATE members SET firstname = ?, lastname = ?, phone = ?, email = ?, gender = ?, picture = ? WHERE id = ?;";
    try {
        PreparedStatement ps = DB.openConnection().prepareStatement(editQuery);

        ps.setString(1, _fname);
        ps.setString(2, _lname);
        ps.setString(3, _phone);
        ps.setString(4, _email);
        ps.setString(5, _gender);
        ps.setBytes(6,_pic);
        ps.setInt(7, _id);
        
        if (ps.executeUpdate() != 0) {
            JOptionPane.showMessageDialog(null, "Member Edited", "edit member", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "Member Not Edited", "edit member", JOptionPane.WARNING_MESSAGE);
        }
        
    } catch (SQLException | IOException ex) {
        Logger.getLogger(Member.class.getName()).log(Level.SEVERE, null, ex);
    }
}
    
    //remove
    public void removeMember(int _id) {
    String removeQuery = "DELETE from members WHERE id = ?";
    try {
        PreparedStatement ps = DB.openConnection().prepareStatement(removeQuery);
        
        ps.setInt(1, _id);      // Second placeholder is for the id (integer)
        
        if (ps.executeUpdate() != 0) {
            JOptionPane.showMessageDialog(null, "Member Deleted", "Remove", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "Member Not Deleted", "Remove", JOptionPane.WARNING_MESSAGE);
        }
        
    } catch (SQLException | IOException ex) {
        Logger.getLogger(Member.class.getName()).log(Level.SEVERE, null, ex);
    }
}
    
    public Member getMemberById(Integer _id)throws SQLException{
        
        Func_Class func = new Func_Class();
        
        String query = "SELECT * FROM members WHERE id = " + _id;
        
        ResultSet rs = func.getData(query);
        
        if(rs.next()){
            return new Member(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getBytes(7));
        }else{
            return null;
        }
    }
       
    public ArrayList<Member> membersList(String query){
        
        
        ArrayList<Member> mlist = new ArrayList<>();
        
        my_class.Func_Class func = new Func_Class();
        
        try {
            
            if(query.equals("")){
                query = "SELECT * FROM members";
            }
            
            ResultSet rs = func.getData(query);
            
            Member member;
            
            while(rs.next()){
            member = new Member(rs.getInt("id"), rs.getString("firstname"),rs.getString("lastname"),rs.getString("phone"),rs.getString("email"),rs.getString("gender"),rs.getBytes("picture"));
            mlist.add(member);
            }
            
            
        } catch (SQLException ex) {
            Logger.getLogger(Member.class.getName()).log(Level.SEVERE, null, ex);
        }
        return mlist;
    }
    
}
