package filterAlgorithms;

import maths.FilterMaths;
import filterObjects.RobertsX;
import filterObjects.RobertsY;
import pgm_utilities.PGMImage;
import pgm_utilities.PGMUtilities;

/**
 * 
 * @see filterObjects.RobertsX 
 * @see filterObjects.RobertsY
 *
 */
public class AlgRoberts implements IAlgorithm {
	
	private RobertsX robertsX = new RobertsX();
	private RobertsY robertsY = new RobertsY();
	
	@Override
	public void computeImage(PGMImage image, String name, String[] args) {
		double[] horImage = robertsX.getFilteredImage(image);
		double[] verImage = robertsY.getFilteredImage(image);
		
		double[] module = FilterMaths.getModule(horImage, verImage, image.getWidth(), image.getHeight());
		double[] phase = FilterMaths.getPhase(horImage, verImage, image.getWidth(), image.getHeight());
		
		PGMImage imgModule = new PGMImage(image.getWidth(), image.getHeight(), image.getMax_val());
		PGMImage imgPhase = new PGMImage(image.getWidth(), image.getHeight(), image.getMax_val());
		
		int[] intModule = FilterMaths.mapping(module);
		int[] intPhase = FilterMaths.mapping(phase);
		
		imgModule.setPixels(intModule);
		imgPhase.setPixels(intPhase);
		
		PGMUtilities.writePGM(imgModule, PGMUtilities.standardOutputPath + name + "_RobertsModule.pgm");
		PGMUtilities.writePGM(imgPhase, PGMUtilities.standardOutputPath + name + "_RobertsPhase.pgm");

	}
}