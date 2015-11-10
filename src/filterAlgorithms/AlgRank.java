package filterAlgorithms;

import maths.FilterMaths;
import pgm_utilities.PGMImage;
import pgm_utilities.PGMUtilities;
import filterObjects.Rank;

/**
 * 
 * @see filterObjects.Rank
 *
 * note: here Median filter is considered as a subcase of Rank
 *
 */
public class AlgRank implements IAlgorithm {
	private Rank filter;

	@Override
	public void computeImage(PGMImage image, String name, String[] args) {
		filter = new Rank(Integer.parseInt(args[0]));
		double[] filteredArray = filter.getFilteredImage(image);
		int[] pixels = FilterMaths.mapping(filteredArray);
		
		PGMImage resultImage = new PGMImage(image.getWidth(), image.getHeight(), image.getMax_val());
		resultImage.setPixels(pixels);

		PGMUtilities.writePGM(resultImage, PGMUtilities.standardOutputPath + name
				+ "_Rank.pgm");
	}
}
