package aifone.iu;


import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

import aifone.AiFone;

@SuppressWarnings("serial")
public class IUContainer extends JFrame {
	
	private static IUContainer instance;

	private IUContainer() {
		super();
		setSize(320, 480);
		setTitle("AiFone");
	}
	
	/**
	 * Get singleton instance
	 * 
	 * @return IUContainer instance
	 */
	static public IUContainer getInstance() {
		if (instance == null) {
			instance = new IUContainer();
		}
		
		return instance;
	}
	
	public void setPanel(JPanel panel) {
		if (mainPanel != null) {
			remove(mainPanel);
		}
		mainPanel = panel;
		add(panel, BorderLayout.CENTER);
		validate();
		repaint();
	}
	
	private JPanel mainPanel;
	
}
