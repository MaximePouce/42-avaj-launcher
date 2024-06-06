package src;

public class WeatherProvider {
    // private instance, to ensure only one exists
    private static WeatherProvider instance;
    private String weather[] = {"FOG", "RAIN", "SNOW", "SUN"};

    // private constructor, prevent instantiation
    private WeatherProvider() {}

    public static WeatherProvider getInstance() {
        if (instance == null) {
            instance = new WeatherProvider();
        }
        return instance;
    }

    public String getCurrentWeather(Coordinates p_coordinates) {
        int longitude = p_coordinates.getLongitude();
        int latitude = p_coordinates.getLatitude();
        int height = p_coordinates.getHeight();
        int weatherIndex = (longitude % height) * (latitude % height) % weather.length;
        return weather[weatherIndex];
    }
}