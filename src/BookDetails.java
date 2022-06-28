
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;


public class BookDetails extends javax.swing.JFrame {
    Connection con;
    Statement stmt;
    ResultSet rs;
    String query;
    String BId,Bname,Bauthor,strm,cls,avl;


    private ButtonGroup b1;
    private JComboBox<String> genreList;
    private JComboBox<String> classList;
    private JButton addBookBtn;
    private JButton homeBtn;
    private JButton issueBookBtn;
    private JButton returnBookBtn;
    private JButton issuedBookDetailsBtn;
    private JLabel title;
    private JScrollPane jScrollPane2;
    private JRadioButton radioButton1;
    private JRadioButton radioButton2;
    private JTable table;
    private JTextField bookNameField;


    public BookDetails() {

        b1 = new ButtonGroup();
        radioButton1 = new JRadioButton();
        radioButton2 = new JRadioButton();
        genreList = new JComboBox<>();
        classList = new JComboBox<>();
        bookNameField = new JTextField();
        jScrollPane2 = new JScrollPane();
        table = new JTable();
        addBookBtn = new JButton();
        homeBtn = new JButton();
        issueBookBtn = new JButton();
        returnBookBtn = new JButton();
        issuedBookDetailsBtn = new JButton();
        title = new javax.swing.JLabel();

        setDefaultCloseOperation(EXIT_ON_CLOSE);

        b1.add(radioButton1);
        radioButton1.setFont(new Font("Tahoma", 0, 13));
        radioButton1.setText("Search by Book Name");
        radioButton1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                radioButton1ActionPerformed(e);
            }
        });

        b1.add(radioButton2);
        radioButton2.setFont(new Font("Tahoma", 0, 13));
        radioButton2.setText("Search By Class");
        radioButton2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                radioButton2ActionPerformed(e);
            }
        });

        genreList.setForeground(new Color(204, 0, 0));
        genreList.setModel(new DefaultComboBoxModel<>(new String[] { "Select Genre", "Science", "Commerce", "Literature","Poetry","History" }));
        genreList.setEnabled(false);
        genreList.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                genreListActionPerformed(e);
            }
        });

        classList.setForeground(new java.awt.Color(204, 0, 0));
        classList.setModel(new DefaultComboBoxModel<>(new String[] { "Select Class" }));
        classList.setEnabled(false);
        classList.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                classListActionPerformed(e);
            }
        });

        bookNameField.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        bookNameField.setForeground(new java.awt.Color(204, 0, 0));
        bookNameField.setEnabled(false);
        bookNameField.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                bookNameFieldActionPerformed(e);
            }
        });
        bookNameField.addKeyListener(new KeyAdapter() {
            public void keyReleased(KeyEvent e) {
                bookNameFieldKeyReleased(e);
            }
        });

        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Book Id", "Book Name", "Author", "Genre", "Class", "Available"
            }
        ));
        table.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        jScrollPane2.setViewportView(table);
        if (table.getColumnModel().getColumnCount() > 0) {
            table.getColumnModel().getColumn(0).setPreferredWidth(40);
            table.getColumnModel().getColumn(1).setPreferredWidth(210);
            table.getColumnModel().getColumn(2).setPreferredWidth(150);
            table.getColumnModel().getColumn(3).setPreferredWidth(40);
            table.getColumnModel().getColumn(4).setPreferredWidth(40);
            table.getColumnModel().getColumn(5).setPreferredWidth(40);
        }

        addBookBtn.setBackground(new Color(0, 102, 102));
        addBookBtn.setForeground(new Color(255, 255, 255));
        addBookBtn.setText("Add a  New Book ");
        addBookBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                addBookBtnActionPerformed(e);
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

        issueBookBtn.setBackground(new Color(0, 102, 102));
        issueBookBtn.setFont(new Font("Tahoma", 0, 12));
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

        issuedBookDetailsBtn.setBackground(new java.awt.Color(0, 102, 102));
        issuedBookDetailsBtn.setFont(new java.awt.Font("Tahoma", 0, 12));
        issuedBookDetailsBtn.setForeground(new java.awt.Color(255, 255, 255));
        issuedBookDetailsBtn.setText("Issued Book Details");
        issuedBookDetailsBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                issuedBookDetailsBtnActionPerformed(e);
            }
        });

        title.setFont(new Font("Georgia", 0, 36));
        title.setForeground(new Color(0, 102, 102));
        title.setText("Book Details");

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(48, 48, 48)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 778, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(radioButton2)
                                    .addComponent(radioButton1))
                                .addGap(26, 26, 26)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(bookNameField, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(genreList, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(84, 84, 84)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(classList, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(addBookBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(98, 98, 98)
                        .addComponent(homeBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(79, 79, 79)
                        .addComponent(issueBookBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(68, 68, 68)
                        .addComponent(returnBookBtn)
                        .addGap(70, 70, 70)
                        .addComponent(issuedBookDetailsBtn))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(302, 302, 302)
                        .addComponent(title)))
                .addContainerGap(55, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(title)
                        .addGap(49, 49, 49)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(radioButton1)
                            .addComponent(bookNameField)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(addBookBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(radioButton2)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(genreList, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(classList, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(26, 26, 26)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(homeBtn)
                    .addComponent(issueBookBtn)
                    .addComponent(returnBookBtn)
                    .addComponent(issuedBookDetailsBtn))
                .addGap(23, 23, 23))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void radioButton1ActionPerformed(ActionEvent e) {
        genreList.disable();
        classList.disable();
        bookNameField.setEnabled(true);
    }

    private void bookNameFieldActionPerformed(ActionEvent e) {
        
    }

    private void radioButton2ActionPerformed(ActionEvent e) {
        bookNameField.disable();
        genreList.setEnabled(true);
    }

    private void classListActionPerformed(ActionEvent e) {
        try
        {
        connect();
        query="select * from books where genre='"+ genreList.getSelectedItem()+"' and class='"+ classList.getSelectedItem()+"';";
        rs=stmt.executeQuery(query); 
        DefaultTableModel model=(DefaultTableModel)table.getModel();
        model.setRowCount(0);
        while(rs.next())
        {
            BId=rs.getString("BookID");
            Bname=rs.getString("BookName");
            Bauthor=rs.getString("Author");
            strm=rs.getString("genre");
            cls=rs.getString("Class");
            avl=rs.getString("Available");
            Object[] row = {BId,Bname,Bauthor,strm,cls,avl};
            model.addRow(row);
        }
        disconnect();
        }
        catch(Exception ex)
        {
            System.out.println(e);
        }
    }

    private void genreListActionPerformed(ActionEvent evt) {//GEN-FIRST:event_c1ActionPerformed
        classList.enable();
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

    private void bookNameFieldKeyReleased(KeyEvent e) {
        DefaultTableModel model=(DefaultTableModel)table.getModel();
        model.setRowCount(0);
        String txt= bookNameField.getText();
        if(txt.equals(""))
            System.out.println("");
        else
        {
            try
            {
                connect();
                query="select * from books where BookName LIKE \"%"+ bookNameField.getText()+"%\";";
                rs=stmt.executeQuery(query); 
                while(rs.next())
                {
                    BId=rs.getString("BookID");
                    Bname=rs.getString("BookName");
                    Bauthor=rs.getString("Author");
                    strm=rs.getString("Stream");
                    cls=rs.getString("Class");
                    avl=rs.getString("Available");
                    Object[] row = {BId,Bname,Bauthor,strm,cls,avl};
                    model.addRow(row);
                }
                disconnect();
            }
            catch(Exception ex)
            {
                System.out.println(e);
            }
        }   
    }//GEN-LAST:event_txt1KeyReleased

    private void addBookBtnActionPerformed(ActionEvent e) {
        AddNewBook anb=new AddNewBook();
        anb.setVisible(true);
        this.setVisible(false);
    }

    private void homeBtnActionPerformed(ActionEvent e) {
        MainLayer mn=new MainLayer();
        mn.setVisible(true);
        this.dispose();
    }

    private void issueBookBtnActionPerformed(ActionEvent e) {
        IssueBook ib=new IssueBook();
        ib.setVisible(true);
        this.setVisible(false);
    }

    private void returnBookBtnActionPerformed(ActionEvent e) {
        ReturnBook rb=new ReturnBook();
        rb.setVisible(true);
        this.setVisible(false);
    }

    private void issuedBookDetailsBtnActionPerformed(ActionEvent e) {
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
            java.util.logging.Logger.getLogger(BookDetails.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BookDetails.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BookDetails.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BookDetails.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new BookDetails().setVisible(true);
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


}
