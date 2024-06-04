package src;

public class Coordinates {
    private int longitude;
    private int latitude;
    private int height;

    // No specified access modifier = package-private
    Coordinates(int p_longitude, int p_latitude, int p_height) {
        longitude = p_longitude;
        latitude = p_latitude;
        height = p_height;
    }

    public int getLongitude() {
        return longitude;
    }

    public int getLatitude() {
        return latitude;
    }

    public int getHeight() {
        return height;
    }

    public void addLongitude(int value) {
        longitude = Math.max(0, longitude + value);
    }

    public void addLatitude(int value) {
        latitude = Math.max(0, latitude + value);
    }

    public void addHeight(int value) {
        height = Math.max(0, Math.min(100, height + value));
    }
}