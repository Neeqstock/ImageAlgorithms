package filterAlgorithms;

import maths.FilterMaths;
import pgm_utilities.PGMImage;
import pgm_utilities.PGMUtilities;
import filterObjects.PrewittHorizontal;
import filterObjects.PrewittVertical;

public class AlgPrewitt implements IAlgorithm {
	
	private PrewittHorizontal prewHor = new PrewittHorizontal();
	private PrewittVertical prewVer = new PrewittVertical();
	
	@Override
	public void computeImage(PGMImage image, String name) {
		double[] horImage = prewHor.getFilteredImage(image);
		double[] verImage = prewVer.getFilteredImage(image);
		
		double[] module = FilterMaths.getModule(horImage, verImage, image.getWidth(), image.getHeight());
		double[] phase = FilterMaths.getPhase(horImage, verImage, image.getWidth(), image.getHeight());
		
		PGMImage imgModule = new PGMImage(image.getWidth(), image.getHeight(), image.getMax_val());
		PGMImage imgPhase = new PGMImage(image.getWidth(), image.getHeight(), image.getMax_val());
		
		int[] intModule = FilterMaths.mapping(module);
		int[] intPhase = FilterMaths.mapping(phase);
		
		imgModule.setPixels(intModule);
		imgPhase.setPixels(intPhase);
		
		PGMUtilities.writePGM(imgModule, PGMUtilities.standardOutputPath + name + "_prewittmodule.pgm");
		PGMUtilities.writePGM(imgPhase, PGMUtilities.standardOutputPath + name + "_prewittphase.pgm");
		
	}

}