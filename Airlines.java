import java.io.* ;
import java.util.ArrayList;
import java.util.HashMap;

public class Airlines {
    private String airlineID;
    private String airlineName;
    private String airlineAlias;
    private String iataCode;
    private String icoaCode;
    private String airlineCountry;
    private String airlineActive;

    public String getAirlineID() {
        return airlineID;
    }

    public String getAirlineName() {
        return airlineName;
    }

    public String getAirlineAlias() {
        return airlineAlias;
    }

    public String getIataCode() {
        return iataCode;
    }

    public String getIcoaCode() {
        return icoaCode;
    }

    public String getAirlineCountry() {
        return airlineCountry;
    }

    public String getAirlineActive() {
        return airlineActive;
    }

    public static void reader(){
        FileReader fileViewer = null;
        BufferedReader buffReader = null;
        HashMap<String, ArrayList<String>> airlinesInfo = new HashMap<String, ArrayList<String>>();
        try{
            fileViewer = new FileReader("airlines.csv");
            buffReader = new BufferedReader(fileViewer);
            String newLine;
            while ((newLine = buffReader.readLine()) != null) {
                String[] airline = newLine.split(",");
                String airlineID = airline[0];
                String airlineName = airline[1];
                String airlineIATA = airline[3];
                String airlineICOA = airline[4];
                String airlineCountry = airline[6];
                String airlineActive = airline[7];

                airlinesInfo.putIfAbsent(airlineID, new ArrayList<>());
                airlinesInfo.get(airlineID).add(airlineCountry);
                airlinesInfo.get(airlineID).add(airlineIATA);
                airlinesInfo.get(airlineID).add(airlineICOA);
                airlinesInfo.get(airlineID).add(airlineActive);



            }
            System.out.println(airlinesInfo);
            buffReader.close();
        } catch (FileNotFoundException e){
            e.printStackTrace();
        } catch (IOException e) {
            throw new RuntimeException(e);

        }
    }

}
