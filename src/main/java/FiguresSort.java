import java.util.ArrayList;
import java.util.Comparator;

public class FiguresSort implements Comparator<Figure> {

    @Override
    public int compare(Figure figure1, Figure figure2) {
        return findWhichIsFirst(figure1, figure2);
    }

    private int findWhichIsFirst(Figure figure1, Figure figure2) {
        ArrayList<Point> points = figure1.getFirstPoints();
        Point p1 = points.get(0);
        Point p2 = points.get(1);
        Point p3 = points.get(2);

        double x = (p2.getY() - p1.getY()) * (p3.getZ() - p1.getZ()) - (p2.getZ() - p1.getZ()) * (p3.getY() - p1.getY());
        double y = (p2.getZ() - p1.getZ()) * (p3.getX() - p1.getX()) - (p2.getX() - p1.getX()) * (p3.getZ() - p1.getZ());
        double z = (p2.getX() - p1.getX()) * (p3.getY() - p1.getY()) - (p2.getY() - p1.getY()) * (p3.getX() - p1.getX());
        double d = -x * p1.getX() - y * p1.getY() - z * p1.getZ();

        ArrayList<Point> pointsToCheck = figure2.getFirstPoints();
        Point firstPoint = pointsToCheck.get(0);
        double result = firstPoint.getX() * x + firstPoint.getY() * y + firstPoint.getZ() * z + d;
        for (int i = 1; i < pointsToCheck.size() - 1; i++) {
            Point point = pointsToCheck.get(i);
            double nextResult = point.getX() * x + point.getY() * y + point.getZ() * z + d;
            if (nextResult * result < 0) {
                return findWhichIsFirst(figure2, figure1);
            }
        }
        return (int) (-d * result);
    }
}
