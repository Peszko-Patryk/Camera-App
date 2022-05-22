public enum Light {
    AMBIENT(0.05f),
    MAX(0.8f);

    float value;

    Light(float v) {
        value = v;
    }
}
