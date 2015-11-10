package filterAlgorithms;

import filterObjects.ThreeNine;
import maths.FilterMaths;
import pgm_utilities.PGMImage;
import pgm_utilities.PGMUtilities;

public class AlgThreeNine implements IAlgorithm {
	private ThreeNine filter = new ThreeNine();
	@Override
	public void computeImage(PGMImage image, String name, String[] args) {
		double[] filteredArray = filter.getFilteredImage(image);
		int[] intArray = FilterMaths.mapping(filteredArray);

		PGMImage filteredImage = new PGMImage(image.getWidth(),
				image.getHeight(), image.getMax_val());
		filteredImage.setPixels(intArray);

		PGMUtilities.writePGM(filteredImage, PGMUtilities.standardOutputPath
				+ name + "_threenines.pgm");

	}
}
