
package my_form;

import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.JOptionPane;
import javax.swing.border.Border;

/**
 *
 * @author snamiracle
 */
public class DeleteMemberForm extends javax.swing.JFrame {

    /**
     * Creates new form ManageGenresForm
     */
    
    my_class.Func_Class func = new my_class.Func_Class();
    my_class.Member member = new my_class.Member();

    
    
    public DeleteMemberForm() {
        initComponents();
        this.setLocationRelativeTo(null);
        
        Border panelHeaderBorder = BorderFactory.createMatteBorder(1, 1, 1, 1, new Color(1,152,117));
        jPanel1.setBorder(panelHeaderBorder);

        
        func.displayImage(60, 60,null, "/images/membericon.png", lblTitleMember);
        
        lblEmptyID.setForeground(Color.white);
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblEmptyFname = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        lblTitleMember = new javax.swing.JLabel();
        lblClose = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtMemID = new javax.swing.JTextField();
        btnDelMem = new javax.swing.JButton();
        lblEmptyID = new javax.swing.JLabel();

        lblEmptyFname.setForeground(new java.awt.Color(255, 0, 0));
        lblEmptyFname.setText("*enter the first name");
        lblEmptyFname.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblEmptyFnameMouseClicked(evt);
            }
        });

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        lblTitleMember.setBackground(new java.awt.Color(1, 152, 117));
        lblTitleMember.setFont(new java.awt.Font("AvertaStd-Black", 0, 24)); // NOI18N
        lblTitleMember.setForeground(new java.awt.Color(255, 255, 255));
        lblTitleMember.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitleMember.setText("Delete Member");
        lblTitleMember.setOpaque(true);

        lblClose.setBackground(new java.awt.Color(1, 152, 117));
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

        jLabel3.setFont(new java.awt.Font("Helvetica Neue", 0, 15)); // NOI18N
        jLabel3.setText("Enter ID:");

        txtMemID.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N

        btnDelMem.setFont(new java.awt.Font("Helvetica Neue", 0, 16)); // NOI18N
        btnDelMem.setText("Delete Member");
        btnDelMem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDelMemActionPerformed(evt);
            }
        });

        lblEmptyID.setForeground(new java.awt.Color(253, 0, 0));
        lblEmptyID.setText("*you must enter member id");
        lblEmptyID.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblEmptyIDMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(lblTitleMember, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblClose, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnDelMem, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 367, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtMemID)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(lblEmptyID, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblTitleMember, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblClose, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(43, 43, 43)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtMemID, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblEmptyID)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 50, Short.MAX_VALUE)
                .addComponent(btnDelMem, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
    private void btnDelMemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDelMemActionPerformed
        // TODO add your handling code here:
        
        try{
            
            Integer id = Integer.parseInt(txtMemID.getText());
            int confirm = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete this Member?", "Confirm",JOptionPane.YES_NO_OPTION);
            
            if(confirm == JOptionPane.YES_OPTION){
                member.removeMember(id);
                txtMemID.setText("");
                lblEmptyID.setForeground(Color.white);
            }
            
            
        }catch(Exception ex){
            lblEmptyID.setForeground(Color.red);
        }
        
        
        
        
    }//GEN-LAST:event_btnDelMemActionPerformed

    private void lblEmptyFnameMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblEmptyFnameMouseClicked
        // TODO add your handling code here:
        lblEmptyFname.setVisible(false);
    }//GEN-LAST:event_lblEmptyFnameMouseClicked

    private void lblEmptyIDMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblEmptyIDMouseClicked
        // TODO add your handling code here:
        lblEmptyID.setForeground(Color.red);
    }//GEN-LAST:event_lblEmptyIDMouseClicked
       
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDelMem;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblClose;
    private javax.swing.JLabel lblEmptyFname;
    private javax.swing.JLabel lblEmptyID;
    private javax.swing.JLabel lblTitleMember;
    private javax.swing.JTextField txtMemID;
    // End of variables declaration//GEN-END:variables
}
