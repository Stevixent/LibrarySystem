
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.*;


public class ReturnBook extends javax.swing.JFrame {
    
     Connection con;
    Statement stmt;
    ResultSet rs;
    String query;
    Date date=new Date();
    SimpleDateFormat format=new SimpleDateFormat("dd-MM-yyyy");

    /**
     * Creates new form ReturnBook
     */
    public ReturnBook() {

        title = new JLabel();
        studentIdLabel = new JLabel();
        studentIdField = new JTextField();
        jLabel3 = new JLabel();
        studentNameField = new JTextField();
        bookIdLabel = new JLabel();
        bookIdField = new JTextField();
        bookNameLabel = new JLabel();
        bookNameField = new JTextField();
        returnDateLabel = new JLabel();
        returnDateField = new JTextField();
        returnBtn = new JButton();
        jButton2 = new JButton();
        jButton3 = new JButton();
        jButton4 = new JButton();
        jButton5 = new JButton();
        jButton6 = new JButton();
        issuedOnLabel = new JLabel();
        issuedOnField = new JTextField();

        setDefaultCloseOperation(EXIT_ON_CLOSE);

        title.setFont(new java.awt.Font("Georgia", 0, 36));
        title.setForeground(new java.awt.Color(0, 102, 102));
        title.setText("Return Book");

        studentIdLabel.setFont(new java.awt.Font("Tahoma", 0, 14));
        studentIdLabel.setText("Student Id");

        studentIdField.setFont(new Font("Tahoma", 0, 14));
        studentIdField.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                studentIdFieldActionPerformed(e);
            }
        });
        studentIdField.addKeyListener(new KeyAdapter() {
            public void keyReleased(KeyEvent e) {
                t1KeyReleased(e);
            }
        });

        jLabel3.setFont(new Font("Tahoma", 0, 14));

        studentNameField.setFont(new Font("Tahoma", 0, 14));
        studentNameField.setEnabled(false);

        bookIdLabel.setFont(new Font("Tahoma", 0, 14));
        bookIdLabel.setText("Book Id");

        bookIdField.setFont(new Font("Tahoma", 0, 14));
        bookIdField.setEnabled(false);

        bookNameLabel.setFont(new Font("Tahoma", 0, 14));
        bookNameLabel.setText("Book name");

        bookNameField.setFont(new Font("Tahoma", 0, 14));
        bookNameField.setEnabled(false);

        returnDateLabel.setFont(new Font("Tahoma", 0, 14));
        returnDateLabel.setText("Return Date");

        returnDateField.setFont(new Font("Tahoma", 0, 14));
        returnDateField.setEnabled(false);


        issuedOnLabel.setFont(new Font("Tahoma", 0, 14));
        issuedOnLabel.setText("Issued On");

        issuedOnField.setFont(new Font("Tahoma", 0, 14));
        issuedOnField.setEnabled(false);


        returnBtn.setBackground(new Color(0, 102, 102));
        returnBtn.setFont(new Font("Tahoma", 0, 14));
        returnBtn.setForeground(new Color(255, 255, 255));
        returnBtn.setText("Return");
        returnBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                returnBtn(e);
            }
        });

        jButton2.setBackground(new java.awt.Color(204, 0, 0));
        jButton2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("Cancel");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setBackground(new java.awt.Color(0, 102, 102));
        jButton3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jButton3.setForeground(new java.awt.Color(255, 255, 255));
        jButton3.setText("Home");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setBackground(new java.awt.Color(0, 102, 102));
        jButton4.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jButton4.setForeground(new java.awt.Color(255, 255, 255));
        jButton4.setText("Book Details");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setBackground(new java.awt.Color(0, 102, 102));
        jButton5.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jButton5.setForeground(new java.awt.Color(255, 255, 255));
        jButton5.setText("Issue Book");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton6.setBackground(new java.awt.Color(0, 102, 102));
        jButton6.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jButton6.setForeground(new java.awt.Color(255, 255, 255));
        jButton6.setText("Issued Book Details");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });



        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(179, 179, 179)
                .addComponent(jButton3)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(205, 268, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(title)
                        .addGap(316, 316, 316))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addComponent(issuedOnLabel)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(returnDateField)
                                .addComponent(issuedOnField, javax.swing.GroupLayout.DEFAULT_SIZE, 127, Short.MAX_VALUE))
                            .addGap(323, 323, 323))
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(returnDateLabel)
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(24, 24, 24)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(returnBtn)
                                        .addComponent(jButton4))
                                    .addGap(76, 76, 76)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(jButton5)
                                            .addGap(57, 57, 57)
                                            .addComponent(jButton6))
                                        .addComponent(jButton2)))
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(bookIdLabel)
                                        .addComponent(bookNameLabel))
                                    .addGap(94, 94, 94)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(bookIdField, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(bookNameField, javax.swing.GroupLayout.PREFERRED_SIZE, 302, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addContainerGap())
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addComponent(studentIdLabel)
                            .addGap(98, 98, 98)
                            .addComponent(studentIdField, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(332, 332, 332))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel3)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(studentNameField, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(243, 243, 243)))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(title)
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(studentIdLabel)
                    .addComponent(studentIdField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(studentNameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bookIdLabel)
                    .addComponent(bookIdField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bookNameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bookNameLabel))
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(issuedOnLabel)
                    .addComponent(issuedOnField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(returnDateLabel)
                    .addComponent(returnDateField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(returnBtn)
                    .addComponent(jButton2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 41, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton3)
                    .addComponent(jButton4)
                    .addComponent(jButton5)
                    .addComponent(jButton6))
                .addGap(20, 20, 20))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void studentIdFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_t1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        MainLayer mn=new MainLayer();
        mn.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
       MainLayer mn=new MainLayer();
        mn.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        BookDetails bd=new BookDetails();
        bd.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        IssueBook ib=new IssueBook();
        ib.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        IssuedBooks ibs=new IssuedBooks();
        ibs.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jButton6ActionPerformed

    private void t1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_t1KeyReleased
        try
        {
            connect();
            query="select * from issue where StudentId='"+ studentIdField.getText()+"';";
            rs=stmt.executeQuery(query); 
            int i=0;
            while(rs.next())
            {
                i++;
            studentNameField.setText(rs.getString("StudentName"));
            bookIdField.setText(rs.getString("BookId"));
            bookNameField.setText(rs.getString("BookName"));
            issuedOnField.setText(rs.getString("IssueDate"));
            }
            disconnect();
            if(i==0)
            {
                studentNameField.setText("");
                bookIdField.setText("");
                bookNameField.setText("");
                issuedOnField.setText("");
            }
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        returnDateField.setText(format.format(date));
    }//GEN-LAST:event_t1KeyReleased

    private void returnBtn(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try
        {
            connect();
            query="select * from issue where StudentId='"+ studentIdField.getText()+"';";
            rs=stmt.executeQuery(query);
            
            if(rs.next())
            {
                query="insert into returndetail values('"+ studentIdField.getText()+"','";
                query+= studentNameField.getText()+"','"+ bookIdField.getText()+"','"+ bookNameField.getText()+"','"+ issuedOnField.getText()+"','"+ returnDateField.getText()+"');";
                stmt.executeUpdate(query);
                query="delete from issue where StudentId='"+ studentIdField.getText()+"';";
                stmt.executeUpdate(query);
                query="update books set Available='YES' where BookId='"+ bookIdField.getText()+"';";
                stmt.executeUpdate(query);
                disconnect();
                JOptionPane.showMessageDialog(this,"Thank you! visit again");
                bookNameField.setText("");
                            studentIdField.setText("");
                            studentNameField.setText("");
                            bookIdField.setText("");
                            issuedOnField.setText("");
            }
            else
            {
                JOptionPane.showMessageDialog(this,"No book is issued on this id currently");
            }
        }
        catch(SQLException e)
        {
            JOptionPane.showMessageDialog(this,e);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ReturnBook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ReturnBook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ReturnBook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ReturnBook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ReturnBook().setVisible(true);
            }
        });
    }
    
    public void connect()
    {
        try
        {  
            Class.forName("com.mysql.jdbc.Driver");  
            con=DriverManager.getConnection(  
            "jdbc:mysql://localhost:3306/pankaj?useSSL=false&autoReconnect=true","root","8543998287");  
            stmt=con.createStatement(); 
        }
        catch(Exception e)
        { 
            System.out.println(e);
            JOptionPane.showMessageDialog(this,"connection error");
        }
    }
    public void disconnect()
    {
        try
        {
           con.close(); 
        }
        catch(Exception e)
        {}

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton returnBtn;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel title;
    private javax.swing.JLabel studentIdLabel;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel bookIdLabel;
    private javax.swing.JLabel bookNameLabel;
    private javax.swing.JLabel returnDateLabel;
    private javax.swing.JLabel issuedOnLabel;
    private javax.swing.JTextField studentIdField;
    private javax.swing.JTextField studentNameField;
    private javax.swing.JTextField bookIdField;
    private javax.swing.JTextField bookNameField;
    private javax.swing.JTextField issuedOnField;
    private javax.swing.JTextField returnDateField;
    // End of variables declaration//GEN-END:variables
}
