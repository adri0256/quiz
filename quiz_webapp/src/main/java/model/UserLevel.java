package model;

public enum UserLevel {
    GUEST,
    USER,
    ORGANIZER,
    ADMIN;

    public static UserLevel fromInteger(int x) {
        return switch (x) {
            case 0 -> GUEST;
            case 1 -> USER;
            case 2 -> ORGANIZER;
            case 3 -> ADMIN;
            default -> null;
        };
    }
}
