package oldfilters;

public class filterUtilities {

	
	/** fa l'operazione di convoluzione del kernel con una parte dell'immagine, avente le stesse dimensioni
	 * @return il valore di convoluzione */
	public double convolution(double[] kernel, double[] img){
		
		int r = img.length;
		double conv = 0;
				
		for (int i = 0; i < r; i++) {
				conv = conv + (kernel[i] * img[i]);
		}
			return conv;
	}
	
	/** esegue il mapping (passaggio di coordinate) da un range di partenza al range 0-255
	 *  è necessario dopo alcuni filtri che restituiscono valori non rappresentabili
	 *  @return un array di interi (valori pixel)*/
	public int[] mapping(double[] convoluted, double max, double min){
		int[] output = new int[convoluted.length];
		double outputMax = 255;
		double outputMin = 0;
			
		for (int i = 0; i < output.length; i++) {
			double tmp = ((outputMax - outputMin)/ (max - min)) * (convoluted[i] - min);			
			output[i] = (int) tmp;
		}		
		return output;
	}
		
	/** per matrici 3X3: convoluzione 
	 * esegue la convoluzione dell'intera immagine con un kernel 3X3 (utilizzo della funzione convolution) 
	 * @return un array di double*/ 
	public double[] TotalConvolution3(double[]kernel, int[] img, int rows, int columns){
		
		double[] convoluteImage = new double[img.length];
						
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
				
				convoluteImage[i*columns + j] = convolution(kernel, kernelledImage);
			}
		}
		return convoluteImage;
	}
	
	/** per matrici 5X5: convoluzione 
	 * esegue la convoluzione dell'intera immagine con un kernel 5X5 (utilizzo della funzione convolution) 
	 * @return un array di double */	
	public double[] TotalConvolution5(double[]kernel, int[] img, int rows, int columns){
		
		double[] convoluteImage = new double[img.length];
		
		for (int i = 2; i < rows-2; i++) {
			for (int j = 2; j < columns-2; j++) {
				
				double[] kernelledImage = new double[kernel.length];
				
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
	
	/** trasforma un array di double in entrata(proveniente da convoluzioni e filtri)
	 *  in un array di interi (da inserire nel PGM)*/
	public int[] toIntArray(double[] inputArray){
		int[] output = new int[inputArray.length];
		
		for (int i = 0; i < output.length; i++) {
			output[i] = (int)inputArray[i];
		}
		return output;
	}
	
	/** trasforma un array di interi(valori pixel in ingresso)
	 *  in un array di double (per applicare filtri)*/
	public double[] toDoubleArray(int[] inputArray){
		double[] output = new double[inputArray.length];

		for (int i = 0; i < output.length; i++) {
			output[i] = (double)inputArray[i];
		}
		return output;
	}
	
}
