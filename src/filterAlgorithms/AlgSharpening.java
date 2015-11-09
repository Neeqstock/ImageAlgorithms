package filterAlgorithms;

import maths.FilterMaths;
import pgm_utilities.PGMImage;
import pgm_utilities.PGMUtilities;
import filterObjects.Box;
import filterObjects.Sharpening;

public class AlgSharpening implements IAlgorithm {
	
	private Sharpening filter = new Sharpening();
	
	@Override
	public void computeImage(PGMImage image, String name, String[] args) {
		double[] filteredArray = filter.getFilteredImage(image);
		
		Box boxFilter = new Box();
		double[] boxedArray = boxFilter.getFilteredImage(image);
		
		for (int i = 0; i < filteredArray.length; i++) {
			filteredArray[i] -= boxedArray[i];
		}
		
		int[] intArray = FilterMaths.mapping(filteredArray);
		PGMImage filteredImage = new PGMImage(image.getWidth(), image.getHeight(), image.getMax_val());
		filteredImage.setPixels(intArray);
		PGMUtilities.writePGM(filteredImage, PGMUtilities.standardOutputPath + name + "_sharpening.pgm");
		
	}

}
