package view;

import observerInterface.Observer;
import view.choiceAssistant.ColorChoiceFrame;
import view.choiceAssistant.ToolShapeChoice;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;


public class PaintingPanel extends JPanel implements MouseListener, Observer {

    private final ColorChoiceFrame backgroundColorChanger;
    private final ColorChoiceFrame toolsColorChanger;
    private final ToolShapeChoice toolShapeChooser;
    private static Object[] dataAboutCurrentObject;
    private Color toolColor;
    private int sizeOfChosenTool;
    private int typeOfChosenTool;
    private boolean ifCovering;

    public PaintingPanel(int width, int height, ColorChoiceFrame backgroundColorChanger, ColorChoiceFrame objectsColor, ToolShapeChoice toolShapeChooser) {
        this.setPreferredSize(new Dimension(width, height));
        this.setVisible(true);
        this.addMouseListener(this);
        this.backgroundColorChanger = backgroundColorChanger;
        this.toolsColorChanger = objectsColor;
        this.toolShapeChooser = toolShapeChooser;
        this.changeColor();
        this.sizeOfChosenTool = toolShapeChooser.getTool()[0];
        this.typeOfChosenTool = toolShapeChooser.getTool()[1];
        this.ifCovering = false;
        dataAboutCurrentObject = new Object[7];
    }


    public void changeColor() {
        this.setBackground(backgroundColorChanger.getColor());
        this.toolColor = toolsColorChanger.getColor();
        revalidate();
        repaint();
    }

    public void changeTool() {

        this.sizeOfChosenTool = toolShapeChooser.getTool()[0];
        this.typeOfChosenTool = toolShapeChooser.getTool()[1];

        for (int i = 0; i < toolShapeChooser.getTool().length; i++)
            System.out.println(toolShapeChooser.getTool()[i]);
    }

    public void dissallowCovering() {
        ifCovering = true;
    }

    public void allowCovering() {
        ifCovering = false;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        dataAboutCurrentObject[0] = MouseInfo.getPointerInfo().getLocation().x; //x location
        dataAboutCurrentObject[1] = MouseInfo.getPointerInfo().getLocation().y; //y location
        dataAboutCurrentObject[2] = toolColor; //tool color
        dataAboutCurrentObject[3] = this.getBackground(); //background color todo: delete this variable after figuring out how to draw stuff (and replace with just redrawing stuff when chaning the background)
        dataAboutCurrentObject[4] = sizeOfChosenTool; //tool atribute
        dataAboutCurrentObject[5] = typeOfChosenTool; //tool shape
        dataAboutCurrentObject[6] = ifCovering; //if true it means that the shape needs to change color accordingly to the background

        System.out.println("x:" + dataAboutCurrentObject[0] + " y: " + dataAboutCurrentObject[1] + " color: " + dataAboutCurrentObject[2] +
                " color of background: " + dataAboutCurrentObject[3] + " size: " + dataAboutCurrentObject[5] + " type: "
                + dataAboutCurrentObject[5] + " ifCovering: " + dataAboutCurrentObject[6]);

        this.repaint();
    }

    public static Object[] getDataAboutCurrentObject() {
        return dataAboutCurrentObject;
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }

    @Override
    public void update() {

    }
}
