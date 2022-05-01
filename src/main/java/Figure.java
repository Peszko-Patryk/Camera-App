import java.awt.*;
import java.util.Comparator;
import java.util.List;

public class Figure {

    private List<Line> lines;

    public Figure(List<Line> lines) {
        this.lines = lines;
    }


    public void paint(Graphics g, int xAngle, int yAngle) {
        Polygon polygon = createPolygon(xAngle);
        g.setColor(Color.black);
        g.fillPolygon(polygon);
        g.setColor(Color.white);
        for (Line line : lines) {
            line.paint(g, xAngle);
        }
    }

    private Polygon createPolygon(int angle) {
        Polygon polygon = new Polygon();
        for (Line line : lines.subList(0,2)) {
            if (line.isVisible(angle)) {
                polygon.addPoint(line.getStartX(), line.getStartY());
                polygon.addPoint(line.getStopX(), line.getStopY());
            }
        }
        return polygon;
    }

    public double getDistance() {
        double x = 0, y = 0, z = 0;
        for (Line line : lines) {
            x += line.getA().getX() + line.getB().getX();
            y += line.getA().getY() + line.getB().getY();
            z += line.getA().getZ() + line.getB().getZ();
        }
        return Math.sqrt(Math.pow(x / lines.size(), 2) + Math.pow(y / lines.size(), 2) + Math.pow(z / lines.size(), 2));
    }
}
