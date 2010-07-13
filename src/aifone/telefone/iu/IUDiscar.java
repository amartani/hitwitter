/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * IUDiscar.java
 *
 * Created on 08/07/2010, 23:46:49
 */

package aifone.telefone.iu;

import aifone.telefone.AppTelefone;
import aifone.telefone.IAppTelefoneIU;
import aifone.telefone.rn.RNAppTelefone;

/**
 * 
 * @author William
 */
public class IUDiscar extends javax.swing.JPanel {

	private RNAppTelefone rnAppTelefone;
	private IAppTelefoneIU appTelefone;

	/** Creates new form IUDiscar */
	public IUDiscar(AppTelefone appTelefone, RNAppTelefone rnAppTelefone) {
		initComponents();
		this.rnAppTelefone = rnAppTelefone;
		this.appTelefone = appTelefone;
		labelNumero.setText(appTelefone.getTelefone().getNumero());
	}

	/**
	 * This method is called from within the constructor to initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is always
	 * regenerated by the Form Editor.
	 */
	@SuppressWarnings("unchecked")
	// <editor-fold defaultstate="collapsed"
	// <editor-fold defaultstate="collapsed"
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        campoDoNumero = new javax.swing.JTextField();
        botao0 = new javax.swing.JButton();
        botaoDiscar = new javax.swing.JButton();
        botao1 = new javax.swing.JButton();
        botao2 = new javax.swing.JButton();
        botao3 = new javax.swing.JButton();
        botao4 = new javax.swing.JButton();
        botao5 = new javax.swing.JButton();
        botao6 = new javax.swing.JButton();
        botao7 = new javax.swing.JButton();
        botao8 = new javax.swing.JButton();
        botao9 = new javax.swing.JButton();
        botaoApagar = new javax.swing.JButton();
        botaoSair = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        labelNumero = new javax.swing.JLabel();

        jButton1.setText("jButton1");

        setPreferredSize(new java.awt.Dimension(320, 480));

        campoDoNumero.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campoDoNumeroActionPerformed(evt);
            }
        });

        botao0.setText("0");
        botao0.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botao0ActionPerformed(evt);
            }
        });

        botaoDiscar.setText("Discar");
        botaoDiscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoDiscarActionPerformed(evt);
            }
        });

        botao1.setText("1");
        botao1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botao1ActionPerformed(evt);
            }
        });

        botao2.setText("2");
        botao2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botao2ActionPerformed(evt);
            }
        });

        botao3.setText("3");
        botao3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botao3ActionPerformed(evt);
            }
        });

        botao4.setText("4");
        botao4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botao4ActionPerformed(evt);
            }
        });

        botao5.setText("5");
        botao5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botao5ActionPerformed(evt);
            }
        });

        botao6.setText("6");
        botao6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botao6ActionPerformed(evt);
            }
        });

        botao7.setText("7");
        botao7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botao7ActionPerformed(evt);
            }
        });

        botao8.setText("8");
        botao8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botao8ActionPerformed(evt);
            }
        });

        botao9.setText("9");
        botao9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botao9ActionPerformed(evt);
            }
        });

        botaoApagar.setText("<");
        botaoApagar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoApagarActionPerformed(evt);
            }
        });

        botaoSair.setText("X");
        botaoSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoSairActionPerformed(evt);
            }
        });

        jLabel1.setText("Meu Numero:");

        labelNumero.setText("numero");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(57, 57, 57)
                .addComponent(campoDoNumero, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(botaoApagar)
                .addGap(41, 41, 41))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(107, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(botaoDiscar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(botaoSair))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(botao7)
                            .addGap(6, 6, 6)
                            .addComponent(botao8)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(botao9))
                        .addComponent(botao0)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(botao1)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(botao2)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(botao3))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(botao4)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(botao5)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(botao6))))
                .addGap(97, 97, 97))
            .addGroup(layout.createSequentialGroup()
                .addGap(84, 84, 84)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(labelNumero)
                .addContainerGap(143, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(labelNumero))
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(campoDoNumero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botaoApagar))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botao1)
                    .addComponent(botao2)
                    .addComponent(botao3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botao4)
                    .addComponent(botao5)
                    .addComponent(botao6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botao7)
                    .addComponent(botao9)
                    .addComponent(botao8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(botao0)
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botaoDiscar)
                    .addComponent(botaoSair))
                .addContainerGap(213, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

        private void campoDoNumeroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campoDoNumeroActionPerformed
            discar();
        }//GEN-LAST:event_campoDoNumeroActionPerformed

	private void botao1ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_botao1ActionPerformed
		adicionarNumero("1");
	}// GEN-LAST:event_botao1ActionPerformed

	private void botao2ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_botao2ActionPerformed
		adicionarNumero("2");
	}// GEN-LAST:event_botao2ActionPerformed

	private void botao3ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_botao3ActionPerformed
		adicionarNumero("3");
	}// GEN-LAST:event_botao3ActionPerformed

	private void botao4ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_botao4ActionPerformed
		adicionarNumero("4");
	}// GEN-LAST:event_botao4ActionPerformed

	private void botao5ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_botao5ActionPerformed
		adicionarNumero("5");
	}// GEN-LAST:event_botao5ActionPerformed

	private void botao6ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_botao6ActionPerformed
		adicionarNumero("6");
	}// GEN-LAST:event_botao6ActionPerformed

	private void botao7ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_botao7ActionPerformed
		adicionarNumero("7");
	}// GEN-LAST:event_botao7ActionPerformed

	private void botao8ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_botao8ActionPerformed
		adicionarNumero("8");
	}// GEN-LAST:event_botao8ActionPerformed

	private void botao9ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_botao9ActionPerformed
		adicionarNumero("9");
	}// GEN-LAST:event_botao9ActionPerformed

	private void botao0ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_botao0ActionPerformed
		adicionarNumero("0");
	}// GEN-LAST:event_botao0ActionPerformed

	private void botaoApagarActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_botaoApagarActionPerformed
		String numeroDeTelefone = campoDoNumero.getText();
		if (numeroDeTelefone.length() > 0) {
			String numero2 = numeroDeTelefone.substring(0, numeroDeTelefone
					.length() - 1);
			campoDoNumero.setText(numero2);
		}
	}// GEN-LAST:event_botaoApagarActionPerformed

	private void botaoDiscarActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_botaoDiscarActionPerformed
            discar();
	}// GEN-LAST:event_botaoDiscarActionPerformed

	private void botaoSairActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_botaoSairActionPerformed
		appTelefone.abrirTelaInicial();
	}// GEN-LAST:event_botaoSairActionPerformed

	private void adicionarNumero(String numero) {
		campoDoNumero.setText(campoDoNumero.getText().concat(numero));
	}

        private void discar(){
            if (campoDoNumero.getText().length() > 0) {
                appTelefone.abrirTelaEfetuandoChamada();
                rnAppTelefone.setInterlocutor(campoDoNumero.getText());
                rnAppTelefone.efetuarChamada();
            }
        }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botao0;
    private javax.swing.JButton botao1;
    private javax.swing.JButton botao2;
    private javax.swing.JButton botao3;
    private javax.swing.JButton botao4;
    private javax.swing.JButton botao5;
    private javax.swing.JButton botao6;
    private javax.swing.JButton botao7;
    private javax.swing.JButton botao8;
    private javax.swing.JButton botao9;
    private javax.swing.JButton botaoApagar;
    private javax.swing.JButton botaoDiscar;
    private javax.swing.JButton botaoSair;
    private javax.swing.JTextField campoDoNumero;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel labelNumero;
    // End of variables declaration//GEN-END:variables

}
