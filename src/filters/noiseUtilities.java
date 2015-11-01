package filters;

import java.util.Random;

public class noiseUtilities {
	
	/**adds salt&pepper noise to img, affecting (density*img.length) pixels */
	public int[] addSaltPepperNoise(int[] img, double density){
		int[] newImg = img;
		int imgSize = img.length;
		int affectedPixels =(int) (((double)imgSize) * density);
		Random rnd = new Random();
		
		for (int i = 0; i < affectedPixels; i++) {
			int nextIndex = rnd.nextInt(imgSize);
			if ((rnd.nextInt() % 2) == 0) {
				newImg[nextIndex] = 0;
			}else{
				newImg[nextIndex] = 255;
			}
		}
		return newImg;
	}
	
	/** adds AWGN to img. Gaussian noise has a given mean and variance */
	public int[] addAWGNNoise(int[] img, double mean, double variance){
		int[] newImg = img;
		Random rnd = new Random();
		
		for (int i = 0; i < newImg.length; i++) {
			double noise = rnd.nextGaussian() * Math.sqrt(variance) + mean;
			newImg[i] = newImg[i] + (int)noise;
			
			if (newImg[i] > 255) {
				newImg[i] = 255;
			}
			
			if (newImg[i] < 0) {
				newImg[i] = 0;
			}
		}		
		return newImg;
	}
	
	/**add impulsive noise */ 
	public int[] addImpulsiveNoise(int[] img, double density){
		int[] newImg = img;
		int imgSize = img.length;
		int affectedPixels =(int) (((double)imgSize) * density);
		Random rnd = new Random();
		
		for (int i = 0; i < affectedPixels; i++) {
			int nextIndex = rnd.nextInt(imgSize);
			newImg[nextIndex] = 255;
		}
		return newImg;
	}

	/** add uniform noise to img. K is maximum noise value*/
	public int[] addUniformNoise(int[] img, int k){
		int[] out = img;
		Random rnd = new Random();
		for (int i = 0; i < out.length; i++) {
			double noise = 2*k*(rnd.nextDouble() - 0.5);
			out[i] = out[i] + (int)noise;
			
			if (out[i] > 255) {
				out[i] = 255;
			}
			
			if (out[i] < 0) {
				out[i] = 0;
			}
		}
		return img;
	}

}
