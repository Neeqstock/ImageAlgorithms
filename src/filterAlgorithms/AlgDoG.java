package filterAlgorithms;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

import pgm_utilities.PGMImage;

public class AlgDoG implements IAlgorithm{
@Override
public void computeImage(PGMImage image, String name) throws IOException {
	// TODO Auto-generated method stub
	Desktop.getDesktop().open(new File("img/estate"));
}
}
