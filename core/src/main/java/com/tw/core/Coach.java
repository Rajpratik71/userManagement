package com.tw.core;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by chenbojian on 15-6-29.
 */
@Entity
@DiscriminatorValue("Coach")
public class Coach extends Employee{
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "privateCoach", cascade = CascadeType.ALL)
    private Set<Customer> privateCustomers = new HashSet<Customer>();

    public Set<Customer> getPrivateCustomers() {
        return privateCustomers;
    }

    public void setPrivateCustomers(Set<Customer> privateCustomers) {
        this.privateCustomers = privateCustomers;
    }
}
