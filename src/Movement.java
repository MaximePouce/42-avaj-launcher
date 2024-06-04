package src;

public class Movement {
    private int longitudeMovement;
    private int latitudeMovement;
    private int heightMovement;

    public Movement(int p_longitude, int p_latitude, int p_height) {
        this.longitudeMovement = p_longitude;
        this.latitudeMovement = p_latitude;
        this.heightMovement = p_height;
    }

    public int getLongitudeMovement() {
        return longitudeMovement;
    }

    public int getLatitudeMovement() {
        return latitudeMovement;
    }

    public int getHeightMovement() {
        return heightMovement;
    }
}