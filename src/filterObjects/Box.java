package filterObjects;

import pgm_utilities.PGMImage;

public class Box extends AFilter {
	
	public Box() {
		kernel = new double[9];
		kernel[0] = ((double)1)/9;
		kernel[1] = ((double)1)/9;
		kernel[2] = ((double)1)/9;
		kernel[3] = ((double)1)/9;
		kernel[4] = ((double)1)/9;
		kernel[5] = ((double)1)/9;
		kernel[6] = ((double)1)/9;
		kernel[7] = ((double)1)/9;
		kernel[8] = ((double)1)/9;
	}

	@Override
	public double[] getFilteredImage(PGMImage image) {
		int[] pixelArray = image.getPixels();
		double[] filteredArray = super.computeFilter3(pixelArray, image.getHeight(), image.getWidth());
		System.out.println("kernel value: " + kernel[0]);
		return filteredArray;
	}
	
	
}