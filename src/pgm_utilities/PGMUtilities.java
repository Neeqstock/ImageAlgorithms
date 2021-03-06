/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pgm_utilities;

import java.io.*;
import java.util.StringTokenizer;

/**
 *
 * @author user
 */
public class PGMUtilities 
{
	private static int numLines = 0;
	public static final String standardOutputPath = "output/";
	
    //---------------------------------------------------------// 
    //------------- Create a new empty pgm image --------------//
    //---------------------------------------------------------// 
    public static PGMImage newPGM(int width, int height, int max_val)
    {
        return new PGMImage(width, height, max_val);
    }
    
   
    // ----------------------------------------------------- //
    // Reads information from header file                    //
    // Allows for reading and writing in PGM P2 - P5 format  //
    // Version 1.1 Piercarlo Dondi & Alessandro Gaggia       //
    // ----------------------------------------------------- //

    //******************* I/O FUNCTIONS *********************//

    //-------------------------------------------------------//
    //--------------- Skip Commented Lines ------------------//
    //-------------------------------------------------------// 
    public static String skipComments(BufferedReader br) throws IOException
    {
        boolean loop = true;
        String buffer = br.readLine();
        
        while(loop)
        {
            if(buffer.charAt(0) != '#')
                loop = false;
            else
            {
                buffer = br.readLine();
                numLines++;
            }
        }
        
        return buffer;
    }

    //---------------------------------------------------------// 
    //------- Set to zero all the pixels of a pgm image -------//
    //---------------------------------------------------------// 
    public static void resetPGM(PGMImage pgm)
    {
        int width = pgm.getWidth();
        int height = pgm.getHeight();
        int i;

        // set to zero all the pixels
        for(i = 0; i < width*height; i++)
        {
            pgm.getPixels()[i] = 0;
        }
    }

    //---------------------------------------------------------//
    //--------- Read Pixels From Different FileType -----------//
    //---------------------------------------------------------// 
    public static PGMImage readPGM(String filename)
    {
        int width, height, max_val;
        boolean binary;
        
        PGMImage pgm;
        numLines = 3; // default number of lines of header
        
        try 
        {
			FileInputStream fstream = new FileInputStream(filename);
			DataInputStream in = new DataInputStream(fstream);
			BufferedReader br = new BufferedReader(new InputStreamReader(in));
			
			String buffer;
			// Read a line till \n or 64 char
			buffer = br.readLine();
			
			if( "P2".equals(buffer)) 
			{
				binary = false;
				System.out.println("\nFORMAT: P2");
			}
			else if ("P5".equals(buffer)) 
			{
				binary = true;
				System.out.println("\nFORMAT: P5");
			}
			else 
			{
				System.err.println("ERROR: incorrect file format\n");
				in.close();
				return null;
			} 

            // Jump commented lines
            buffer = skipComments(br);

            // Read width, height and max grayscale value
            StringTokenizer st = new StringTokenizer(buffer);
            width = Integer.parseInt(st.nextToken());
            height = Integer.parseInt(st.nextToken());
                       
            buffer = br.readLine();
            max_val = Integer.parseInt(buffer);

            // Printing information on screen
            System.out.println("\nPGM Filename: " + filename + "\nPGM Width & Height: " + width + "," + height + "\nPGM Max Val & Type: " + max_val + ","  + (binary ? "P5" : "P2") + "\n" );

            // Initialize PGM
            pgm = newPGM(width, height, max_val);
                        
            // Reading Pixels
            if(binary) // P5 case
            {

            	br.close();
    			fstream = new FileInputStream(filename);
    			in = new DataInputStream(fstream);
    			
			    int numLinesToSkip = numLines;
			    System.out.println(numLinesToSkip);
			    while (numLinesToSkip > 0)
			    {
			        char c;
			        do {
			            c = (char)(in.readUnsignedByte());
			        } while (c != '\n');
			        numLinesToSkip--;
			    }

			    int num;
			    int x=0;
			    
			    while ((num = in.read()) != -1)
				{
				    pgm.getPixels()[x] =  num;
					x++;
                }
            }
            else // P2 case
            {	
            	int i=0;
                while((buffer = br.readLine())!=null)
                {
                     st = new StringTokenizer(buffer);
                     while(st.hasMoreTokens())
                     {
                    	 pgm.getPixels()[i] = Integer.parseInt(st.nextToken());
                    	 i++;
                     }
                }
            }

            // Ok close the file
            in.close();

            System.out.println("\nImage correctly loaded");

            return pgm;
        } 
        catch (FileNotFoundException ex) 
        {
            System.out.println("File not found.");
            return null;
        }
        catch (IOException ex) 
        {
            System.out.println("IOException. Please check file.");
            return null;
        }
    }

    //---------------------------------------------------------//
    //--- Write Pixels inside images for Different FileType ---//
    //---------------------------------------------------------// 
    public static void writePGM(PGMImage pgm, String filename)
    {
        if(pgm == null)
        {
            System.err.println("Error! No data to write. Please Check.");
            return;
        }

        FileWriter fstream;
        try 
        {
            fstream = new FileWriter(filename);       
            BufferedWriter out = new BufferedWriter(fstream);

            out.write("P2\n" + pgm.getWidth() + " " + pgm.getHeight() + "\n" + pgm.getMax_val() + "\n");

            int i;
            int width = pgm.getWidth();
            int height = pgm.getHeight();

            // Write image
            for(i = 0; i < width * height; i++)
            {
                out.write(pgm.getPixels()[i] + "\n");
            }	

            System.out.println("\nImage correctly written");

            // Ok close the file
            out.close();
        
        } 
        catch (IOException ex) 
        {
            System.err.println("\nIOException. Check input Data.");
        }
    }

    //*************** SOME BASIC OPERATIONS *****************//

    //-------------------------------------------------------//
    //----- Invert Pixels GrayScale value inside images -----//
    //--------------- for Different FileType ----------------//
    //-------------------------------------------------------// 
    public static PGMImage invertPGM(PGMImage pgmIn)
    {	
        if(pgmIn == null)
        {
            System.err.println("Error! No input data. Please Check.");
            return null;
        }

    	PGMImage pgmOut = new PGMImage(pgmIn.getWidth(), pgmIn.getHeight(), pgmIn.getMax_val());
        int i, inv;
        int max = pgmIn.getMax_val();
        int width = pgmIn.getWidth();
        int height = pgmIn.getHeight();

        // Writing Pixels
        for(i = 0; i < width * height; i++)
        {
            // Invert GrayScale Value
            inv = max - pgmIn.getPixels()[i];
            pgmOut.getPixels()[i] = inv;
        }
        
        return pgmOut;
    }

    //-------------------------------------------------------//
    //---------------- Flip Image Horizontally --------------//
    //-------------------------------------------------------// 
    public static PGMImage hflipPGM(PGMImage pgmIn)
    {	
        if(pgmIn == null)
        {
            System.err.println("Error! No input data. Please Check.");
            return null;
        }
        
    	PGMImage pgmOut = new PGMImage(pgmIn.getWidth(), pgmIn.getHeight(), pgmIn.getMax_val());

        int i, j;
        int hfp;

        int width = pgmIn.getWidth();
        int height = pgmIn.getHeight();
        
        int[] inputPixels = pgmIn.getPixels();
        int[] flipPixels = new int[width * height];

        // Modify Pixels
        for(i = 0; i < height; i++)
        {
            for(j = 0; j < width; j++)
            {
                // Flip GrayScale Value on width
                hfp = inputPixels[i*width + j];
                flipPixels[i*width + (width -j -1)] = hfp;
            }	
        }
        
        pgmOut.setPixels(flipPixels);

        return pgmOut;
    }

    //-------------------------------------------------------//
    //------------------ Copy a PGM Image -------------------//
    //-------------------------------------------------------// 
    public static PGMImage copyPGM(PGMImage pgmIn)
    {		
        if(pgmIn == null)
        {
            System.err.println("Error! No input data. Please Check.");
            return null;
        }
    	PGMImage pgmOut = new PGMImage(pgmIn.getWidth(), pgmIn.getHeight(), pgmIn.getMax_val());

        int i;

        int width = pgmIn.getWidth();
        int height = pgmIn.getHeight();

        int[] inPixels = pgmIn.getPixels();
        int[] outPixels = new int[width * height];

        // Copy image
        for( i = 0; i < width * height; i++)
        {
            // Copy image
            outPixels[i] = inPixels[i];
        }

        pgmOut.setPixels(outPixels);

        return pgmOut;
    }
    
    //--------------------------------------------------------//
    //------------------ Calculate Histogram -----------------//
    //--------------------------------------------------------// 
    public static int[] histogramPGM(PGMImage pgm)
    {
        if(pgm == null)
        {
            System.err.println("Error! No input data. Please Check.");
            return null;
        }

        int i,index;

        int[] inPixels = pgm.getPixels();
        int width = pgm.getWidth();
        int height = pgm.getHeight();
        int max_val = pgm.getMax_val();

        // if max_val is 255 each pixel of the image can have a value between [0;255]
        // so histogram have a dimension of 256
        int[] histogram = new int[max_val+1];

        for(i = 0; i < width * height; i++)
        {
            index = inPixels[i];
            histogram[index]++;
        }

        return histogram;
    }
    
}
