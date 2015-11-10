package filterObjects;

import pgm_utilities.PGMImage;

/**
 * this filter can be a median, rank 3, rank 5, rank 7 or rank 9, depending on the users' choice.
 * it takes the median (or average median) of the image kernel.  
 *
 */
public class Rank extends AFilter {

	private int dimension = 1;
	
	public Rank(int dimension) {
		this.dimension = dimension;
	}

	@Override
	public double[] getFilteredImage(PGMImage image) {
		int[] pixelArray = image.getPixels();
		double[] filteredArray = super.computeRank(pixelArray,
				image.getHeight(), image.getWidth(), dimension);

		return filteredArray;
	}

}
