
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;


public class IssuedBooks extends javax.swing.JFrame {

    Connection con;
    Statement stmt;
    ResultSet rs;
    String query;

    private javax.swing.JComboBox<String> genreList;
    private javax.swing.JComboBox<String> classList;
    private javax.swing.JButton homeBtn;
    private javax.swing.JButton bookDetailsBtn;
    private javax.swing.JButton addNewBookBtn;
    private javax.swing.JButton issueBookBtn;
    private javax.swing.JButton returnBookBtn;
    private javax.swing.JButton studentRegBtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel genreLabel;
    private javax.swing.JLabel classLabel;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable table;

    public IssuedBooks() {

        jLabel1 = new JLabel();
        jScrollPane1 = new JScrollPane();
        table = new JTable();
        homeBtn = new JButton();
        bookDetailsBtn = new JButton();
        addNewBookBtn = new JButton();
        issueBookBtn = new JButton();
        returnBookBtn = new JButton();
        studentRegBtn = new JButton();
        genreList = new JComboBox<>();
        classList = new JComboBox<>();
        genreLabel = new JLabel();
        classLabel = new JLabel();

        setDefaultCloseOperation(EXIT_ON_CLOSE);

        jLabel1.setFont(new Font("Georgia", 0, 36));
        jLabel1.setForeground(new Color(0, 102, 102));
        jLabel1.setText("Issued Book Details");

        table.setModel(new DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Student Id", "Student Name", "Book Id", "Book Name", "Student Address", "Issue Date"
            }
        ));
        jScrollPane1.setViewportView(table);
        if (table.getColumnModel().getColumnCount() > 0) {
            table.getColumnModel().getColumn(0).setPreferredWidth(40);
            table.getColumnModel().getColumn(1).setPreferredWidth(150);
            table.getColumnModel().getColumn(2).setPreferredWidth(30);
            table.getColumnModel().getColumn(3).setPreferredWidth(150);
            table.getColumnModel().getColumn(4).setPreferredWidth(200);
            table.getColumnModel().getColumn(5).setPreferredWidth(60);
        }

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
        bookDetailsBtn.setFont(new Font("Tahoma", 0, 12)); // NOI18N
        bookDetailsBtn.setForeground(new Color(255, 255, 255));
        bookDetailsBtn.setText("Book Details");
        bookDetailsBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                bookDetailsBtnActionPerformed(e);
            }
        });

        addNewBookBtn.setBackground(new Color(0, 102, 102));
        addNewBookBtn.setFont(new Font("Tahoma", 0, 12)); // NOI18N
        addNewBookBtn.setForeground(new Color(255, 255, 255));
        addNewBookBtn.setText("AddNewBook");
        addNewBookBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                newBookBtnActionPerformed(e);
            }
        });

        issueBookBtn.setBackground(new Color(0, 102, 102));
        issueBookBtn.setFont(new Font("Tahoma", 0, 12)); // NOI18N
        issueBookBtn.setForeground(new Color(255, 255, 255));
        issueBookBtn.setText("Issue Book");
        issueBookBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                issueBookBtnActionPerformed(e);
            }
        });

        returnBookBtn.setBackground(new Color(0, 102, 102));
        returnBookBtn.setFont(new Font("Tahoma", 0, 12)); // NOI18N
        returnBookBtn.setForeground(new Color(255, 255, 255));
        returnBookBtn.setText("Return Book");
        returnBookBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                returnBookBtnActionPerformed(e);
            }
        });

        studentRegBtn.setBackground(new Color(0, 102, 102));
        studentRegBtn.setFont(new Font("Tahoma", 0, 12)); // NOI18N
        studentRegBtn.setForeground(new Color(255, 255, 255));
        studentRegBtn.setText("Student Registration");
        studentRegBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                studentRegBtnActionPerformed(e);
            }
        });

        genreList.setFont(new java.awt.Font("Tahoma", 0, 14));
        genreList.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select Genre", "Commerce", "Science", "Literature","History","Poetry" }));
        genreList.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                genreListActionPerformed(e);
            }
        });

        classList.setFont(new Font("Tahoma", 0, 14));
        classList.setModel(new DefaultComboBoxModel<>(new String[] { "Select Class" }));
        classList.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                classListActionPerformed(e);
            }
        });

        genreLabel.setFont(new java.awt.Font("Tahoma", 0, 14));
        genreLabel.setText("Genre");

        classLabel.setFont(new java.awt.Font("Tahoma", 0, 14));
        classLabel.setText("Class");

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(homeBtn)
                        .addGap(46, 46, 46)
                        .addComponent(bookDetailsBtn)
                        .addGap(46, 46, 46)
                        .addComponent(addNewBookBtn)
                        .addGap(41, 41, 41)
                        .addComponent(issueBookBtn)
                        .addGap(48, 48, 48)
                        .addComponent(returnBookBtn)
                        .addGap(39, 39, 39)
                        .addComponent(studentRegBtn)))
                .addContainerGap(24, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(genreLabel)
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(genreList, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(176, 176, 176)
                        .addComponent(classLabel)
                        .addGap(33, 33, 33)
                        .addComponent(classList, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel1))
                .addGap(233, 233, 233))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(42, 42, 42)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(genreList, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(classList, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(genreLabel)
                    .addComponent(classLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 55, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(homeBtn)
                    .addComponent(bookDetailsBtn)
                    .addComponent(addNewBookBtn)
                    .addComponent(issueBookBtn)
                    .addComponent(returnBookBtn)
                    .addComponent(studentRegBtn))
                .addGap(25, 25, 25))
        );

        pack();
    }

    private void homeBtnActionPerformed(ActionEvent e) {
        MainLayer mn=new MainLayer();
        mn.setVisible(true);
        this.setVisible(false);
    }

    private void genreListActionPerformed(ActionEvent e) {
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

    private void classListActionPerformed(ActionEvent e) {
        try
        {
            connect();
            query="select * from issue where genre='"+ genreList.getSelectedItem()+"' and class='"+ classList.getSelectedItem()+"';";
            rs=stmt.executeQuery(query); 
            DefaultTableModel model=(DefaultTableModel)table.getModel();
            model.setRowCount(0);
            while(rs.next())
            {
            Object[] row = {rs.getString("StudentId"),rs.getString("StudentName"),rs.getString("BookId"),rs.getString("BookName"),rs.getString("Address"),rs.getString("IssueDate")};
            model.addRow(row);
            }
        }
        catch(Exception ex)
        {
            
        }
    }

    private void bookDetailsBtnActionPerformed(ActionEvent e) {
        BookDetails bd=new BookDetails();
        bd.setVisible(true);
        this.setVisible(false);
    }

    private void newBookBtnActionPerformed(ActionEvent evt) {
        AddNewBook anb=new AddNewBook();
        anb.setVisible(true);
        this.setVisible(false);
    }

    private void issueBookBtnActionPerformed(ActionEvent evt) {
        IssueBook ib=new IssueBook();
        ib.setVisible(true);
        this.setVisible(false);
    }

    private void returnBookBtnActionPerformed(ActionEvent e) {
        ReturnBook rb=new ReturnBook();
        rb.setVisible(true);
        this.setVisible(false);
    }

    private void studentRegBtnActionPerformed(ActionEvent e) {
        RegisterStudent r=new RegisterStudent();
        r.setVisible(true);
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
            java.util.logging.Logger.getLogger(IssuedBooks.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(IssuedBooks.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(IssuedBooks.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(IssuedBooks.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new IssuedBooks().setVisible(true);
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
