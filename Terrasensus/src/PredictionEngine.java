import java.util.*;

public class PredictionEngine {
    private Map<DisasterType, DisasterPredictor> predictors;
    
    public PredictionEngine() {
        this.predictors = new HashMap<>();
        predictors.put(DisasterType.FAMINE, new FaminePredictor());
        predictors.put(DisasterType.FLOOD, new FloodPredictor());
    }
    
    public List<DisasterPrediction> analyzeRegion(Region region, SatelliteData data) {
        List<DisasterPrediction> predictions = new ArrayList<>();
        
        for (DisasterPredictor predictor : predictors.values()) {
            DisasterPrediction prediction = predictor.predict(region, data);
            if (prediction.getProbability() > 0.2) {
                predictions.add(prediction);
            }
        }
        
        predictions.sort((p1, p2) -> Double.compare(p2.getProbability(), p1.getProbability()));
        return predictions;
    }
}