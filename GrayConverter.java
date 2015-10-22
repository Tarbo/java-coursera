
/**
 * Write a description of GrayConverter here.
 * This program takes a coloured image files in batches.
 * It then converts each of them to grey image. 
 * This reduces the burden on network resources
 * @author (Okwudili Ezeme) 
 * @version (October 22, 2015)
 */
import edu.duke.*;
import java.io.File;

public class GrayConverter 
{
    public ImageResource makeGray(ImageResource inImage)
	{
		ImageResource outImage = new ImageResource(inImage);
		for (Pixel pixel : outImage.pixels())
		{
			Pixel inPixel = inImage.getPixel(pixel.getX(), pixel.getY());
			int average = (inPixel.getRed() + inPixel.getBlue() + inPixel.getGreen())/3;
			pixel.setBlue(average);
			pixel.setGreen(average);
			pixel.setRed(average);
		}
		return outImage;
	}
	
	public void doGray()
	{
		DirectoryResource directory = new DirectoryResource();
		for(File file: directory.selectedFiles())
		{
			ImageResource image = new ImageResource(file);
			ImageResource grayImage = makeGray(image);
			String oldName = image.getFileName();
			String newName = "gray-"+oldName;
			grayImage.setFileName(newName);
			grayImage.draw();
			grayImage.save();			
		}
	}
}
