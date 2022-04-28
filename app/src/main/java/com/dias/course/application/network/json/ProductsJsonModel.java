package com.dias.course.application.network.json;

import java.io.Serializable;
import java.util.Objects;

public class ProductsJsonModel implements Serializable {
    private String name;
    private double amount;
    private String slug;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductsJsonModel that = (ProductsJsonModel) o;
        return Double.compare(that.amount, amount) == 0 && name.equals(that.name) && Objects.equals(slug, that.slug);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, amount, slug);
    }

    @Override
    public String toString() {
        return "ProductsJsonModel{" +
                "name='" + name + '\'' +
                ", amount=" + amount +
                ", slug='" + slug + '\'' +
                '}';
    }
}
