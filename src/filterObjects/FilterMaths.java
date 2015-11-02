package filterObjects;


public class FilterMaths {
	
	
	public static double[] totalConvolution3(double[] kernel, int[] img, int rows, int columns){
		 
		double[] convolutedDoubleImage = new double[img.length];
		
		// -1, a causa del bordo				
		for (int i = 1; i < rows-1; i++) {
			for (int j = 1; j < columns-1; j++) {
				
				double[] kernelledImage = new double[kernel.length];
				
				kernelledImage[0] = img[(i-1)*columns + (j-1)];
				kernelledImage[3] = img[(i-1)*columns + ( j )];
				kernelledImage[6] = img[(i-1)*columns + (j+1)];
				kernelledImage[1] = img[( i )*columns + (j-1)];
				kernelledImage[4] = img[( i )*columns + ( j )];
				kernelledImage[7] = img[( i )*columns + (j+1)];
				kernelledImage[2] = img[(i+1)*columns + (j-1)];
				kernelledImage[5] = img[(i+1)*columns + ( j )];
				kernelledImage[8] = img[(i+1)*columns + (j+1)];
				
				convolutedDoubleImage[i*columns + j] = convolution(kernel, kernelledImage);
			}
		}
		
		return convolutedDoubleImage;
	}
	
	public static int[] getModule(double[] horPixels, double[] verPixels, int width, int heigth){
		
		double[] doubleResult = new double[horPixels.length];
		
		for (int i = 0; i < horPixels.length; i++) {
			doubleResult[i] = Math.sqrt((double)(horPixels[i]*horPixels[i])+(verPixels[i]*verPixels[i]));
		}
		
		int[] intResult = castDoubleToIntArray(doubleResult);
		return intResult;
	}
	
	public static int[] getPhase(double[] horPixels, double[] verPixels, int width, int heigth){
		
		double[] doubleResult = new double[horPixels.length];
		
		for (int i = 0; i < horPixels.length; i++) {
			doubleResult[i] = Math.atan2(verPixels[i],horPixels[i]);
		}
		
		int[] intResult = castDoubleToIntArray(doubleResult);
		return intResult;
	}
	
	private static double convolution(double[] kernel, double[] img){
		
		// si suppone che vengano passati kernel e imagini di dimensioni giuste
		
		int r = img.length;
		
		double conv = 0;
				
		for (int i = 0; i < r; i++) {
				conv = conv + (kernel[i] * img[i]);
		}
		
			// si suppone quasi sempre vero     	if((rows>=3) & (columns >=3)){} 
			return conv;
	}
	
	public static int[] castDoubleToIntArray(double[] inputArray){
		int[] output = new int[inputArray.length];
		
		for (int i = 0; i < output.length; i++) {
			output[i] = (int)inputArray[i];
		}
		
		return output;
	}
	
}
