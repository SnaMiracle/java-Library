
package my_form;

import java.awt.Color;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.JOptionPane;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author snamiracle
 */
public class ManageAuthorsForm extends javax.swing.JFrame {

    /**
     * Creates new form ManageGenresForm
     */
    
    my_class.Func_Class func = new my_class.Func_Class();
    
    my_class.Author author = new my_class.Author();
    
    public ManageAuthorsForm() {
        initComponents();
        this.setLocationRelativeTo(null);
        
        Border panelHeaderBorder = BorderFactory.createMatteBorder(1, 1, 1, 1, new Color(1,50,67));
        jPanel1.setBorder(panelHeaderBorder);
        
        func.customTable(tblAuthor);
        
        func.customTableHeader(tblAuthor, new Color(34,167,240),16);
        
        lblEmptyFname.setForeground(Color.white);
        lblEmptyLname.setForeground(Color.white);
        
        func.displayImage(60, 60,null, "/images/authoricon.png", lblTitle);
        
        populateJtableWithAuthors();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lblTitle = new javax.swing.JLabel();
        lblClose = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtAuId = new javax.swing.JTextField();
        txtAuFname = new javax.swing.JTextField();
        btnAuadd = new javax.swing.JButton();
        btnAuedit = new javax.swing.JButton();
        btnAudel = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblAuthor = new javax.swing.JTable();
        lblEmptyFname = new javax.swing.JLabel();
        txtAuLname = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        lblEmptyLname = new javax.swing.JLabel();
        txtAuExpertise = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtAuAbout = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        lblTitle.setBackground(new java.awt.Color(1, 50, 67));
        lblTitle.setFont(new java.awt.Font("AvertaStd-Black", 0, 24)); // NOI18N
        lblTitle.setForeground(new java.awt.Color(255, 255, 255));
        lblTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitle.setText("Manage Authors");
        lblTitle.setOpaque(true);

        lblClose.setBackground(new java.awt.Color(1, 50, 67));
        lblClose.setFont(new java.awt.Font("Helvetica Neue", 0, 24)); // NOI18N
        lblClose.setForeground(new java.awt.Color(255, 255, 255));
        lblClose.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblClose.setText("X");
        lblClose.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblClose.setOpaque(true);
        lblClose.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblCloseMouseClicked(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Helvetica Neue", 0, 16)); // NOI18N
        jLabel2.setText("ID:");

        jLabel3.setFont(new java.awt.Font("Helvetica Neue", 0, 15)); // NOI18N
        jLabel3.setText("First Name:");

        txtAuFname.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N

        btnAuadd.setText("Add");
        btnAuadd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAuaddActionPerformed(evt);
            }
        });

        btnAuedit.setText("Edit");
        btnAuedit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAueditActionPerformed(evt);
            }
        });

        btnAudel.setText("Delete");
        btnAudel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAudelActionPerformed(evt);
            }
        });

        tblAuthor.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
        tblAuthor.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tblAuthor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblAuthorMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblAuthor);

        lblEmptyFname.setForeground(new java.awt.Color(255, 0, 0));
        lblEmptyFname.setText("*enter the first name");
        lblEmptyFname.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblEmptyFnameMouseClicked(evt);
            }
        });

        txtAuLname.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N

        jLabel4.setFont(new java.awt.Font("Helvetica Neue", 0, 15)); // NOI18N
        jLabel4.setText("Last Name:");

        lblEmptyLname.setForeground(new java.awt.Color(255, 0, 0));
        lblEmptyLname.setText("*enter the last name");
        lblEmptyLname.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblEmptyLnameMouseClicked(evt);
            }
        });

        txtAuExpertise.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N

        jLabel5.setFont(new java.awt.Font("Helvetica Neue", 0, 15)); // NOI18N
        jLabel5.setText("Expertise:");

        jLabel6.setFont(new java.awt.Font("Helvetica Neue", 0, 15)); // NOI18N
        jLabel6.setText("About:");

        txtAuAbout.setColumns(20);
        txtAuAbout.setFont(new java.awt.Font("Verdana", 0, 13)); // NOI18N
        txtAuAbout.setRows(5);
        jScrollPane2.setViewportView(txtAuAbout);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGap(21, 21, 21)
                            .addComponent(jLabel2)
                            .addGap(4, 4, 4)
                            .addComponent(txtAuId, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                            .addContainerGap()
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(lblEmptyFname, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtAuFname, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 273, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4)
                                    .addComponent(lblEmptyLname)
                                    .addComponent(txtAuLname, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 273, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGap(15, 15, 15)
                            .addComponent(jLabel6)
                            .addGap(228, 228, 228))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                            .addContainerGap()
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel5)
                                .addComponent(txtAuExpertise, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 273, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 273, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(btnAuadd, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnAuedit, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnAudel, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 458, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(lblTitle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblClose, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblClose, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtAuId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtAuFname, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblEmptyFname)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtAuLname, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblEmptyLname, javax.swing.GroupLayout.PREFERRED_SIZE, 11, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtAuExpertise, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(33, 33, 33)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnAuadd, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnAuedit, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnAudel, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(55, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1)
                        .addContainerGap())))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void lblCloseMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblCloseMouseClicked
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_lblCloseMouseClicked

    //add
    private void btnAuaddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAuaddActionPerformed
        // TODO add your handling code here:
        
        lblEmptyFname.setForeground(Color.white);
        lblEmptyLname.setForeground(Color.white);
        
        String fname = txtAuFname.getText();
        String lname = txtAuLname.getText();
        String expertise = txtAuExpertise.getText();
        String about = txtAuAbout.getText();
        
        if(fname.trim().isEmpty()){
            lblEmptyFname.setForeground(Color.red);
        }else if(lname.trim().isEmpty()){
            lblEmptyLname.setForeground(Color.red);
        }
        else{
            author.addAuthor(fname,lname,expertise,about);
            populateJtableWithAuthors();
            lblEmptyLname.setVisible(false);
            lblEmptyFname.setVisible(false);
        }
    }//GEN-LAST:event_btnAuaddActionPerformed

    //edit
    private void btnAueditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAueditActionPerformed
        // TODO add your handling code here:
        
        String fname = txtAuFname.getText();
        String lname = txtAuLname.getText();
        String expertise = txtAuExpertise.getText();
        String about = txtAuAbout.getText();
        
        if(fname.trim().isEmpty()){
            lblEmptyFname.setVisible(true);
        }else if(lname.trim().isEmpty()){
            lblEmptyLname.setVisible(true);
        }else{
            
            try{
                int id = Integer.parseInt(txtAuId.getText());
                author.editAuthor(id, fname,lname,expertise,about);
                populateJtableWithAuthors();
                lblEmptyLname.setVisible(false);
                lblEmptyFname.setVisible(false);
            }
            catch(NumberFormatException ex){
                JOptionPane.showMessageDialog(null, "Invalid Author ID", "error", 0);
            }
              
        }
    }//GEN-LAST:event_btnAueditActionPerformed

    //delete
    private void btnAudelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAudelActionPerformed
        // TODO add your handling code here:
        try{
                int id = Integer.parseInt(txtAuId.getText());
                
                int confirm = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete this Author?", "Confirm",JOptionPane.YES_NO_OPTION);
            
                if(confirm == JOptionPane.YES_OPTION){
                    author.removeAuthor(id);
                }
                
                lblEmptyFname.setVisible(false);
                lblEmptyLname.setVisible(false);
                
                populateJtableWithAuthors();
                txtAuId.setText("");
                txtAuFname.setText("");
                txtAuLname.setText("");
                txtAuExpertise.setText("");
                txtAuAbout.setText("");
            }
            catch(NumberFormatException ex){
                JOptionPane.showMessageDialog(null, "Invalid Author ID - ", "error", 0);
            }
    }//GEN-LAST:event_btnAudelActionPerformed

    private void tblAuthorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblAuthorMouseClicked
        // TODO add your handling code here:
        int index = tblAuthor.getSelectedRow();
        String id = tblAuthor.getValueAt(index, 0).toString();
        String firstName = tblAuthor.getValueAt(index, 1).toString();
        String lastName = tblAuthor.getValueAt(index, 2).toString();
        String expertise = tblAuthor.getValueAt(index, 3).toString();
        String about = tblAuthor.getValueAt(index, 4).toString();
        
        txtAuId.setText(id);
        txtAuFname.setText(firstName);
        txtAuLname.setText(lastName);
        txtAuExpertise.setText(expertise);
        txtAuAbout.setText(about);
        
    }//GEN-LAST:event_tblAuthorMouseClicked

    private void lblEmptyFnameMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblEmptyFnameMouseClicked
        // TODO add your handling code here:
        lblEmptyFname.setVisible(false);
    }//GEN-LAST:event_lblEmptyFnameMouseClicked

    private void lblEmptyLnameMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblEmptyLnameMouseClicked
        // TODO add your handling code here:
        lblEmptyLname.setVisible(false);
    }//GEN-LAST:event_lblEmptyLnameMouseClicked

    public void populateJtableWithAuthors(){
        ArrayList<my_class.Author> authorsList = author.authorsList();
        
        String[] colNames = {"ID","First Name","Last Name", "Expertise","About"};
        Object[][] rows = new Object[authorsList.size()][colNames.length];
        
        for(int i = 0; i < authorsList.size(); i++){
            rows[i][0] = authorsList.get(i).getId();
            rows[i][1] = authorsList.get(i).getFirstName();
            rows[i][2] = authorsList.get(i).getLastname();
            rows[i][3] = authorsList.get(i).getField_Of_Expertise();
            rows[i][4] = authorsList.get(i).getAbout();
        }
        DefaultTableModel model = new DefaultTableModel(rows,colNames);
        tblAuthor.setModel(model);
    }        
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAuadd;
    private javax.swing.JButton btnAudel;
    private javax.swing.JButton btnAuedit;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblClose;
    private javax.swing.JLabel lblEmptyFname;
    private javax.swing.JLabel lblEmptyLname;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JTable tblAuthor;
    private javax.swing.JTextArea txtAuAbout;
    private javax.swing.JTextField txtAuExpertise;
    private javax.swing.JTextField txtAuFname;
    private javax.swing.JTextField txtAuId;
    private javax.swing.JTextField txtAuLname;
    // End of variables declaration//GEN-END:variables
}
