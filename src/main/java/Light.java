public enum Light {
    AMBIENT(0.4f),
    KD(0.75f),
    KS(0.25f),
    N(2),
    IP(0.5f),
    MAX(0.9f),
    MIN(0.15f);

    float value;

    Light(float v) {
        value = v;
    }
}
