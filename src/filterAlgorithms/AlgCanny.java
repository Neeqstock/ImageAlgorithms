package filterAlgorithms;

import java.awt.image.BufferedImage;
import java.awt.image.DataBufferByte;
import java.awt.image.DataBufferInt;

import maths.FilterMaths;
import pgm_utilities.PGMImage;
import pgm_utilities.PGMUtilities;
import canny.CannyEdgeDetector;

public class AlgCanny implements IAlgorithm {

	@Override
	public void computeImage(PGMImage image, String name) {
		// create the detector
		CannyEdgeDetector detector = new CannyEdgeDetector();

		// adjust its parameters as desired
		detector.setLowThreshold(0.5f);
		detector.setHighThreshold(1f);

		BufferedImage bufferedImage = new BufferedImage(image.getWidth(),
				image.getHeight(), BufferedImage.TYPE_BYTE_GRAY);

		byte[] newData = ((DataBufferByte) bufferedImage.getRaster()
				.getDataBuffer()).getData();
		int[] pixel = image.getPixels();

		for (int i = 0; i < image.getHeight() * image.getWidth(); i++) {
			byte b = (byte) (pixel[i] & 0xff);
			newData[i] = b;

			// System.out.println(b);
			// int i2 = b & 0xFF;
			// System.out.println(i2);
		}

		detector.setSourceImage(bufferedImage);
		detector.process();
		BufferedImage edges = new BufferedImage(detector.getEdgesImage()
				.getWidth(), detector.getEdgesImage().getHeight(),
				BufferedImage.TYPE_INT_ARGB);
		edges = detector.getEdgesImage();
		int[] outData = ((DataBufferInt) edges.getRaster().getDataBuffer())
				.getData();

		outData = FilterMaths.mapping((FilterMaths.CastIntToDoubleArray(outData)));
		
		// int[] pixel2 = new int[edges.getWidth()*edges.getHeight()];
		//
		// for (int i = 0; i < image.getHeight(); i++)
		// {
		// for (int j = 0; i < image.getWidth(); i++)
		// {
		// pixel2[i] = outData[i];
		// }}

		PGMImage filteredImage = new PGMImage(image.getWidth(),
				image.getHeight(), image.getMax_val());
		filteredImage.setPixels(outData);

		PGMUtilities.writePGM(filteredImage, PGMUtilities.standardOutputPath
				+ name + "_Canny.pgm");

		// File outputfile = new File(name + "_canny.pgm");
		// try {
		// ImageIO.write(edges, "pgm", outputfile);
		// } catch (IOException e1) {
		// e1.printStackTrace();
		// System.out.println("Fuck Canny");
		// }
	}
}
