package pl.edu.agh.dronka.shop.model.items;

import pl.edu.agh.dronka.shop.model.Category;
import pl.edu.agh.dronka.shop.model.Item;

public class Electronics extends Item {
    private boolean isMobile;
    private boolean hasWarranty;

    public Electronics(String name, Category category, int price, int quantity, boolean isMobile, boolean hasWarranty) {
        super(name, category, price, quantity);
        this.isMobile = isMobile;
        this.hasWarranty = hasWarranty;
    }
    public Electronics(){category = Category.ELECTRONICS;}

    public boolean isMobile() {
        return isMobile;
    }


    public boolean hasWarranty() {
        return hasWarranty;
    }

    public void setMobile(boolean isMobile) {
        this.isMobile = isMobile;
    }

    public void setHasWarranty(boolean hasWarranty) {
        this.hasWarranty = hasWarranty;
    }
}

