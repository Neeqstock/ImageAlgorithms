package filterObjects;

import pgm_utilities.PGMImage;

public class PrewittHorizontal extends AFilter {
	
	public PrewittHorizontal() {
		kernel = new double[9];
		kernel[0] = -1;
		kernel[1] = 0;
		kernel[2] = 1;
		kernel[3] = -1;
		kernel[4] = 0;
		kernel[5] = 1;
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
