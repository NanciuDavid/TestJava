package ro.ase.acs.models;

import ro.ase.acs.contracts.Buyable;

abstract public class PublicTransportTicket implements Buyable, Cloneable{
    protected String departure;
    protected String destination;
    protected int distance;

    public PublicTransportTicket(String departure, String destination, int distance) {
        this.departure = departure;
        this.destination = destination;
        this.distance = distance;
    }

    @Override
    public float getPrice() {
        return 5;
    }

    public abstract float getDiscount();



}
