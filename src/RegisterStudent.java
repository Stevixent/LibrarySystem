
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.*;


public class RegisterStudent extends JFrame {

    Connection con;
    Statement stmt;
    ResultSet rs;
    String query;

    private JTextArea addressTextarea;
    private JComboBox<String> genreList;
    private JComboBox<String> classList;
    private JButton registerBtn;
    private JButton cancelBtn;
    private JButton homeBtn;
    private JButton issuebookBtn;
    private JButton returnbookBtn;
    private JButton jButton6;
    private JButton bookDetailsBtnActionPerformed;
    private JLabel title;
    private JLabel studentIdLabel;
    private JLabel studentNameLabel;
    private JLabel genreLabel;
    private JLabel classLabel;
    private JLabel addressLabel;
    private JScrollPane jScrollPane1;
    private JTextField studentIdField;
    private JTextField studentNameField;

    public RegisterStudent() {

        title = new JLabel();
        studentIdLabel = new JLabel();
        studentNameLabel = new JLabel();
        genreLabel = new JLabel();
        classLabel = new JLabel();
        addressLabel = new JLabel();
        studentIdField = new JTextField();
        studentNameField = new JTextField();
        genreList = new JComboBox<>();
        classList = new JComboBox<>();
        jScrollPane1 = new JScrollPane();
        addressTextarea = new JTextArea();
        registerBtn = new JButton();
        cancelBtn = new JButton();
        homeBtn = new JButton();
        issuebookBtn = new JButton();
        returnbookBtn = new JButton();
        jButton6 = new JButton();
        bookDetailsBtnActionPerformed = new JButton();

        setDefaultCloseOperation(EXIT_ON_CLOSE);

        title.setFont(new Font("Georgia", 0, 36));
        title.setForeground(new Color(0, 102, 102));
        title.setText("Student Registration");

        studentIdLabel.setFont(new Font("Tahoma", 0, 14));
        studentIdLabel.setText("Student Id");

        studentNameLabel.setFont(new Font("Tahoma", 0, 14));
        studentNameLabel.setText("Student Name");

        genreLabel.setFont(new Font("Tahoma", 0, 14));
        genreLabel.setText("Genre");

        classLabel.setFont(new Font("Tahoma", 0, 14));
        classLabel.setText("Class");

        addressLabel.setFont(new Font("Tahoma", 0, 14));
        addressLabel.setText("Address");

        studentIdField.setFont(new Font("Tahoma", 0, 14));
        studentIdField.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                studentIdFieldActionPerformed(e);
            }
        });

        studentNameField.setFont(new java.awt.Font("Tahoma", 0, 14));

        genreList.setFont(new java.awt.Font("Tahoma", 0, 14));
        genreList.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select Genre", "Commerce", "Science", "Literature","History","Poetry" }));
        genreList.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                genreListActionPerformed(e);
            }
        });

        classList.setFont(new Font("Tahoma", 0, 14));
        classList.setModel(new DefaultComboBoxModel<>(new String[] { "Select Class" }));

        addressTextarea.setColumns(20);
        addressTextarea.setFont(new Font("Monospaced", 0, 14));
        addressTextarea.setRows(5);
        jScrollPane1.setViewportView(addressTextarea);

        registerBtn.setBackground(new Color(0, 102, 102));
        registerBtn.setFont(new Font("Tahoma", 0, 14));
        registerBtn.setForeground(new Color(255, 255, 255));
        registerBtn.setText("Register");
        registerBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                registerBtnActionPerformed(e);
            }
        });

        cancelBtn.setBackground(new Color(204, 0, 0));
        cancelBtn.setFont(new Font("Tahoma", 0, 14));
        cancelBtn.setForeground(new Color(255, 255, 255));
        cancelBtn.setText("Cancel");
        cancelBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cancelBtnActionPerformed(e);
            }
        });

        homeBtn.setBackground(new Color(0, 102, 102));
        homeBtn.setFont(new Font("Tahoma", 0, 12));
        homeBtn.setForeground(new Color(255, 255, 255));
        homeBtn.setText("Home");
        homeBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                homeBtnActionPerformed(e);
            }
        });

        issuebookBtn.setBackground(new java.awt.Color(0, 102, 102));
        issuebookBtn.setFont(new java.awt.Font("Tahoma", 0, 12));
        issuebookBtn.setForeground(new java.awt.Color(255, 255, 255));
        issuebookBtn.setText("Issue Book");
        issuebookBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                issueBookActionPerformed(e);
            }
        });

        returnbookBtn.setBackground(new java.awt.Color(0, 102, 102));
        returnbookBtn.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        returnbookBtn.setForeground(new java.awt.Color(255, 255, 255));
        returnbookBtn.setText("Return Book");
        returnbookBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                returnBookBtnActionPerformed(e);
            }
        });

        jButton6.setBackground(new Color(0, 102, 102));
        jButton6.setFont(new Font("Tahoma", 0, 12));
        jButton6.setForeground(new Color(255, 255, 255));
        jButton6.setText("Issued Book Details");
        jButton6.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                issuedBookDetailsActionPerformed(e);
            }
        });

        bookDetailsBtnActionPerformed.setBackground(new Color(0, 102, 102));
        bookDetailsBtnActionPerformed.setFont(new Font("Tahoma", 0, 12));
        bookDetailsBtnActionPerformed.setForeground(new Color(255, 255, 255));
        bookDetailsBtnActionPerformed.setText("Book Details");
        bookDetailsBtnActionPerformed.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                jButton7ActionPerformed(e);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(178, 178, 178)
                        .addComponent(title))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(216, 216, 216)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(36, 36, 36)
                                        .addComponent(registerBtn)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(cancelBtn)
                                        .addGap(89, 89, 89))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(bookDetailsBtnActionPerformed)
                                        .addGap(32, 32, 32)
                                        .addComponent(issuebookBtn)
                                        .addGap(34, 34, 34)
                                        .addComponent(returnbookBtn)
                                        .addGap(14, 14, 14))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(addressLabel)
                                                .addGap(100, 100, 100)
                                                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 205, Short.MAX_VALUE))
                                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(studentIdLabel)
                                                    .addComponent(studentNameLabel)
                                                    .addComponent(genreLabel)
                                                    .addComponent(classLabel))
                                                .addGap(60, 60, 60)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                    .addComponent(genreList, javax.swing.GroupLayout.Alignment.LEADING, 0, 205, Short.MAX_VALUE)
                                                    .addComponent(studentNameField, javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(studentIdField, javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(classList, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                                        .addGap(0, 0, Short.MAX_VALUE))))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(117, 117, 117)
                                .addComponent(homeBtn)))
                        .addGap(18, 18, 18)
                        .addComponent(jButton6)))
                .addContainerGap(139, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(title)
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(studentIdLabel)
                    .addComponent(studentIdField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(39, 39, 39)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(studentNameLabel)
                    .addComponent(studentNameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(genreLabel)
                    .addComponent(genreList, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(classLabel)
                    .addComponent(classList, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(66, 66, 66)
                        .addComponent(addressLabel))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(registerBtn)
                            .addComponent(cancelBtn))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 40, Short.MAX_VALUE)
                        .addComponent(homeBtn))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(bookDetailsBtnActionPerformed)
                            .addComponent(returnbookBtn)
                            .addComponent(issuebookBtn)
                            .addComponent(jButton6))))
                .addGap(18, 18, 18))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void studentIdFieldActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }//GEN-LAST:event_t1ActionPerformed

    private void returnBookBtnActionPerformed(java.awt.event.ActionEvent evt) {
        ReturnBook rb=new ReturnBook();
        rb.setVisible(true);
       this.setVisible(false);
    }//GEN-LAST:event_jButton5ActionPerformed

    private void registerBtnActionPerformed(java.awt.event.ActionEvent evt) {
        if(studentIdField.getText().equals(""))
            JOptionPane.showMessageDialog(this,"Please enter StudentId");
        else if(studentNameField.getText().equals(""))
            JOptionPane.showMessageDialog(this,"Please enter Student Name");
        else if(genreList.getSelectedItem()=="Select Stream")
            JOptionPane.showMessageDialog(this,"Please select stream");
        else if(classList.getSelectedItem()=="Select Class")
            JOptionPane.showMessageDialog(this,"Please select class");
        else if(addressTextarea.getText().equals(""))
            JOptionPane.showMessageDialog(this,"Please enter Address"); 
        else
        {
        connect();
       try
       {
       query="insert into student values('"+ studentIdField.getText()+"','"+ studentNameField.getText()+"','"+ genreList.getSelectedItem()+"','"+ classList.getSelectedItem()+"','"+ addressTextarea.getText()+"');";
       stmt.executeUpdate(query);
       JOptionPane.showMessageDialog(this,"Thank you "+ studentIdField.getText()+"\nYou are registered now");
        
        }
        catch(SQLException e)
        {
            if(e.getErrorCode()==1062)
                JOptionPane.showMessageDialog(this,"StudentId is a primary key, duplicate entry is not allowed\nIt should be unique");
            else
                JOptionPane.showMessageDialog(this,"connection error");
        }
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void genreListActionPerformed(java.awt.event.ActionEvent evt) {
        if(genreList.getSelectedItem()=="Science")
        {
            classList.removeAllItems();
            classList.addItem("Select Class");
            classList.addItem("FYBScCS");
            classList.addItem("SYBScCS");
            classList.addItem("TYBScCS");
        }
        if(genreList.getSelectedItem()=="Arts")
        {
            classList.removeAllItems();
            classList.addItem("Select Class");
            classList.addItem("FYBA");
            classList.addItem("SYBA");
            classList.addItem("TYBA");
        }
        if(genreList.getSelectedItem()=="Commerce")
        {
            classList.removeAllItems();
            classList.addItem("Select Class");
            classList.addItem("FYBCom");
            classList.addItem("SYBCom");
            classList.addItem("TYBCom");
        }
        if(genreList.getSelectedItem()=="Poetry")
        {
            classList.removeAllItems();
            classList.addItem("Select Class");
            classList.addItem("FYBCom");
            classList.addItem("SYBCom");
            classList.addItem("TYBCom");
        }
        if(genreList.getSelectedItem()=="Literature")
        {
            classList.removeAllItems();
            classList.addItem("Select Class");
            classList.addItem("FYBCom");
            classList.addItem("SYBCom");
            classList.addItem("TYBCom");
        }
        if(genreList.getSelectedItem()=="History")
        {
            classList.removeAllItems();
            classList.addItem("Select Class");
            classList.addItem("FYBCom");
            classList.addItem("SYBCom");
            classList.addItem("TYBCom");
        }
    }

    private void cancelBtnActionPerformed(java.awt.event.ActionEvent evt) {
       MainLayer mn=new MainLayer();
       mn.setVisible(true);
       this.setVisible(false);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void homeBtnActionPerformed(java.awt.event.ActionEvent evt) {
        MainLayer mn=new MainLayer();
       mn.setVisible(true);
       this.setVisible(false);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {
        BookDetails bd=new BookDetails();
        bd.setVisible(true);
       this.setVisible(false);
    }//GEN-LAST:event_jButton7ActionPerformed

    private void issueBookActionPerformed(java.awt.event.ActionEvent evt) {
        IssueBook ib=new IssueBook();
        ib.setVisible(true);
       this.setVisible(false);
    }//GEN-LAST:event_jButton4ActionPerformed

    private void issuedBookDetailsActionPerformed(java.awt.event.ActionEvent evt) {
        IssuedBooks ibs=new IssuedBooks();
        ibs.setVisible(true);
        this.setVisible(false);
    }


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
            java.util.logging.Logger.getLogger(RegisterStudent.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RegisterStudent.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RegisterStudent.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RegisterStudent.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                
                new RegisterStudent().setVisible(true);
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
    
    

}
