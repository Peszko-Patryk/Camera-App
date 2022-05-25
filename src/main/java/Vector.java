public class Vector extends Line {

    public static final double AMBIENT_LIGHT = 0.05;
    private double x;
    private double y;
    private double z;

    public Vector(Point point, Point point1) {
        super(point, point1);
        x = point1.getX() - point.getX();
        y = point1.getY() - point.getY();
        z = point1.getZ() - point.getZ();
    }

    // iloczyn skalarny
    public static double dot(Vector v1, Vector v2) {
        return v1.x * v2.x + v1.y * v2.y + v1.z * v2.z;
    }

    // iloczyn wektorowy
    public static Vector cross(Vector v1, Vector v2) {
        return new Vector(new Point(0, 0, 0), new Point((float) (v1.y * v2.z - v1.z * v2.y),
                (float) (v1.z * v2.x - v1.x * v2.z), (float) (v1.x * v2.y - v1.y * v2.x)));
    }

    public static Vector normalize(Vector v) {
        double magnitude = Math.sqrt(v.x * v.x + v.y * v.y + v.z * v.z);
        return new Vector(new Point(0, 0, 0), new Point((float) (v.x / magnitude), (float) (v.y / magnitude), (float) (v.z / magnitude)));
    }

    public void update() {
        x = this.getB().getX() - this.getA().getX();
        y = this.getB().getY() - this.getA().getY();
        z = this.getB().getZ() - this.getA().getZ();
    }
}
