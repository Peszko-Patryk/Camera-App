import java.awt.*;

import static java.lang.Math.*;

public class Line {

    private Point a;
    private Point b;
    private final float move = 0.4f;
    private final double rotate = Math.toRadians(0.5);
    private int startX, stopX, startY, stopY;

    public Line(Point a, Point b) {
        this.a = a;
        this.b = b;
    }

    public void paint(Graphics g, int angle) {
        if (isVisible(angle)) {
            g.drawLine(startX, startY, stopX, stopY);
        }
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
        a.setY(a.getY() - move);
        b.setY(b.getY() - move);
    }

    public void moveUp() {
        a.setY(a.getY() + move);
        b.setY(b.getY() + move);
    }

    public void moveRight() {
        a.setX(a.getX() + move);
        b.setX(b.getX() + move);
    }

    public void moveLeft() {
        a.setX(a.getX() - move);
        b.setX(b.getX() - move);
    }

    public void rotateLeftZ() {
        rotateZ(a, rotate);
        rotateZ(b, rotate);
    }

    public void rotateRightZ() {
        rotateZ(a, -rotate);
        rotateZ(b, -rotate);
    }

    private void rotateZ(Point p, double rotateAngle) {
        float oldX = p.getX();
        float oldY = p.getY();
        p.setX((float) (oldX * cos(rotateAngle) - oldY * sin(rotateAngle)));
        p.setY((float) (oldX * sin(rotateAngle) + oldY * cos(rotateAngle)));
    }

    public void rotateLeftY() {
        rotateY(a, rotate);
        rotateY(b, rotate);
    }

    public void rotateRightY() {
        rotateY(a, -rotate);
        rotateY(b, -rotate);
    }

    private void rotateY(Point p, double rotateAngle) {
        float oldX = p.getX();
        float oldZ = p.getZ();
        p.setX((float) (oldX * cos(rotateAngle) - oldZ * sin(rotateAngle)));
        p.setZ((float) (oldX * sin(rotateAngle) + oldZ * cos(rotateAngle)));
    }

    public void rotateUpX() {
        rotateX(a, -rotate);
        rotateX(b, -rotate);
    }

    public void rotateDownX() {
        rotateX(a, rotate);
        rotateX(b, rotate);
    }

    private void rotateX(Point p, double rotateAngle) {
        float oldY = p.getY();
        float oldZ = p.getZ();
        p.setY((float) (oldY * cos(rotateAngle) - oldZ * sin(rotateAngle)));
        p.setZ((float) (oldY * sin(rotateAngle) + oldZ * cos(rotateAngle)));
    }

    public void moveBackward() {
        a.setZ(a.getZ() - move);
        b.setZ(b.getZ() - move);
    }

    public void moveForward() {
        a.setZ(a.getZ() + move);
        b.setZ(b.getZ() + move);
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

    public void setA(Point a) {
        this.a = a;
    }

    public void setB(Point b) {
        this.b = b;
    }
}
