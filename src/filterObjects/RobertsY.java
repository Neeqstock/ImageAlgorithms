package filterObjects;

import pgm_utilities.PGMImage;

/**
 * vertical kernel for the roberts (edge detection) filter
 *
 */
public class RobertsY extends AFilter {
	
	public RobertsY() {
		kernel = new double[4];
		kernel[0] = 0;
		kernel[1] = 1;
		kernel[2] = -1;
		kernel[3] = 0;
	}

	@Override
	public double[] getFilteredImage(PGMImage image) {
		int[] pixelArray = image.getPixels();
		double[] filteredArray = super.computeFilter2(pixelArray, image.getHeight(), image.getWidth());
		
		return filteredArray;
	}
	
	
}
