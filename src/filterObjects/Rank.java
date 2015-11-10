package filterObjects;

import pgm_utilities.PGMImage;

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
