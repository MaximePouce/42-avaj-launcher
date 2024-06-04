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

    public String getCurrentWeather(Coordinates p_coordinates){
        return "SUN";
    }
}