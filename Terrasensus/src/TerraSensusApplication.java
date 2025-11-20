import java.util.*;

public class TerraSensusApplication {
    private PredictionEngine predictionEngine;
    private DataPipeline dataPipeline;
    private List<Region> monitoredRegions;
    
    public TerraSensusApplication() {
        this.predictionEngine = new PredictionEngine();
        this.dataPipeline = new DataPipeline();
        this.monitoredRegions = new ArrayList<>();
        
        // Initialize regions
        monitoredRegions.add(new Region("SAHEL_1", "Central Sahel", 13.0, 2.0, "Mali"));
        monitoredRegions.add(new Region("SAHEL_2", "Western Sahel", 14.0, -2.0, "Senegal"));
        monitoredRegions.add(new Region("SA_1", "South Asia Delta", 23.0, 90.0, "Bangladesh"));
        monitoredRegions.add(new Region("EU_1", "Southern Europe", 41.0, 12.0, "Italy"));
        monitoredRegions.add(new Region("AF_1", "East Africa", 1.0, 38.0, "Kenya"));
    }
    
    public void runDisasterPredictionCycle() {
        System.out.println("🛰️  COLLECTING SATELLITE DATA...");
        System.out.println("==========================================");
        
        for (Region region : monitoredRegions) {
            System.out.println("\n🔍 ANALYZING: " + region.getName() + ", " + region.getCountry());
            
            SatelliteData data = dataPipeline.generateSatelliteData(region);
            displayRegionData(data);
            
            List<DisasterPrediction> predictions = predictionEngine.analyzeRegion(region, data);
            displayPredictions(predictions);
        }
    }
    
    private void displayRegionData(SatelliteData data) {
        System.out.printf("   📊 Soil Moisture: %.1f%% | ", data.getSoilMoisture() * 100);
        System.out.printf("Vegetation: %.1f%% | ", data.getVegetationIndex() * 100);
        System.out.printf("Rain: %.1fmm%n", data.getRainfall());
    }
    
    private void displayPredictions(List<DisasterPrediction> predictions) {
        if (predictions.isEmpty()) {
            System.out.println("   ✅ No significant threats detected");
            return;
        }
        
        for (DisasterPrediction prediction : predictions) {
            String icon = getDisasterIcon(prediction.getDisasterType());
            String severityText = getSeverityText(prediction.getSeverity());
            System.out.printf("   %s %s: %.0f%% probability | %s%n",
                icon,
                prediction.getDisasterType(),
                prediction.getProbability() * 100,
                severityText);
        }
    }
    
    private String getDisasterIcon(DisasterType type) {
        switch (type) {
            case FAMINE: return "🌾";
            case FLOOD: return "🌊";
            case CYCLONE: return "🌀";
            case WILDFIRE: return "🔥";
            default: return "⚠️";
        }
    }
    
    private String getSeverityText(SeverityLevel severity) {
        switch (severity) {
            case CRITICAL: return "!!! CRITICAL !!!";
            case HIGH: return "** HIGH **";
            case MEDIUM: return "- MEDIUM -";
            case LOW: return "LOW";
            default: return "UNKNOWN";
        }
    }
    
    public void showRegionalAnalysis() {
        System.out.println("\n📈 REGIONAL RISK ANALYSIS SUMMARY");
        System.out.println("==========================================");
        
        for (Region region : monitoredRegions) {
            SatelliteData data = dataPipeline.generateSatelliteData(region);
            List<DisasterPrediction> predictions = predictionEngine.analyzeRegion(region, data);
            
            System.out.printf("\n📍 %s (%s)%n", region.getName(), region.getCountry());
            
            if (predictions.isEmpty()) {
                System.out.println("   ✅ LOW RISK - No immediate threats");
            } else {
                DisasterPrediction highestRisk = predictions.get(0);
                String severityIndicator = getSeverityIndicator(highestRisk.getSeverity());
                System.out.printf("   %s PRIMARY RISK: %s (%.0f%%)%n",
                    severityIndicator,
                    highestRisk.getDisasterType(),
                    highestRisk.getProbability() * 100);
            }
        }
        
        System.out.println("\n🚀 SYSTEM READY FOR DEPLOYMENT");
    }
    
    private String getSeverityIndicator(SeverityLevel severity) {
        switch (severity) {
            case CRITICAL: return "[CRITICAL]";
            case HIGH: return "[HIGH]";
            case MEDIUM: return "[MEDIUM]";
            case LOW: return "[LOW]";
            default: return "[UNKNOWN]";
        }
    }
}