package aifone.iu;


import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class IUContainer extends JFrame {
	
	private static IUContainer instance;  //  @jve:decl-index=0:visual-constraint="17,56"

	private IUContainer() {
		super();
		setSize(320, 480);
	}
	
	static public IUContainer getInstance() {
		if (instance == null) {
			instance = new IUContainer();
			instance.setTitle("AiFone");
		}
		return instance;
	}
	
	public void setPanel(JPanel panel) {
		if (mainPanel != null) {
			remove(mainPanel);
		}
		mainPanel = panel;
		this.add(panel, BorderLayout.CENTER);
		this.validate();
	}
	
	private JPanel mainPanel;
	
	public static void main(String args[]) {
		IUContainer container = IUContainer.getInstance();
		container.setVisible(true);
	}
}
