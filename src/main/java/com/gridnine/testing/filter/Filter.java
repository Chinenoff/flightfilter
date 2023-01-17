package com.gridnine.testing.filter;

import com.gridnine.testing.filter.collection.DepartingInPast;
import com.gridnine.testing.filter.collection.DepartsBeforeArrives;
import com.gridnine.testing.filter.collection.MoreTwoHoursGroundTime;

public enum Filter {
    DEPARTINGINPAST(new DepartingInPast()),
    DEPARTSBEFOREARRIVES(new DepartsBeforeArrives()),
    MORETWOHOURSGROUNDTIME(new MoreTwoHoursGroundTime());

    private final FlightFilter typeFilter;

    Filter(FlightFilter typeFilter) {
        this.typeFilter = typeFilter;
    }

    public FlightFilter getTypeFilter() {
        return typeFilter;
    }
}
