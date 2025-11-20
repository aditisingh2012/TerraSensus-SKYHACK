import java.util.Date;
import java.util.UUID;

public class DisasterPrediction {
    private String predictionId;
    private DisasterType disasterType;
    private String regionId;
    private SeverityLevel severity;
    private double probability;
    private Date predictedDate;
    private String recommendedActions;
    
    public DisasterPrediction(DisasterType type, String regionId, double probability) {
        this.disasterType = type;
        this.regionId = regionId;
        this.probability = probability;
        this.predictionId = UUID.randomUUID().toString();
        this.predictedDate = new Date();
    }
    
    // Getters
    public String getPredictionId() { return predictionId; }
    public DisasterType getDisasterType() { return disasterType; }
    public String getRegionId() { return regionId; }
    public SeverityLevel getSeverity() { return severity; }
    public double getProbability() { return probability; }
    public Date getPredictedDate() { return predictedDate; }
    public String getRecommendedActions() { return recommendedActions; }
    
    // Setters
    public void setSeverity(SeverityLevel severity) { this.severity = severity; }
    public void setPredictedDate(Date predictedDate) { this.predictedDate = predictedDate; }
    public void setRecommendedActions(String recommendedActions) { this.recommendedActions = recommendedActions; }
}