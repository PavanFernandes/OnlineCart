package org.example.entities;

import java.sql.Date;

public class Order {

    private  int id;

    private int customer_id;

    private Date date;

    public Order(int id ,int customer_id, Date date) {
        this.id = id;
        this.customer_id = customer_id;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(int customer_id) {
        this.customer_id = customer_id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
