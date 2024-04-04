package pl.edu.agh.dronka.shop.model.filter;

import pl.edu.agh.dronka.shop.model.Category;
import pl.edu.agh.dronka.shop.model.Item;
import pl.edu.agh.dronka.shop.model.items.*;

public class ItemFilter {
	private Item itemSpec;
	public ItemFilter(Category category){
		switch(category){
			case BOOKS -> itemSpec = new Books();
			case ELECTRONICS -> itemSpec = new Electronics();
			case FOOD -> itemSpec = new Food();
			case MUSIC -> itemSpec = new Music();
			case SPORT -> itemSpec = new Sport();
			default -> itemSpec = new Item();
		}
	}

	public Item getItemSpec() {
		return itemSpec;
	}
	public boolean appliesTo(Item item) {
		if (itemSpec.getName() != null
				&& !itemSpec.getName().equals(item.getName())) {
			return false;
		}
		if (itemSpec.getCategory() != null
				&& !itemSpec.getCategory().equals(item.getCategory())) {
			return false;
		}

		// applies filter only if the flag (secondHand) is true)
		if (itemSpec.isSecondhand() && !item.isSecondhand()) {
			return false;
		}

		// applies filter only if the flag (polish) is true)
		if (itemSpec.isPolish() && !item.isPolish()) {
			return false;
		}

		switch (itemSpec.getCategory()){
			case BOOKS -> {
				if (((Books) itemSpec).isHardCovered() && !((Books) item).isHardCovered()) {
					return false;
				}
			}
			case ELECTRONICS -> {
				if (((Electronics) itemSpec).hasWarranty() && !((Electronics) item).hasWarranty()) {
					return false;
				}
				if(((Electronics) itemSpec).isMobile() && !((Electronics) item).isMobile()){
					return false;
				}
			}
			case MUSIC -> {
				if (((Music) itemSpec).hasVideo() && !((Music) item).hasVideo()) {
					return false;
				}
			}
		}

		return true;
	}
}