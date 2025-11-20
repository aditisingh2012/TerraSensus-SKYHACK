import java.util.Random;

public class DataPipeline {
    private Random random = new Random();
    
    public SatelliteData generateSatelliteData(Region region) {
        SatelliteData data = new SatelliteData(region.getId());
        
        if (region.getName().contains("Sahel")) {
            // Dry region - high famine risk
            data.setSoilMoisture(random.nextDouble() * 0.3 + 0.1); // 10-40%
            data.setVegetationIndex(random.nextDouble() * 0.4 + 0.2); // 20-60%
            data.setTemperature(random.nextDouble() * 15 + 30); // 30-45°C
            data.setRainfall(random.nextDouble() * 50); // 0-50mm
        } else if (region.getName().contains("Asia")) {
            // Flood-prone region
            data.setSoilMoisture(random.nextDouble() * 0.4 + 0.5); // 50-90%
            data.setVegetationIndex(random.nextDouble() * 0.3 + 0.6); // 60-90%
            data.setTemperature(random.nextDouble() * 10 + 25); // 25-35°C
            data.setRainfall(random.nextDouble() * 200 + 50); // 50-250mm
        } else if (region.getName().contains("Europe")) {
            // Moderate climate
            data.setSoilMoisture(random.nextDouble() * 0.4 + 0.3); // 30-70%
            data.setVegetationIndex(random.nextDouble() * 0.4 + 0.4); // 40-80%
            data.setTemperature(random.nextDouble() * 20 + 15); // 15-35°C
            data.setRainfall(random.nextDouble() * 100 + 30); // 30-130mm
        } else {
            // Default - Africa
            data.setSoilMoisture(random.nextDouble() * 0.5 + 0.2); // 20-70%
            data.setVegetationIndex(random.nextDouble() * 0.5 + 0.3); // 30-80%
            data.setTemperature(random.nextDouble() * 15 + 25); // 25-40°C
            data.setRainfall(random.nextDouble() * 100); // 0-100mm
        }
        
        data.setWindSpeed(random.nextDouble() * 30 + 5); // 5-35 km/h
        
        return data;
    }
}