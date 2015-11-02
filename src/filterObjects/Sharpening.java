package filterObjects;

import pgm_utilities.PGMImage;

public class Sharpening extends AFilter {
	
	public Sharpening() {
		kernel = new double[9];
		kernel[0] = 0;
		kernel[1] = 0;
		kernel[2] = 0;
		kernel[3] = 0;
		kernel[4] = 2;
		kernel[5] = 0;
		kernel[6] = 0;
		kernel[7] = 0;
		kernel[8] = 0;
	}

	@Override
	public double[] getFilteredImage(PGMImage image) {
		int[] pixelArray = image.getPixels();
		double[] filteredArray = super.computeFilter3(pixelArray, image.getHeight(), image.getWidth());
		
		return filteredArray;
	}
	
	
}
