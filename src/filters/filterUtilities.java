package filters;

public class filterUtilities {

	public int convolution(int[] kernel, int[] img){
		
		// si suppone che vengano passati kernel e imagini di dimensioni giuste
		
		int r = img.length;
		
		int conv = 0;
				
		for (int i = 0; i < r; i++) {
				conv = conv + (kernel[i] * img[i]);
		}
		
			// si suppone quasi sempre vero     	if((rows>=3) & (columns >=3)){} 
			return conv;
	}
	
	/** 3X3 matrix convolution */ 
	public int[] TotalConvolution3(int[]kernel, int[] img, int rows, int columns){
		
		// -1, a causa del bordo 
		int[] convoluteImage = new int[img.length];
		
		for (int i = 1; i < rows-1; i++) {
			for (int j = 1; j < columns-1; j++) {
				
				int[] kernelledImage = new int[kernel.length];
				
				kernelledImage[0] = img[(i-1)*rows + (j-1)];
				kernelledImage[1] = img[(i-1)*rows + (j  )];
				kernelledImage[2] = img[(i-1)*rows + (j+1)];
				kernelledImage[3] = img[(i  )*rows + (j-1)];
				kernelledImage[4] = img[(i  )*rows + (j  )];
				kernelledImage[5] = img[(i  )*rows + (j+1)];
				kernelledImage[6] = img[(i+1)*rows + (j-1)];
				kernelledImage[7] = img[(i+1)*rows + (j  )];
				kernelledImage[8] = img[(i+1)*rows + (j+1)];
				
				convoluteImage[i] = convolution(kernel, kernelledImage);
			}
		}
		return convoluteImage;
	}
	
	
	/** convolution for Nagao-Matsuyama */	
	public int[] TotalConvolution5(int[]kernel, int[] img, int rows, int columns){
		
		int[] convoluteImage = new int[img.length];
		
		for (int i = 2; i < rows-2; i++) {
			for (int j = 2; j < columns-2; j++) {
				
				int[] kernelledImage = new int[kernel.length];
				
				kernelledImage[0] = img[(i-2)*rows + (j-2)*columns];
				kernelledImage[1] = img[(i-2)*rows + (j-1)*columns];
				kernelledImage[2] = img[(i-2)*rows + (j  )*columns];
				kernelledImage[3] = img[(i-2)*rows + (j+1)*columns];
				kernelledImage[4] = img[(i-2)*rows + (j+2)*columns];
				
				kernelledImage[5] = img[(i-1)*rows + (j-2)*columns];
				kernelledImage[6] = img[(i-1)*rows + (j-1)*columns];
				kernelledImage[7] = img[(i-1)*rows + (j  )*columns];
				kernelledImage[8] = img[(i-1)*rows + (j+1)*columns];
				kernelledImage[9] = img[(i-1)*rows + (j+2)*columns];
				
				kernelledImage[10] = img[(i  )*rows + (j-2)*columns];
				kernelledImage[11] = img[(i  )*rows + (j-1)*columns];
				kernelledImage[12] = img[(i  )*rows + (j  )*columns];
				kernelledImage[13] = img[(i  )*rows + (j+1)*columns];
				kernelledImage[14] = img[(i  )*rows + (j+2)*columns];
				
				kernelledImage[15] = img[(i+1)*rows + (j-2)*columns];
				kernelledImage[16] = img[(i+1)*rows + (j-1)*columns];
				kernelledImage[17] = img[(i+1)*rows + (j  )*columns];
				kernelledImage[18] = img[(i+1)*rows + (j+1)*columns];
				kernelledImage[19] = img[(i+1)*rows + (j+2)*columns];
				
				kernelledImage[20] = img[(i+2)*rows + (j-2)*columns];
				kernelledImage[21] = img[(i+2)*rows + (j-1)*columns];
				kernelledImage[22] = img[(i+2)*rows + (j  )*columns];
				kernelledImage[23] = img[(i+2)*rows + (j+1)*columns];
				kernelledImage[24] = img[(i+2)*rows + (j+2)*columns];
				
				convoluteImage[i] = convolution(kernel, kernelledImage);
			}
		}
		return convoluteImage;
	}
	
}
