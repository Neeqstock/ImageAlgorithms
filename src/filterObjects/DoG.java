package filterObjects;

import maths.FilterMaths;
import maths.GaussianFunction;
import pgm_utilities.PGMImage;

public class DoG extends AFilter {

	public static final int defaultVarianceMAX = 2;
	public static final int defaultVarianceMIN = 1;

	private int minVariance;
	private int maxVariance;
	
	private double[][] differenceKernel;

	public DoG(int minVariance, int maxVariance) {
		// DEFAULT VALUES
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

		this.minVariance = minVariance;
		this.maxVariance = maxVariance;

	}

	public void setDefaultMinVariance() {
		minVariance = defaultVarianceMIN;
	}

	public void setDefaultMaxVariance() {
		maxVariance = defaultVarianceMAX;
	}

	public void generateKernel() {
		int kernelDimension = (int) maxVariance * 6;
		int whaaat = kernelDimension % 2;
		if (whaaat == 0) {
			kernelDimension++;
		}

		double[][] matKernel = new double[kernelDimension][kernelDimension];
		int kernelCenter = (kernelDimension - 1) / 2;

		double[][] minKernel = fillKernel(matKernel, kernelCenter,
				kernelDimension, minVariance);
		double[][] maxKernel = fillKernel(matKernel, kernelCenter,
				kernelDimension, maxVariance);
		
		differenceKernel = getDifferenceKernel(minKernel, maxKernel);
	}

	private double[][] getDifferenceKernel(double[][] minKernel,
			double[][] maxKernel) {
		
		double[][] result = new double[minKernel.length][minKernel.length];
		
		for (int i = 0; i < maxKernel.length; i++) {
			for (int j = 0; j < maxKernel.length; j++) {
				result[i][j] = maxKernel[i][j] - minKernel[i][j];
			}
		}
		return result;
	}

	private double[][] fillKernel(double[][] matKernel, int center,
			int kernelDimension, int variance) {
		
		double[][] resultKernel = new double[kernelDimension][kernelDimension];
		
		// The graph's base
		int[] abscissa = getAbscissaVector(kernelDimension);
		
		for (int rowFlag = 0; rowFlag < kernelDimension - 1; rowFlag++) {
			for (int colFlag = 0; colFlag < kernelDimension - 1; colFlag++) {
				resultKernel[rowFlag][colFlag] = GaussianFunction.phi3d(abscissa[rowFlag], abscissa[colFlag], variance);
			}
		}

		matKernel[center][center] = GaussianFunction.phi(center, 0, variance);

		return resultKernel;
	}

	private int[] getAbscissaVector(int kernelDimension) {
		int[] abscissa = new int[kernelDimension];
		int startingZero = -((kernelDimension - 1) / 2);
		System.out.println("startingZero: " + startingZero
				+ " on a kernelDimension: " + kernelDimension);
		abscissa[0] = startingZero;
		for (int i = 1; i < kernelDimension - 1; i++) {
			abscissa[i] = abscissa[i - 1] + 1;
		}
		
		return abscissa;
	}

	@Override
	public double[] getFilteredImage(PGMImage image) {
		
		generateKernel();
		
		int[][] imageMatrix = FilterMaths.arrayToMatrix(image.getPixels(), image.getWidth(), image.getHeight());
		double[][] resultDoublePixels = FilterMaths.genericTotalConvolution(differenceKernel, imageMatrix, image.getWidth(), image.getHeight());
		
		double[] resultPixels = FilterMaths.
				matrixToVector(resultDoublePixels, image.getWidth(), image.getHeight());
		return resultPixels;
	}
}
