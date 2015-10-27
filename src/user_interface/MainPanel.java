package user_interface;

import java.awt.BorderLayout;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class MainPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private FiltersPanel filtersPanel = new FiltersPanel();
	
	public MainPanel(){
		super();
		setLayout(new BorderLayout());
		
		JLabel title=new JLabel("Image Algorithms V1.0");
		title.setFont(new Font("Sans-serif", Font.BOLD, 20));
		
		add(title, BorderLayout.PAGE_START);
		add(filtersPanel, BorderLayout.WEST);
	}
	
}
