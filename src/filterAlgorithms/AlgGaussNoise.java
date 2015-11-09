package filterAlgorithms;

import java.util.Random;

import pgm_utilities.PGMImage;
import pgm_utilities.PGMUtilities;

public class AlgGaussNoise implements IAlgorithm{

	private double mean;
	private double variance;
	
	// STUB, una volta sistemato l'interfaccia questo va via
	public AlgGaussNoise () {
		mean = 0;
		variance = 100;
	}
	
	public AlgGaussNoise(double mean, double variance) {
		this.mean = mean;
		this.variance = variance;
	}
	
	public void setMean(double mean) {
		this.mean = mean;
	}	
	public double getMean() {
		return mean;
	}	
	public void setVariance(double variance) {
		this.variance = variance;
	}	
	public double getVariance() {
		return variance;
	}
	@Override
	public void computeImage(PGMImage image, String name) {
		int[] newImg = image.getPixels();
		Random rnd = new Random();
		
		for (int i = 0; i < newImg.length; i++) {
			double noise = rnd.nextGaussian() * Math.sqrt(variance) + mean;
			newImg[i] = newImg[i] + (int)noise;
			
			if (newImg[i] > 255) {
				newImg[i] = 255;
			}
			
			if (newImg[i] < 0) {
				newImg[i] = 0;
			}
		}		
		PGMImage filteredImage = new PGMImage(image.getWidth(), image.getHeight(), image.getMax_val());
		filteredImage.setPixels(newImg);
		
		PGMUtilities.writePGM(filteredImage, PGMUtilities.standardOutputPath + name + "_gaussianNoise.pgm");
		
	}
}
