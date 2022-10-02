import java.io.* ;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;

public class Routes {

    public static HashMap<String, ArrayList<Routes>> routesMap = new HashMap<>();

    public static HashMap<String, Routes> iataRoutes = new HashMap<>();
    private String airlineCode;
    private String airlineID;
    private String sourceAirportCode;
    private String sourceAirportID;
    private String destinationAirportCode;
    private String destinationAirportID;
    private String codeShare;
    private String stops;
    private String equipment;

    public static HashMap<String, Routes> getIataRoutes() {
        return iataRoutes;
    }

    public static void setIataRoutes(HashMap<String, Routes> iataRoutes) {
        Routes.iataRoutes = iataRoutes;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Routes routes)) return false;
        return Objects.equals(airlineCode, routes.airlineCode) && Objects.equals(airlineID, routes.airlineID) && Objects.equals(sourceAirportCode, routes.sourceAirportCode) && Objects.equals(sourceAirportID, routes.sourceAirportID) && Objects.equals(destinationAirportCode, routes.destinationAirportCode) && Objects.equals(destinationAirportID, routes.destinationAirportID) && Objects.equals(codeShare, routes.codeShare) && Objects.equals(stops, routes.stops) && Objects.equals(equipment, routes.equipment);
    }

    @Override
    public int hashCode() {
        return Objects.hash(airlineCode, airlineID, sourceAirportCode, sourceAirportID, destinationAirportCode, destinationAirportID, codeShare, stops, equipment);
    }

    public static HashMap<String, ArrayList<Routes>> getRoutesMap() {
        return routesMap;
    }

    public String getAirlineCode() {
        return airlineCode;
    }

    public String getAirlineID() {
        return airlineID;
    }

    public String getSourceAirportCode() {
        return sourceAirportCode;
    }

    public String getSourceAirportID() {
        return sourceAirportID;
    }

    public String getDestinationAirportCode() {
        return destinationAirportCode;
    }

    public String getDestinationAirportID() {
        return destinationAirportID;
    }

    public String getCodeShare() {
        return codeShare;
    }

    public String getStops() {
        return stops;
    }

    public String getEquipment() {
        return equipment;
    }

    public static void setRoutesMap(HashMap<String, ArrayList<Routes>> routesMap) {
        Routes.routesMap = routesMap;
    }

    public void setAirlineCode(String airlineCode) {
        this.airlineCode = airlineCode;
    }

    public void setAirlineID(String airlineID) {
        this.airlineID = airlineID;
    }

    public void setSourceAirportCode(String sourceAirportCode) {
        this.sourceAirportCode = sourceAirportCode;
    }

    public void setSourceAirportID(String sourceAirportID) {
        this.sourceAirportID = sourceAirportID;
    }

    public void setDestinationAirportCode(String destinationAirportCode) {
        this.destinationAirportCode = destinationAirportCode;
    }

    public void setDestinationAirportID(String destinationAirportID) {
        this.destinationAirportID = destinationAirportID;
    }

    public void setCodeShare(String codeShare) {
        this.codeShare = codeShare;
    }

    public void setStops(String stops) {
        this.stops = stops;
    }

    public void setEquipment(String equipment) {
        this.equipment = equipment;
    }

    public Routes(String airlineCode, String airlineID, String sourceAirportCode, String sourceAirportID, String destinationAirportCode, String destinationAirportID, String codeShare, String stops, String equipment) {
        this.airlineCode = airlineCode;
        this.airlineID = airlineID;
        this.sourceAirportCode = sourceAirportCode;
        this.sourceAirportID = sourceAirportID;
        this.destinationAirportCode = destinationAirportCode;
        this.destinationAirportID = destinationAirportID;
        this.codeShare = codeShare;
        this.stops = stops;
        this.equipment = equipment;
    }

    public static void reader(){
        FileReader fileViewer = null;
        BufferedReader buffReader = null;
        HashMap<String, ArrayList<ArrayList<String>>> routesInfo = new HashMap<String, ArrayList<ArrayList<String>>>();

        try{
            fileViewer = new FileReader("routes.csv");
            buffReader = new BufferedReader(fileViewer);
            String newLine;
            while ((newLine = buffReader.readLine()) != null) {
                String[] route = newLine.split(",");

                if (route.length == 9) {
                    String airlineCode = route[0];
                    String airlineID = route[1];
                    String sourceAirportCode = route[2];
                    String sourceAirportID = route[3];
                    String destinationAirportCode = route[4];
                    String destinationAirportID = route[5];
                    String codeShare = route[6];
                    String stops = route[7];
                    String equipment = route[8];

                    Routes newRoutes = new Routes(airlineCode, airlineID, sourceAirportCode, sourceAirportID, destinationAirportCode, destinationAirportID, codeShare, stops, equipment);

                    if (!routesMap.containsKey(sourceAirportCode)) {
                        routesMap.put(sourceAirportCode, new ArrayList<Routes>());
                        routesMap.get(sourceAirportCode).add(newRoutes);
                    } else {
                        routesMap.get(sourceAirportCode).add(newRoutes);
                    }

                    iataRoutes.putIfAbsent(sourceAirportCode,newRoutes);


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
        return "Routes{" +
                "sourceAirportCode='" + sourceAirportCode + '\'' +
                ", destinationAirportCode='" + destinationAirportCode + '\'' +
                '}';
    }
}
