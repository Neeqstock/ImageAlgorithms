package filterAlgorithms;

import java.io.IOException;

import maths.EdgeExtractor;
import maths.FilterMaths;
import pgm_utilities.PGMImage;
import pgm_utilities.PGMUtilities;
import filterObjects.DoG;

/**
 * 
 * @see filterObjects.DoG
 *
 */
public class AlgDoG implements IAlgorithm {

	private DoG filter;

	@Override
	public void computeImage(PGMImage image, String name, String[] args)
			throws IOException {

		filter = new DoG(DoG.defaultVarianceMIN, DoG.defaultVarianceMAX);
		
		if (!(args[0].equalsIgnoreCase("") && args[1].equalsIgnoreCase(""))) {
			if ((Integer.parseInt(args[0]) != 0)
					&& (Integer.parseInt(args[1]) != 0)) {
				filter = new DoG(Integer.parseInt(args[0]),
						Integer.parseInt(args[1]));
			}
		} 

		double[] filteredArray = filter.getFilteredImage(image);
		int[] intArray = FilterMaths.mapping(filteredArray);

		// Thresholding and edge extraction
		int[] finalArray = EdgeExtractor.extractEdges(intArray,
				image.getWidth(), image.getHeight(), image.getMax_val());

		PGMImage filteredImage = new PGMImage(image.getWidth(),
				image.getHeight(), image.getMax_val());
		filteredImage.setPixels(finalArray);

		PGMUtilities.writePGM(filteredImage, PGMUtilities.standardOutputPath
				+ name + "_DoG.pgm");

	}
}
