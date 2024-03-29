package model.paintingModel.drawableShapes.drawInterface.fillShape;

import model.paintingModel.drawableShapes.drawInterface.PaintAll;

import java.awt.*;

public class FillCircle extends PaintAll {

    private static final long serialVersionUID = -3987766223137884832L;

    public FillCircle(int x, int y, int diameter, Color color) {
        super(x, y, diameter, color);
    }

    @Override
    public void drawMe(Graphics g) {
        Graphics2D g2d = super.setGraphicsProperties(g);

        g2d.fillOval(x - (attribute / 2), y - (attribute / 2), attribute, attribute);
    }
}
