package view.choiceAssistant;

import javax.swing.*;
import java.awt.*;

public class FilteringToolPropertiesChoice extends ToolChoiceFrame {

    private boolean ifAppliedToEntireImage = true;
    private int chosenFilterType = 1;
    private final JRadioButton brightenRadioButton; //type 1
    private final JRadioButton darkenRadioButton; //type 2
    private final JRadioButton grayScaleRadioButton; //type 3
    private final JRadioButton invertedColorsRadioButton; //type 4
    private final JRadioButton sepiaRadioButton; //type 5
    private final JRadioButton onlyRedRadioButton; //type 6
    private final JRadioButton onlyGreenRadioButton; //type 7
    private final JRadioButton onlyBlueRadioButton; //type 8
    private final JRadioButton boxBlurRadioButton; //type 9
    private final JRadioButton sobelEdgeDetectionRadioButton; //type 10
    private final JRadioButton robertsCrossEdgeDetectionRadioButton; //type 11
    private final JRadioButton laplacianEdgeDetectionRadioButton; //type 12
    private final JRadioButton scharrEdgeDetectionRadioButton; //type 13

    private final JRadioButton entireImageRadioButton;
    private final JRadioButton selectedSizeRadioButton;


    public FilteringToolPropertiesChoice() {
        super();

        this.setTitle("Choose a filtering tool");
        this.setSize(new Dimension(WIDTH+600, HEIGHT-100));

        brightenRadioButton = new JRadioButton("Brighten");
        darkenRadioButton = new JRadioButton("Darken");
        grayScaleRadioButton = new JRadioButton("Gray scale");
        invertedColorsRadioButton = new JRadioButton("Invert colors");
        sepiaRadioButton = new JRadioButton("Sepia");
        onlyRedRadioButton = new JRadioButton("Only red");
        onlyGreenRadioButton = new JRadioButton("Only green");
        onlyBlueRadioButton = new JRadioButton("Only blue");
        boxBlurRadioButton = new JRadioButton("Box blur");
        sobelEdgeDetectionRadioButton = new JRadioButton("Sobel edge detection");
        robertsCrossEdgeDetectionRadioButton = new JRadioButton("Roberts cross edge detection");
        laplacianEdgeDetectionRadioButton = new JRadioButton("Laplacian edge detection");
        scharrEdgeDetectionRadioButton = new JRadioButton("Scharr edge detection");

        entireImageRadioButton = new JRadioButton("Apply to entire picture");
        selectedSizeRadioButton = new JRadioButton("Apply according to tool size");

        brightenRadioButton.setSelected(true);
        entireImageRadioButton.setSelected(true);

        brightenRadioButton.addActionListener(e -> {
            this.allFilteringJRadioButtonsToFalse();
            brightenRadioButton.setSelected(true);
            chosenFilterType = 1;
        });

        darkenRadioButton.addActionListener(e -> {
            this.allFilteringJRadioButtonsToFalse();
            darkenRadioButton.setSelected(true);
            chosenFilterType = 2;
        });

        grayScaleRadioButton.addActionListener(e -> {
            this.allFilteringJRadioButtonsToFalse();
            grayScaleRadioButton.setSelected(true);
            chosenFilterType = 3;
        });

        invertedColorsRadioButton.addActionListener(e -> {
            this.allFilteringJRadioButtonsToFalse();
            invertedColorsRadioButton.setSelected(true);
            chosenFilterType = 4;
        });

        sepiaRadioButton.addActionListener(e -> {
            this.allFilteringJRadioButtonsToFalse();
            sepiaRadioButton.setSelected(true);
            chosenFilterType = 5;
        });

        onlyRedRadioButton.addActionListener(e -> {
            this.allFilteringJRadioButtonsToFalse();
            onlyRedRadioButton.setSelected(true);
            chosenFilterType = 6;
        });

        onlyGreenRadioButton.addActionListener(e -> {
            this.allFilteringJRadioButtonsToFalse();
            onlyGreenRadioButton.setSelected(true);
            chosenFilterType = 7;
        });

        onlyBlueRadioButton.addActionListener(e -> {
            this.allFilteringJRadioButtonsToFalse();
            onlyBlueRadioButton.setSelected(true);
            chosenFilterType = 8;
        });

        boxBlurRadioButton.addActionListener(e -> {
            this.allFilteringJRadioButtonsToFalse();
            boxBlurRadioButton.setSelected(true);
            chosenFilterType = 9;
        });

        sobelEdgeDetectionRadioButton.addActionListener(e -> {
            this.allFilteringJRadioButtonsToFalse();
            sobelEdgeDetectionRadioButton.setSelected(true);
            chosenFilterType = 10;
        });

        robertsCrossEdgeDetectionRadioButton.addActionListener(e -> {
            this.allFilteringJRadioButtonsToFalse();
            robertsCrossEdgeDetectionRadioButton.setSelected(true);
            chosenFilterType = 11;
        });

        laplacianEdgeDetectionRadioButton.addActionListener(e -> {
            this.allFilteringJRadioButtonsToFalse();
            laplacianEdgeDetectionRadioButton.setSelected(true);
            chosenFilterType = 12;
        });

        scharrEdgeDetectionRadioButton.addActionListener(e -> {
            this.allFilteringJRadioButtonsToFalse();
            scharrEdgeDetectionRadioButton.setSelected(true);
            chosenFilterType = 13;
        });

        entireImageRadioButton.addActionListener(e -> {
            entireImageRadioButton.setSelected(true);
            selectedSizeRadioButton.setSelected(false);
            ifAppliedToEntireImage = true;
        });

        selectedSizeRadioButton.addActionListener(e -> {
            selectedSizeRadioButton.setSelected(true);
            entireImageRadioButton.setSelected(false);
            ifAppliedToEntireImage = false;
        });

        okButton.addActionListener(e -> {
            this.setVisibility();
            this.informOfFilterChange();
        });

        topPanel.add(chooseToolAttributeInfo);
        topPanel.add(toolAttriuteSlider);

        middlePanel.add(brightenRadioButton);
        middlePanel.add(darkenRadioButton);
        middlePanel.add(grayScaleRadioButton);
        middlePanel.add(invertedColorsRadioButton);
        middlePanel.add(sepiaRadioButton);
        middlePanel.add(onlyRedRadioButton);
        middlePanel.add(onlyGreenRadioButton);
        middlePanel.add(onlyBlueRadioButton);
        middlePanel.add(boxBlurRadioButton);
        middlePanel.add(sobelEdgeDetectionRadioButton);
        middlePanel.add(robertsCrossEdgeDetectionRadioButton);
        middlePanel.add(laplacianEdgeDetectionRadioButton);
        middlePanel.add(scharrEdgeDetectionRadioButton);

        bottomPanel.add(entireImageRadioButton);
        bottomPanel.add(selectedSizeRadioButton);
        bottomPanel.add(okButton);

        this.add(topPanel);
        this.add(middlePanel);
        this.add(bottomPanel);
        //this.pack();
    }

    private void allFilteringJRadioButtonsToFalse() {
        brightenRadioButton.setSelected(false);
        darkenRadioButton.setSelected(false);
        grayScaleRadioButton.setSelected(false);
        invertedColorsRadioButton.setSelected(false);
        sepiaRadioButton.setSelected(false);
        onlyRedRadioButton.setSelected(false);
        onlyGreenRadioButton.setSelected(false);
        onlyBlueRadioButton.setSelected(false);
        boxBlurRadioButton.setSelected(false);
        sobelEdgeDetectionRadioButton.setSelected(false);
        robertsCrossEdgeDetectionRadioButton.setSelected(false);
        laplacianEdgeDetectionRadioButton.setSelected(false);
        scharrEdgeDetectionRadioButton.setSelected(false);
    }

    public void informOfFilterChange() {
        toolGatherer.changeFilter();
    }

    public int[] getFilter() {
        return new int[]{toolAttriuteSlider.getValue(), chosenFilterType};
    }

    public boolean getIfAppliedToEntireImage() {
        return ifAppliedToEntireImage;
    }
}
