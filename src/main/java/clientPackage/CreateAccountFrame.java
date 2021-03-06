/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clientPackage;

import java.io.EOFException;
import java.io.IOException;
import java.net.SocketException;
import javax.swing.JOptionPane;
import static clientPackage.LoginFrame.dis;
import static clientPackage.LoginFrame.dos;
import java.awt.event.WindowEvent;

/**
 *
 * @author Aidan
 */
public class CreateAccountFrame extends javax.swing.JFrame {

    /**
     * Creates new form CreateAccount
     */
    public CreateAccountFrame() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jtfUsername = new javax.swing.JTextField();
        jtfPassword = new javax.swing.JTextField();
        jtfFirstName = new javax.swing.JTextField();
        jtfSurname = new javax.swing.JTextField();
        jbUsername = new javax.swing.JLabel();
        jbPassword = new javax.swing.JLabel();
        jbFirstName = new javax.swing.JLabel();
        jbSurname = new javax.swing.JLabel();
        btnCreateAccount = new javax.swing.JButton();
        btnBack = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jbUsername.setText("Username");

        jbPassword.setText("Password");

        jbFirstName.setText("Firstname");

        jbSurname.setText("Surname");

        btnCreateAccount.setText("Create Account");
        btnCreateAccount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCreateAccountActionPerformed(evt);
            }
        });

        btnBack.setText("Back");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jtfSurname, javax.swing.GroupLayout.DEFAULT_SIZE, 76, Short.MAX_VALUE)
                        .addGap(45, 45, 45)
                        .addComponent(btnCreateAccount, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(29, 29, 29)
                        .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(19, 19, 19))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jbFirstName)
                            .addComponent(jbUsername)
                            .addComponent(jbSurname)
                            .addComponent(jbPassword)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jtfFirstName, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 109, Short.MAX_VALUE)
                                .addComponent(jtfPassword, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jtfUsername, javax.swing.GroupLayout.Alignment.LEADING)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(jbUsername)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jtfUsername, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jbPassword)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jtfPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jbFirstName)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jtfFirstName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jbSurname)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtfSurname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBack)
                    .addComponent(btnCreateAccount))
                .addContainerGap(40, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnCreateAccountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCreateAccountActionPerformed
        // TODO add your handling code here:
        createAccount();
    }//GEN-LAST:event_btnCreateAccountActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        // TODO add your handling code here:
        LoginFrame.lg.setVisible(true);
        LoginFrame.ca.setVisible(false);
    }//GEN-LAST:event_btnBackActionPerformed

    /**
     * @param args the command line arguments
     */
    public static boolean usernameAcceptable = false;

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
            java.util.logging.Logger.getLogger(CreateAccountFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CreateAccountFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CreateAccountFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CreateAccountFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CreateAccountFrame().setVisible(true);
            }
        });
    }

    private void createAccount() {
        try {
            if (testInputFields()) {
                testUsername(jtfUsername.getText());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private boolean testInputFields() {
        boolean inputValid = true;
        if (((jtfUsername.getText()).trim()).length() == 0) {
            JOptionPane.showMessageDialog(this, "Please enter valid input", "Username Input Lacking", JOptionPane.ERROR_MESSAGE);
            inputValid = false;
        } else if (((jtfPassword.getText()).trim()).length() == 0) {
            JOptionPane.showMessageDialog(this, "Please enter valid input", "Password Input Lacking", JOptionPane.ERROR_MESSAGE);
            inputValid = false;
        } else if (((jtfFirstName.getText()).trim()).length() == 0) {
            JOptionPane.showMessageDialog(this, "Please enter valid input", "First Name Input Lacking", JOptionPane.ERROR_MESSAGE);
            inputValid = false;
        } else if (((jtfSurname.getText()).trim()).length() == 0) {
            JOptionPane.showMessageDialog(this, "Please enter valid input", "Surname Input Lacking", JOptionPane.ERROR_MESSAGE);
            inputValid = false;
        }

        return inputValid;
    }

    private void createValidUser(String username, String password, String firstName, String surname) {

//        sendMessage thread
        Thread sendMessage = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
//                    write on the output stream
                    String msg = "createNewUser#" + username + "#" + password + "#" + firstName + "#" + surname;
                    dos.writeUTF(msg);
                    dos.flush();
                } catch (SocketException e) {
//                            e.printStackTrace();
                } catch (IOException e) {
//                            e.printStackTrace();
                }
            }
        });
        sendMessage.start();
    }

    private void testUsername(String username) {
//        sendMessage thread
        Thread sendMessage = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
//                    write on the output stream
                    String msg = "testUsername#" + username;
                    dos.writeUTF(msg);
                    dos.flush();
                } catch (SocketException e) {
//                            e.printStackTrace();
                } catch (IOException e) {
//                            e.printStackTrace();
                }
            }
        });

//                    readMessage thread
        Thread readMessage = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
//                    read the message sent to this client 
                    String msg = dis.readUTF();
//                    System.out.println(msg);
                    if (Boolean.valueOf(msg)) {
                        createValidUser(jtfUsername.getText(), jtfPassword.getText(), jtfFirstName.getText(), jtfSurname.getText());
                        JOptionPane.showMessageDialog(CreateAccountFrame.this, "Account successfully created");
//                        System.out.println("account created");
                        CentralGui cf = new CentralGui(jtfUsername.getText());
                        cf.runSomething();
                        cf.setVisible(true);
                        cf.jlblCurrentUser.setText(cf.jlblCurrentUser.getText() + jtfUsername.getText());

                        cf.username = jtfUsername.getText();
                        LoginFrame.lg.dispatchEvent(new WindowEvent(LoginFrame.lg, WindowEvent.WINDOW_CLOSING));
                        LoginFrame.ca.dispatchEvent(new WindowEvent(LoginFrame.ca, WindowEvent.WINDOW_CLOSING));
                    } else {
                        JOptionPane.showMessageDialog(CreateAccountFrame.this, "Username already taken", "Username already exists", JOptionPane.ERROR_MESSAGE);
                    }
                } catch (EOFException e) {
//                            e.printStackTrace();
                } catch (SocketException e) {
//                             e.printStackTrace();
                } catch (IOException e) {
//                            e.printStackTrace();
                }
            }
        });

        sendMessage.start();
        readMessage.start();
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnCreateAccount;
    private javax.swing.JLabel jbFirstName;
    private javax.swing.JLabel jbPassword;
    private javax.swing.JLabel jbSurname;
    private javax.swing.JLabel jbUsername;
    private static javax.swing.JTextField jtfFirstName;
    private static javax.swing.JTextField jtfPassword;
    private static javax.swing.JTextField jtfSurname;
    private static javax.swing.JTextField jtfUsername;
    // End of variables declaration//GEN-END:variables
}
