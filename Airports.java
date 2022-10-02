import java.io.* ;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;

public class Airports {
    public static HashMap<String, ArrayList<Airports>> airportsMap = new HashMap<>();

    public static HashMap<String, Airports>  iataAirport = new HashMap<>();
    private String airportID;
    private String airportName;
    private String airportCity;
    private String airportCountry;
    private String airportIata;
    private String airportIcao;

    public static HashMap<String, ArrayList<Airports>> getAirportsMap() {
        return airportsMap;
    }

    public String getAirportID() {
        return airportID;
    }

    public String getAirportName() {
        return airportName;
    }

    public String getAirportCity() {
        return airportCity;
    }

    public String getAirportCountry() {
        return airportCountry;
    }

    public String getAirportIata() {
        return airportIata;
    }

    public String getAirportIcao() {
        return airportIcao;
    }

    public static void setAirportsMap(HashMap<String, ArrayList<Airports>> airportsMap) {
        Airports.airportsMap = airportsMap;
    }

    public void setAirportID(String airportID) {
        this.airportID = airportID;
    }

    public void setAirportName(String airportName) {
        this.airportName = airportName;
    }

    public void setAirportCity(String airportCity) {
        this.airportCity = airportCity;
    }

    public void setAirportCountry(String airportCountry) {
        this.airportCountry = airportCountry;
    }

    public void setAirportIata(String airportIata) {
        this.airportIata = airportIata;
    }

    public void setAirportIcao(String airportIcao) {
        this.airportIcao = airportIcao;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Airports airports)) return false;
        return Objects.equals(airportID, airports.airportID) && Objects.equals(airportName, airports.airportName) && Objects.equals(airportCity, airports.airportCity) && Objects.equals(airportCountry, airports.airportCountry) && Objects.equals(airportIata, airports.airportIata) && Objects.equals(airportIcao, airports.airportIcao);
    }

    @Override
    public int hashCode() {
        return Objects.hash(airportID, airportName, airportCity, airportCountry, airportIata, airportIcao);
    }

    public Airports(String airportID, String airportName, String airportCity, String airportCountry, String airportIata, String airportIcao) {
        this.airportID = airportID;
        this.airportName = airportName;
        this.airportCity = airportCity;
        this.airportCountry = airportCountry;
        this.airportIata = airportIata;
        this.airportIcao = airportIcao;
    }

    public static void reader(){
        FileReader fileViewer = null;
        BufferedReader buffReader = null;

        try{
            fileViewer = new FileReader("airports.csv");
            buffReader = new BufferedReader(fileViewer);
            String newLine;
            while ((newLine = buffReader.readLine()) != null) {
                String[] airport = newLine.split(",");
                String airportID = airport[0];
                String airportName = airport[1];
                String airportCity = airport[2];
                String airportCountry = airport[3];
                String airportIATA = airport[4];
                String airportICAO = airport[5];

                String key = airportCity + airportCountry;

                Airports newAirports = new Airports(airportID,airportName,airportCity,airportCountry,airportIATA,airportICAO);


                if (!airportsMap.containsKey(key)){
                    airportsMap.put(key, new ArrayList<Airports>());
                    airportsMap.get(key).add(newAirports);
                }
                else {
                    airportsMap.get(key).add(newAirports);
                }

                iataAirport.putIfAbsent(airportIATA,newAirports);

            }
            buffReader.close();
        } catch (FileNotFoundException e){
            e.printStackTrace();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String toString() {
        return "Airports{" +
                "airportName='" + airportName + '\'' +
                ", airportIata='" + airportIata + '\'' +
                '}';
    }
}


