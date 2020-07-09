package ru.netology.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class Smartphone extends Product {
    private String vendor;

    public Smartphone(int id, String name, int price, String vendor) {
        super(id, name, price);
        this.vendor = vendor;
    }

    public boolean matches(String search) {
        if (super.matches(search)) {
            return true;
        }
        return this.vendor.equalsIgnoreCase(search);

    }

}
