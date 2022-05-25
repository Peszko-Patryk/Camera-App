import static java.lang.Math.*;

public class Line {

    private final Point a;
    private final Point b;
    private int startX, stopX, startY, stopY;

    public Line(Point a, Point b) {
        this.a = a;
        this.b = b;
    }

    public boolean isVisible(int angle) {
        double xTan = tan(Math.toRadians(angle / 2.0));
        double yTan = tan(Math.toRadians(angle / 2.0));

        if (a.getZ() > 0 && b.getZ() > 0) {
            startX = (int) ((500 * a.getX()) / (a.getZ() * xTan)) + 500;
            startY = (int) -((500 * a.getY()) / (a.getZ() * yTan)) + 350;
            stopX = (int) ((500 * b.getX()) / (b.getZ() * xTan)) + 500;
            stopY = (int) -((500 * b.getY()) / (b.getZ() * yTan)) + 350;
        } else if (a.getZ() > 0 || b.getZ() > 0) {
            if (a.getZ() > 0) {
                if (pointInSight(a, angle, angle)) {
                    startX = (int) ((500 * a.getX()) / (a.getZ() * xTan)) + 500;
                    startY = (int) -((500 * a.getY()) / (a.getZ() * yTan)) + 350;
                    stopX = (int) ((500 * b.getX()) / xTan) + 500;
                    stopY = (int) -((500 * b.getY()) / yTan) + 350;
                } else {
                    return false;
                }
            } else {
                if (pointInSight(b, angle, angle)) {
                    startX = (int) ((500 * a.getX()) / (1 * xTan)) + 500;
                    startY = (int) -((500 * a.getY()) / (1 * yTan)) + 350;
                    stopX = (int) ((500 * b.getX()) / (b.getZ() * xTan)) + 500;
                    stopY = (int) -((500 * b.getY()) / (b.getZ() * yTan)) + 350;
                } else {
                    return false;
                }
            }
        } else {
            return false;
        }
        return true;
    }

    private boolean pointInSight(Point a, int xAngle, int yAngle) {
        boolean xInView = tan(Math.abs(a.getX()) / a.getZ()) < xAngle / 2.;
        boolean yInView = tan(Math.abs(a.getY()) / a.getZ()) < yAngle / 2.;
        return xInView && yInView;
    }

    public void moveDown() {
        a.setY((a.getY() - Camera.MOVE.value));
        b.setY(b.getY() - Camera.MOVE.value);
    }

    public void moveUp() {
        a.setY(a.getY() + Camera.MOVE.value);
        b.setY(b.getY() + Camera.MOVE.value);
    }

    public void moveRight() {
        a.setX(a.getX() + Camera.MOVE.value);
        b.setX(b.getX() + Camera.MOVE.value);
    }

    public void moveLeft() {
        a.setX(a.getX() - Camera.MOVE.value);
        b.setX(b.getX() - Camera.MOVE.value);
    }

    public void rotateLeftZ() {
        rotateZ(a, Camera.ROTATE_DEGREE.value);
        rotateZ(b, Camera.ROTATE_DEGREE.value);
    }

    public void rotateRightZ() {
        rotateZ(a, -Camera.ROTATE_DEGREE.value);
        rotateZ(b, -Camera.ROTATE_DEGREE.value);
    }

    private void rotateZ(Point p, double rotateAngle) {
        double oldX = p.getX();
        double oldY = p.getY();
        p.setX((float) (oldX * cos(rotateAngle) - oldY * sin(rotateAngle)));
        p.setY((float) (oldX * sin(rotateAngle) + oldY * cos(rotateAngle)));
    }

    public void rotateLeftY() {
        rotateY(a, Camera.ROTATE_DEGREE.value);
        rotateY(b, Camera.ROTATE_DEGREE.value);
    }

    public void rotateRightY() {
        rotateY(a, -Camera.ROTATE_DEGREE.value);
        rotateY(b, -Camera.ROTATE_DEGREE.value);
    }

    private void rotateY(Point p, double rotateAngle) {
        double oldX = p.getX();
        double oldZ = p.getZ();
        p.setX((float) (oldX * cos(rotateAngle) - oldZ * sin(rotateAngle)));
        p.setZ((float) (oldX * sin(rotateAngle) + oldZ * cos(rotateAngle)));
    }

    public void rotateUpX() {
        rotateX(a, -Camera.ROTATE_DEGREE.value);
        rotateX(b, -Camera.ROTATE_DEGREE.value);
    }

    public void rotateDownX() {
        rotateX(a, Camera.ROTATE_DEGREE.value);
        rotateX(b, Camera.ROTATE_DEGREE.value);
    }

    private void rotateX(Point p, double rotateAngle) {
        double oldY = p.getY();
        double oldZ = p.getZ();
        p.setY((float) (oldY * cos(rotateAngle) - oldZ * sin(rotateAngle)));
        p.setZ((float) (oldY * sin(rotateAngle) + oldZ * cos(rotateAngle)));
    }

    public void moveBackward() {
        a.setZ(a.getZ() - Camera.MOVE.value);
        b.setZ(b.getZ() - Camera.MOVE.value);
    }

    public void moveForward() {
        a.setZ(a.getZ() + Camera.MOVE.value);
        b.setZ(b.getZ() + Camera.MOVE.value);
    }

    public Point getA() {
        return a;
    }

    public Point getB() {
        return b;
    }

    public int getStartX() {
        return startX;
    }

    public int getStopX() {
        return stopX;
    }

    public int getStartY() {
        return startY;
    }

    public int getStopY() {
        return stopY;
    }
}
