package pgm_utilities;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import pgm_utilities.PGMImage;
import pgm_utilities.PGMUtilities;

/**
 *
 * @author user
 */
public class ImageUtilityTest
{
     /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        if(args.length == 0)
		{
            System.err.println("Error! No file name.");
            return;
		}

	    System.out.println(args[0]);
	    PGMUtilities pgmUtil = new PGMUtilities();

		PGMImage imgIn = pgmUtil.readPGM(args[0]);

		if(imgIn == null)
	       return;

		PGMImage imgOut = pgmUtil.newPGM(imgIn.getWidth(), imgIn.getHeight(), imgIn.getMax_val());

		// copy the image
		imgOut = pgmUtil.copyPGM(imgIn);
		pgmUtil.writePGM(imgOut, "copy.pgm");

		// flip the image
		pgmUtil.resetPGM(imgOut);
		imgOut = pgmUtil.hflipPGM(imgIn);
		pgmUtil.writePGM(imgOut, "flip.pgm");

	        // invert the image
		pgmUtil.resetPGM(imgOut);
		imgOut = pgmUtil.invertPGM(imgIn);
		pgmUtil.writePGM(imgOut, "invert.pgm");

		// calculate histogram and write it in a file
		int i;
		int[] histogram = pgmUtil.histogramPGM(imgIn);

		FileWriter fstream;
        try
        {
            fstream = new FileWriter("histogram.dat");
            BufferedWriter out = new BufferedWriter(fstream);

            for(i=0; i<256; i++)
            {
                System.out.println("HISTOGRAM[" + i + "] = " + histogram[i]);
                out.write(i + " " + histogram[i] + "\n");
            }

            out.close();
        }
        catch (IOException ex)
        {
            System.err.println("\nIOException. Check input Data.");
        }
    }
}
