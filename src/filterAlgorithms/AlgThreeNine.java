package filterAlgorithms;

import maths.FilterMaths;
import pgm_utilities.PGMImage;
import pgm_utilities.PGMUtilities;
import filterObjects.ThreeNine;

public class AlgThreeNine implements IAlgorithm {

	private ThreeNine filter = new ThreeNine();

	@Override
	public void computeImage(PGMImage image, String name) {

		PGMImage filteredImage = new PGMImage(image.getWidth(),image.getHeight(), image.getMax_val());
		
		int[] intArray = FilterMaths.mapping(filter.getFilteredImage(image));
				
		filteredImage.setPixels(intArray);
		PGMUtilities.writePGM(filteredImage, PGMUtilities.standardOutputPath
				+ name + "_3OVER9.pgm");
	}
}
