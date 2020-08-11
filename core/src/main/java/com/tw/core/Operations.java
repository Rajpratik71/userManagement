package com.tw.core;

import javax.persistence.*;

/**
 * Created by chenbojian on 15-6-29.
 */
@Entity
@DiscriminatorValue("OPs")
public class Operations extends Employee {
}
