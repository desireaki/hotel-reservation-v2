package com.desire.model;

import jakarta.persistence.*;

@Entity
public class Room {

    @Id
    @SequenceGenerator(
            name = "room_id_sequence",
            sequenceName = "room_id_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "room_id_sequence"
    )
    private Long roomNumber;
    private Double roomPrice;
    private RoomType roomType;

    public Room(Long roomNumber, Double roomPrice) {
        this.roomNumber = roomNumber;
        this.roomPrice = roomPrice;
        this.roomType = RoomType.REGULAR;
    }

    public Room() {

    }

    public Long getRoomNumber() {
        return roomNumber;
    }

    public Double getRoomPrice() {
        return roomPrice;
    }

    public RoomType getRoomType() {
        return roomType;
    }

    public void setRoomType(RoomType roomType) {
        this.roomType = roomType;
    }
}
