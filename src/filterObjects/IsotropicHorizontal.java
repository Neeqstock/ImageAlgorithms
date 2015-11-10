package filterObjects;

import pgm_utilities.PGMImage;

/**
 * horizontal kernel for the isotropic (edge detection) filter
 * 
 */

public class IsotropicHorizontal extends AFilter {
	
	public IsotropicHorizontal() {
		kernel = new double[9];
		kernel[0] = -1;
		kernel[0] = 0;
		kernel[0] = 1;
		kernel[0] = -Math.sqrt(2);
		kernel[0] = 0;
		kernel[0] = Math.sqrt(2);
		kernel[0] = -1;
		kernel[0] = 0;
		kernel[0] = 1;
	}

	@Override
	public double[] getFilteredImage(PGMImage image) {
		int[] pixelArray = image.getPixels();
		double[] filteredArray = super.computeFilter3(pixelArray, image.getHeight(), image.getWidth());
		
		return filteredArray;
	}
	
	
}
