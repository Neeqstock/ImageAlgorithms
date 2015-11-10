package filterObjects;

import pgm_utilities.PGMImage;

/**
 * applies a 3/9 operator filter.
 * each pixel is computed using the formula p = (3/2) * ((max / sum) - 1/3), 
 * where sum is the sum of the values of the 3X3 image kernel, and max is the maximum
 * among the 8 considered kernels.
 * 
 */
public class ThreeNine extends AFilter {

	public ThreeNine() {
		kernel = new double[9];
	}

	public static final double[] kernelN = { 1, 1, 1, 0, 0, 0, 0, 0, 0 };
	public static final double[] kernelE = { 0, 0, 1, 0, 0, 1, 0, 0, 1 };
	public static final double[] kernelS = { 0, 0, 0, 0, 0, 0, 1, 1, 1 };
	public static final double[] kernelW = { 1, 0, 0, 1, 0, 0, 1, 0, 0 };
	public static final double[] kernelNE = { 0, 1, 1, 0, 0, 1, 0, 0, 0 };
	public static final double[] kernelSE = { 0, 0, 0, 0, 0, 1, 0, 1, 1 };
	public static final double[] kernelSW = { 0, 0, 0, 1, 0, 0, 1, 1, 0 };
	public static final double[] kernelNW = { 1, 1, 0, 1, 0, 0, 0, 0, 0 };

	@Override
	public double[] getFilteredImage(PGMImage image) {
		int[] pixelArray = image.getPixels();
		int rows = image.getHeight();
		int columns = image.getWidth();
		double[] filteredArray = new double[image.getHeight()
				* image.getWidth()];
		
		double[] kernelledImage = new double[9];
		for (int i = 1; i < rows - 1; i++) {
			for (int j = 1; j < columns - 1; j++) {

				kernelledImage[0] = pixelArray[(i - 1) * columns + (j - 1)];
				kernelledImage[1] = pixelArray[(i - 1) * columns + (j)];
				kernelledImage[2] = pixelArray[(i - 1) * columns + (j + 1)];
				kernelledImage[3] = pixelArray[(i) * columns + (j - 1)];
				kernelledImage[4] = pixelArray[(i) * columns + (j)];
				kernelledImage[5] = pixelArray[(i) * columns + (j + 1)];
				kernelledImage[6] = pixelArray[(i + 1) * columns + (j - 1)];
				kernelledImage[7] = pixelArray[(i + 1) * columns + (j)];
				kernelledImage[8] = pixelArray[(i + 1) * columns + (j + 1)];

				double sum = 0;
				for (int k = 0; k < kernelledImage.length; k++) {
					sum = sum + kernelledImage[k];
				}
			
				double[] conv = new double[8];
				conv[0] = convolution(kernelE, kernelledImage);
				conv[1] = convolution(kernelNE, kernelledImage);
				conv[2] = convolution(kernelN, kernelledImage);
				conv[3] = convolution(kernelNW, kernelledImage);
				conv[4] = convolution(kernelW, kernelledImage);
				conv[5] = convolution(kernelSW, kernelledImage);
				conv[6] = convolution(kernelS, kernelledImage);
				conv[7] = convolution(kernelSE, kernelledImage);

				double max = conv[0];
				int index = 0;
				for (int k = 1; k < conv.length; k++) {
					if (max < conv[k]) {
						max = conv[k];
						index = k;
					}
				}
			
				
				double a = (sum-conv[index])/6d;
				double b = conv[index]/3d;
				double tau = a/b;
				double threshold = (1d - tau)/((2d*tau) + 1d);
				
				double oneoverthree = 1d/3d;
				
				double p = (1.5d) * ((max / sum) - oneoverthree);
				if (sum == 0) {
					p = 0;
				}
		//		if (p < threshold) {
		//			p = 0;
		//		}
				filteredArray[i * columns + j] = p;
			}
		}
		return filteredArray;
	}

	private double convolution(double[] kernel, double[] img) {
		double conv = 0;

		for (int i = 0; i < img.length; i++) {
			conv = conv + (kernel[i] * img[i]);
		}
		return conv;
	}

}
