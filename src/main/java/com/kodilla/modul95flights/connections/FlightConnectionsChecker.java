package com.kodilla.modul95flights.connections;

import com.kodilla.modul95flights.requests.FlightRequest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class FlightConnectionsChecker implements ConnectionChecker {

    public FlightsMapCreator flightsMapCreator = new FlightsMapCreator();
    public HashMap<String, ArrayList<String>> myMap = flightsMapCreator.createConnectionsMap();

    public boolean checkConnectionFromDeparture(FlightRequest flightRequest) {
        String departure = flightRequest.getDeparture();
        String arrival = flightRequest.getArrival();
        boolean foundFlight = false;
        String arrivals = "";

        for (Map.Entry<String, ArrayList<String>> entry : myMap.entrySet()) {
            if (entry.getKey().equals(departure)) {
                arrivals = myMap.entrySet().stream()
                        .filter(m -> m.getKey().equals(departure))
                        .flatMap(m -> m.getValue().stream())
                        .collect(Collectors.joining(", ", " All airports available from " + departure + ": ", "."));

                foundFlight = true;
            }
        }
        if (foundFlight) {
            System.out.println(arrivals);
            return true;
        } else {
            System.out.println("No flights available from this departure");
            return false;
        }
    }

    public boolean checkConnectionToArrival(FlightRequest flightRequest) {
        String departure = flightRequest.getDeparture();
        String arrival = flightRequest.getArrival();
        boolean foundFlight = false;
        String departures = "";
        List<String> result = new ArrayList<>();

        for(Map.Entry<String, ArrayList<String>> theMap: myMap.entrySet()){
            ArrayList<String> temporary = theMap.getValue();
            for(String theArrival: temporary){
                if(theArrival.equals(arrival)){
                    //result.add(theMap.getKey());
                    if(theMap.getKey().equals(departure)) {
                        departures = departures + " " + theMap.getKey();
                        foundFlight = true;
                    }
                }
            }
        }

        if (foundFlight) {
            System.out.println("To " + arrival + " you can flight from: " + departures);
            return true;
        } else {
            System.out.println("No flights to choosen destination");
            return false;
        }
    }

    public boolean checkConnectionWithOneChange(FlightRequest flightRequest) {

        return true;//temp
    }
}
