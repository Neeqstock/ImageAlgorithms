package filterAlgorithms;

import java.util.Random;

import pgm_utilities.PGMImage;
import pgm_utilities.PGMUtilities;

public class AlgUniformNoise implements IAlgorithm {

	private double k;

	public AlgUniformNoise() {
		k = 10; // alta per apprezzare il risultato
	}

	public void setK(double k) {
		this.k = k;
	}

	public double getK() {
		return k;
	}

	@Override
	public void computeImage(PGMImage image, String name, String[] args) {

		if (!(args[0].equalsIgnoreCase(""))) {
			if ((Double.parseDouble(args[0]) != 0)) {

				k = Double.parseDouble(args[0]);
			}
		}
		
		int[] out = image.getPixels();
		Random rnd = new Random();
		for (int i = 0; i < out.length; i++) {
			double noise = 2 * k * (rnd.nextDouble() - 0.5);
			out[i] = out[i] + (int) noise;

			if (out[i] > 255) {
				out[i] = 255;
			}

			if (out[i] < 0) {
				out[i] = 0;
			}
		}
		PGMImage filteredImage = new PGMImage(image.getWidth(),
				image.getHeight(), image.getMax_val());
		filteredImage.setPixels(out);
		PGMUtilities.writePGM(filteredImage, PGMUtilities.standardOutputPath
				+ name + "_Uniform.pgm");

	}
}
