package filterAlgorithms;

import java.util.Random;

import pgm_utilities.PGMImage;
import pgm_utilities.PGMUtilities;

/**
 * Adds AWGN with a given mean and variance to the image. 
 * If no values are given, mean = 0 and variance = 100 
 * (to better see the results)
 */
public class AlgGaussNoise implements IAlgorithm {

	private double mean;
	private double variance;

	public AlgGaussNoise() {
		mean = 0;
		variance = 100;
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
	public void computeImage(PGMImage image, String name, String[] args) {

		if (!(args[0].equalsIgnoreCase("") && args[1].equalsIgnoreCase(""))) {
			if ((Double.parseDouble(args[0]) != 0)
					&& (Double.parseDouble(args[1]) != 0)) {
				
				mean = Double.parseDouble(args[0]);
				variance = Double.parseDouble(args[1]);
			}
		}
		int[] newImg = image.getPixels();
		Random rnd = new Random();

		for (int i = 0; i < newImg.length; i++) {
			double noise = rnd.nextGaussian() * Math.sqrt(variance) + mean;
			newImg[i] = newImg[i] + (int) noise;

			if (newImg[i] > 255) {
				newImg[i] = 255;
			}

			if (newImg[i] < 0) {
				newImg[i] = 0;
			}
		}
		PGMImage filteredImage = new PGMImage(image.getWidth(),
				image.getHeight(), image.getMax_val());
		filteredImage.setPixels(newImg);
		PGMUtilities.writePGM(filteredImage, PGMUtilities.standardOutputPath
				+ name + "_AWGN.pgm");
	}
}
