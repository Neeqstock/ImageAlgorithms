package tests;

import pgm_utilities.PGM;
import pgm_utilities.PgmUtilities;
import filters.noiseUtilities;

public class ImpulsiveNoiseAdderTest {
	public static void main(String[] args) {
		 PgmUtilities pgmUtil = new PgmUtilities();
			PGM imgIn = pgmUtil.readPGM("img/Pavia2.pgm");

			if(imgIn == null)
		       return;
			
			noiseUtilities nu = new noiseUtilities();
			
			int[] out =  nu.addImpulsiveNoise(imgIn.getPixels(), 0.05);
			
			PGM imgOut = pgmUtil.newPGM(imgIn.getWidth(), imgIn.getHeight(), imgIn.getMax_val());
			imgOut.setPixels(out);	
			pgmUtil.writePGM(imgOut, "testResults/impulsive.pgm");
	}
}
