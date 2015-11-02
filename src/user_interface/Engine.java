package user_interface;

import java.io.File;
import java.util.ArrayList;

import pgm_utilities.PGMImage;
import pgm_utilities.PGMUtilities;
import filterAlgorithms.AlgBox;
import filterAlgorithms.AlgPrewitt;
import filterAlgorithms.AlgSharpening;
import filterAlgorithms.AlgSobel;
import filterAlgorithms.IAlgorithm;

public class Engine {

	private IAlgorithm selectedAlgorithm = new AlgSobel(); // XXX DEFAULT
	private ArrayList<String> selectedFiles = new ArrayList<String>();

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
		default:
			break;
		}
	}

	public void setSelectedFiles(ArrayList<String> selectedFiles) {
		this.selectedFiles = selectedFiles;
	}

	public void compute() {
		ArrayList<PGMImage> images = new ArrayList<PGMImage>();

		for (int i = 0; i < selectedFiles.size(); i++) {
			images.add(PGMUtilities.readPGM(selectedFiles.get(i)));
		}

		for (int i = 0; i < selectedFiles.size(); i++) {
			selectedAlgorithm.computeImage(images.get(i),
					getNameToken(selectedFiles.get(i)));
		}

	}

	private String getNameToken(String filepath) {
		// StringTokenizer tokenizer = new StringTokenizer()
		File file = new File(filepath);
		String gesu = file.getName();
		gesu.replaceAll(".pgm", "");
		return gesu;
	}

}
