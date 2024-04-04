package pl.edu.agh.dronka.shop.model.items;

import pl.edu.agh.dronka.shop.model.Category;
import pl.edu.agh.dronka.shop.model.Item;

public class Books extends Item {
    private int pageAmount;
    private boolean isHardCovered;
    public Books(String name, Category category, int price, int quantity, int pageAmount, boolean isHardCovered) {
        super(name, category, price, quantity);
        this.pageAmount = pageAmount;
        this.isHardCovered = isHardCovered;
    }
    public Books(){category = Category.BOOKS;}

    public boolean isHardCovered() {
        return isHardCovered;
    }

    public int getPageAmount() {
        return pageAmount;
    }

    public void setPageAmount(int pageAmount) {
        this.pageAmount = pageAmount;
    }
    public void setHardCovered(boolean hardCovered) {
        isHardCovered = hardCovered;
    }
}
