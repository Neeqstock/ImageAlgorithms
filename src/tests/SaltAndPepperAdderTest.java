package tests;

import pgm_utilities.PGM;
import pgm_utilities.PgmUtilities;
import filters.noiseUtilities;

public class SaltAndPepperAdderTest {

	public static void main(String[] args) {
		 PgmUtilities pgmUtil = new PgmUtilities();
			PGM imgIn = pgmUtil.readPGM("img/piante.pgm");

			if(imgIn == null)
		       return;
			
			noiseUtilities nu = new noiseUtilities();
			int[] out =  nu.addSaltPepperNoise(imgIn.getPixels(), 0.05);
			
			PGM imgOut = pgmUtil.newPGM(imgIn.getWidth(), imgIn.getHeight(), imgIn.getMax_val());
			imgOut.setPixels(out);	
			pgmUtil.writePGM(imgOut, "testResults/saltpepper.pgm");
	}
}
