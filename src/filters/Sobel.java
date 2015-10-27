package filters;

public class Sobel implements Ifilters{

	int[] verticalValues = {1,0,-1,2,0,-2,1,0,-1};
	int[] horizontalValues = {1,2,1,0,0,0,-1,-2,-1};
	
	/** Vertical Sobel */ 
	public int[][] generateVerticalSobel(){
		return generateKernel(3, 3, verticalValues);
	}
	
	/** Horizontal Sobel */
	public int[][] generateHorizontalSobel(){
		return generateKernel(3, 3, horizontalValues);
	}
	
	/** Sobel custom Kernel implementation*/
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
