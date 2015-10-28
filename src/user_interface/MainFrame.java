package user_interface;

import java.awt.Dimension;

import javax.swing.JFrame;

public class MainFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public MainFrame(){
		super();
		setTitle("Image Algorithms V1.0");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(new Dimension(850,400));
		
		setContentPane(new MainPanel());
		
	}

}
