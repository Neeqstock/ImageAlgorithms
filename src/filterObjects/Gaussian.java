package filterObjects;

import pgm_utilities.PGMImage;

/**
 * applies a Gaussian filter on the image using a 5X5 kernel.
 * The result is a smoothed image
 * mean and variance are given
 *
 */

public class Gaussian extends AFilter {
	
	public Gaussian() {
		kernel = new double[25];
		kernel[0] = 0.003;
		kernel[1] = 0.013;
		kernel[2] = 0.022;
		kernel[3] = 0.013;
		kernel[4] = 0.003;
		kernel[5] = 0.013;
		kernel[6] = 0.059;
		kernel[7] = 0.097;
		kernel[8] = 0.059;
		kernel[9] = 0.013;
		kernel[10] = 0.022;
		kernel[11] = 0.097;
		kernel[12] = 0.159;
		kernel[13] = 0.097;
		kernel[14] = 0.022;
		kernel[15] = 0.013;
		kernel[16] = 0.059;
		kernel[17] = 0.097;
		kernel[18] = 0.059;
		kernel[19] = 0.013;
		kernel[20] = 0.003;
		kernel[21] = 0.013;
		kernel[22] = 0.022;
		kernel[23] = 0.013;
		kernel[24] = 0.003;
	}

	@Override
	public double[] getFilteredImage(PGMImage image) {
		int[] pixelArray = image.getPixels();
		double[] filteredArray = super.computeFilter5(pixelArray, image.getHeight(), image.getWidth());
		System.out.println("kernel value: " + kernel[0]);
		return filteredArray;
	}
	
	
}
