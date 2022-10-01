import java.io.* ;
import java.util.ArrayList;
import java.util.HashMap;

public class Routes {
    private String airlineCode;
    private String airlineID;
    private String sourceAirportCode;
    private String sourceAirportID;
    private String destinationAirportCode;
    private String destinationAirportID;
    private String codeShare;
    private String stops;
    private String equipment;

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
                String airlineCode = route[0];
                String airlineID = route[1];
                String sourceAirportCode = route[2];
                String sourceAirportID = route[3];
                String destinationAirportCode= route[4];
                String destinationAirportID = route[5];
                String stops = route[7];
                ArrayList<String> routesExtra = new ArrayList<String>();
                routesExtra.add(destinationAirportCode);
                routesExtra.add(destinationAirportID);

                routesExtra.add(stops);
                routesExtra.add(airlineCode);

                routesInfo.putIfAbsent(sourceAirportID, new ArrayList<ArrayList<String>>());

                routesInfo.get(sourceAirportID).add(routesExtra);



            }
            buffReader.close();
        } catch (FileNotFoundException e){
            e.printStackTrace();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
