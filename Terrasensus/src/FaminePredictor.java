import java.util.Calendar;
import java.util.Date;

public class FaminePredictor implements DisasterPredictor {
    
    @Override
    public DisasterPrediction predict(Region region, SatelliteData data) {
        double riskScore = calculateFamineRisk(data);
        SeverityLevel severity = determineSeverity(riskScore);
        
        DisasterPrediction prediction = new DisasterPrediction(
            DisasterType.FAMINE, region.getId(), riskScore
        );
        prediction.setSeverity(severity);
        prediction.setPredictedDate(calculatePredictionDate());
        prediction.setRecommendedActions(generateRecommendations(severity));
        
        return prediction;
    }
    
    private double calculateFamineRisk(SatelliteData data) {
        double baseRisk = (1.0 - data.getSoilMoisture()) * 0.4;
        double vegetationRisk = (1.0 - data.getVegetationIndex()) * 0.3;
        double weatherRisk = (data.getTemperature() > 35 ? 0.2 : 0.0);
        double rainfallRisk = (data.getRainfall() < 50 ? 0.1 : 0.0);
        
        return Math.min(baseRisk + vegetationRisk + weatherRisk + rainfallRisk, 1.0);
    }
    
    private SeverityLevel determineSeverity(double riskScore) {
        if (riskScore >= 0.7) return SeverityLevel.CRITICAL;
        if (riskScore >= 0.5) return SeverityLevel.HIGH;
        if (riskScore >= 0.3) return SeverityLevel.MEDIUM;
        return SeverityLevel.LOW;
    }
    
    private Date calculatePredictionDate() {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.MONTH, 3);
        return cal.getTime();
    }
    
    private String generateRecommendations(SeverityLevel severity) {
        switch (severity) {
            case CRITICAL: return "IMMEDIATE ACTION: Deploy emergency food and water supplies";
            case HIGH: return "HIGH PRIORITY: Initiate water conservation programs";
            case MEDIUM: return "MONITOR: Educate farmers on water management";
            default: return "LOW RISK: Continue regular monitoring";
        }
    }
    
    @Override
    public DisasterType getSupportedDisasterType() {
        return DisasterType.FAMINE;
    }
}