package tests;

import pgm_utilities.PGMImage;
import pgm_utilities.PGMUtilities;
import filters.noiseUtilities;

public class AWGNAdderTest {

	public static void main(String[] args) {
		 PGMUtilities pgmUtil = new PGMUtilities();
			PGMImage imgIn = pgmUtil.readPGM("img/inverno.pgm");

			if(imgIn == null)
		       return;
			
			noiseUtilities nu = new noiseUtilities();
			int[] out =  nu.addAWGNNoise(imgIn.getPixels(),0, 100);
			
			PGMImage imgOut = pgmUtil.newPGM(imgIn.getWidth(), imgIn.getHeight(), imgIn.getMax_val());
			imgOut.setPixels(out);	
			pgmUtil.writePGM(imgOut, "testResults/gaussian.pgm");
			
	}
}
