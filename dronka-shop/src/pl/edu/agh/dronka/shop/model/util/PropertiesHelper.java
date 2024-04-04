package pl.edu.agh.dronka.shop.model.util;

import java.util.LinkedHashMap;
import java.util.Map;

import pl.edu.agh.dronka.shop.model.Category;
import pl.edu.agh.dronka.shop.model.Item;
import pl.edu.agh.dronka.shop.model.items.Books;
import pl.edu.agh.dronka.shop.model.items.Electronics;
import pl.edu.agh.dronka.shop.model.items.Food;
import pl.edu.agh.dronka.shop.model.items.Music;

public class PropertiesHelper {

	public static Map<String, Object> getPropertiesMap(Item item) {
		Map<String, Object> propertiesMap = new LinkedHashMap<>();
		Category category = item.getCategory();

		propertiesMap.put("Nazwa", item.getName());
		propertiesMap.put("Cena", item.getPrice());
		propertiesMap.put("Kategoria", item.getCategory().getDisplayName()); 
		propertiesMap.put("Ilość", Integer.toString(item.getQuantity()));
		propertiesMap.put("Tanie bo polskie", item.isPolish());
		propertiesMap.put("Używany", item.isSecondhand());

		switch(category){
			case BOOKS -> {
				propertiesMap.put("Strony", ((Books) item).getPageAmount());
				propertiesMap.put("Twarda okładka", ((Books) item).isHardCovered());
			}
			case ELECTRONICS -> {
				propertiesMap.put("Mobilny", ((Electronics) item).isMobile());
				propertiesMap.put("Gwarancja", ((Electronics) item).hasWarranty());
			}
			case FOOD -> propertiesMap.put("Data spożycia", ((Food) item).getDateOfConsumption());

			case MUSIC -> {
				propertiesMap.put("Typ", ((Music) item).getMusicType());
				propertiesMap.put("Wideo", ((Music) item).hasVideo());
			}
		}

		return propertiesMap;
	}
}
