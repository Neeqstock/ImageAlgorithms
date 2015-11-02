package filterAlgorithms;

import pgm_utilities.PGMImage;

public interface IAlgorithm {
	public abstract void computeImage(PGMImage image, String name);
}
