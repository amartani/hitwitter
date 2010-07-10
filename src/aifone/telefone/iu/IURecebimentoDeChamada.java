/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * IURecebimentoDeChamada.java
 *
 * Created on 09/07/2010, 16:29:25
 */

package aifone.telefone.iu;

import aifone.iu.IUContainer;

/**
 *
 * @author William
 */
public class IURecebimentoDeChamada extends javax.swing.JPanel {

    /** Creates new form IURecebimentoDeChamada */
    public IURecebimentoDeChamada() {
        initComponents();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        labelNumero = new javax.swing.JLabel();
        botaoAceitar = new javax.swing.JButton();
        botaoRejeitar = new javax.swing.JButton();

        jLabel1.setText("Recebendo chamada...");

        labelNumero.setText("0000");

        botaoAceitar.setText("Aceitar");
        botaoAceitar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoAceitarActionPerformed(evt);
            }
        });

        botaoRejeitar.setText("Rejeitar");
        botaoRejeitar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoRejeitarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(84, 84, 84)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(125, 125, 125)
                        .addComponent(labelNumero))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(57, 57, 57)
                        .addComponent(botaoAceitar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(botaoRejeitar)))
                .addContainerGap(199, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(66, 66, 66)
                .addComponent(jLabel1)
                .addGap(33, 33, 33)
                .addComponent(labelNumero)
                .addGap(74, 74, 74)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botaoAceitar)
                    .addComponent(botaoRejeitar))
                .addContainerGap(76, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void botaoAceitarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoAceitarActionPerformed
        IUContainer.getInstance().setPanel(new IUConversa());
    }//GEN-LAST:event_botaoAceitarActionPerformed

    private void botaoRejeitarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoRejeitarActionPerformed
        IUContainer.getInstance().setPanel(new IUDiscar());
    }//GEN-LAST:event_botaoRejeitarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botaoAceitar;
    private javax.swing.JButton botaoRejeitar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel labelNumero;
    // End of variables declaration//GEN-END:variables

}
