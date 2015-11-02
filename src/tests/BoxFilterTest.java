package tests;
import oldfilters.filterUtilities;
import pgm_utilities.PGMImage;
import pgm_utilities.PGMUtilities;

public class BoxFilterTest {

	public static void main(String[] args) {
		 PGMUtilities pgmUtil = new PGMUtilities();
			PGMImage imgIn = pgmUtil.readPGM("img/piante.pgm");

			if(imgIn == null)
		       return;
			
			filterUtilities fu = new filterUtilities();
			double boxValue = 1.0/9.0;	
			double[] box = {boxValue,boxValue,boxValue,boxValue,boxValue,boxValue,boxValue,boxValue,boxValue};
			
			double[] Gx = fu.TotalConvolution3(box, imgIn.getPixels(),imgIn.getHeight(),imgIn.getWidth());
			int[] pixOut = fu.toIntArray(Gx);
			
			PGMImage imgOut = pgmUtil.newPGM(imgIn.getWidth(), imgIn.getHeight(), imgIn.getMax_val());
			imgOut.setPixels(pixOut);	
			pgmUtil.writePGM(imgOut, "testResults/BoxFiltered.pgm");
			
	}
}
