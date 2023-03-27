package com.desire.model;

public class SuiteRoom extends Room {
    private Double premium;
    public SuiteRoom(Long roomNumber, Double roomPrice, Double premium) {
        super(roomNumber, roomPrice);
        this.premium = premium;
        this.setRoomType(RoomType.SUITE);
    }

    public SuiteRoom() {

    }
    @Override
    public Double getRoomPrice() {
        return (super.getRoomPrice() + premium);
    }

}
