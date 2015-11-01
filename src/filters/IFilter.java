package filters;

public interface IFilter {
	
	/** Generic kernel generation*/ 
	public int[] generateKernel(int rows, int columns, int[] values);
}
