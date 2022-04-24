import java.awt.*;

import static java.lang.Math.*;

public class Line {

    private Point a;
    private Point b;
    private final float move = 0.4f;
    private final double rotate = Math.toRadians(0.5);

    public Line(Point a, Point b) {
        this.a = a;
        this.b = b;
    }

    public void paint(Graphics g, int xAngle, int yAngle) {
        double aX, aY, bX, bY;
        double xTan = tan(Math.toRadians(xAngle / 2.0));
        double yTan = tan(Math.toRadians(yAngle / 2.0));

        if (a.getZ() > 0 && b.getZ() > 0) {
            aX = (500 * a.getX()) / (a.getZ() * xTan);
            aY = (500 * a.getY()) / (a.getZ() * yTan);
            bX = (500 * b.getX()) / (b.getZ() * xTan);
            bY = (500 * b.getY()) / (b.getZ() * yTan);
        } else if (a.getZ() > 0 || b.getZ() > 0) {
            if (a.getZ() > 0) {
                if (pointInSight(a, xAngle, yAngle)) {
                    aX = (500 * a.getX()) / (a.getZ() * xTan);
                    aY = (500 * a.getY()) / (a.getZ() * yTan);
                    bX = (500 * b.getX()) / xTan;
                    bY = (500 * b.getY()) / yTan;
                } else {
                    return;
                }
            } else {
                if (pointInSight(b, xAngle, yAngle)) {
                    aX = (500 * a.getX()) / (1 * xTan);
                    aY = (500 * a.getY()) / (1 * yTan);
                    bX = (500 * b.getX()) / (b.getZ() * xTan);
                    bY = (500 * b.getY()) / (b.getZ() * yTan);
                } else {
                    return;
                }
            }
        } else {
            return;
        }
        g.drawLine((int) aX + 500, (int) -aY + 350, (int) bX + 500, (int) -bY + 350);
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
}
