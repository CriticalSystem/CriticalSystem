/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;

/**
 *
 * @author s20163045
 */
public class Storemap {
    
    public static void main(String args[]) throws Exception {

		BufferedImage bufferedImage1 = ImageIO.read(new File("src_jpg.jpg"));
		BufferedImage bufferedImage2 = ImageIO.read(new File("src_png.png"));

		Graphics graphics1 = null;
		try {
			graphics1 = bufferedImage1.getGraphics();
			int x = 0;
			int y = 0;
			graphics1.drawImage(bufferedImage2, x, y, null);
		} finally {
			graphics1.dispose();
		}
		ImageIO.write(bufferedImage1, "jpg", new File("dst_jpg.jpg"));
	} 
}
