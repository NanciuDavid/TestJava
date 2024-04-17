package ro.ase.acs.models;

import ro.ase.acs.models.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Objects;
import java.util.stream.Collectors;


public class TrainTicket extends PublicTransportTicket implements  Cloneable, Comparable{

    private static Collection<TrainTicket> issuedTickets = new HashSet<>();
    private TrainType trainType ;

    public TrainTicket(String departure, String destination, int distance, TrainType trainType) {
        super(departure, destination, distance);
        this.trainType = trainType;
    }


    public String getDeparture() {
        return new String(super.departure);
    }

    public String getDestination(){
        return new String(super.destination);
    }

    public int getDistance(){
        return super.distance ;
    }

    @Override
    public float getPrice() {
        return super.getPrice() * super.distance * this.getDiscount();
    }

    public TrainType getTrainType(){
        return this.trainType;
    }
    @Override
    public float getDiscount() {
        if (this.trainType.toString().equals("REGIO")) {
            return 0.5f;
        } else if (this.trainType.toString().equals("INTERREGIO")) {
            return 0.25f;
        }
        else if(this.trainType.toString().equals("INTERCITY")){
            return 0.0f;
        }
        return 0.0f;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        TrainTicket cloned = (TrainTicket)super.clone();
        cloned.trainType = this.trainType;
        return cloned;
    }

    @Override
    public String toString() {
        return "> " + this.getDeparture() + " " + this.getDestination() + " " + this.getDistance();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TrainTicket that = (TrainTicket) o;
        return (this.getDeparture().equals(that.getDeparture()) && this.getDestination().equals(that.destination));
    }

    @Override
    public int hashCode() {
        return departure.hashCode() + destination.hashCode();
    }


    public static void issueTicket(TrainTicket ticket) {
        issuedTickets.add(ticket);
    }

    public static Collection<TrainTicket> getTickets() {
        return issuedTickets;
    }


    @Override
    public int compareTo(Object o) {
        return 0;
    }
}
