package maths;

import java.util.ArrayList;

import filterObjects.NagaoMatsuyama;

public class FilterMaths {

	public static double[] totalConvolution2(double[] kernel, int[] img,
			int rows, int columns) {

		double[] convolutedDoubleImage = new double[img.length];

		for (int i = 0; i < rows - 1; i++) {
			for (int j = 0; j < columns - 1; j++) {
				double[] kernelledImage = new double[kernel.length];

				kernelledImage[0] = img[(i) * columns + (j)];
				kernelledImage[1] = img[(i) * columns + (j + 1)];
				kernelledImage[2] = img[(i + 1) * columns + (j)];
				kernelledImage[3] = img[(i + 1) * columns + (j + 1)];

				convolutedDoubleImage[i * columns + j] = convolution(kernel,
						kernelledImage);
			}
		}
		return convolutedDoubleImage;

	}

	public static double[] totalConvolution3(double[] kernel, int[] img,
			int rows, int columns) {

		double[] convolutedDoubleImage = new double[img.length];

		// -1, a causa del bordo
		for (int i = 1; i < rows - 1; i++) {
			for (int j = 1; j < columns - 1; j++) {

				double[] kernelledImage = new double[kernel.length];

				kernelledImage[0] = img[(i - 1) * columns + (j - 1)];
				kernelledImage[3] = img[(i - 1) * columns + (j)];
				kernelledImage[6] = img[(i - 1) * columns + (j + 1)];
				kernelledImage[1] = img[(i) * columns + (j - 1)];
				kernelledImage[4] = img[(i) * columns + (j)];
				kernelledImage[5] = img[(i) * columns + (j + 1)];
				kernelledImage[7] = img[(i + 1) * columns + (j - 1)];
				kernelledImage[5] = img[(i + 1) * columns + (j)];
				kernelledImage[8] = img[(i + 1) * columns + (j + 1)];

				convolutedDoubleImage[i * columns + j] = convolution(kernel,
						kernelledImage);
			}
		}

		return convolutedDoubleImage;
	}

	public static double[] totalConvolution5(double[] kernel, int[] img,
			int rows, int columns) {

		double[] convoluteImage = new double[img.length];

		for (int i = 2; i < rows - 2; i++) {
			for (int j = 2; j < columns - 2; j++) {

				double[] kernelledImage = new double[kernel.length];

				kernelledImage[0] = img[(i - 2) * columns + (j - 2)];
				kernelledImage[1] = img[(i - 2) * columns + (j - 1)];
				kernelledImage[2] = img[(i - 2) * columns + (j)];
				kernelledImage[3] = img[(i - 2) * columns + (j + 1)];
				kernelledImage[4] = img[(i - 2) * columns + (j + 2)];

				kernelledImage[5] = img[(i - 1) * columns + (j - 2)];
				kernelledImage[6] = img[(i - 1) * columns + (j - 1)];
				kernelledImage[7] = img[(i - 1) * columns + (j)];
				kernelledImage[8] = img[(i - 1) * columns + (j + 1)];
				kernelledImage[9] = img[(i - 1) * columns + (j + 2)];

				kernelledImage[10] = img[(i) * columns + (j - 2)];
				kernelledImage[11] = img[(i) * columns + (j - 1)];
				kernelledImage[12] = img[(i) * columns + (j)];
				kernelledImage[13] = img[(i) * columns + (j + 1)];
				kernelledImage[14] = img[(i) * columns + (j + 2)];

				kernelledImage[15] = img[(i + 1) * columns + (j - 2)];
				kernelledImage[16] = img[(i + 1) * columns + (j - 1)];
				kernelledImage[17] = img[(i + 1) * columns + (j)];
				kernelledImage[18] = img[(i + 1) * columns + (j + 1)];
				kernelledImage[19] = img[(i + 1) * columns + (j + 2)];

				kernelledImage[20] = img[(i + 2) * columns + (j - 2)];
				kernelledImage[21] = img[(i + 2) * columns + (j - 1)];
				kernelledImage[22] = img[(i + 2) * columns + (j)];
				kernelledImage[23] = img[(i + 2) * columns + (j + 1)];
				kernelledImage[24] = img[(i + 2) * columns + (j + 2)];

				convoluteImage[i * columns + j] = convolution(kernel,
						kernelledImage);
			}
		}
		return convoluteImage;
	}

	public static double[] totalNagao(int[] img, int rows, int columns) {

		double[] convoluteImage = new double[img.length];

		for (int i = 2; i < rows - 2; i++) {
			for (int j = 2; j < columns - 2; j++) {
				double[] kernelledImage = new double[25];

				kernelledImage[0] = img[(i - 2) * columns + (j - 2)];
				kernelledImage[1] = img[(i - 2) * columns + (j - 1)];
				kernelledImage[2] = img[(i - 2) * columns + (j)];
				kernelledImage[3] = img[(i - 2) * columns + (j + 1)];
				kernelledImage[4] = img[(i - 2) * columns + (j + 2)];

				kernelledImage[5] = img[(i - 1) * columns + (j - 2)];
				kernelledImage[6] = img[(i - 1) * columns + (j - 1)];
				kernelledImage[7] = img[(i - 1) * columns + (j)];
				kernelledImage[8] = img[(i - 1) * columns + (j + 1)];
				kernelledImage[9] = img[(i - 1) * columns + (j + 2)];

				kernelledImage[10] = img[(i) * columns + (j - 2)];
				kernelledImage[11] = img[(i) * columns + (j - 1)];
				kernelledImage[12] = img[(i) * columns + (j)];
				kernelledImage[13] = img[(i) * columns + (j + 1)];
				kernelledImage[14] = img[(i) * columns + (j + 2)];

				kernelledImage[15] = img[(i + 1) * columns + (j - 2)];
				kernelledImage[16] = img[(i + 1) * columns + (j - 1)];
				kernelledImage[17] = img[(i + 1) * columns + (j)];
				kernelledImage[18] = img[(i + 1) * columns + (j + 1)];
				kernelledImage[19] = img[(i + 1) * columns + (j + 2)];

				kernelledImage[20] = img[(i + 2) * columns + (j - 2)];
				kernelledImage[21] = img[(i + 2) * columns + (j - 1)];
				kernelledImage[22] = img[(i + 2) * columns + (j)];
				kernelledImage[23] = img[(i + 2) * columns + (j + 1)];
				kernelledImage[24] = img[(i + 2) * columns + (j + 2)];

				double var1C = getVarianceFromKernel(NagaoMatsuyama.kernelC,
						kernelledImage);
				double var2N = getVarianceFromKernel(NagaoMatsuyama.kernelN,
						kernelledImage);
				double var3W = getVarianceFromKernel(NagaoMatsuyama.kernelW,
						kernelledImage);
				double var4E = getVarianceFromKernel(NagaoMatsuyama.kernelE,
						kernelledImage);
				double var5S = getVarianceFromKernel(NagaoMatsuyama.kernelS,
						kernelledImage);
				double var6NW = getVarianceFromKernel(NagaoMatsuyama.kernelNW,
						kernelledImage);
				double var7SW = getVarianceFromKernel(NagaoMatsuyama.kernelSW,
						kernelledImage);
				double var8SE = getVarianceFromKernel(NagaoMatsuyama.kernelSE,
						kernelledImage);
				double var9SW = getVarianceFromKernel(NagaoMatsuyama.kernelSW,
						kernelledImage);

				ArrayList<Double> variances = new ArrayList<Double>();

				variances.add(var1C);
				variances.add(var2N);
				variances.add(var3W);
				variances.add(var4E);
				variances.add(var5S);
				variances.add(var6NW);
				variances.add(var7SW);
				variances.add(var8SE);
				variances.add(var9SW);

				int maxindex = 0;
				double maxvalue = variances.get(0);

				for (int k = 0; k < variances.size() - 1; k++) {
					if (variances.get(k) > maxvalue) {
						maxindex = k;
						maxvalue = variances.get(k);
					}
				}
				
				double[] neededKernel = new double[25];
				
				switch (maxindex) {
				case 0:
					neededKernel = NagaoMatsuyama.kernelC;
					break;
				case 1:
					neededKernel = NagaoMatsuyama.kernelN;
					break;
				case 2:
					neededKernel = NagaoMatsuyama.kernelW;
					break;
				case 3:
					neededKernel = NagaoMatsuyama.kernelS;
					break;
				case 4:
					neededKernel = NagaoMatsuyama.kernelW;
					break;
				case 5:
					neededKernel = NagaoMatsuyama.kernelNW;
					break;
				case 6:
					neededKernel = NagaoMatsuyama.kernelSW;
					break;
				case 7:
					neededKernel = NagaoMatsuyama.kernelSE;
					break;
				case 8:
					neededKernel = NagaoMatsuyama.kernelNE;
					break;
				default:
					neededKernel = NagaoMatsuyama.kernelC;
					break;
				}
				
				convoluteImage[i * columns + j] = convolution(neededKernel,
						kernelledImage);
			}
		}
		
		return convoluteImage;
	}

	private static double getVarianceFromKernel(double[] kernel,
			double[] kernelledImage) {

		double[] data = new double[25];
		for (int i = 0; i < data.length; i++) {
			data[i] = kernel[i] * kernelledImage[i];
		}
		double variance = Statistics.getVariance(data);
		return variance;
	}

	public static double[] getModule(double[] horPixels, double[] verPixels,
			int width, int heigth) {

		double[] doubleResult = new double[horPixels.length];

		for (int i = 0; i < horPixels.length; i++) {
			doubleResult[i] = Math.sqrt((double) (horPixels[i] * horPixels[i])
					+ (verPixels[i] * verPixels[i]));
		}

		return doubleResult;
	}

	public static double[] getPhase(double[] horPixels, double[] verPixels,
			int width, int heigth) {

		double[] doubleResult = new double[horPixels.length];

		for (int i = 0; i < horPixels.length; i++) {
			doubleResult[i] = Math.atan2(verPixels[i], horPixels[i]);
		}

		return doubleResult;
	}

	public static int[] mapping(double[] convoluted) {
		double max = convoluted[0];
		double min = convoluted[0];

		for (int i = 0; i < convoluted.length; i++) {
			if (convoluted[i] > max) {
				max = convoluted[i];
			}
			if (convoluted[i] < min) {
				min = convoluted[i];
			}
		}

		int[] output = new int[convoluted.length];
		double outputMax = 255;
		double outputMin = 0;

		for (int i = 0; i < output.length; i++) {
			double tmp = ((outputMax - outputMin) / (max - min))
					* (convoluted[i] - min);
			output[i] = (int) tmp;
		}
		return output;
	}

	private static double convolution(double[] kernel, double[] img) {

		// si suppone che vengano passati kernel e imagini di dimensioni giuste

		int r = img.length;

		double conv = 0;

		for (int i = 0; i < r; i++) {
			conv = conv + (kernel[i] * img[i]);
		}

		// si suppone quasi sempre vero if((rows>=3) & (columns >=3)){}
		return conv;
	}

	public static int[] castDoubleToIntArray(double[] inputArray) {
		int[] output = new int[inputArray.length];

		for (int i = 0; i < output.length; i++) {
			output[i] = (int) inputArray[i];
		}

		return output;
	}
	
}
