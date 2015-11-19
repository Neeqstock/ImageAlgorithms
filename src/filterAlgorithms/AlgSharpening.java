package filterAlgorithms;

import maths.FilterMaths;
import pgm_utilities.PGMImage;
import pgm_utilities.PGMUtilities;
import filterObjects.Box;
import filterObjects.Sharpening;

/**
 * 
 * @see filterObjects.Sharpening
 *
 */
public class AlgSharpening implements IAlgorithm {
	
	private Sharpening filter = new Sharpening();
	
	@Override
	public void computeImage(PGMImage image, String name, String[] args) {
		double[] filteredArray = filter.getFilteredImage(image);
		
		Box boxFilter = new Box();
		double[] boxedArray = boxFilter.getFilteredImage(image);
		
		for (int i = 0; i < filteredArray.length; i++) {
			filteredArray[i] -= boxedArray[i];
		}
		
//		int[] intArray = FilterMaths.mapping(filteredArray);
		int[] intArray = map(filteredArray,image.getWidth());
		PGMImage filteredImage = new PGMImage(image.getWidth(), image.getHeight(), image.getMax_val());
		filteredImage.setPixels(intArray);
		PGMUtilities.writePGM(filteredImage, PGMUtilities.standardOutputPath + name + "_sharpening.pgm");
		
	}

	private int[] map(double[] convoluted,int width){
		double max = convoluted[width+1];
		double min = convoluted[width+1];

		for (int i = width+2; i < convoluted.length; i++) {
			if (convoluted[i] > max) {
				max = convoluted[i];
			}
			if (convoluted[i] < min && convoluted[i] != 0) {
				min = convoluted[i];
			}
		}

		int[] output = new int[convoluted.length];
		double outputMax = 255;
		double outputMin = 0;

		for (int i = 0; i < output.length; i++) {
			double tmp = ((outputMax - outputMin) / (max - min)) * (convoluted[i] - min);
			output[i] = (int) tmp;
		}
		return output;
	}
	
}
