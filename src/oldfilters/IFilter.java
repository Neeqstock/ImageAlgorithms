package oldfilters;

public interface IFilter {
	
	/** Generic image generation*/ 
	public int[] generateFinalImage(int[] image, double[] filter);
}
