
/**
 * Write a description of BatchInversions here.
 * This file takes coloured images.
 * It then inverts the colored images and produces the inverted file.
 * the algorithm below is used for inversion
 * @author (Okwudilichukwu Ezeme) 
 * @version (October 22, 2015)
 */
import edu.duke.*;
import java.io.*;

public class BatchInversions 
{
    // This method inverts each image supplied to it as inImage
    public ImageResource makeInversion(ImageResource inImage)
	{
		int maxColor = 255; //The number used to invert RGB pixel of the new image
		ImageResource outImage = new ImageResource(inImage);
		for (Pixel pixel : outImage.pixels())
		{
			Pixel inPixel = inImage.getPixel(pixel.getX(), pixel.getY());
			int red = maxColor - inPixel.getRed();
			int blue = maxColor - inPixel.getBlue();
			int green = maxColor - inPixel.getGreen();
			pixel.setBlue(blue);
			pixel.setGreen(green);
			pixel.setRed(red);
		}
		return outImage;
	}
	// A method to select the images and supply them to the inverting function
	// Inverted is appended to old file name as the new filename
	public void selectAndConvert()
	{
		DirectoryResource directory = new DirectoryResource();
		for(File file: directory.selectedFiles())
		{
			ImageResource image = new ImageResource(file);
			ImageResource invertedImage = makeInversion(image);
			String oldName = image.getFileName();
			String newName = "inverted-"+oldName;
			invertedImage.setFileName(newName);
			invertedImage.draw();
			invertedImage.save();		
		}
	}
}
