/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package my_form;

import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.JOptionPane;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;
import my_class.Genre;

/**
 *
 * @author snamiracle
 */
public class ManageGenresForm extends javax.swing.JFrame {

    /**
     * Creates new form ManageGenresForm
     */
    
    my_class.Func_Class func = new my_class.Func_Class();
    
    my_class.Genre genre = new my_class.Genre();
    
    public ManageGenresForm() {
        initComponents();
        this.setLocationRelativeTo(null);
        
        Border panelHeaderBorder = BorderFactory.createMatteBorder(1, 1, 1, 1, Color.gray);
        jPanel1.setBorder(panelHeaderBorder);

        func.customTable(tblGen);
        
        func.customTableHeader(tblGen, new Color(42,187,155),22);

        
        lblEmpty.setVisible(false);
        
        populateJtableWithGenres();
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
        jLabel1 = new javax.swing.JLabel();
        lblClose = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtGenid = new javax.swing.JTextField();
        txtGenname = new javax.swing.JTextField();
        btnGenadd = new javax.swing.JButton();
        btnGenedit = new javax.swing.JButton();
        btnGendel = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblGen = new javax.swing.JTable();
        lblEmpty = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setBackground(java.awt.Color.gray);
        jLabel1.setFont(new java.awt.Font("AvertaStd-Black", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Manage Books Genres");
        jLabel1.setOpaque(true);

        lblClose.setBackground(java.awt.Color.gray);
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

        jLabel2.setFont(new java.awt.Font("Helvetica Neue", 0, 18)); // NOI18N
        jLabel2.setText("ID:");

        jLabel3.setFont(new java.awt.Font("Helvetica Neue", 0, 18)); // NOI18N
        jLabel3.setText("Name:");

        btnGenadd.setText("Add");
        btnGenadd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGenaddActionPerformed(evt);
            }
        });

        btnGenedit.setText("Edit");
        btnGenedit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGeneditActionPerformed(evt);
            }
        });

        btnGendel.setText("Delete");
        btnGendel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGendelActionPerformed(evt);
            }
        });

        tblGen.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tblGen.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblGenMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblGen);

        lblEmpty.setForeground(new java.awt.Color(255, 0, 0));
        lblEmpty.setText("*enter the genre name");
        lblEmpty.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblEmptyMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnGenadd, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnGenedit, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnGendel, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lblEmpty, javax.swing.GroupLayout.DEFAULT_SIZE, 190, Short.MAX_VALUE)
                            .addComponent(txtGenname, javax.swing.GroupLayout.DEFAULT_SIZE, 190, Short.MAX_VALUE)
                            .addComponent(txtGenid))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 354, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblClose, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblClose, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtGenid, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtGenname, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(3, 3, 3)
                        .addComponent(lblEmpty)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 61, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnGenadd, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnGenedit, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnGendel, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(57, 57, 57))))
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
    private void btnGenaddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGenaddActionPerformed
        // TODO add your handling code here:
        String name = txtGenname.getText();
        
        if(name.trim().isEmpty()){
            lblEmpty.setVisible(true);
        }else{
            genre.addGenre(name);
            lblEmpty.setVisible(false);
            populateJtableWithGenres();
        }
    }//GEN-LAST:event_btnGenaddActionPerformed

    //edit
    private void btnGeneditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGeneditActionPerformed
        // TODO add your handling code here:
        
        String name = txtGenname.getText();
        
        if(name.trim().isEmpty()){
            lblEmpty.setVisible(true);
        }else{
            
            try{
                int id = Integer.parseInt(txtGenid.getText());
                genre.editGenre(id, name);
                lblEmpty.setVisible(false);
                populateJtableWithGenres();
            }
            catch(NumberFormatException ex){
                JOptionPane.showMessageDialog(null, "Invalid Genre ID", "error", 0);
            }
              
        }
    }//GEN-LAST:event_btnGeneditActionPerformed

    //delete
    private void btnGendelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGendelActionPerformed
        // TODO add your handling code here:
        try{
                int id = Integer.parseInt(txtGenid.getText());
                
                int confirm = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete this Genre?", "Confirm",JOptionPane.YES_NO_OPTION);
            
                if(confirm == JOptionPane.YES_OPTION){
                    genre.removeGenre(id);
                }
                
                populateJtableWithGenres();
                txtGenid.setText("");
                txtGenname.setText("");
            }
            catch(NumberFormatException ex){
                JOptionPane.showMessageDialog(null, "Invalid Genre ID - ", "error", 0);
            }
    }//GEN-LAST:event_btnGendelActionPerformed

    private void tblGenMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblGenMouseClicked
        // TODO add your handling code here:
        int index = tblGen.getSelectedRow();
        String id = tblGen.getValueAt(index, 0).toString();
        String name = tblGen.getValueAt(index, 1).toString();
        
        txtGenid.setText(id);
        txtGenname.setText(name);
        
    }//GEN-LAST:event_tblGenMouseClicked

    public void populateJtableWithGenres(){
        ArrayList<my_class.Genre> genresList = genre.genreList();
        
        String[] colNames = {"ID","NAME"};
        Object[][] rows = new Object[genresList.size()][colNames.length];
        
        for(int i = 0; i < genresList.size(); i++){
            rows[i][0] = genresList.get(i).getId();
            rows[i][1] = genresList.get(i).getName();
        }
        DefaultTableModel model = new DefaultTableModel(rows,colNames);
        tblGen.setModel(model);
    }        
    
    private void lblEmptyMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblEmptyMouseClicked
        // TODO add your handling code here:
        lblEmpty.setVisible(false);
    }//GEN-LAST:event_lblEmptyMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGenadd;
    private javax.swing.JButton btnGendel;
    private javax.swing.JButton btnGenedit;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblClose;
    private javax.swing.JLabel lblEmpty;
    private javax.swing.JTable tblGen;
    private javax.swing.JTextField txtGenid;
    private javax.swing.JTextField txtGenname;
    // End of variables declaration//GEN-END:variables
}
