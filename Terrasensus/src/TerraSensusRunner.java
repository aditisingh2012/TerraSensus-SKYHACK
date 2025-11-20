public class TerraSensusRunner {
    public static void main(String[] args) {
        System.out.println("🌍 INITIALIZING TERRASENSUS MULTI-DISASTER PREDICTION SYSTEM");
        System.out.println("============================================================\n");
        
        TerraSensusApplication app = new TerraSensusApplication();
        
        // Run the main prediction cycle
        app.runDisasterPredictionCycle();
        
        // Show summary analysis
        app.showRegionalAnalysis();
        
        System.out.println("\n💡 DEMO FEATURES:");
        System.out.println("✅ Multi-disaster detection (Famine, Flood, Cyclone, Wildfire)");
        System.out.println("✅ Real-time satellite data analysis");
        System.out.println("✅ Risk probability scoring (0-100%)");
        System.out.println("✅ Severity level classification");
        System.out.println("✅ Regional threat assessment");
        System.out.println("✅ Early warning system");
    }
}