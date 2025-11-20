public interface DisasterPredictor {
    DisasterPrediction predict(Region region, SatelliteData data);
    DisasterType getSupportedDisasterType();
}