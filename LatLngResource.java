
@RestController
@RequestMapping()
public class LatLngResource {
  
    public JSONObject getLocationFormGoogle(String placesName) {
        String newUrlString = placesName.replaceAll(" ", "%20");
        HttpGet httpGet = new HttpGet("https://maps.google.com/maps/api/geocode/json?address=" + newUrlString1 + "&key="Your Key"");
        HttpClient client = new DefaultHttpClient();
        HttpResponse response;
        StringBuilder stringBuilder = new StringBuilder();

        try {
            response = client.execute(httpGet);
            HttpEntity entity = response.getEntity();
            InputStream stream = entity.getContent();
            int b;
            while ((b = stream.read()) != -1) {
                stringBuilder.append((char) b);
            }
        } catch (ClientProtocolException e) {
        } catch (IOException e) {
        }

        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject = new JSONObject(stringBuilder.toString());
        } catch (JSONException e) {

            e.printStackTrace();
        }

        return jsonObject;
    }

    public LatLng getLatLng(JSONObject jsonObject) {

        Double lon = new Double(0);
        Double lat = new Double(0);

        try {

            lon = ((JSONArray) jsonObject.get("results")).getJSONObject(0)
                .getJSONObject("geometry").getJSONObject("location")
                .getDouble("lng");

            lat = ((JSONArray) jsonObject.get("results")).getJSONObject(0)
                .getJSONObject("geometry").getJSONObject("location")
                .getDouble("lat");

        } catch (JSONException e) {
            e.printStackTrace();
        }
        LatLng latLng = new LatLng();
        latLng.setLat(lat);
        latLng.setLng(lon);
        return latLng;
    }
  
  public void getLatLngForAddress() {
    String street = "Street 201, NewYork";
    LatLng source = getLatLng(getLocationFormGoogle(street));
    System.out.println("Lat and Lng",source);
  }
  
}
