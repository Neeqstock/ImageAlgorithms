package user_interface;

import java.awt.CardLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.filechooser.FileNameExtensionFilter;

public class FileSelectionPanel extends JPanel {
	
	private JButton selectButton;
	private JList visualList = new JList();
	private DefaultListModel<String> listModel = new DefaultListModel<String>();
	
	public FileSelectionPanel(final JFrame frame) {
		super();
		
		setLayout(new CardLayout());
		selectButton = new JButton();
		add(selectButton);
		add(visualList);
		visualList.setModel(listModel);
		
		ActionListener baubau = new ActionListener(){
				
				@Override
				public void actionPerformed(ActionEvent e) {
					JFileChooser chooser = new JFileChooser();
					FileNameExtensionFilter filter = new FileNameExtensionFilter("PGM images", "pgm");
					chooser.setFileFilter(filter);
					int returnVal = chooser.showOpenDialog(frame);
					if(returnVal == JFileChooser.APPROVE_OPTION){
						System.out.println(chooser.getSelectedFile().getName());
					}
				}	
				
			};

		
	}
}
