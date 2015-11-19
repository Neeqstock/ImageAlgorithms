package maths;

import filterObjects.UnitaryKernel;
/**
 * Edge extraction algorithm. Needed for a DoG filter, for example.
 * @author Nicola, Tomas
 *
 */
public class EdgeExtractor {
	public static int[] extractEdges(int[] pixels, int width, int height,
			int maxVal) {
		UnitaryKernel filter = new UnitaryKernel();
		int mediumVal = maxVal / 2;
		int[] result = new int[pixels.length];
		
		for (int i = 0; i < pixels.length; i++) {
			
			if (pixels[i] < mediumVal) {
				pixels[i] = 0;
			} else {
				pixels[i] = 1;
			}
		}
		double[] intermediate = FilterMaths.totalConvolution3(
				filter.getKernel(), pixels, height, width);

		int[] finalResult = new int[result.length];

		for (int i = 0; i < intermediate.length; i++) {
			if (intermediate[i] > 7 || intermediate[i] < 2) {
				finalResult[i] = 0;
			} else {
				finalResult[i] = 255;
			}
		}
	return finalResult;
	}
}
