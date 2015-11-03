package filterAlgorithms;

import maths.FilterMaths;
import pgm_utilities.PGMImage;
import pgm_utilities.PGMUtilities;
import filterObjects.SobelHorizontal;
import filterObjects.SobelVertical;

public class AlgSobel implements IAlgorithm {
	
	private SobelHorizontal sobelHor = new SobelHorizontal();
	private SobelVertical sobelVer = new SobelVertical();
	
	@Override
	public void computeImage(PGMImage image, String name) {
		double[] horImage = sobelHor.getFilteredImage(image);
		double[] verImage = sobelVer.getFilteredImage(image);
		
		double[] module = FilterMaths.getModule(horImage, verImage, image.getWidth(), image.getHeight());
		double[] phase = FilterMaths.getPhase(horImage, verImage, image.getWidth(), image.getHeight());
		
		PGMImage imgModule = new PGMImage(image.getWidth(), image.getHeight(), image.getMax_val());
		PGMImage imgPhase = new PGMImage(image.getWidth(), image.getHeight(), image.getMax_val());
		
		int[] intModule = FilterMaths.mapping(module);
		int[] intPhase = FilterMaths.mapping(phase);
		
		imgModule.setPixels(intModule);
		imgPhase.setPixels(intPhase);
		
		PGMUtilities.writePGM(imgModule, PGMUtilities.standardOutputPath + name + "_Sobelmodule.pgm");
		PGMUtilities.writePGM(imgPhase, PGMUtilities.standardOutputPath + name + "_Sobelphase.pgm");
		
	}

}
