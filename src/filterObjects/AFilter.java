package filterObjects;

import pgm_utilities.PGMImage;

public abstract class AFilter {

	protected double[] kernel;

	public double[] getKernel() {
		return kernel;
	}

	protected double[] computeFilter2(int[] image, int rows, int columns){
		double[] convoluted = FilterMaths.totalConvolution2(kernel, image,
				rows, columns);
		return convoluted;
	}
	
	protected double[] computeFilter3(int[] image, int rows, int columns) {
		double[] convoluted = FilterMaths.totalConvolution3(kernel, image,
				rows, columns);
		return convoluted;
	}

	protected double[] computeFilter5(int[] image, int rows, int columns){
		double[] convoluted = FilterMaths.totalConvolution5(kernel, image,
				rows, columns);
		return convoluted;
	}

	public abstract double[] getFilteredImage(PGMImage image);

}
