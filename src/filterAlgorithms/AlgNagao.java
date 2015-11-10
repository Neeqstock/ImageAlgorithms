package filterAlgorithms;

import filterObjects.NagaoMatsuyama;
import maths.FilterMaths;
import pgm_utilities.PGMImage;
import pgm_utilities.PGMUtilities;

/**
 * 
 * @see filterObjects.NagaoMatsuyama
 *
 */

public class AlgNagao implements IAlgorithm {

	private NagaoMatsuyama filter = new NagaoMatsuyama();
	
	@Override
	public void computeImage(PGMImage image, String name, String[] args) {
		double[] filteredArray = filter.getFilteredImage(image);
		int[] intArray = FilterMaths.mapping(filteredArray);

		PGMImage filteredImage = new PGMImage(image.getWidth(),
				image.getHeight(), image.getMax_val());
		filteredImage.setPixels(intArray);

		PGMUtilities.writePGM(filteredImage, PGMUtilities.standardOutputPath
				+ name + "_nagaomatsuyama.pgm");

	}
}
