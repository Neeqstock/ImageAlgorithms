package filterObjects;

import pgm_utilities.PGMImage;
/**
 * A kernel with all 1s in it. It's useful for the DoG filter's application.
 * @author Nicola, Tomas
 *
 */
public class UnitaryKernel extends AFilter {
	
	public UnitaryKernel() {
		kernel = new double[9];
		kernel[0] = 1;
		kernel[1] = 1;
		kernel[2] = 1;
		kernel[3] = 1;
		kernel[4] = 1;
		kernel[5] = 1;
		kernel[6] = 1;
		kernel[7] = 1;
		kernel[8] = 1;
	}

	@Override
	public double[] getFilteredImage(PGMImage image) {
		int[] pixelArray = image.getPixels();
		double[] filteredArray = super.computeFilter3(pixelArray, image.getHeight(), image.getWidth());
		
		return filteredArray;
	}
	
	
}
