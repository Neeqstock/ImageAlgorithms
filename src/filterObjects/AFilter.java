package filterObjects;

import maths.FilterMaths;
import pgm_utilities.PGMImage;
/**
 * An abstract filter object. A filter has a kernel, and a function to get the filtered image.
 * All the other functions are common to many filters.
 * @author Nicola, Tomas
 *
 */
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
	
	protected double[] computeNagao(int[] image, int rows, int columns){
		double[] convoluted = FilterMaths.totalNagao(image,
				rows, columns);
		return convoluted;
	}
	
	protected double[] computeRank(int[] image, int rows, int columns, int rankDimension){
		double[] ranked = FilterMaths.rank(image, rows, columns,
				rankDimension);
		return ranked;
	}

	public abstract double[] getFilteredImage(PGMImage image);

}
