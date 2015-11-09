package filterAlgorithms;

import java.io.IOException;

import pgm_utilities.PGMImage;

public interface IAlgorithm {
	public abstract void computeImage(PGMImage image, String name, String[] args) throws IOException;
}
