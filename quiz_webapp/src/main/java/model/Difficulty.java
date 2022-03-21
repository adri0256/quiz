package model;

public enum Difficulty {
    EASY,
    NORMAL,
    HARD;

    public static Difficulty fromInteger(int x) {
        return switch (x) {
            case 0 -> EASY;
            case 1 -> NORMAL;
            case 2 -> HARD;
            default -> null;
        };
    }
}
