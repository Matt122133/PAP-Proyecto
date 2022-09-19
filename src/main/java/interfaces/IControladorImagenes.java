package interfaces;

import java.awt.Image;

import javax.swing.Icon;

public interface IControladorImagenes {

	public Image iconToImage(Icon icon);
	public byte[] imageToByte(Image image);
}
