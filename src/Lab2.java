/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Khoa Vo
 */
public class Lab2 extends javax.swing.JFrame {

    /**
     * Creates new form Lab2
     */
    public Lab2() {
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

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtPlainText = new javax.swing.JTextArea();
        jLabel3 = new javax.swing.JLabel();
        txtKey = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtCipherText = new javax.swing.JTextArea();
        btnEncrypt = new javax.swing.JButton();
        txtDecrypt = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Vigenere Cipher Encrypt & Decrypt Program");

        jLabel2.setText("Plaint Text");

        txtPlainText.setColumns(20);
        txtPlainText.setRows(5);
        jScrollPane1.setViewportView(txtPlainText);

        jLabel3.setText("Key");

        jLabel4.setText("Cipher Text");

        txtCipherText.setColumns(20);
        txtCipherText.setRows(5);
        jScrollPane2.setViewportView(txtCipherText);

        btnEncrypt.setText("Encrypt");
        btnEncrypt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEncryptActionPerformed(evt);
            }
        });

        txtDecrypt.setText("Decrypt");
        txtDecrypt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDecryptActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 470, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1)
                            .addComponent(jScrollPane2)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtKey)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnEncrypt)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtDecrypt)))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtKey, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(txtDecrypt)
                    .addComponent(btnEncrypt))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnEncryptActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEncryptActionPerformed
        int tableRowSize = 26;
        int tableColumnSize = 26;
        int vigenereTable[][] = new int[26][26];
        
        for (int rows = 0; rows < tableRowSize; rows++) {
            for (int columns = 0; columns < tableColumnSize; columns++) {
                vigenereTable[rows][columns] = (rows + columns) % 26;
            }
        }
        
        String plainText = txtPlainText.getText().toUpperCase();
        String key = txtKey.getText().toUpperCase();
        String cipherText = "";
        
        int kIndex = 0;
        for (int ptIndex = 0; ptIndex < plainText.length(); ptIndex++) {
            char pChar = plainText.charAt(ptIndex);
            int asciiValue = (int) pChar;
            
            if (pChar == ' ') {
                cipherText += pChar;
                continue;
            }
            if (asciiValue < 65 || asciiValue > 90) {
                cipherText += pChar;
                continue;
            }
            
            int basicPlainTextValue = ((int) pChar) - 65;
            char kChar = key.charAt(kIndex);
            int basicKeyValue = ((int) kChar) - 65;
            int tableEntry = vigenereTable[basicPlainTextValue][basicKeyValue];
            char cChar = (char) (tableEntry + 65);
            
            cipherText += cChar;
            kIndex++;
            
            if (kIndex == key.length())
                kIndex = 0;
        }
        
        txtCipherText.setText(cipherText.toString().toUpperCase());
    }//GEN-LAST:event_btnEncryptActionPerformed

    private void txtDecryptActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDecryptActionPerformed
        int tableRowSize = 26;
        int tableColumnSize = 26;
        int vigenereTable[][] = new int[26][26];
        String cipherText = txtCipherText.getText().toUpperCase();
        String plainText = "";
        
        for (int rows = 0; rows < tableRowSize; rows++) {
            for (int columns = 0; columns < tableColumnSize; columns++) {
                vigenereTable[rows][columns] = (rows + columns) % 26;
            }
        }
        
        String key = txtKey.getText().toUpperCase();
        
        int kIndex = 0;
        
        for (int ctIndex = 0; ctIndex < cipherText.length(); ctIndex++) {
            char cChar = cipherText.charAt(ctIndex);
            int asciiValue = (int) cChar;
            if (cChar == ' ') {
                plainText += cChar;
                continue;
            }
            if (asciiValue < 65 || asciiValue > 90) {
                plainText += cChar;
                continue;
            }
            
            int basicCipherTextValue = ((int) cChar - 65);
            char kChar = key.charAt(kIndex);
            int basicKeyValue = ((int) kChar) - 65;
            
            for (int pIndex = 0; pIndex < tableColumnSize; pIndex++) {
                if (vigenereTable[basicKeyValue][pIndex] == basicCipherTextValue) {
                    char potcChar = (char) (vigenereTable[basicKeyValue][pIndex] + 65);
                    char potpChar = (char) (pIndex + 65);
                    plainText += potpChar;
                }
            }
            
            if  (kIndex == key.length())
                kIndex = 0;
        }
        
        txtPlainText.setText(cipherText.toString().toUpperCase());
        txtCipherText.setText(plainText.toString().toUpperCase());
    }//GEN-LAST:event_txtDecryptActionPerformed

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
            java.util.logging.Logger.getLogger(Lab2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Lab2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Lab2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Lab2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Lab2().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEncrypt;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea txtCipherText;
    private javax.swing.JButton txtDecrypt;
    private javax.swing.JTextField txtKey;
    private javax.swing.JTextArea txtPlainText;
    // End of variables declaration//GEN-END:variables
}
