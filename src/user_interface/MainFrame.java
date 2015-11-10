package user_interface;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;

public class MainFrame extends JFrame implements ActionListener {

	private JPanel contentPane;
	private Engine engine;
	private JList<String> fileList = new JList<String>();

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

		engine = new Engine();

		JPanel panel = new JPanel();
		contentPane.add(panel);
		panel.setLayout(new BorderLayout(0, 0));

		JLabel lblImageAlgorithmsV = new JLabel("Image Algorithms V1.0");
		lblImageAlgorithmsV.setFont(new Font("Ubuntu Light", Font.BOLD
				| Font.ITALIC, 14));
		panel.add(lblImageAlgorithmsV, BorderLayout.NORTH);

		JPanel panel_1 = new JPanel();
		panel.add(panel_1, BorderLayout.WEST);
		panel_1.setLayout(new GridLayout(10, 2, 0, 0));

		JRadioButton rdbtnSobel = new JRadioButton("Sobel");
		panel_1.add(rdbtnSobel);
		rdbtnSobel.setSelected(true);

		JRadioButton rdbtnSharpening = new JRadioButton("Sharpening");
		panel_1.add(rdbtnSharpening);

		JRadioButton rdbtnPrewitt = new JRadioButton("Prewitt");
		panel_1.add(rdbtnPrewitt);

		JRadioButton rdbtnBox = new JRadioButton("Box");
		panel_1.add(rdbtnBox);

		JRadioButton rdbtnGaussian = new JRadioButton("Gaussian");
		panel_1.add(rdbtnGaussian);

		JRadioButton rdbtnThreenines = new JRadioButton("Threenines");
		panel_1.add(rdbtnThreenines);
		
		JRadioButton rdbtnDoG = new JRadioButton("DoG");
		panel_1.add(rdbtnDoG);
		
		JRadioButton rdbtnRoberts = new JRadioButton("Roberts");
		panel_1.add(rdbtnRoberts);

		JRadioButton rdbtnIsotropic = new JRadioButton("Isotropic");
		panel_1.add(rdbtnIsotropic);

		JRadioButton rdbtnCanny = new JRadioButton("Canny");
		panel_1.add(rdbtnCanny);
		
		final JRadioButton rdbtnRank = new JRadioButton("Rank");
		String[] rankNumbers = {"1", "3", "5", "7", "9"};
		final JComboBox cbboxRank = new JComboBox(rankNumbers);
		cbboxRank.setSelectedIndex(0);
		JPanel pnlRank = new JPanel();
		pnlRank.setLayout(new GridLayout(1, 2));
		pnlRank.add(rdbtnRank);
		pnlRank.add(cbboxRank);
		panel_1.add(pnlRank);

		JRadioButton rdbtnNagaomatsuyama = new JRadioButton("Nagao-Matsuyama");
		panel_1.add(rdbtnNagaomatsuyama);

		JRadioButton rdbtnSaltandpepperNoise = new JRadioButton(
				"SaltAndPepper noise");
		panel_1.add(rdbtnSaltandpepperNoise);

		JRadioButton rdbtnGaussianNoise = new JRadioButton("Gaussian noise");
		panel_1.add(rdbtnGaussianNoise);

		JRadioButton rdbtnUniformNoise = new JRadioButton("Uniform noise");
		panel_1.add(rdbtnUniformNoise);

		JRadioButton rdbtnImpulseNoise = new JRadioButton("Impulse noise");
		panel_1.add(rdbtnImpulseNoise);

		JPanel panel_2 = new JPanel();
		panel.add(panel_2, BorderLayout.CENTER);
		panel_2.setLayout(new GridLayout(3, 1));

		JPanel twoButtons = new JPanel();
		panel_2.add(twoButtons);

		fileList.setBounds(0, 36, 378, 175);
		panel_2.add(fileList);

		final DefaultListModel<String> listModel = new DefaultListModel<String>();
		fileList.setModel(listModel);

		JButton btnPickAPgm = new JButton("Pick a PGM image");
		btnPickAPgm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser chooser = new JFileChooser();
				File file = new File("img/");
				chooser.setCurrentDirectory(file);
				FileNameExtensionFilter filter = new FileNameExtensionFilter(
						"PGM images", "pgm");
				chooser.setFileFilter(filter);
				int returnVal = chooser.showOpenDialog(MainFrame.this);
				if (returnVal == JFileChooser.APPROVE_OPTION) {
					System.out.println("woooo. "
							+ chooser.getSelectedFile().getName());
					listModel.addElement(chooser.getSelectedFile()
							.getAbsolutePath());
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
				ArrayList<String> selectedFiles = new ArrayList<String>();
				for (int i = 0; i < fileList.getModel().getSize(); i++) {
					selectedFiles.add(fileList.getModel().getElementAt(i));
				}
				engine.setSelectedFiles(selectedFiles);
				
				if(rdbtnRank.isSelected()){
					String[] args = {(String)cbboxRank.getSelectedItem()};
					engine.setArgs(args);
				}
				
				engine.compute();
			}
		});

		computePanel.add(btnCompute);
		panel_2.add(computePanel);

		ButtonGroup filtersGroup = new ButtonGroup();
		filtersGroup.add(rdbtnCanny);
		filtersGroup.add(rdbtnBox);
		filtersGroup.add(rdbtnGaussian);
		filtersGroup.add(rdbtnGaussianNoise);
		filtersGroup.add(rdbtnImpulseNoise);
		filtersGroup.add(rdbtnIsotropic);
		filtersGroup.add(rdbtnNagaomatsuyama);
		filtersGroup.add(rdbtnPrewitt);
		filtersGroup.add(rdbtnRank);
		filtersGroup.add(rdbtnSaltandpepperNoise);
		filtersGroup.add(rdbtnSharpening);
		filtersGroup.add(rdbtnSobel);
		filtersGroup.add(rdbtnThreenines);
		filtersGroup.add(rdbtnUniformNoise);
		filtersGroup.add(rdbtnDoG);
		filtersGroup.add(rdbtnRoberts);

		rdbtnSobel.addActionListener(this);
		rdbtnBox.addActionListener(this);
		rdbtnSharpening.addActionListener(this);
		rdbtnPrewitt.addActionListener(this);
		rdbtnCanny.addActionListener(this);
		rdbtnGaussian.addActionListener(this);
		rdbtnGaussianNoise.addActionListener(this);
		rdbtnImpulseNoise.addActionListener(this);
		rdbtnIsotropic.addActionListener(this);
		rdbtnNagaomatsuyama.addActionListener(this);
		rdbtnRank.addActionListener(this);
		rdbtnSaltandpepperNoise.addActionListener(this);
		rdbtnThreenines.addActionListener(this);
		rdbtnUniformNoise.addActionListener(this);
		rdbtnDoG.addActionListener(this);
		rdbtnRoberts.addActionListener(this);

		rdbtnSobel.setActionCommand("Sobel");
		rdbtnBox.setActionCommand("Box");
		rdbtnSharpening.setActionCommand("Sharpening");
		rdbtnPrewitt.setActionCommand("Prewitt");
		rdbtnCanny.setActionCommand("Canny");
		rdbtnGaussian.setActionCommand("Gaussian");
		rdbtnGaussianNoise.setActionCommand("GaussNoise");
		rdbtnImpulseNoise.setActionCommand("ImpulseNoise");
		rdbtnIsotropic.setActionCommand("Isotropic");

		rdbtnNagaomatsuyama.setActionCommand("Nagao");
		rdbtnRank.setActionCommand("Rank");
		rdbtnSaltandpepperNoise.setActionCommand("SaltPepperNoise");
		rdbtnThreenines.setActionCommand("ThreeNine");
		rdbtnUniformNoise.setActionCommand("UniformNoise");
		rdbtnDoG.setActionCommand("DoG");
		rdbtnRoberts.setActionCommand("Roberts");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		engine.setAlgorithmByName(e.getActionCommand());
	}
}
