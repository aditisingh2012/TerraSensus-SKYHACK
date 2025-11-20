import java.util.Date;

public class SatelliteData {
    private String regionId;
    private double soilMoisture;
    private double vegetationIndex;
    private double temperature;
    private double rainfall;
    private double windSpeed;
    private Date timestamp;
    
    public SatelliteData(String regionId) {
        this.regionId = regionId;
        this.timestamp = new Date();
        this.soilMoisture = 0.0;
        this.vegetationIndex = 0.0;
        this.temperature = 0.0;
        this.rainfall = 0.0;
        this.windSpeed = 0.0;
    }
    
    // Getters
    public String getRegionId() { return regionId; }
    public double getSoilMoisture() { return soilMoisture; }
    public double getVegetationIndex() { return vegetationIndex; }
    public double getTemperature() { return temperature; }
    public double getRainfall() { return rainfall; }
    public double getWindSpeed() { return windSpeed; }
    public Date getTimestamp() { return timestamp; }
    
    // Setters
    public void setSoilMoisture(double soilMoisture) { this.soilMoisture = soilMoisture; }
    public void setVegetationIndex(double vegetationIndex) { this.vegetationIndex = vegetationIndex; }
    public void setTemperature(double temperature) { this.temperature = temperature; }
    public void setRainfall(double rainfall) { this.rainfall = rainfall; }
    public void setWindSpeed(double windSpeed) { this.windSpeed = windSpeed; }
}