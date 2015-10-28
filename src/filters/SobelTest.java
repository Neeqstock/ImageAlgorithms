package filters;

import pgm_utilities.PGM;
import pgm_utilities.PgmUtilities;

public class SobelTest {

	public static void main(String[] args) {
		    PgmUtilities pgmUtil = new PgmUtilities();
			PGM imgIn = pgmUtil.readPGM("img/estate.pgm");

			if(imgIn == null)
		       return;
			
			filterUtilities fu = new filterUtilities();
						
			int[] HorizSobel = {-1,0,1,-2,0,2,-1,0,1};
			
			PGM imgOut = pgmUtil.newPGM(imgIn.getWidth(), imgIn.getHeight(), imgIn.getMax_val());
			imgOut.setPixels(fu.TotalConvolution3(HorizSobel, imgIn.getPixels(),imgIn.getWidth(),imgIn.getHeight()));
			pgmUtil.writePGM(imgOut, "img/SobelHori.pgm");

			int[] VertSobel = {-1,-2,-1,0,0,0,1,2,1};
			
			pgmUtil.resetPGM(imgOut);
			imgOut.setPixels(fu.TotalConvolution3(VertSobel, imgIn.getPixels(),imgIn.getWidth(),imgIn.getHeight()));
			pgmUtil.writePGM(imgOut, "img/SobelVert.pgm");
	}
}
