package filters;

public class Sobel implements Ifilters{

	/** Sobel custom Kernel */
	@Override
	public int[][] generateKernel(int rows, int columns, int[] values) {
		int[][] kernel = new int[rows][columns];
		int i = 0;
			for (int j = 0; j < rows; j++) {
				for (int k = 0; k < columns; k++) {
					kernel[j][k] = values[i];
					i++;
			}
		}
		return kernel;
	}
	
	
	
}
