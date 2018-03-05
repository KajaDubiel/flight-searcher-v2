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

        for (Map.Entry<String, ArrayList<String>> theMap : myMap.entrySet()) {
            ArrayList<String> temporary = theMap.getValue();
            for (String theArrival : temporary) {
                if (theArrival.equals(arrival)) {
                    //result.add(theMap.getKey());
                    if (theMap.getKey().equals(departure)) {
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
        String departure = flightRequest.getDeparture();
        String arrival = flightRequest.getArrival();
        boolean foundFlight = false;
        String departure2 = "";
        String route = "";

        for(Map.Entry<String, ArrayList<String>> entry: myMap.entrySet()){
            ArrayList<String> values = entry.getValue();
            if(entry.getKey().equals(departure)){
                for(String value: values){
                    if(value.equals(arrival)){
                        System.out.println("Direct flight available");
                        foundFlight = true;
                        route = departure + " " + arrival;
                    } else {
                        departure2 = value;

                        for(Map.Entry<String, ArrayList<String>> entry2: myMap.entrySet()){
                            ArrayList<String> values2 = entry.getValue();
                            if(entry2.getKey().equals(departure2)){
                                for(String value2: values2){
                                    if(value2.equals(arrival)){
                                        System.out.println("Found flight");
                                        route = departure + " " + departure2 + " " + arrival;
                                        foundFlight = true;
                                    }
                                }
                            }
                        }
                    }


                }

            }
        }

        if(foundFlight){
            System.out.println(route);
            return true;
        } else{
            System.out.println("No flights");
            return false;
        }

    }
}
