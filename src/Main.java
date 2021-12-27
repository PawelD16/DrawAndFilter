import model.DrawablesCreator;
import view.MainFrame;

public class Main {

    public static void main(String[] args) {
        MainFrame mainFrame = new MainFrame();
        DrawablesCreator drawablesCreator = new DrawablesCreator();
        mainFrame.getPaintingPanel().setDrawablesManipulator(drawablesCreator);
        drawablesCreator.registerObserver(mainFrame.getPaintingPanel());
    }
}
