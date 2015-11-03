package tests;

import oldfilters.filterUtilities;
import pgm_utilities.PGMImage;
import pgm_utilities.PGMUtilities;

public class SobelTest {

	public static void main(String[] args) {
		    PGMUtilities pgmUtil = new PGMUtilities();
			PGMImage imgIn = pgmUtil.readPGM("img/inverno.pgm");
			
			if(imgIn == null)
		       return;
			
			filterUtilities fu = new filterUtilities();
						
			double[] HorizSobel = {-1,0,1,-2,0,2,-1,0,1};
			double[] VertiSobel = {-1,-2,-1,0,0,0,1,2,1};
					
			double[] Gx = fu.TotalConvolution3(HorizSobel, imgIn.getPixels(),imgIn.getHeight(),imgIn.getWidth());
			double[] Gy = fu.TotalConvolution3(VertiSobel, imgIn.getPixels(),imgIn.getHeight(),imgIn.getWidth());
						
			double[] pix = new double[Gx.length];
			double[] pixPhase = new double[Gx.length];
			
			for (int i = 0; i < Gx.length; i++) {
				pix[i] = Math.sqrt((double)(Gx[i]*Gx[i])+(Gy[i]*Gy[i]));
				pixPhase[i] = Math.atan2(Gy[i],Gx[i]);
			}
			
			double minMod = pix[0];
			double maxMod = pix[0];
			double minPha = pixPhase[0];
			double maxPha = pixPhase[0];
			
			for (int i = 0; i < pix.length; i++) {
				if(pix[i] < minMod){
					minMod = pix[i];
				}
				if(pix[i] > maxMod){
					maxMod = pix[i];
				}
				if(pixPhase[i] < minPha){
					minPha = pixPhase[i];
				}
				if(pixPhase[i] > maxPha){
					maxPha = pixPhase[i];
				}
			}
			
			int[] pixoutMod =  fu.mapping(pix, maxMod, minMod);
			int[] pixoutPha =  fu.mapping(pixPhase, maxPha, minPha);
			
			
			PGMImage imgOut = pgmUtil.newPGM(imgIn.getWidth(), imgIn.getHeight(), imgIn.getMax_val());
			imgOut.setPixels(pixoutMod);	
			pgmUtil.writePGM(imgOut, "testResults/SobelModul.pgm");
			
			pgmUtil.resetPGM(imgOut);
			imgOut.setPixels(pixoutPha);
			pgmUtil.writePGM(imgOut, "testResults/SobelPhase.pgm");
	}
}
