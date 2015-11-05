package filterObjects;

import maths.FilterMaths;
import pgm_utilities.PGMImage;

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
				double a = kernelledImage[0];
				double b = kernelledImage[0];
				for (int k = 1; k < kernelledImage.length; k++) {
					sum += kernelledImage[k];
					if (a > kernelledImage[k]) {
						a = kernelledImage[k];
					}
					if (b < kernelledImage[k]) {
						b = kernelledImage[k];
					}
				}
				double tau = a/b;
				double threshold = (1d - tau)/((2d*tau) + 1d);
				
				double[] conv = new double[8];
				conv[0] = convolution(kernelE, kernelledImage);
				conv[1] = convolution(kernelNE, kernelledImage);
				conv[2] = convolution(kernelN, kernelledImage);
				conv[3] = convolution(kernelNW, kernelledImage);
				conv[4] = convolution(kernelW, kernelledImage);
				conv[5] = convolution(kernelSW, kernelledImage);
				conv[6] = convolution(kernelS, kernelledImage);
				conv[7] = convolution(kernelSE, kernelledImage);

				double[] result = new double[8];
				result[0] = conv[7] + conv[0] + conv[1];
				result[1] = conv[0] + conv[1] + conv[2];
				result[2] = conv[1] + conv[2] + conv[3];
				result[3] = conv[2] + conv[3] + conv[4];
				result[4] = conv[3] + conv[4] + conv[5];
				result[5] = conv[4] + conv[5] + conv[6];
				result[6] = conv[5] + conv[6] + conv[7];
				result[7] = conv[6] + conv[7] + conv[0];

				double max = result[0];
				for (int k = 1; k < result.length; k++) {
					if (max < result[k]) {
						max = result[k];
					}
				}
				
				double p = (1.5) * ((max / sum) - 0.333);
			//	System.out.println(p + "       " + threshold);
				if (p < threshold) {
					p = 0;
				}
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
