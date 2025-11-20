public class Region {
    private String id;
    private String name;
    private double latitude;
    private double longitude;
    private String country;
    
    public Region(String id, String name, double lat, double lon, String country) {
        this.id = id;
        this.name = name;
        this.latitude = lat;
        this.longitude = lon;
        this.country = country;
    }
    
    public String getId() { return id; }
    public String getName() { return name; }
    public double getLatitude() { return latitude; }
    public double getLongitude() { return longitude; }
    public String getCountry() { return country; }
}