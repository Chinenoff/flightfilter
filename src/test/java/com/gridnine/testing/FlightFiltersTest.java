package com.gridnine.testing;

import com.gridnine.testing.filter.FlightFilter;
import com.gridnine.testing.filter.collection.DepartingInPast;
import com.gridnine.testing.filter.collection.DepartsBeforeArrives;
import com.gridnine.testing.filter.collection.MoreTwoHoursGroundTime;
import com.gridnine.testing.model.Flight;
import com.gridnine.testing.model.FlightBuilder;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FlightFiltersTest {

    List<Flight> flights = FlightBuilder.createFlights();

    @Test
    void departingInPastTest() {
        FlightFilter flightFilterDepartingInPast = new DepartingInPast();
        List<Flight> actual = flights.stream().filter(flightFilterDepartingInPast::check)
                .collect(Collectors.toList());
        List<Flight> expected = new ArrayList<>(flights);
        expected.remove(2);
        assertEquals(actual, expected);
    }

    @Test
    void departsBeforeArrivesTest() {
        FlightFilter flightFilterDepartsBeforeArrives = new DepartsBeforeArrives();
        List<Flight> actual = flights.stream().filter(flightFilterDepartsBeforeArrives::check)
                .collect(Collectors.toList());
        List<Flight> expected = new ArrayList<>(flights);
        expected.remove(3);
        assertEquals(actual, expected);
    }

    @Test
    void moreTwoHoursGroundTimeTest() {
        FlightFilter flightFilterMoreTwoHoursGroundTime = new MoreTwoHoursGroundTime();
        List<Flight> actual = flights.stream().filter(flightFilterMoreTwoHoursGroundTime::check)
                .collect(Collectors.toList());
        List<Flight> expected = new ArrayList<>(flights);
        expected.remove(5);
        expected.remove(4);
        assertEquals(actual, expected);
    }
}