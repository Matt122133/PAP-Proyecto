package logic;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GraphicsConfiguration;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.JOptionPane;

import interfaces.IControladorImagenes;

public class ControladorImagenes implements IControladorImagenes {

	public Image iconToImage(Icon icon) {
		int h = icon.getIconHeight();
		int w = icon.getIconWidth();
		GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
		GraphicsDevice gd = ge.getDefaultScreenDevice();
		GraphicsConfiguration gc = gd.getDefaultConfiguration();
		BufferedImage bi = gc.createCompatibleImage(w, h);
		Graphics2D g = bi.createGraphics();
		icon.paintIcon(null, g, 0, 0);
		g.dispose();
		return bi;
	}
	
	public byte[] imageToByte(Image image) {
		BufferedImage bi = new BufferedImage(image.getWidth(null), image.getHeight(null), BufferedImage.TYPE_INT_RGB);
		Graphics g = bi.getGraphics();
		g.drawImage(image, 0, 0, null);
		g.dispose();
		ByteArrayOutputStream stream = new ByteArrayOutputStream();
		try {
			ImageIO.write(bi, "JPG", stream);
		} catch (IOException e) {
			JOptionPane.showMessageDialog( null, " Error de imagen: " + e.getMessage());
		}
		return stream.toByteArray();
	}
	
	
}
