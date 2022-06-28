import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainLayer extends JFrame implements ActionListener {

    private JButton issueBookBtn;
    private JButton returnBookBtn;
    private JButton newBookBtn;
    private JButton registerBtn;
    private JButton issuedBookDetailsBtn;
    private JButton bookDetailsBtn;
    private JLabel jLabel1;
    private JLabel jLabel2;
    private JLabel jLabel3;
    private JLabel jLabel4;
    private JLabel jLabel5;


    public MainLayer() {
//        initcomponents();


        jLabel1 = new JLabel();
        jLabel2 = new JLabel();
        jLabel4 = new JLabel();
        jLabel3 = new JLabel();
        jLabel5 = new JLabel();
        issueBookBtn = new JButton();
        returnBookBtn = new JButton();
        newBookBtn = new JButton();
        registerBtn = new JButton();
        issuedBookDetailsBtn = new JButton();
        bookDetailsBtn = new JButton();

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setBackground(new Color(255, 255, 255));

        jLabel1.setFont(new Font("Footlight MT Light", 0, 56)); // NOI18N
        jLabel1.setForeground(new Color(0, 102, 102));
        jLabel1.setText("University Library");

        jLabel2.setFont(new Font("Lucida Handwriting", 0, 24)); // NOI18N
        jLabel2.setForeground(new Color(0, 204, 204));
        jLabel2.setText("Library ");

        jLabel4.setIcon(new ImageIcon(getClass().getResource("/Book Details.png"))); // NOI18N

        jLabel3.setIcon(new ImageIcon(getClass().getResource("/Issue Book.png"))); // NOI18N

        jLabel5.setIcon(new ImageIcon(getClass().getResource("/Return Books.png"))); // NOI18N

        issueBookBtn.setBackground(new Color(0, 102, 102));
        issueBookBtn.setFont(new Font("Tahoma", 1, 24)); // NOI18N
        issueBookBtn.setForeground(new Color(255, 255, 255));
        issueBookBtn.setText("Issue Book");
        issueBookBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                issueBookBtnActionPerformed(e);
            }
        });

        returnBookBtn.setBackground(new Color(0, 102, 102));
        returnBookBtn.setFont(new Font("Tahoma", 1, 24)); // NOI18N
        returnBookBtn.setForeground(new Color(255, 255, 255));
        returnBookBtn.setText("Return Book");
        returnBookBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(ActionEvent e) {
                returnBookBtnActionPerformed(e);
            }
        });

        newBookBtn.setBackground(new Color(0, 102, 102));
        newBookBtn.setFont(new Font("Tahoma", 0, 12)); // NOI18N
        newBookBtn.setForeground(new Color(255, 255, 255));
        newBookBtn.setText("Add New Books");
        newBookBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                newBookBtnActionPerformed(e);
            }
        });

        registerBtn.setBackground(new Color(0, 102, 102));
        registerBtn.setFont(new Font("Tahoma", 0, 12)); // NOI18N
        registerBtn.setForeground(new Color(255, 255, 255));
        registerBtn.setText("Student Registration");
        registerBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                registerBtnActionPerformed(e);
            }
        });

        issuedBookDetailsBtn.setBackground(new Color(0, 102, 102));
        issuedBookDetailsBtn.setFont(new Font("Tahoma", 0, 12)); // NOI18N
        issuedBookDetailsBtn.setForeground(new Color(255, 255, 255));
        issuedBookDetailsBtn.setText("Issued Book Details");
        issuedBookDetailsBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(ActionEvent e) {
                issuedBookDetailsBtnActionPerformed(e);
            }
        });

        bookDetailsBtn.setBackground(new Color(0, 102, 102));
        bookDetailsBtn.setFont(new Font("Tahoma", 1, 24)); // NOI18N
        bookDetailsBtn.setForeground(new Color(255, 255, 255));
        bookDetailsBtn.setText("Book Details");
        bookDetailsBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                bookDetailsBtnActionPerformed(e);
            }
        });

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(54, 54, 54)
                        .addComponent(bookDetailsBtn)))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 84, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(issueBookBtn)
                        .addGap(94, 94, 94))
                    .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 149, GroupLayout.PREFERRED_SIZE))
                        .addGap(84, 84, 84)))
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(returnBookBtn)
                    .addComponent(jLabel5))
                .addGap(82, 82, 82))
            .addGroup(layout.createSequentialGroup()
                .addGap(249, 249, 249)
                .addComponent(newBookBtn)
                .addGap(139, 139, 139)
                .addComponent(registerBtn)
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(issuedBookDetailsBtn)
                        .addGap(366, 366, 366))
                    .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(175, 175, 175))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabel4))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(jLabel5))
                            .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel3)))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(issueBookBtn)
                                .addComponent(bookDetailsBtn))
                            .addComponent(returnBookBtn))))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(newBookBtn)
                    .addComponent(registerBtn))
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(issuedBookDetailsBtn)
                .addContainerGap(24, Short.MAX_VALUE))
        );

        pack();
    }

    private void newBookBtnActionPerformed(ActionEvent evt) {
        AddNewBook anb=new AddNewBook();
        anb.setVisible(true);
        this.setVisible(false);
    }

    private void registerBtnActionPerformed(ActionEvent evt) {
        RegisterStudent r=new RegisterStudent();
        r.setVisible(true);
        this.setVisible(false);
    }

    private void issueBookBtnActionPerformed(java.awt.event.ActionEvent evt) {
        IssueBook ib=new IssueBook();
        ib.setVisible(true);
        this.setVisible(false);
    }

    private void returnBookBtnActionPerformed(java.awt.event.ActionEvent evt) {
        ReturnBook rb=new ReturnBook();
        rb.setVisible(true);
        this.setVisible(false);
    }

    private void issuedBookDetailsBtnActionPerformed(java.awt.event.ActionEvent evt) {
        IssuedBooks ibs=new IssuedBooks();
        ibs.setVisible(true);
        this.setVisible(false);
    }

    private void bookDetailsBtnActionPerformed(java.awt.event.ActionEvent evt) {
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
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainLayer().setVisible(true);
            }
        });
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }



}
