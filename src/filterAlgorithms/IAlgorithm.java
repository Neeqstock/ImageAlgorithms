package filterAlgorithms;

import java.io.IOException;

import pgm_utilities.PGMImage;
/**
 * An interface of a generic filtering algorithm.
 * A single algorithm computation is all incapsulated and depends on launching computeImage (even the image writing process)
 * @author Nicola, Tomas
 *
 */
public interface IAlgorithm {
	public abstract void computeImage(PGMImage image, String name, String[] args) throws IOException;
}
