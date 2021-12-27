
public class LatLng implements Serializable {

   @Column(name = "lat")
    private Double lat;

    @Column(name = "lng")
    private Double lng;

  
    public Double getLat() {
        return lat;
    }

    public void setLat(Double lat) {
        this.lat = lat;
    }

    public Double getLng() {
        return lng;
    }

    public void setLng(Double lng) {
        this.lng = lng;
    }

    @Override
    public String toString() {
        return "LatLng{" +
            "lat=" + lat +
            ", lng=" + lng +
            '}';
    }
}
