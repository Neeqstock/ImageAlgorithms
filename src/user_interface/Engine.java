package user_interface;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import pgm_utilities.PGMImage;
import pgm_utilities.PGMUtilities;
import filterAlgorithms.AlgBox;
import filterAlgorithms.AlgCanny;
import filterAlgorithms.AlgDoG;
import filterAlgorithms.AlgGaussNoise;
import filterAlgorithms.AlgGaussian;
import filterAlgorithms.AlgImpulseNoise;
import filterAlgorithms.AlgIsotropic;
import filterAlgorithms.AlgNagao;
import filterAlgorithms.AlgPrewitt;
import filterAlgorithms.AlgRank;
import filterAlgorithms.AlgRoberts;
import filterAlgorithms.AlgSaltPepperNoise;
import filterAlgorithms.AlgSharpening;
import filterAlgorithms.AlgSobel;
import filterAlgorithms.AlgThreeNine;
import filterAlgorithms.AlgUniformNoise;
import filterAlgorithms.IAlgorithm;

public class Engine {

	private IAlgorithm selectedAlgorithm = new AlgSobel(); // XXX DEFAULT
	private ArrayList<String> selectedFiles = new ArrayList<String>();
	private String[] args;
	
	public Engine() {

	}

	public void setSelectedAlgorithm(IAlgorithm selectedAlgorithm) {
		this.selectedAlgorithm = selectedAlgorithm;
	}

	public void setAlgorithmByName(String name) {
		switch (name) {
		case "Sobel":
			selectedAlgorithm = new AlgSobel();
			break;
		case "Box":
			selectedAlgorithm = new AlgBox();
			break;
		case "Sharpening":
			selectedAlgorithm = new AlgSharpening();
			break;
		case "Prewitt":
			selectedAlgorithm = new AlgPrewitt();
			break;
		case "Canny":
			selectedAlgorithm = new AlgCanny();
			break;
		case "Gaussian":
			selectedAlgorithm = new AlgGaussian();
			break;
		case "Isotropic":
			selectedAlgorithm = new AlgIsotropic();
			break;			
		case "GaussNoise":
			selectedAlgorithm = new AlgGaussNoise();
			break;		
		case "ImpulseNoise":
			selectedAlgorithm = new AlgImpulseNoise();
			break;			
		case "Nagao":
			selectedAlgorithm = new AlgNagao();
			break;	
		case "Rank":
			selectedAlgorithm = new AlgRank();
			break;	
		case "SaltPepperNoise":
			selectedAlgorithm = new AlgSaltPepperNoise();
			break;
		case "ThreeNine":
			selectedAlgorithm = new AlgThreeNine();
			break;
		case "UniformNoise":
			selectedAlgorithm = new AlgUniformNoise();
			break;
		case "DoG":
			selectedAlgorithm = new AlgDoG();
			break;
		case "Roberts":
			selectedAlgorithm = new AlgRoberts();
			break;
		}
	}

	public void setSelectedFiles(ArrayList<String> selectedFiles) {
		this.selectedFiles = selectedFiles;
	}
	
	public void setArgs(String[] args){
		this.args = args;
	}

	public void compute() {
		ArrayList<PGMImage> images = new ArrayList<PGMImage>();

		for (int i = 0; i < selectedFiles.size(); i++) {
			images.add(PGMUtilities.readPGM(selectedFiles.get(i)));
		}

		for (int i = 0; i < selectedFiles.size(); i++) {
			try {
				selectedAlgorithm.computeImage(images.get(i), getNameToken(selectedFiles.get(i)), args);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	private String getNameToken(String filepath) {
		// StringTokenizer tokenizer = new StringTokenizer()
		File file = new File(filepath);
		String gesu = file.getName();
		gesu = gesu.replaceAll(".pgm", " ");
		return gesu;
	}

}
