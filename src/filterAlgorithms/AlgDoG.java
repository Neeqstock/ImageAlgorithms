package filterAlgorithms;

import java.io.IOException;

import maths.EdgeExtractor;
import maths.FilterMaths;
import pgm_utilities.PGMImage;
import pgm_utilities.PGMUtilities;
import filterObjects.DoG;
import filterObjects.UnitaryKernel;

public class AlgDoG implements IAlgorithm {
	
	private DoG filter = new DoG(DoG.defaultVarianceMIN, DoG.defaultVarianceMAX);
	
	@Override
	public void computeImage(PGMImage image, String name, String[] args) throws IOException {
		double[] filteredArray = filter.getFilteredImage(image);
		int[] intArray = FilterMaths.mapping(filteredArray);

		// Thresholding and edge extraction
		int[] finalArray = EdgeExtractor.extractEdges(intArray, image.getWidth(), image.getHeight(), image.getMax_val());
		
		PGMImage filteredImage = new PGMImage(image.getWidth(), image.getHeight(), image.getMax_val());
		filteredImage.setPixels(finalArray);
		
		PGMUtilities.writePGM(filteredImage, PGMUtilities.standardOutputPath + name + "_DoG.pgm");
		
		
	}
}
