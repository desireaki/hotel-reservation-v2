package com.desire.model;

//import jakarta.persistence.*;
import jakarta.persistence.*;
import java.util.Date;

@Entity
public class Reservation {

    @Id
    @SequenceGenerator(
            name = "reservation_id_sequence",
            sequenceName = "reservation_id_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "reservation_id_sequence"
    )
    private Long id;
    private String customerEmail;
    private Date creationDate;
    @ManyToOne
    @JoinColumn(name = "room_room_number")
    private Room room;
    private Date checkIn;
    private Date checkOut;

    public Reservation(Long reservationId, String customerEmail, Date creationDate, Room room, Date checkIn, Date checkOut) {
        this.id = reservationId;
        this.customerEmail = customerEmail;
        this.creationDate = creationDate;
        this.room = room;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
    }

    public Reservation () {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationdate) {
        this.creationDate = creationdate;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public Date getCheckIn() {
        return checkIn;
    }

    public void setCheckIn(Date checkIn) {
        this.checkIn = checkIn;
    }

    public Date getCheckOut() {
        return checkOut;
    }

    public void setCheckOut(Date checkOut) {
        this.checkOut = checkOut;
    }
}
