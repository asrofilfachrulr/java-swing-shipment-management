package Helper;

import javax.swing.*;
import java.awt.*;

public class ImageHelper {
    public static ImageIcon resizeIcon(ImageIcon icon, int width, int height) {
        Image image = icon.getImage(); // Get the original Image
        Image scaledImage = image.getScaledInstance(width, height, Image.SCALE_SMOOTH); // Scale the image
        return new ImageIcon(scaledImage); // Return the resized ImageIcon
    }
}
