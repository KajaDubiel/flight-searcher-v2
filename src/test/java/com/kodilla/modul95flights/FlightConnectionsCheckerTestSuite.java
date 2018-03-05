package com.kodilla.modul95flights;

import com.kodilla.modul95flights.connections.FlightConnectionsChecker;
import com.kodilla.modul95flights.data.User;
import com.kodilla.modul95flights.requests.FlightRequest;
import org.junit.Assert;
import org.junit.Test;

public class FlightConnectionsCheckerTestSuite {

    @Test
    public void checkConnectionFromDepartureAvailableTest(){
        //Given
        User user = new User("Anna", "Nowak", "an@op.pl");
        FlightRequest flightRequest = new FlightRequest(user, "Katowice", "Warszawa");
        FlightConnectionsChecker flightConnectionsChecker = new FlightConnectionsChecker();

        //When
        boolean result = flightConnectionsChecker.checkConnectionFromDeparture(flightRequest);

        //Then
        Assert.assertTrue(result);
    }

    @Test
    public void checkConnectionFromDepartureUnavailableTest(){

        //Given
        User user = new User("Anna", "Nowak", "an@op.pl");
        FlightRequest flightRequest = new FlightRequest(user, "Porto", "Warszawa");
        FlightConnectionsChecker flightConnectionsChecker = new FlightConnectionsChecker();

        //When
        boolean result = flightConnectionsChecker.checkConnectionFromDeparture(flightRequest);

        //Then
        Assert.assertFalse(result);
    }

    @Test
    public void checkConnectionToArrivalAvailableTest(){
        //Given
        User user = new User("Anna", "Nowak", "an@op.pl");
        FlightRequest flightRequest = new FlightRequest(user, "Katowice", "Warszawa");
        FlightConnectionsChecker flightConnectionsChecker = new FlightConnectionsChecker();

        //When
        boolean result = flightConnectionsChecker.checkConnectionToArrival(flightRequest);

        //Then
        Assert.assertTrue(result);
    }

    @Test
    public void checkConnectionToArrivalUnavailableTest(){
        //Given
        User user = new User("Anna", "Nowak", "an@op.pl");
        FlightRequest flightRequest = new FlightRequest(user, "Kraków", "Warszawa");
        FlightConnectionsChecker flightConnectionsChecker = new FlightConnectionsChecker();

        //When
        boolean result = flightConnectionsChecker.checkConnectionToArrival(flightRequest);

        //Then
        Assert.assertFalse(result);
    }

    @Test
    public void checkConnectionWithOneChangeAvailableTest(){
        //Given
        User user = new User("Anna", "Nowak", "an@op.pl");
        FlightRequest flightRequest = new FlightRequest(user, "Warszawa", "Katowice");
        FlightConnectionsChecker flightConnectionsChecker = new FlightConnectionsChecker();

        //When
        boolean result = flightConnectionsChecker.checkConnectionWithOneChange(flightRequest);

        //Then
        Assert.assertTrue(result);
    }

    @Test
    public void checkConnectionWithOneChangeUnavailableTest(){
        //Given
        User user = new User("Anna", "Nowak", "an@op.pl");
        FlightRequest flightRequest = new FlightRequest(user, "Katowice", "Szczecin");
        FlightConnectionsChecker flightConnectionsChecker = new FlightConnectionsChecker();

        //When
        boolean result = flightConnectionsChecker.checkConnectionWithOneChange(flightRequest);

        //Then
        Assert.assertFalse(result);
    }
}
