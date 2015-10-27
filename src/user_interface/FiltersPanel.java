package user_interface;

import java.awt.GridLayout;

import javax.swing.ButtonGroup;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class FiltersPanel extends JPanel {
	
	private JRadioButton box = new JRadioButton("Box");
	private JRadioButton prewitt = new JRadioButton("Prewitt");
	private JRadioButton sobel = new JRadioButton("Sobel");
	private JRadioButton gaussian = new JRadioButton("Gaussian");
	private JRadioButton threenines = new JRadioButton("3/9");
	private JRadioButton sharpening = new JRadioButton("Sharpening");
	private JRadioButton normalization = new JRadioButton("Normalization");
	private JRadioButton equalization = new JRadioButton("Equalization");
	private JRadioButton roberts = new JRadioButton("Roberts");
	private JRadioButton isotropic = new JRadioButton("Isotropic");
	private JRadioButton dog = new JRadioButton("DoG");
	private JRadioButton canny = new JRadioButton("Canny");
	private JRadioButton median = new JRadioButton("Median");
	private JRadioButton rank = new JRadioButton("Rank");
	private JRadioButton nagao = new JRadioButton("Nagao");
	
	private JRadioButton saltandpeppernoise = new JRadioButton("Salt and pepper noise");
	private JRadioButton gaussiannoise = new JRadioButton("Gaussian noise");
	private JRadioButton impulsenoise = new JRadioButton("Impulse noise");
	private JRadioButton uniformnoise = new JRadioButton("Uniform noise");
	
	private ButtonGroup filters = new ButtonGroup();
	
	
	
	
	
	public FiltersPanel() {
		super();
		setLayout(new GridLayout(10, 2));
		
		filters.add(box);
		filters.add(prewitt);
		filters.add(sobel);
		filters.add(gaussian);
		filters.add(threenines);
		filters.add(sharpening);
		filters.add(normalization);
		filters.add(equalization);
		filters.add(roberts);
		filters.add(isotropic);
		filters.add(dog);
		filters.add(canny);
		filters.add(median);
		filters.add(rank);
		filters.add(nagao);
		filters.add(saltandpeppernoise);
		filters.add(gaussiannoise);
		filters.add(impulsenoise);
		filters.add(uniformnoise);
		
		add(box);
		add(prewitt);
		add(sobel);
		add(gaussian);
		add(threenines);
		add(sharpening);
		add(normalization);
		add(equalization);
		add(roberts);
		add(isotropic);
		add(dog);
		add(canny);
		add(median);
		add(rank);
		add(nagao);
		add(saltandpeppernoise);
		add(gaussiannoise);
		add(impulsenoise);
		add(uniformnoise);

		
		
	}

}
