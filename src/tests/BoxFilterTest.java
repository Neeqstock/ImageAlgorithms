package tests;
import filters.filterUtilities;
import pgm_utilities.PGM;
import pgm_utilities.PgmUtilities;

public class BoxFilterTest {

	public static void main(String[] args) {
		 PgmUtilities pgmUtil = new PgmUtilities();
			PGM imgIn = pgmUtil.readPGM("img/piante.pgm");

			if(imgIn == null)
		       return;
			
			filterUtilities fu = new filterUtilities();
			double boxValue = 1.0/9.0;	
			double[] box = {boxValue,boxValue,boxValue,boxValue,boxValue,boxValue,boxValue,boxValue,boxValue};
			
			double[] Gx = fu.TotalConvolution3(box, imgIn.getPixels(),imgIn.getHeight(),imgIn.getWidth());
			int[] pixOut = fu.toIntArray(Gx);
			
			PGM imgOut = pgmUtil.newPGM(imgIn.getWidth(), imgIn.getHeight(), imgIn.getMax_val());
			imgOut.setPixels(pixOut);	
			pgmUtil.writePGM(imgOut, "testResults/BoxFiltered.pgm");
			
	}
}
