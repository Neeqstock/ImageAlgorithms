package filterAlgorithms;

import java.awt.image.BufferedImage;

import pgm_utilities.PGMImage;
import canny.CannyEdgeDetector;

public class AlgCanny implements IAlgorithm{

	@Override
	public void computeImage(PGMImage image, String name) {
		//create the detector
		CannyEdgeDetector detector = new CannyEdgeDetector();

		//adjust its parameters as desired
		detector.setLowThreshold(0.5f);
		detector.setHighThreshold(1f);

		//apply it to an image
		
		BufferedImage img = new BufferedImage(image.getWidth(), image.getHeight(), BufferedImage.TYPE_BYTE_GRAY);
		
		detector.setSourceImage(image);
		detector.process();
		BufferedImage edges = detector.getEdgesImage();
		
	}
	
}
