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
public class Issue_Book {
    
    private int book_id;
    private int member_id;
    private String status;
    private String issue_date;
    private String Return_date;
    private String note;

    public int getBook_id() {
        return book_id;
    }

    public int getMember_id() {
        return member_id;
    }

    public String getStatus() {
        return status;
    }

    public String getIssue_date() {
        return issue_date;
    }

    public String getReturn_date() {
        return Return_date;
    }

    public String getNote() {
        return note;
    }

    public Book getBook() {
        return book;
    }

    public void setBook_id(int book_id) {
        this.book_id = book_id;
    }

    public void setMember_id(int member_id) {
        this.member_id = member_id;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setIssue_date(String issue_date) {
        this.issue_date = issue_date;
    }

    public void setReturn_date(String Return_date) {
        this.Return_date = Return_date;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public Issue_Book() {
    }

    public Issue_Book(int _id, int _member, String _status, String _issue_date, String _Return_date, String _note) {
        this.book_id = _id;
        this.member_id = _member;
        this.status = _status;
        this.issue_date = _issue_date;
        this.Return_date = _Return_date;
        this.note = _note;
    }
    
    
    Book book = new Book();
    Func_Class func = new Func_Class();
    
    public void addIssue(int _book_id, int _member_id, String _status, String _issue_date, String _return_date, String _note){
        String insertQuery = "INSERT INTO issue_book (book_id, member_id, status, issue_date, return_date, note) VALUES(?,?,?,?,?,?)";
        try {
            PreparedStatement ps = DB.openConnection().prepareStatement(insertQuery);
            ps.setInt(1, _book_id);
            ps.setInt(2, _member_id);
            ps.setString(3, _status);
            ps.setObject(4, _issue_date, java.sql.Types.TIMESTAMP);
            ps.setObject(5, _return_date, java.sql.Types.TIMESTAMP);
            ps.setString(6, _note);

            if(ps.executeUpdate() != 0){
                JOptionPane.showMessageDialog(null, "Issue Added", "add issue" ,1);
            }else{
                JOptionPane.showMessageDialog(null, "Issue Not Added", "add issue", 2);
            }
            
        } catch (SQLException | IOException ex) {
            Logger.getLogger(Issue_Book.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void updateIssue(int _book_id, int _member_id, String _status, String _issue_date, String _return_date, String _note){
        
        String updatetQuery = "UPDATE issue_book SET status = ?, return_date = ?, note = ? WHERE book_id = ? AND member_id = ? AND issue_date = ?";
        try {
            PreparedStatement ps = DB.openConnection().prepareStatement(updatetQuery);
            
            ps.setString(1, _status);
            ps.setObject(2, _return_date, java.sql.Types.TIMESTAMP);
            ps.setString(3, _note);
            ps.setInt(4, _book_id);
            ps.setInt(5, _member_id);
            ps.setObject(6, _issue_date, java.sql.Types.TIMESTAMP);

            if(ps.executeUpdate() != 0){
                JOptionPane.showMessageDialog(null, "Status Updated", "Book Issue" ,1);
            }else{
                JOptionPane.showMessageDialog(null, "Status Not Updated", "Book Issue", 2);
            }
            
        } catch (SQLException | IOException ex) {
            Logger.getLogger(Issue_Book.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public boolean checkBookAvailability(int _book_id){
        
        boolean availavility = false;
        try {
            Book selectedBook = book.getBookById(_book_id);
            int quantity = selectedBook.getQuantity();
            
            int issued_book_count = countData(_book_id);
            
            if(quantity > issued_book_count){
                availavility = true;
            }else{
                availavility = false;
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(Issue_Book.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return availavility;
    }
    
    public int countData(int _book_id){
        int total = 0;
        ResultSet rs;
        PreparedStatement ps;
        
        try {
            ps = DB.openConnection().prepareStatement("SELECT COUNT(*) as total FROM issue_book WHERE book_id = ? and status = 'issued'");
            
            ps.setInt(1, _book_id);
            
            rs = ps.executeQuery();
            
            if(rs.next()){
                total = rs.getInt("total");
            }
        } catch (SQLException | IOException ex) {
            Logger.getLogger(Issue_Book.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return total;
    }
    
    public ArrayList<Issue_Book> issuedBooksList(String _status){
        
        ArrayList<Issue_Book> issuedBookslist = new ArrayList<>();
        String query;
        
        if(_status.equals("")){
           query = "SELECT * FROM issue_book";
        }
        else if(_status.equals("All")){
            query = "SELECT * FROM issue_book;";
        }else if(_status.equals("Issued")){
            query = "SELECT * FROM issue_book WHERE status = 'issued';";
        }else if(_status.equals("Returned")){
            query = "SELECT * FROM issue_book WHERE status = 'returned';";
        }else{
            
            query = "SELECT * FROM issue_book WHERE status = 'lost';";
        }
//        else{
//                query = "SELECT * FROM issue_book WHERE status = '"+_status+"';";
//                }
        
        try {
            
            ResultSet rs = func.getData(query);
            Issue_Book issBook;
            
            while(rs.next()){
                
                issBook = new Issue_Book(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4), 
                            rs.getString(5), rs.getString(6));
                issuedBookslist.add(issBook);
            }
            rs.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(Issue_Book.class.getName()).log(Level.SEVERE, null, ex);
        }
        return issuedBookslist;
    }
    
    public void removeFromIssueTable(int _book_id, int _member_id, String _issued_date) {
        String removeQuery = "DELETE FROM issue_book WHERE book_id = ? AND member_id = ? AND issue_date =?";
        try {
            PreparedStatement ps = DB.openConnection().prepareStatement(removeQuery);

            ps.setInt(1, _book_id);
            ps.setInt(2, _member_id);
            ps.setObject(3, _issued_date, java.sql.Types.TIMESTAMP);

            if (ps.executeUpdate() != 0) {
                JOptionPane.showMessageDialog(null, "Deleted Successfully", "Remove", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "Not Deleted", "Remove", JOptionPane.WARNING_MESSAGE);
            }

        } catch (SQLException | IOException ex) {
            Logger.getLogger(Issue_Book.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
