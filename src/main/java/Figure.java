import java.awt.*;
import java.util.List;

public class Figure {

    private final List<Line> lines;
    private final Color BASE_COLOR = new Color(18, 240, 168);
    private Color lighteningColor;

    public Figure(List<Line> lines) {
        this.lines = lines;
    }


    public void paint(Graphics g, int xAngle, Vector lightVector) {
        Polygon polygon = createPolygon(xAngle);
        updateColor(lightVector);
        g.setColor(lighteningColor);
        g.fillPolygon(polygon);
//        g.setColor(Color.white);
//        for (Line line : lines) {
//            line.paint(g, xAngle);
//        }
    }

    private void updateColor(Vector light) {
        Vector v1 = new Vector(lines.get(0).getB(), lines.get(0).getA());
        Vector v2 = new Vector(lines.get(0).getB(), lines.get(1).getA());
        Vector normal = Vector.normalize(Vector.cross(v1, v2));
        double dot = Vector.dot(normal, light);
        double sign = dot < 0 ? -1 : 1;
        dot = sign * dot * dot;
        dot = (dot + 1) / 2 * Light.MAX.value;
        double lightRatio = Math.min(1, Math.max(0, Light.AMBIENT.value) + dot);
        lighteningColor = new Color((int) (BASE_COLOR.getRed() * lightRatio), (int) (BASE_COLOR.getGreen() * lightRatio)
                , (int) (BASE_COLOR.getBlue() * lightRatio));
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
