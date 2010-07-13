/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * IUEnviarTweet.java
 *
 * Created on 13/07/2010, 01:06:31
 */

package aifone.hitwitter.iu;

import aifone.iu.IObservaTeclado;
import aifone.iu.AdapterJTextComponentObservaTeclado;
/**
 *
 * @author William
 */
public class IUEnviarTweet extends javax.swing.JPanel {

    /** Creates new form IUEnviarTweet */
    public IUEnviarTweet() {
        initComponents();
        componenteTeclado.setCampoAlvo(new AdapterJTextComponentObservaTeclado(areaTexto));
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        areaTexto = new javax.swing.JTextArea();
        labelNumeroCaracteres = new javax.swing.JLabel();
        componenteTeclado = new aifone.iu.IUTeclado();
        label140char = new javax.swing.JLabel();
        botaoTuitar = new javax.swing.JButton();
        botaoCancelar = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        areaTexto.setColumns(20);
        areaTexto.setLineWrap(true);
        areaTexto.setRows(5);
        areaTexto.setWrapStyleWord(true);
        areaTexto.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                areaTextoCaretUpdate(evt);
            }
        });
        jScrollPane1.setViewportView(areaTexto);

        labelNumeroCaracteres.setText("000");

        label140char.setText("/140 Caracteres");

        botaoTuitar.setText("Tweet!");
        botaoTuitar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoTuitarActionPerformed(evt);
            }
        });

        botaoCancelar.setText("X");

        jButton1.setText("jButton1");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(labelNumeroCaracteres)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(label140char)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(botaoTuitar))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 269, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButton1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(botaoCancelar))))
                    .addComponent(componenteTeclado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botaoCancelar)
                    .addComponent(jButton1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelNumeroCaracteres)
                    .addComponent(label140char)
                    .addComponent(botaoTuitar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(componenteTeclado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void areaTextoCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_areaTextoCaretUpdate
        contarCaracteres();
    }//GEN-LAST:event_areaTextoCaretUpdate

    private void botaoTuitarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoTuitarActionPerformed

    }//GEN-LAST:event_botaoTuitarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea areaTexto;
    private javax.swing.JButton botaoCancelar;
    private javax.swing.JButton botaoTuitar;
    private aifone.iu.IUTeclado componenteTeclado;
    private javax.swing.JButton jButton1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel label140char;
    private javax.swing.JLabel labelNumeroCaracteres;
    // End of variables declaration//GEN-END:variables

    private void contarCaracteres(){
        labelNumeroCaracteres.setText(String.valueOf(areaTexto.getText().length()));
    }
}
