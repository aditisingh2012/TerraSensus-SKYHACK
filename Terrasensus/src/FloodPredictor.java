import java.util.Calendar;
import java.util.Date;

public class FloodPredictor implements DisasterPredictor {
    public DisasterPrediction predict(Region region, SatelliteData data) {
        double floodRisk = calculateFloodRisk(data);
        SeverityLevel severity = determineFloodSeverity(floodRisk);
        
        DisasterPrediction prediction = new DisasterPrediction(
            DisasterType.FLOOD, region.getId(), floodRisk
        );
        prediction.setSeverity(severity);
        prediction.setPredictedDate(calculateFloodPredictionDate());
        prediction.setRecommendedActions("Prepare for potential flooding");
        
        return prediction;
    }
    
    private double calculateFloodRisk(SatelliteData data) {
        return Math.min(data.getRainfall() / 200.0, 0.8);
    }
    
    private SeverityLevel determineFloodSeverity(double riskScore) {
        if (riskScore >= 0.6) return SeverityLevel.CRITICAL;
        if (riskScore >= 0.4) return SeverityLevel.HIGH;
        return SeverityLevel.MEDIUM;
    }
    
    private Date calculateFloodPredictionDate() {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DAY_OF_WEEK, 2);
        return cal.getTime();
    }
    
    public DisasterType getSupportedDisasterType() {
        return DisasterType.FLOOD;
    }
}
