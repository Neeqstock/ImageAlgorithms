package filters;

public class filterUtilities {

	public static int[][] convolution(int[][] kernel, int[][] img){
		
		int r = img.length-1;
		int c = img[0].length-1;
		
		int[][] conv = new int[r][c];
		int rows = kernel.length;
		int columns = kernel[0].length;
		
		for (int i = 1; i < conv.length-1; i++) {
			for (int j = 1; j < conv[0].length-1; j++) {
				
				
				
				
				
			}
		}
		
		
		
		
		
		return conv;
	}
}
