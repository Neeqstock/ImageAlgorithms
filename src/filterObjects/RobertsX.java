package filterObjects;

import pgm_utilities.PGMImage;

public class RobertsX extends AFilter {
	
	public RobertsX() {
		kernel = new double[4];
		kernel[0] = 1;
		kernel[1] = 0;
		kernel[2] = 0;
		kernel[3] = -1;
	}

	@Override
	public double[] getFilteredImage(PGMImage image) {
		int[] pixelArray = image.getPixels();
		double[] filteredArray = super.computeFilter2(pixelArray, image.getHeight(), image.getWidth());
		
		return filteredArray;
	}
	
	
}
