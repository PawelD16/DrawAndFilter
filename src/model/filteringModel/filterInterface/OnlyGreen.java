package model.filteringModel.filterInterface;

import java.awt.*;
import java.awt.image.BufferedImage;

public class OnlyGreen extends FilterAll {

    public OnlyGreen(BufferedImage image) {
        super(image);
    }

    public OnlyGreen(BufferedImage image, int xInfo, int yInfo, int filterSize, boolean ifAppliedToEntireImage) {
        super(image, xInfo, yInfo, filterSize, ifAppliedToEntireImage);
    }

    @Override
    public BufferedImage filterMe() {

        // convert to onlygreen
        for (int y = startingPointHeight; y < endingPointHeight; y++) {
            for (int x = startingPointWidth; x < endingPointWidth; x++) {
                c = new Color(image.getRGB(x, y));

                // set new RGB value
                c = new Color(0, c.getGreen(), 0);

                image.setRGB(x, y, c.getRGB());
            }
        }
        return image;
    }
}
