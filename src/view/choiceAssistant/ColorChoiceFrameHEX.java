package view.choiceAssistant;

import javax.swing.*;
import java.awt.*;

public class ColorChoiceFrameHEX extends ColorChoiceFrame {

    private final JTextField colorValueInput;
    private final JLabel initialInfo;
    private final JLabel adequateInfo;
    private final JButton checkButton;
    private final JPanel middlePanel;
    private final JPanel bottomPanel;

    public ColorChoiceFrameHEX() {
        super();

        this.setLayout(new BoxLayout(this.getContentPane(), BoxLayout.Y_AXIS));
        bottomPanel = new JPanel();
        middlePanel = new JPanel();

        colorValueInput = new JTextField("FFFFFF", 6);
        colorValueInput.setFont(new Font("Arial", Font.BOLD, 30));

        initialInfo = new JLabel("Enter HEX value of desired color");
        adequateInfo = new JLabel();

        okButton.setVisible(false);
        checkButton = new JButton("Check");
        checkButton.addActionListener(e -> {

            if (colorValueInput.getText().length() == 6) {

                if (checkIfValueIsCorrect(colorValueInput.getText().toUpperCase())) {
                    changeColorOfPreviewLabel();
                    okButton.setVisible(true);
                    chosenColor = Color.decode("#" + colorValueInput.getText().toUpperCase());
                    adequateInfo.setText("<html>Value is correct!<br>Press OK to set the color<html>");
                } else adequateInfo.setText("<html>Incorrect input value!<br>Please try again!<html>");
            } else adequateInfo.setText("<html>Incorrect number of characters!<br>Please try again<html>");
        });

        chooseColorPanel.add(initialInfo); //used as top panel
        chooseColorPanel.add(colorValueInput);
        chooseColorPanel.add(colorPreviewLabel);
        chooseColorPanel.add(checkButton);
        middlePanel.add(adequateInfo);
        bottomPanel.add(okButton);

        this.add(chooseColorPanel);
        this.add(middlePanel);
        this.add(bottomPanel);
    }

    public boolean checkIfValueIsCorrect(String string) {
        int checker = 0;
        char[] charOfString = string.toCharArray();

        char[] possibleValues = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
        for (int i = 0; i < charOfString.length; i++) {
            for (int j = 0; j < possibleValues.length; j++) {
                if (charOfString[i] == possibleValues[j]) checker++;
            }
        }

        if (checker == string.length()) return true;
        else return false;
    }

    @Override
    public void informOfColorChange() {
        okButton.setVisible(false);
        adequateInfo.setText("");
        colorGatherer.changeColor();
    }

    @Override
    public void setChosenColor(Color chosenColor) {
        super.setChosenColor(chosenColor);
        colorValueInput.setText(String.format("%02X%02X%02X", chosenColor.getRed(), chosenColor.getGreen(), chosenColor.getBlue()));
        checkButton.doClick();
    }

    @Override
    protected void changeColorOfPreviewLabel() {
        colorPreviewLabel.setBackground(Color.decode("#" + colorValueInput.getText().toUpperCase()));
        super.changeColorOfPreviewLabel();
    }
}
