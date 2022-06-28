
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.*;
import java.text.SimpleDateFormat;
import java.util.Date;


public class IssueBook extends javax.swing.JFrame {

    Connection con;
    Statement stmt;
    ResultSet rs;
    String query;
    Date date=new Date();
    SimpleDateFormat format=new SimpleDateFormat("dd-MM-yyyy");
    String  checkAvailability,SName,Address,SStream,SClass;

    private JButton issueBtn;
    private JButton cancelBtn;
    private JButton homeBtn;
    private JButton bookDetailsBtn;
    private JButton returnBookBtn;
    private JButton issuedBookDetailsBtn;
    private JButton studentRegBtn;
    private JLabel title;
    private JLabel studentIdLabel;
    private JLabel studentNameLabel;
    private JLabel bookIdLabel;
    private JLabel bookNameLabel;
    private JLabel issueDateLabel;
    private JLabel availableLabel;
    private JTextField studentIdField;
    private JTextField studentNameField;
    private JTextField bookIdField;
    private JTextField bookNameField;
    private JTextField issueDateField;
    private JTextField availableField;


    public IssueBook() {


        title = new JLabel();
        studentIdLabel = new JLabel();
        studentIdField = new JTextField();
        studentNameLabel = new JLabel();
        studentNameField = new JTextField();
        bookIdLabel = new JLabel();
        bookIdField = new JTextField();
        bookNameLabel = new JLabel();
        bookNameField = new JTextField();
        issueDateLabel = new JLabel();
        issueDateField = new JTextField();
        issueBtn = new JButton();
        cancelBtn = new JButton();
        homeBtn = new JButton();
        bookDetailsBtn = new JButton();
        returnBookBtn = new JButton();
        issuedBookDetailsBtn = new JButton();
        studentRegBtn = new JButton();
        availableField = new JTextField();
        availableLabel = new JLabel();

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                OnCreate(evt);
            }
        });

        title.setFont(new Font("Georgia", 0, 36));
        title.setForeground(new Color(0, 102, 102));
        title.setText("Issue Book");

        studentIdLabel.setFont(new Font("Tahoma", 0, 14));
        studentIdLabel.setText("Student Id");

        studentIdField.setFont(new java.awt.Font("Tahoma", 0, 14));
        studentIdField.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                t1ActionPerformed(e);
            }
        });
        studentIdField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(KeyEvent e) {
                studentIdFieldKeyReleased(e);
            }
        });

        studentNameLabel.setFont(new Font("Tahoma", 0, 14));
        studentNameLabel.setText("Student Name");

        studentNameField.setFont(new Font("Tahoma", 0, 14));
        studentNameField.setEnabled(false);

        bookIdLabel.setFont(new Font("Tahoma", 0, 14));
        bookIdLabel.setText("Book Id");

        bookIdField.setFont(new Font("Tahoma", 0, 14));
        bookIdField.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                bookIdFieldActionPerformed(e);
            }
        });
        bookIdField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent e) {
                bookIdFieldKeyReleased(e);
            }
        });

        bookNameLabel.setFont(new Font("Tahoma", 0, 14));
        bookNameLabel.setText("Book name");

        bookNameField.setFont(new Font("Tahoma", 0, 14));
        bookNameField.setEnabled(false);

        issueDateLabel.setFont(new Font("Tahoma", 0, 14));
        issueDateLabel.setText("Issue Date");

        issueDateField.setFont(new java.awt.Font("Tahoma", 0, 14));
        issueDateField.setEnabled(false);
        issueDateField.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                issueDateFieldActionPerformed(e);
            }
        });

        issueBtn.setBackground(new Color(0, 102, 102));
        issueBtn.setFont(new Font("Tahoma", 0, 14));
        issueBtn.setForeground(new Color(255, 255, 255));
        issueBtn.setText("Issue");
        issueBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                issueBtnActionPerformed(e);
            }
        });

        cancelBtn.setBackground(new Color(204, 0, 0));
        cancelBtn.setFont(new Font("Tahoma", 0, 14)); // NOI18N
        cancelBtn.setForeground(new Color(255, 255, 255));
        cancelBtn.setText("Cancel");
        cancelBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cancelBtnActionPerformed(e);
            }
        });

        homeBtn.setBackground(new Color(0, 102, 102));
        homeBtn.setFont(new Font("Tahoma", 0, 12)); // NOI18N
        homeBtn.setForeground(new Color(255, 255, 255));
        homeBtn.setText("Home");
        homeBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                homeBtnActionPerformed(e);
            }
        });

        bookDetailsBtn.setBackground(new Color(0, 102, 102));
        bookDetailsBtn.setFont(new Font("Tahoma", 0, 12));
        bookDetailsBtn.setForeground(new Color(255, 255, 255));
        bookDetailsBtn.setText("Book Details");
        bookDetailsBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                bookDetailsBtnActionPerformed(e);
            }
        });

        returnBookBtn.setBackground(new Color(0, 102, 102));
        returnBookBtn.setFont(new Font("Tahoma", 0, 12));
        returnBookBtn.setForeground(new Color(255, 255, 255));
        returnBookBtn.setText("Return Book");
        returnBookBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                returnBookBtnActionPerformed(e);
            }
        });

        issuedBookDetailsBtn.setBackground(new Color(0, 102, 102));
        issuedBookDetailsBtn.setFont(new Font("Tahoma", 0, 12));
        issuedBookDetailsBtn.setForeground(new Color(255, 255, 255));
        issuedBookDetailsBtn.setText("Issued Book Details");
        issuedBookDetailsBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                issuedBookDetailsBtnActionPerformed(e);
            }
        });

        studentRegBtn.setBackground(new java.awt.Color(0, 102, 102));
        studentRegBtn.setFont(new java.awt.Font("Tahoma", 0, 12));
        studentRegBtn.setForeground(new java.awt.Color(255, 255, 255));
        studentRegBtn.setText("Student Registration");
        studentRegBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                studentRegBtnActionPerformed(e);
            }
        });

        availableField.setFont(new java.awt.Font("Tahoma", 0, 14));
        availableField.setEnabled(false);

        availableLabel.setFont(new java.awt.Font("Tahoma", 0, 14));
        availableLabel.setText("Available");

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(73, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(title)
                        .addGap(316, 316, 316))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(studentRegBtn)
                        .addGap(50, 50, 50)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(studentNameLabel, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(studentIdLabel)
                                        .addGap(296, 296, 296)))
                                .addGap(252, 252, 252))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                            .addGap(83, 83, 83)
                                            .addComponent(issueBtn)
                                            .addGap(112, 112, 112)
                                            .addComponent(cancelBtn))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                            .addComponent(homeBtn)
                                            .addGap(45, 45, 45)
                                            .addComponent(bookDetailsBtn)
                                            .addGap(50, 50, 50)
                                            .addComponent(returnBookBtn)
                                            .addGap(55, 55, 55)
                                            .addComponent(issuedBookDetailsBtn)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(bookNameLabel, javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(issueDateLabel, javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(bookIdLabel, javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(availableLabel, javax.swing.GroupLayout.Alignment.LEADING))
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(58, 58, 58)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(studentNameField, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(issueDateField, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(bookNameField, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(studentIdField, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(bookIdField, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(availableField, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(132, 132, 132)))))
                                .addContainerGap())))))
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
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(studentNameLabel)
                    .addComponent(studentNameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bookIdLabel)
                    .addComponent(bookIdField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(availableLabel)
                    .addComponent(availableField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bookNameLabel)
                    .addComponent(bookNameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(issueDateLabel)
                    .addComponent(issueDateField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(issueBtn)
                    .addComponent(cancelBtn))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 45, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(homeBtn)
                    .addComponent(bookDetailsBtn)
                    .addComponent(returnBookBtn)
                    .addComponent(issuedBookDetailsBtn)
                    .addComponent(studentRegBtn))
                .addGap(19, 19, 19))
        );

        pack();
    }

    private void t1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_t1ActionPerformed

    private void homeBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        MainLayer mn=new MainLayer();
        mn.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void OnCreate(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_OnCreate
        // TODO add your handling code here:
    }//GEN-LAST:event_OnCreate

    private void issueBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if(studentNameField.getText().equals(""))
            JOptionPane.showMessageDialog(this,"Please enter Book id");
        else
        {
                try
                    {
                        connect();
                        query="select * from books where BookId='"+ bookIdField.getText()+"';";
                        
                        rs=stmt.executeQuery(query); 
                        rs.next();
                        if(availableField.getText().equals("YES"))
                        {
                            query="insert into issue values('"+ studentIdField.getText()+"','"+ studentNameField.getText()+"','"+ bookIdField.getText()+"','"+ bookNameField.getText()+"','"+Address+"','"+ issueDateField.getText()+"','"+SStream+"','"+SClass+"');";
                            
                            stmt.executeUpdate(query);
                            JOptionPane.showMessageDialog(this,"Book with id = "+ bookIdField.getText()+" has been issued to "+ studentNameField.getText());
                            query="update books set Available='NO' where BookId='"+ bookIdField.getText()+"';";
                            stmt.executeUpdate(query);
                            
                            
                        }
                        if(availableField.getText().equals("NO"))
                        {
                            JOptionPane.showMessageDialog(this,"Book with this id is not available currently");
                        }
                        if(availableField.getText().equals(""))
                        {
                            JOptionPane.showMessageDialog(this,"There is no book in the library with this id");
                        }
                        
                            bookNameField.setText("");
                            studentIdField.setText("");
                            studentNameField.setText("");
                            bookIdField.setText("");
                            availableField.setText("");
                        disconnect();

                    }
                    catch(SQLException e)
                    {
                        if(e.getErrorCode()==1062)
                        JOptionPane.showMessageDialog(this,"A student can only get a single book from library at a time ");
                    }
                }
                
                
    }

    private void cancelBtnActionPerformed(ActionEvent e) {
        MainLayer mn=new MainLayer();
        mn.setVisible(true);
        this.setVisible(false);
    }

    private void bookDetailsBtnActionPerformed(ActionEvent e) {
        BookDetails bd=new BookDetails();
        bd.setVisible(true);
        this.setVisible(false);
    }

    private void returnBookBtnActionPerformed(ActionEvent e) {
        ReturnBook rb=new ReturnBook();
        rb.setVisible(true);
        this.setVisible(false);
    }

    private void studentRegBtnActionPerformed(java.awt.event.ActionEvent evt) {
        RegisterStudent r=new RegisterStudent();
        r.setVisible(true);
        this.setVisible(false);
    }

    private void issuedBookDetailsBtnActionPerformed(ActionEvent e) {
        IssuedBooks ibs=new IssuedBooks();
        ibs.setVisible(true);
        this.setVisible(false);
    }

    private void studentIdFieldKeyReleased(KeyEvent e) {
        try
        {
            connect();
            query="select * from student where StudentId='"+ studentIdField.getText()+"';";
            rs=stmt.executeQuery(query); 
            if(rs.next())
            {
                SName=rs.getString("StudentName");
                Address=rs.getString("Address");
                SStream=rs.getString("SStream");
                SClass=rs.getString("SClass");
                studentNameField.setText(SName);
            }
            else
                studentNameField.setText("");
            disconnect();
        }
        catch(Exception ex)
        {
            System.out.println(ex);
        }
        issueDateField.setText(format.format(date));
    }

    private void bookIdFieldKeyReleased(java.awt.event.KeyEvent evt) {
        try
        {
            connect();
            query="select * from books where BookId='"+ bookIdField.getText()+"';";
            rs=stmt.executeQuery(query); 
            if(rs.next())
            {
                availableField.setText(rs.getString("Available"));
                bookNameField.setText(rs.getString("BookName"));
            }
            else
            {
                availableField.setText("");
                bookNameField.setText("");
            }
            disconnect();
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }

    private void issueDateFieldActionPerformed(ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void bookIdFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t3ActionPerformed
        // TODO add your handling code here:
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
                new IssueBook().setVisible(true);
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

}
