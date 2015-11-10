package user_interface;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;

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

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
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
		setSize(new Dimension(1000,300));
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(1,3));

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
		
		JPanel pnlDoG = new JPanel();
		pnlDoG.setLayout(new GridLayout(1, 3));
		JRadioButton rdbtnDoG = new JRadioButton("DoG");
		JTextField txtDoGvar1 = new JTextField();
		JTextField txtDoGvar2 = new JTextField();
		pnlDoG.add(rdbtnDoG);
		pnlDoG.add(txtDoGvar1);
		pnlDoG.add(txtDoGvar2);
		panel_1.add(pnlDoG);
		
		JRadioButton rdbtnRoberts = new JRadioButton("Roberts");
		panel_1.add(rdbtnRoberts);

		JRadioButton rdbtnIsotropic = new JRadioButton("Isotropic");
		panel_1.add(rdbtnIsotropic);

		JRadioButton rdbtnCanny = new JRadioButton("Canny");
		panel_1.add(rdbtnCanny);
		
		final JRadioButton rdbtnRank = new JRadioButton("Rank");
		String[] rankNumbers = {"1", "3", "5", "7", "9"};
		final JComboBox<String> cbboxRank = new JComboBox<String>(rankNumbers);
		cbboxRank.setSelectedIndex(0);
		JPanel pnlRank = new JPanel();
		pnlRank.setLayout(new GridLayout(1, 2));
		pnlRank.add(rdbtnRank);
		pnlRank.add(cbboxRank);
		panel_1.add(pnlRank);

		JRadioButton rdbtnNagaomatsuyama = new JRadioButton("Nagao-Matsuyama");
		panel_1.add(rdbtnNagaomatsuyama);

		JRadioButton rdbtnSAPnoise = new JRadioButton(
				"SAP noise");
		JPanel pnlSAPnoise = new JPanel();
		pnlSAPnoise.setLayout(new GridLayout(1, 2));
		JTextField txtSAPdns = new JTextField();
		pnlSAPnoise.add(rdbtnSAPnoise);
		pnlSAPnoise.add(txtSAPdns);
		panel_1.add(pnlSAPnoise);

		JRadioButton rdbtnGaussianNoise = new JRadioButton("Gauss noise");
		JPanel pnlGausNoise = new JPanel();
		pnlGausNoise.setLayout(new GridLayout(1, 3));
		JTextField txtGausAvg = new JTextField();
		JTextField txtGausVar = new JTextField();
		pnlGausNoise.add(rdbtnGaussianNoise);
		pnlGausNoise.add(txtGausAvg);
		pnlGausNoise.add(txtGausVar);
		panel_1.add(pnlGausNoise);

		JRadioButton rdbtnUniformNoise = new JRadioButton("Uni noise");
		JPanel pnlUniNoise = new JPanel();
		pnlUniNoise.setLayout(new GridLayout(1, 2));
		JTextField txtUniK = new JTextField();
		pnlUniNoise.add(rdbtnUniformNoise);
		pnlUniNoise.add(txtUniK);
		panel_1.add(pnlUniNoise);


		JRadioButton rdbtnImpulseNoise = new JRadioButton("Imp noise");
		JPanel pnlImpNoise = new JPanel();
		pnlImpNoise.setLayout(new GridLayout(1, 2));
		JTextField txtImpDns = new JTextField();
		pnlImpNoise.add(rdbtnImpulseNoise);
		pnlImpNoise.add(txtImpDns);
		panel_1.add(pnlImpNoise);

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
				if(rdbtnDoG.isSelected()){
					String[] args = {txtDoGvar1.getText(), txtDoGvar2.getText()};
					engine.setArgs(args);
				}
				if(rdbtnSAPnoise.isSelected()){
					String[] args = {txtSAPdns.getText()};
					engine.setArgs(args);
				}
				if(rdbtnGaussianNoise.isSelected()){
					String[] args = {txtGausAvg.getText(), txtGausVar.getText()};
					engine.setArgs(args);
				}
				if(rdbtnUniformNoise.isSelected()){
					String[] args = {txtUniK.getText()};
					engine.setArgs(args);
				}
				if(rdbtnImpulseNoise.isSelected()){
					String[] args = {txtImpDns.getText()};
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
		filtersGroup.add(rdbtnSAPnoise);
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
		rdbtnSAPnoise.addActionListener(this);
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
		rdbtnSAPnoise.setActionCommand("SaltPepperNoise");
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
