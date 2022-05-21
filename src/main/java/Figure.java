import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Figure {

    private List<Line> lines;

    public Figure(List<Line> lines) {
        this.lines = lines;
    }


    public void paint(Graphics g, int xAngle) {
        Polygon polygon = createPolygon(xAngle);
        g.setColor(Color.green);
        g.fillPolygon(polygon);
        g.setColor(Color.white);
        for (Line line : lines) {
            line.paint(g, xAngle);
        }
    }

    private Polygon createPolygon(int angle) {
        Polygon polygon = new Polygon();
        for (Line line : lines.subList(0, 2)) {
            if (line.isVisible(angle)) {
                polygon.addPoint(line.getStartX(), line.getStartY());
                polygon.addPoint(line.getStopX(), line.getStopY());
            }
        }
        return polygon;
    }

    public ArrayList<Point> getFirstPoints(){
        ArrayList<Point> points = new ArrayList<>();
        points.add(lines.get(0).getA());
        points.add(lines.get(0).getB());
        points.add(lines.get(1).getA());
        points.add(lines.get(1).getB());

        return points;
    }
}
