package filterObjects;

import pgm_utilities.PGMImage;

public class NagaoMatsuyama extends AFilter {
	
	public static final double[] kernelC = {0,0,0,0,0,0,1,1,1,0,0,1,1,1,0,0,1,1,1,0,0,0,0,0,0};
	public static final double[] kernelN = {0,1,1,1,0,0,1,1,1,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0};
	public static final double[] kernelE = {0,0,0,0,0,0,0,0,1,1,0,0,1,1,1,0,0,0,1,1,0,0,0,0,0};
	public static final double[] kernelS = {0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,1,1,1,0,0,1,1,1,0};
	public static final double[] kernelW = {0,0,0,0,0,1,1,0,0,0,1,1,1,0,0,1,1,0,0,0,0,0,0,0,0};
	public static final double[] kernelNE = {0,0,0,1,1,0,0,1,1,1,0,0,1,1,0,0,0,0,0,0,0,0,0,0,0};
	public static final double[] kernelSE = {0,0,0,0,0,0,0,0,0,0,0,0,1,1,0,0,0,1,1,1,0,0,0,1,1};
	public static final double[] kernelSW = {0,0,0,0,0,0,0,0,0,0,0,1,1,0,0,1,1,1,0,0,1,1,0,0,0};
	public static final double[] kernelNW = {1,1,0,0,0,1,1,1,0,0,0,1,1,0,0,0,0,0,0,0,0,0,0,0,0};
	
	public NagaoMatsuyama() {
		kernel = new double[25];
	}

	@Override
	public double[] getFilteredImage(PGMImage image) {
		int[] pixelArray = image.getPixels();
		double[] filteredArray = super.computeNagao(pixelArray, image.getHeight(), image.getWidth());
		return filteredArray;
	}
	
	
}
