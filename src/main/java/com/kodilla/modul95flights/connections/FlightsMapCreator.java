package com.kodilla.modul95flights.connections;

import java.util.ArrayList;
import java.util.HashMap;

public class FlightsMapCreator {
        public HashMap<String, ArrayList<String>> createConnectionsMap() {
        ArrayList<String> arrivals = new ArrayList<>();
        arrivals.add("Warszawa");
        arrivals.add("Poznań");
        arrivals.add("Kraków");

        ArrayList<String> arrivals1 = new ArrayList<>();
        arrivals1.add("Lódź");
        arrivals1.add("Gdańsk");
        arrivals1.add("Wrocław");

        ArrayList<String> arrivals2 = new ArrayList<>();
        arrivals2.add("Szczecin");
        arrivals2.add("Rzeszów");
        arrivals2.add("Katowice");
        arrivals2.add("Warszawa");

        HashMap<String, ArrayList<String>> connections = new HashMap<>();
        connections.put("Katowice", arrivals);
        connections.put("Warszawa", arrivals1);
        connections.put("Wrocław", arrivals2);

        return connections;
    }

}
