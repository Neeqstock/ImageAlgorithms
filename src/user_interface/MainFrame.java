package user_interface;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;

public class MainFrame extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainFrame frame = new MainFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MainFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 654, 312);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.X_AXIS));
		
		JPanel panel = new JPanel();
		contentPane.add(panel);
		panel.setLayout(new BorderLayout(0, 0));
		
		JLabel lblImageAlgorithmsV = new JLabel("Image Algorithms V1.0");
		lblImageAlgorithmsV.setFont(new Font("Ubuntu Light", Font.BOLD | Font.ITALIC, 14));
		panel.add(lblImageAlgorithmsV, BorderLayout.NORTH);
		
		JPanel panel_1 = new JPanel();
		panel.add(panel_1, BorderLayout.WEST);
		panel_1.setLayout(new GridLayout(10, 2, 0, 0));
		
		JRadioButton rdbtnSobelHor = new JRadioButton("Sobel Horizontal");
		panel_1.add(rdbtnSobelHor);
		
		JRadioButton rdbtnSobelVertical = new JRadioButton("Sobel Vertical");
		panel_1.add(rdbtnSobelVertical);
		
		JRadioButton rdbtnSharpening = new JRadioButton("Sharpening");
		panel_1.add(rdbtnSharpening);
		
		JRadioButton rdbtnPrewitt = new JRadioButton("Prewitt");
		panel_1.add(rdbtnPrewitt);
		
		JRadioButton rdbtnGaussian = new JRadioButton("Gaussian");
		panel_1.add(rdbtnGaussian);
		
		JRadioButton rdbtnThreenines = new JRadioButton("Threenines");
		panel_1.add(rdbtnThreenines);
		
		JRadioButton rdbtnIsotropic = new JRadioButton("Isotropic");
		panel_1.add(rdbtnIsotropic);
		
		JRadioButton rdbtnCanny = new JRadioButton("Canny");
		panel_1.add(rdbtnCanny);
		
		JRadioButton rdbtnMedian = new JRadioButton("Median");
		panel_1.add(rdbtnMedian);
		
		JRadioButton rdbtnRank = new JRadioButton("Rank");
		panel_1.add(rdbtnRank);
		
		JRadioButton rdbtnNagaomatsuyama = new JRadioButton("Nagao-Matsuyama");
		panel_1.add(rdbtnNagaomatsuyama);
		
		JRadioButton rdbtnSaltandpepperNoise = new JRadioButton("SaltAndPepper noise");
		panel_1.add(rdbtnSaltandpepperNoise);
		
		JRadioButton rdbtnGaussianNoise = new JRadioButton("Gaussian noise");
		panel_1.add(rdbtnGaussianNoise);
		
		JRadioButton rdbtnUniformNoise = new JRadioButton("Uniform noise");
		panel_1.add(rdbtnUniformNoise);
		
		JRadioButton rdbtnImpulseNoise = new JRadioButton("Impulse noise");
		panel_1.add(rdbtnImpulseNoise);
		
		JPanel panel_2 = new JPanel();
		panel.add(panel_2, BorderLayout.CENTER);
		panel_2.setLayout(new GridLayout(3,1));
		
		JPanel twoButtons = new JPanel();
		panel_2.add(twoButtons);
		
		final JList<String> fileList = new JList<String>();
		fileList.setBounds(0, 36, 378, 175);
		panel_2.add(fileList);
		
		final DefaultListModel<String> listModel = new DefaultListModel<String>();
		fileList.setModel(listModel);
		
		JButton btnPickAPgm = new JButton("Pick a PGM image");
		btnPickAPgm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser chooser = new JFileChooser();
				FileNameExtensionFilter filter = new FileNameExtensionFilter("PGM images", "pgm");
				chooser.setFileFilter(filter);
				int returnVal = chooser.showOpenDialog(MainFrame.this);
				if(returnVal == JFileChooser.APPROVE_OPTION) {
					System.out.println("woooo. " + chooser.getSelectedFile().getName());
					listModel.addElement(chooser.getSelectedFile().getAbsolutePath());
				}
			}
		});
		
		JButton btnRemoveFile = new JButton("Remove file from list");
		btnRemoveFile.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				listModel.removeElementAt(fileList.getSelectedIndex());
			}
		});
		
		twoButtons.add(btnPickAPgm);
		twoButtons.add(btnRemoveFile);
		
		JPanel computePanel = new JPanel();
		
		JButton btnCompute = new JButton("Compute");
		btnCompute.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		
		computePanel.add(btnCompute);
		panel_2.add(computePanel);
	}
}
