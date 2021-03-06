package filterObjects;

import pgm_utilities.PGMImage;

/**
 * vertical kernel for the isotropic (edge detection) filter
 *
 */
public class SobelVertical extends AFilter {
	
	public SobelVertical() {
		kernel = new double[9];
		kernel[0] = -1;
		kernel[1] = -2;
		kernel[2] = -1;
		kernel[3] = 0;
		kernel[4] = 0;
		kernel[5] = 0;
		kernel[6] = 1;
		kernel[7] = 2;
		kernel[8] = 1;
	}

	@Override
	public double[] getFilteredImage(PGMImage image) {
		int[] pixelArray = image.getPixels();
		double[] filteredArray = super.computeFilter3(pixelArray, image.getHeight(), image.getWidth());
		
		return filteredArray;
	}
	
}
