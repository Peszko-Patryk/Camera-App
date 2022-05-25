public enum Camera {
    ROTATE_DEGREE(Math.toRadians(0.5)),
    MOVE(0.4);

    double value;

    Camera(double v) {
        value = v;
    }
}
