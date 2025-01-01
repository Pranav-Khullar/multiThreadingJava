package com.example.multithreadingProject.ParkingLot.models;

import java.time.LocalDateTime;
import java.util.concurrent.atomic.AtomicInteger;

public class Ticket {

    private static final AtomicInteger ticketCounter = new AtomicInteger(1);

    private final Integer ticketNumber;
    private final Integer floorNumber;
    private final Integer slotNumber;
    private final LocalDateTime parkingTime;

    public Ticket(Integer floorNumber, Integer slotNumber, LocalDateTime parkingTime) {
        this.ticketNumber = ticketCounter.getAndIncrement();
        this.floorNumber = floorNumber;
        this.slotNumber = slotNumber;
        this.parkingTime = parkingTime;
    }

    public Integer getFloorNumber() {
        return floorNumber;
    }

    public Integer getSlotNumber() {
        return slotNumber;
    }

    public LocalDateTime getParkingTime() {
        return parkingTime;
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "ticketNumber=" + ticketNumber +
                ", floorNumber=" + floorNumber +
                ", slotNumber=" + slotNumber +
                ", parkingTime=" + parkingTime +
                '}';
    }
}
