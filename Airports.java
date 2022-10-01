import java.io.* ;
import java.util.ArrayList;
import java.util.HashMap;
public class Airports {
    private String airportID;
    private String airportName;
    private String airportCity;
    private String airportCountry;
    private String iataCode;
    private String icaoCode;



    public String getAirportID() {return airportID;
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

    public String getIataCode() {
        return iataCode;
    }

    public String getIcaoCode() {
        return icaoCode;
    }


    //ArrayList<String[]> airport;
    public static void reader(){
        FileReader fileViewer = null;
        BufferedReader buffReader = null;

        try{
            fileViewer = new FileReader("airports.csv");
            buffReader = new BufferedReader(fileViewer);
            HashMap<String, ArrayList<String>> airportInfo = new HashMap<String, ArrayList<String>>();
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

                airportInfo.putIfAbsent(key, new ArrayList<>());
                airportInfo.get(key).add(airportID);
                airportInfo.get(key).add(airportIATA);
                airportInfo.get(key).add(airportICAO);
            }
            System.out.println(airportInfo);
            buffReader.close();
        } catch (FileNotFoundException e){
            e.printStackTrace();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}


