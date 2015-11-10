package filterAlgorithms;

import java.util.Random;

import pgm_utilities.PGMImage;
import pgm_utilities.PGMUtilities;

public class AlgImpulseNoise implements IAlgorithm{

private double density;
	
	public AlgImpulseNoise() {
		density = 0.05;
	}
	
	public void setDensity(double density) {
		this.density = density;
	}
	public double getDensity() {
		return density;
	}
	
	@Override
	public void computeImage(PGMImage image, String name, String[] args) {
		
		if (!(args[0].equalsIgnoreCase(""))) {
			if ((Double.parseDouble(args[0]) != 0)) {

				density = Double.parseDouble(args[0]);
			}
		}
		
		int[] newImg = image.getPixels();
		int imgSize = newImg.length;
		int affectedPixels =(int) (((double)imgSize) * density);
		Random rnd = new Random();
		
		for (int i = 0; i < affectedPixels; i++) {
			int nextIndex = rnd.nextInt(imgSize);
			newImg[nextIndex] = 255;
		}
		PGMImage filteredImage = new PGMImage(image.getWidth(), image.getHeight(), image.getMax_val());
		filteredImage.setPixels(newImg);
		PGMUtilities.writePGM(filteredImage, PGMUtilities.standardOutputPath + name + "_Impulse.pgm");
	}
}
