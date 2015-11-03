package filterAlgorithms;

import pgm_utilities.PGMImage;
import pgm_utilities.PGMUtilities;
import filterObjects.Box;
import filterObjects.FilterMaths;

public class AlgBox implements IAlgorithm {
	
	private Box filter = new Box();
	
	@Override
	public void computeImage(PGMImage image, String name) {
		double[] filteredArray = filter.getFilteredImage(image);
		int[] intArray = FilterMaths.mapping(filteredArray);
		
		PGMImage filteredImage = new PGMImage(image.getWidth(), image.getHeight(), image.getMax_val());
		filteredImage.setPixels(intArray);
		
		PGMUtilities.writePGM(filteredImage, PGMUtilities.standardOutputPath + name + "_box.pgm");
		
	}

}
