package filterObjects;

import pgm_utilities.PGMImage;

public class IsotropicVertical extends AFilter {
	
	public IsotropicVertical() {
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
