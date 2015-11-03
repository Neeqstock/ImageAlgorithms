package filterObjects;

import pgm_utilities.PGMImage;

public class SobelHorizontal extends AFilter {
	
	public SobelHorizontal() {
		kernel = new double[9];
		kernel[0] = -1;
		kernel[1] = 0;
		kernel[2] = 1;
		kernel[3] = -2;
		kernel[4] = 0;
		kernel[5] = 2;
		kernel[6] = -1;
		kernel[7] = 0;
		kernel[8] = 1;
	}

	@Override
	public double[] getFilteredImage(PGMImage image) {
		int[] pixelArray = image.getPixels();
		double[] filteredArray = super.computeFilter3(pixelArray, image.getHeight(), image.getWidth());
		
		return filteredArray;
	}
	
	
}
