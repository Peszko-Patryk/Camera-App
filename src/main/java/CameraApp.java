import javax.swing.*;
import java.util.ArrayList;

public class CameraApp {

    public static void main(String[] args) {
        FileReader fr = new FileReader(args[0]);
        ArrayList<Line> lines = fr.getLines();
        ArrayList<Figure> figures = fr.getFigures();
        Observer observer = new Observer(0, 0, 0, lines, figures);

        JFrame frame = new JFrame();
        Graphic graphic = new Graphic();
        graphic.setObserver(observer);
        frame.addKeyListener(new KeyOperations(observer));
        frame.setSize(1200, 700);
        frame.setLocationRelativeTo(null);
        frame.setTitle("Camera App");
        frame.setResizable(false);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(graphic);
    }
}
