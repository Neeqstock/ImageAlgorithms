package tests;

import pgm_utilities.PGM;
import pgm_utilities.PgmUtilities;
import filters.noiseUtilities;

public class UniformNoiseAdderTest {

	public static void main(String[] args) {
		PgmUtilities pgmUtil = new PgmUtilities();
		PGM imgIn = pgmUtil.readPGM("img/inverno.pgm");

			if(imgIn == null)
		       return;
			
			noiseUtilities nu = new noiseUtilities();
		
		int[] out2 = nu.addUniformNoise(imgIn.getPixels(), 40);
		
		PGM imgOut = pgmUtil.newPGM(imgIn.getWidth(), imgIn.getHeight(), imgIn.getMax_val());
		imgOut.setPixels(out2);	
		pgmUtil.writePGM(imgOut, "testResults/uniform.pgm");
	}

}
