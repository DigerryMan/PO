package pl.edu.agh.dronka.shop.model.items;

import pl.edu.agh.dronka.shop.model.Category;
import pl.edu.agh.dronka.shop.model.Item;

import java.time.LocalDate;
import java.util.Date;

public class Food extends Item {
    private LocalDate dateOfConsumption;

    public Food(String name, Category category, int price, int quantity, LocalDate dateOfConsumption) {
        super(name, category, price, quantity);
        this.dateOfConsumption = dateOfConsumption;
    }
    public Food(){category = Category.FOOD;}
    public LocalDate getDateOfConsumption() {
        return dateOfConsumption;
    }

    public void setDateOfConsumption(LocalDate dateOfConsumption) {
        this.dateOfConsumption = dateOfConsumption;
    }
}
