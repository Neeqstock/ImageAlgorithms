package tests;

import oldfilters.noiseUtilities;
import pgm_utilities.PGMImage;
import pgm_utilities.PGMUtilities;

public class UniformNoiseAdderTest {

	public static void main(String[] args) {
		PGMUtilities pgmUtil = new PGMUtilities();
		PGMImage imgIn = pgmUtil.readPGM("img/inverno.pgm");

			if(imgIn == null)
		       return;
			
			noiseUtilities nu = new noiseUtilities();
		
		int[] out2 = nu.addUniformNoise(imgIn.getPixels(), 40);
		
		PGMImage imgOut = pgmUtil.newPGM(imgIn.getWidth(), imgIn.getHeight(), imgIn.getMax_val());
		imgOut.setPixels(out2);	
		pgmUtil.writePGM(imgOut, "testResults/uniform.pgm");
	}

}
