
//import com.mysql.jdbc.exceptions.MySQLIntegrityConstraintViolationException;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.*;


public class AddNewBook extends JFrame {
    Connection con;
    Statement stmt;
    String query;
    private JComboBox<String> genreList;
    private JComboBox<String> classList;
    private JButton addBtn;
    private JButton cancelBtn;
    private JButton homeBtn;
    private JButton issuebookBtn;
    private JButton returnbookBtn;
    private JButton issuedbookdetailsBtn;
    private JButton bookdetailsBtn;
    private JLabel bookIDLabel;
    private JLabel bookNameLabel;
    private JLabel authorLabel;
    private JLabel genreLabel;
    private JLabel classLabel;
    private JLabel title;
    private JTextField bookIdField;
    private JTextField bookNameField;
    private JTextField authorField;


    public AddNewBook() {
        bookIDLabel = new JLabel();
        bookIdField = new JTextField();
        bookNameLabel = new JLabel();
        bookNameField = new JTextField();
        authorLabel = new JLabel();
        authorField = new JTextField();
        genreLabel = new JLabel();
        classLabel = new JLabel();
        addBtn = new JButton();
        cancelBtn = new JButton();
        genreList = new JComboBox<>();
        classList = new JComboBox<>();
        title = new JLabel();
        homeBtn = new JButton();
        issuebookBtn = new JButton();
        returnbookBtn = new JButton();
        issuedbookdetailsBtn = new JButton();
        bookdetailsBtn = new JButton();

        setDefaultCloseOperation(EXIT_ON_CLOSE);

        bookIDLabel.setFont(new Font("Tahoma", 0, 14));
        bookIDLabel.setText("Book Id");

        bookIdField.setFont(new Font("Tahoma", 0, 14));

        bookNameLabel.setFont(new Font("Tahoma", 0, 14));
        bookNameLabel.setText("Book Name");

        bookNameField.setFont(new Font("Tahoma", 0, 14));

        authorLabel.setFont(new Font("Tahoma", 0, 14));
        authorLabel.setText("Author");

        authorField.setFont(new Font("Tahoma", 0, 14));

        genreLabel.setFont(new Font("Tahoma", 0, 14));
        genreLabel.setText("Genre");

        classLabel.setFont(new Font("Tahoma", 0, 14));
        classLabel.setText("Class");

        addBtn.setBackground(new Color(0, 102, 102));
        addBtn.setFont(new Font("Tahoma", 0, 14));
        addBtn.setForeground(new Color(255, 255, 255));
        addBtn.setText("Add");
        addBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                addBtnactionPerformed(e);
            }
        });

        cancelBtn.setBackground(new Color(204, 0, 0));
        cancelBtn.setFont(new Font("Tahoma", 0, 14));
        cancelBtn.setForeground(new Color(255, 255, 255));
        cancelBtn.setText("Cancel");
        cancelBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cancelBtnactionPerformed(e);
            }
        });

        genreList.setFont(new Font("Tahoma", 0, 14));
        genreList.setModel(new DefaultComboBoxModel<>(new String[] { "Select Genre", "Commerce", "Science", "Arts" }));
        genreList.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                genreListactionPerformed(e);
            }
        });

        classList.setFont(new Font("Tahoma", 0, 14)); //
        classList.setModel(new DefaultComboBoxModel<>(new String[] { "Select Class" }));
        classList.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                classListactionPerformed(e);
            }
        });

        title.setFont(new Font("Georgia", 0, 36));
        title.setForeground(new Color(0, 102, 102));
        title.setText("Add a New Book");

        homeBtn.setBackground(new Color(0, 102, 102));
        homeBtn.setFont(new Font("Tahoma", 0, 12));
        homeBtn.setForeground(new Color(255, 255, 255));
        homeBtn.setText("Home");
        homeBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                homeBtnactionPerformed(e);
            }
        });

        issuebookBtn.setBackground(new Color(0, 102, 102));
        issuebookBtn.setFont(new Font("Tahoma", 0, 12)); // NOI18N
        issuebookBtn.setForeground(new Color(255, 255, 255));
        issuebookBtn.setText("Issue Book");
        issuebookBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                issuebookBtnactionPerformed(e);
            }
        });

        returnbookBtn.setBackground(new Color(0, 102, 102));
        returnbookBtn.setForeground(new Color(255, 255, 255));
        returnbookBtn.setText("Return Book");
        returnbookBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                returnbookBtnactionPerformed(e);
            }
        });

        issuedbookdetailsBtn.setBackground(new Color(0, 102, 102));
        issuedbookdetailsBtn.setForeground(new Color(255, 255, 255));
        issuedbookdetailsBtn.setText("Issued Book Details");
        issuedbookdetailsBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                issuedbookdetailsBtnactionPerformed(e);
            }
        });

        bookdetailsBtn.setBackground(new Color(0, 102, 102));
        bookdetailsBtn.setFont(new Font("Tahoma", 0, 12)); // NOI18N
        bookdetailsBtn.setForeground(new Color(255, 255, 255));
        bookdetailsBtn.setText("Book Details");
        bookdetailsBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                bookdetailsBtnactionPerformed(e);
            }
        });

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(68, 68, 68)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(addBtn, GroupLayout.PREFERRED_SIZE, 116, GroupLayout.PREFERRED_SIZE)
                        .addGap(65, 65, 65)
                        .addComponent(cancelBtn, GroupLayout.DEFAULT_SIZE, 104, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                .addComponent(bookNameLabel)
                                .addComponent(bookIDLabel, GroupLayout.Alignment.LEADING)
                                .addComponent(authorLabel, GroupLayout.Alignment.LEADING))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(genreLabel)
                                .addGap(28, 28, 28)))
                        .addGap(53, 53, 53)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addComponent(bookIdField)
                            .addComponent(bookNameField)
                            .addComponent(authorField)
                            .addComponent(genreList, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(classList, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(classLabel)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(528, 528, 528))
            .addGroup(layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(title)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(homeBtn)
                        .addGap(49, 49, 49)
                        .addComponent(issuebookBtn)
                        .addGap(45, 45, 45)
                        .addComponent(returnbookBtn)))
                .addGap(45, 45, 45)
                .addComponent(issuedbookdetailsBtn)
                .addGap(41, 41, 41)
                .addComponent(bookdetailsBtn)
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(title)
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(bookIDLabel)
                    .addComponent(bookIdField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(bookNameLabel)
                    .addComponent(bookNameField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(authorLabel)
                    .addComponent(authorField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(genreLabel)
                    .addComponent(genreList, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(classList, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(classLabel))
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(addBtn)
                    .addComponent(cancelBtn))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 83, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(homeBtn)
                    .addComponent(issuebookBtn)
                    .addComponent(returnbookBtn)
                    .addComponent(issuedbookdetailsBtn)
                    .addComponent(bookdetailsBtn))
                .addGap(25, 25, 25))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void classListactionPerformed(ActionEvent e){
    }//GEN-LAST:event_c4ActionPerformed

    private void genreListactionPerformed(ActionEvent e) {//GEN-FIRST:event_c3ActionPerformed
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
    }

    private void homeBtnactionPerformed(ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        MainLayer mn=new MainLayer();
        mn.setVisible(true);
        this.setVisible(false);
    }

    private void cancelBtnactionPerformed(ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        MainLayer mn=new MainLayer();
        mn.setVisible(true);
        this.setVisible(false);
    }

    private void addBtnactionPerformed(ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if(bookIdField.getText().equals(""))
            JOptionPane.showMessageDialog(this,"Please enter Book id"); 
        else if(bookNameField.getText().equals(""))
            JOptionPane.showMessageDialog(this,"Please enter Book name"); 
        else if(bookNameField.getText().equals(""))
            JOptionPane.showMessageDialog(this,"Please enter author name"); 
        else if(genreList.getSelectedItem().equals("Select Genre"))
            JOptionPane.showMessageDialog(this,"Please select Genre");
        else if(classList.getSelectedItem().equals("Select Class"))
            JOptionPane.showMessageDialog(this,"Please select class");    
        else
        {
        try
        {
        connect();
        query="insert into books values('"+ bookIdField.getText()+"','"+ bookNameField.getText()+"','"+ authorField.getText()+"','"+ genreList.getSelectedItem()+"','"+ classList.getSelectedItem()+"','YES');";
        stmt.executeUpdate(query);
        
        disconnect();
        JOptionPane.showMessageDialog(this,"New book added to Library");
        bookIdField.setText("");
        bookNameField.setText("");
        authorField.setText("");
        genreList.setSelectedIndex(0);
        classList.removeAllItems();
        classList.addItem("Select Class");
        
        }
        catch(SQLException e)
        {
            if(e.getErrorCode()==1062)
                JOptionPane.showMessageDialog(this,"BookId is a primary key\nduplicate entry is not allowed\nit should be unique");
            else
                JOptionPane.showMessageDialog(this,"connection error");
        }
                }
       
    }

    private void issuebookBtnactionPerformed(ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        IssueBook ib=new IssueBook();
        ib.setVisible(true);
        this.setVisible(false);
    }

    private void returnbookBtnactionPerformed(ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        ReturnBook rb=new ReturnBook();
        rb.setVisible(true);
        this.setVisible(false);
    }

    private void issuedbookdetailsBtnactionPerformed(ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        IssuedBooks ibs=new IssuedBooks();
        ibs.setVisible(true);
        this.setVisible(false);
    }

    private void bookdetailsBtnactionPerformed(ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        BookDetails bd=new BookDetails();
        bd.setVisible(true);
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
            java.util.logging.Logger.getLogger(AddNewBook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AddNewBook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AddNewBook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AddNewBook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run()  {
                new AddNewBook().setVisible(true);
            }
        });
    }

    public void connect()
    {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = null;
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/NIIT", "root", "");
            System.out.println("Database is connected");
            conn.close();
        }catch (Exception e) {
            System.out.println("Database was unable to connect");
            e.printStackTrace();
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
