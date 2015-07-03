
import java.awt.image.BufferedImage;
import java.awt.image.WritableRaster;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.Vector;

import javax.imageio.ImageIO;

public class ImageProcessing {
	File inFile;
  static int width;
  static int height;
  
	public ImageProcessing(String path) {
		inFile = new File(path);
	
	}

	public 	Vector<Integer> readImage() {
		BufferedImage image = null;
		try {
			image = ImageIO.read(inFile);
		} catch (IOException e) {
			e.printStackTrace();
		}

		 width = image.getWidth();
		 height = image.getHeight();
		Vector<Integer> pixels = new Vector<Integer>();

		for (int y = 0; y < height; y++) {
			for (int x = 0; x < width; x++) {
				int rgb = image.getRGB(x, y);
				int r = (int) ((rgb >> 16) & 0xff);
				int g = (rgb >> 8) & 0xff;
				int b = (rgb >> 0) & 0xff;
				if(r==0&&g==0&&b==0)
				{
				    pixels.add(-1);
				}
				else
				{
				    pixels.add(1);
				}
			}
		}

		return pixels;
	}
	
	
	public byte[] getPixelArrayToBmpByteArray(int[] pixelData,int width,int height ,String FileName) throws Exception{
	    //int[] pixels = byteToInt(pixelData);

	    BufferedImage image = null;
	    
	        image = new BufferedImage(width, height, BufferedImage.TYPE_BYTE_GRAY);
	    
	    WritableRaster raster = (WritableRaster) image.getData();
	    raster.setPixels(0, 0, width, height, pixelData);
	    image.setData(raster);
	    return getBufferedImageToBmpByteArray(image,FileName );
	}

	
	private byte[] getBufferedImageToBmpByteArray(BufferedImage image ,String FileName) {
	    byte[] imageData = null;
	    try {
	        ByteArrayOutputStream bas = new ByteArrayOutputStream();
	        	ImageIO.write(image, "bmp", new File(FileName));
	        
	        imageData = bas.toByteArray();
	        bas.close();
	    } catch (Exception e) {
	        e.printStackTrace();
	    }

	    return imageData;
	}
	
}
