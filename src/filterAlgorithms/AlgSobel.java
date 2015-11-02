package filterAlgorithms;

import pgm_utilities.PGMImage;
import pgm_utilities.PGMUtilities;
import filterObjects.FilterMaths;
import filterObjects.SobelHorizontal;
import filterObjects.SobelVertical;

public class AlgSobel implements IAlgorithm {
	
	private SobelHorizontal sobelHor = new SobelHorizontal();
	private SobelVertical sobelVer = new SobelVertical();
	
	@Override
	public void computeImage(PGMImage image, String name) {
		double[] horImage = sobelHor.getFilteredImage(image);
		double[] verImage = sobelVer.getFilteredImage(image);
		
		int[] module = FilterMaths.getModule(horImage, verImage, image.getWidth(), image.getHeight());
		int[] phase = FilterMaths.getPhase(horImage, verImage, image.getWidth(), image.getHeight());
		
		PGMImage imgModule = new PGMImage(image.getWidth(), image.getHeight(), image.getMax_val());
		PGMImage imgPhase = new PGMImage(image.getWidth(), image.getHeight(), image.getMax_val());
		
		imgModule.setPixels(module);
		imgPhase.setPixels(phase);
		
		PGMUtilities.writePGM(imgModule, PGMUtilities.standardOutputPath + name + "_module.pgm");
		PGMUtilities.writePGM(imgPhase, PGMUtilities.standardOutputPath + name + "_phase.pgm");
		
	}

}
