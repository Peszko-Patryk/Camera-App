import java.awt.*;
import java.util.ArrayList;

public class Observer extends Point {

    private final ArrayList<Line> lines;
    private ArrayList<Figure> figures;
    private Vector lightVector;
    private int xAngle = 90;
    private int yAngle = 90;

    public Observer(float x, float y, float z, ArrayList<Line> lines, ArrayList<Figure> figures) {
        super(x, y, z);
        this.lines = lines;
        lightVector = Vector.normalize(new Vector(new Point(0,0,0), new Point(1,2,3)));
        this.figures = figures;
    }

    public void paint(Graphics g) {
        figures.sort(new FiguresSort());
        for (Figure figure : figures) {
            figure.paint(g, xAngle, lightVector);
        }
    }

    public void linesDown() {
        for (Line line : lines) {
            line.moveDown();
        }
    }

    public void linesUp() {
        for (Line line : lines) {
            line.moveUp();
        }
    }

    public void linesRight() {
        for (Line line : lines) {
            line.moveRight();
        }
    }

    public void linesLeft() {
        for (Line line : lines) {
            line.moveLeft();
        }
    }

    public void zoomOut() {
        if (xAngle < 150 && yAngle < 150) {
            xAngle += 2;
            yAngle += 2;
        }
    }

    public void zoomIn() {
        if (xAngle > 20 && yAngle > 20) {
            xAngle -= 2;
            yAngle -= 2;
        }
    }

    public void turnLeftZ() {
        for (Line line : lines) {
            line.rotateLeftZ();
        }
        lightVector.rotateLeftZ();
        lightVector.update();
    }

    public void turnRightZ() {
        for (Line line : lines) {
            line.rotateRightZ();
        }
        lightVector.rotateRightZ();
        lightVector.update();
    }

    public void turnLeftY() {
        for (Line line : lines) {
            line.rotateLeftY();
        }
        lightVector.rotateLeftY();
        lightVector.update();
    }

    public void turnRightY() {
        for (Line line : lines) {
            line.rotateRightY();
        }
        lightVector.rotateRightY();
        lightVector.update();
    }

    public void turnUpX() {
        for (Line line : lines) {
            line.rotateUpX();
        }
        lightVector.rotateUpX();
        lightVector.update();
    }

    public void turnDownX() {
        for (Line line : lines) {
            line.rotateDownX();
        }
        lightVector.rotateDownX();
        lightVector.update();
    }

    public void linesBackward() {
        for (Line line : lines) {
            line.moveBackward();
        }
    }

    public void linesForward() {
        for (Line line : lines) {
            line.moveForward();
        }
    }
}