package my_class;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JLabel;

/**
 *
 * @author snamiracle
 */
public class Book {
    
    private Integer id;
    private String isbn;
    private String name;
    private Integer author_id;
    private Integer genre_id;
    private Integer quantity;
    private String publisher;
    private double price;
    private String date_received;
    private String description;
    private byte[] cover;
    
    public Book(){}
    
    public Book(Integer _id, String _isbn, String _name, Integer _author_id, Integer _genre_id, Integer _quantity,
                String _publisher, double _price, String _date_received, String _description, byte[] _cover){
        
        this.id = _id;
        this.isbn = _isbn;
        this.name = _name;
        this.author_id = _author_id;
        this.genre_id = _genre_id;
        this.quantity = _quantity;
        this.publisher = _publisher;
        this.price = _price;
        this.date_received = _date_received;
        this.description = _description;
        this.cover = _cover;
    }

    public Integer getId() {
        return id;
    }

    public String getIsbn() {
        return isbn;
    }

    public String getName() {
        return name;
    }

    public Integer getAuthor_id() {
        return author_id;
    }

    public Integer getGenre_id() {
        return genre_id;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public String getPublisher() {
        return publisher;
    }

    public double getPrice() {
        return price;
    }

    public String getDate_received() {
        return date_received;
    }

    public String getDescription() {
        return description;
    }

    public byte[] getCover() {
        return cover;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAuthor_id(Integer author_id) {
        this.author_id = author_id;
    }

    public void setGenre_id(Integer genre_id) {
        this.genre_id = genre_id;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setDate_received(String date_received) {
        this.date_received = date_received;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setCover(byte[] cover) {
        this.cover = cover;
    }
    
    Func_Class func = new Func_Class();
    
    //add
    public void addBook(String _isbn, String _name, Integer _author_id, Integer _genre_id, Integer _quantity,
                String _publisher, double _price, String _date_received, String _description, byte[] _cover){

        String insertQuery = "INSERT INTO books (isbn, name, author_id, genre_id, quantity, publisher, price, date_received, description, cover_image) VALUES (?,?,?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement ps = DB.openConnection().prepareStatement(insertQuery);
            ps.setString(1, _isbn);
            ps.setString(2, _name);
            ps.setInt(3, _author_id);
            ps.setInt(4, _genre_id);
            ps.setInt(5, _quantity);
            ps.setString(6, _publisher);
            ps.setDouble(7, _price);
            ps.setObject(8, _date_received, java.sql.Types.TIMESTAMP);  // Directly insert the string as a TIMESTAMP
            ps.setString(9, _description);
            ps.setBytes(10, _cover);

            if(ps.executeUpdate() != 0){
                JOptionPane.showMessageDialog(null, "Book Added", "add book" ,1);
            }else{
                JOptionPane.showMessageDialog(null, "Book Not Added", "add book", 2);
            }
            
        } catch (SQLException | IOException ex) {
            Logger.getLogger(Book.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    //edit
    public void editBook(int _id, String _name, Integer _author_id, Integer _genre_id, Integer _quantity,
                String _publisher, double _price, String _date_received, String _description, byte[] _cover){
        
        String updateQuery;
        PreparedStatement ps;
        
        try {
            
        if(_cover != null){
            updateQuery = "UPDATE books SET name = ?, author_id = ?, genre_id = ?, quantity = ?, publisher = ?, price = ?, date_received = ?, description = ?, cover_image = ? WHERE id = ?";
            ps = DB.openConnection().prepareStatement(updateQuery);
            //ps.setString(1, _isbn);
            ps.setString(1, _name);
            ps.setInt(2, _author_id);
            ps.setInt(3, _genre_id);
            ps.setInt(4, _quantity);
            ps.setString(5, _publisher);
            ps.setDouble(6, _price);
            ps.setObject(7, _date_received, java.sql.Types.TIMESTAMP);  // Directly insert the string as a TIMESTAMP
            ps.setString(8, _description);
            ps.setBytes(9, _cover);
            ps.setInt(10, _id);
            
        }else{
            updateQuery = "UPDATE books SET name = ?, author_id = ?, genre_id = ?, quantity = ?, publisher = ?, price = ?, date_received = ?, description = ? WHERE id = ?";
            ps = DB.openConnection().prepareStatement(updateQuery);
            //ps.setString(1, _isbn);
            ps.setString(1, _name);
            ps.setInt(2, _author_id);
            ps.setInt(3, _genre_id);
            ps.setInt(4, _quantity);
            ps.setString(5, _publisher);
            ps.setDouble(6, _price);
            ps.setObject(7, _date_received, java.sql.Types.TIMESTAMP);  // Directly insert the string as a TIMESTAMP
            ps.setString(8, _description);
            //ps.setBytes(9, _cover);
            ps.setInt(9, _id);
        }
            if(ps.executeUpdate() != 0){
                JOptionPane.showMessageDialog(null, "Book Edited", "edit book" ,1);
            }else{
                JOptionPane.showMessageDialog(null, "Book Not Edited", "edit book", 2);
            }
            
        } catch (SQLException | IOException ex) {
            Logger.getLogger(Book.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    //remove
    public void removeBook(int _id) {
    String removeQuery = "DELETE from books WHERE id = ?";
    try {
        PreparedStatement ps = DB.openConnection().prepareStatement(removeQuery);
        
        ps.setInt(1, _id);      // Second placeholder is for the id (integer)
        
        if (ps.executeUpdate() != 0) {
            JOptionPane.showMessageDialog(null, "Book Deleted", "Remove", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "Book Not Deleted", "Remove", JOptionPane.WARNING_MESSAGE);
        }
        
    } catch (SQLException | IOException ex) {
        Logger.getLogger(Book.class.getName()).log(Level.SEVERE, null, ex);
    }
}

    public boolean isISBNexists(String _isbn){
        
        String query = "SELECT * FROM books WHERE isbn = '"+ _isbn +"'";
        
        ResultSet rs = func.getData(query);
        try {
            if(rs.next()){
                return true;
            }else{
                return false;
            }
        } catch (SQLException ex) {
            Logger.getLogger(Book.class.getName()).log(Level.SEVERE, null, ex);
        }
        return true;
    }
    
    public Book searchBookbyID_Isbn(int _id, String _isbn){
        
        String query = "SELECT * FROM books WHERE id = '"+ _id +"' or isbn = '"+ _isbn +"'";
        
        ResultSet rs = func.getData(query);
        Book book = null;
        
        try {
            if(rs.next()){
                book = new Book(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), 
                        rs.getInt(5), rs.getInt(6), rs.getString(7), rs.getDouble(8), rs.getString(9),
                        rs.getString(10), rs.getBytes(11));
            }else{
                return  book;
            }
        } catch (SQLException ex) {
            Logger.getLogger(Book.class.getName()).log(Level.SEVERE, null, ex);
        }
        return book;
    }
    
    public ArrayList<Book> booksList(String query){
        ArrayList<Book> blist = new ArrayList<>();
        
        try {
            
            if(query.equals("")){
                query = "SELECT * FROM books";
            }
            
            ResultSet rs = func.getData(query);
            
            Book book;
            
            while(rs.next()){
            book = new Book(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), 
                        rs.getInt(5), rs.getInt(6), rs.getString(7), rs.getDouble(8), rs.getString(9),
                        rs.getString(10), rs.getBytes(11));
            blist.add(book);
            }
            
            
        } catch (SQLException ex) {
            Logger.getLogger(Book.class.getName()).log(Level.SEVERE, null, ex);
        }
        return blist;
    }
    
    public Book getBookById(Integer _id)throws SQLException{
        
        String query = "SELECT * FROM books WHERE id = " + _id;
        
        ResultSet rs = func.getData(query);
        
        if(rs.next()){
            return new Book(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), 
                        rs.getInt(5), rs.getInt(6), rs.getString(7), rs.getDouble(8), rs.getString(9),
                        rs.getString(10), rs.getBytes(11));
        }else{
            return null;
        }
    }
    
    public void displayBooksCover(JLabel[] labels_tab){
        ResultSet rs;
        Statement st;
        
        try {
            st = DB.openConnection().createStatement();
            rs = st.executeQuery("SELECT cover_image FROM books ORDER BY id desc LIMIT 5");
            byte[] image;
            int i = 0;
            while(rs.next()){
                image = rs.getBytes("cover_image");
                func.displayImage(labels_tab[i].getWidth(), labels_tab[i].getHeight(), image, name, labels_tab[i]);
                i++;
            }
        } catch (Exception ex) {
            Logger.getLogger(Book.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void setQuantity_Minus_One(int _book_id, int _quantity){
        
        String updateQuantityQuery;
        PreparedStatement ps;
        
        try {
            
            updateQuantityQuery = "UPDATE books SET quantity = ? WHERE id = ?";
            ps = DB.openConnection().prepareStatement(updateQuantityQuery);
            //ps.setString(1, _isbn);
            ps.setInt(1, _quantity);
            ps.setInt(2, _book_id);
            
            if(ps.executeUpdate() != 0){
                JOptionPane.showMessageDialog(null, "This Book is set to lost -> The quantity = Quantity -1", "edit book Quantity" ,1);
            }else{
                JOptionPane.showMessageDialog(null, "Book quantity not edited", "edit book Quantity", 2);
            }
            
        } catch (SQLException | IOException ex) {
            Logger.getLogger(Book.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}
