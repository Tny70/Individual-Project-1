import java.io.* ;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;

public class Airlines {

    public static HashMap<String, ArrayList<Airlines>> airlinesMap = new HashMap<>();
    private String airlineID;
    private String airlineName;
    private String airlineAlias;
    private String airlineIataCode;
    private String airlineIcoaCode;
    private String airlineCallsign;
    private String airlineCountry;
    private String airlineActive;

    public static HashMap<String, ArrayList<Airlines>> getAirlinesMap() {
        return airlinesMap;
    }

    public String getAirlineID() {
        return airlineID;
    }

    public String getAirlineName() {
        return airlineName;
    }

    public String getAirlineAlias() {
        return airlineAlias;
    }

    public String getAirlineIataCode() {
        return airlineIataCode;
    }

    public String getAirlineIcoaCode() {
        return airlineIcoaCode;
    }

    public String getAirlineCallsign() {
        return airlineCallsign;
    }

    public String getAirlineCountry() {
        return airlineCountry;
    }

    public String getAirlineActive() {
        return airlineActive;
    }


    public static void setAirlinesMap(HashMap<String, ArrayList<Airlines>> airlinesMap) {
        Airlines.airlinesMap = airlinesMap;
    }

    public void setAirlineID(String airlineID) {
        this.airlineID = airlineID;
    }

    public void setAirlineName(String airlineName) {
        this.airlineName = airlineName;
    }

    public void setAirlineAlias(String airlineAlias) {
        this.airlineAlias = airlineAlias;
    }

    public void setAirlineIataCode(String airlineIataCode) {
        this.airlineIataCode = airlineIataCode;
    }

    public void setAirlineIcoaCode(String airlineIcoaCode) {
        this.airlineIcoaCode = airlineIcoaCode;
    }

    public void setAirlineCallsign(String airlineCallsign) {
        this.airlineCallsign = airlineCallsign;
    }

    public void setAirlineCountry(String airlineCountry) {
        this.airlineCountry = airlineCountry;
    }

    public void setAirlineActive(String airlineActive) {
        this.airlineActive = airlineActive;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Airlines airlines)) return false;
        return Objects.equals(airlineID, airlines.airlineID) && Objects.equals(airlineName, airlines.airlineName) && Objects.equals(airlineAlias, airlines.airlineAlias) && Objects.equals(airlineIataCode, airlines.airlineIataCode) && Objects.equals(airlineIcoaCode, airlines.airlineIcoaCode) && Objects.equals(airlineCallsign, airlines.airlineCallsign) && Objects.equals(airlineCountry, airlines.airlineCountry) && Objects.equals(airlineActive, airlines.airlineActive);
    }

    @Override
    public int hashCode() {
        return Objects.hash(airlineID, airlineName, airlineAlias, airlineIataCode, airlineIcoaCode, airlineCallsign, airlineCountry, airlineActive);
    }

    public Airlines(String airlineID, String airlineName, String airlineAlias, String airlineIataCode, String airlineIcoaCode, String airlineCallsign, String airlineCountry, String airlineActive) {
        this.airlineID = airlineID;
        this.airlineName = airlineName;
        this.airlineAlias = airlineAlias;
        this.airlineIataCode = airlineIataCode;
        this.airlineIcoaCode = airlineIcoaCode;
        this.airlineCallsign = airlineCallsign;
        this.airlineCountry = airlineCountry;
        this.airlineActive = airlineActive;
    }

    public static void reader(){
        FileReader fileViewer = null;
        BufferedReader buffReader = null;
        try{
            fileViewer = new FileReader("airlines.csv");
            buffReader = new BufferedReader(fileViewer);
            String newLine;
            while ((newLine = buffReader.readLine()) != null) {
                String[] airline = newLine.split(",");
                String airlineID = airline[0];
                String airlineName = airline[1];
                String airlineAlias = airline[2];
                String airlineIATA = airline[3];
                String airlineICOA = airline[4];
                String airlineCallsign = airline[5];
                String airlineCountry = airline[6];
                String airlineActive = airline[7];

                Airlines newAirlines = new Airlines(airlineID,airlineName,airlineAlias,airlineIATA,airlineICOA,airlineCallsign,airlineCountry,airlineActive);

                if (!airlinesMap.containsKey(airlineIATA)){
                    airlinesMap.put(airlineIATA, new ArrayList<Airlines>());
                    airlinesMap.get(airlineIATA).add(newAirlines);
                }
                else {
                    airlinesMap.get(airlineIATA).add(newAirlines);
                }



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
        return "Airlines{" +
                "airlineName='" + airlineName + '\'' +
                ", airlineIataCode='" + airlineIataCode + '\'' +
                '}';
    }
}
