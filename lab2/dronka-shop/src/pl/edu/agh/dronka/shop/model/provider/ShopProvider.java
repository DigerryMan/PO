package pl.edu.agh.dronka.shop.model.provider;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import pl.edu.agh.dronka.shop.model.Category;
import pl.edu.agh.dronka.shop.model.Index;
import pl.edu.agh.dronka.shop.model.Item;
import pl.edu.agh.dronka.shop.model.Shop;
import pl.edu.agh.dronka.shop.model.User;
import pl.edu.agh.dronka.shop.model.items.*;

public class ShopProvider {

	public static Shop getExampleShop() {
		Shop shop = new Shop();

		shop.addUser(getExampleUser());

		Index itemsIndex = new Index();

		for (Item item : getExampleItems()) {
			itemsIndex.addItem(item);
		}

		registerExampleCategories(itemsIndex);
		shop.setItemsIndex(itemsIndex);

		return shop;
	}

	public static User getExampleUser() {
		return new User("Jan", "Rejnor");
	}

	public static List<Item> getExampleItems() {
		List<Item> items = new ArrayList<>();

		CSVReader booksReader = new CSVReader("resources/books.csv");
		items.addAll(readItems(booksReader, Category.BOOKS));
		
		CSVReader electronicsReader = new CSVReader("resources/electronics.csv");
		items.addAll(readItems(electronicsReader, Category.ELECTRONICS));
		
		CSVReader foodReader = new CSVReader("resources/food.csv");
		items.addAll(readItems(foodReader, Category.FOOD));
		
		CSVReader musicReader = new CSVReader("resources/music.csv");
		items.addAll(readItems(musicReader, Category.MUSIC));
		
		CSVReader sportReader = new CSVReader("resources/sport.csv");
		items.addAll(readItems(sportReader, Category.SPORT));

		return items;
	}

	public static void registerExampleCategories(Index index) {
		for (Category category : Category.values()) {
			index.registerCategory(category);
		}
	}

	private static List<Item> readItems(CSVReader reader, Category category) {
		List<Item> items = new ArrayList<>();

		try {
			reader.parse();
			List<String[]> data = reader.getData();

			for (String[] dataLine : data) {
	
				String name = reader.getValue(dataLine,"Nazwa");
				int price = Integer.parseInt(reader.getValue(dataLine, "Cena"));
				int quantity = Integer.parseInt(reader.getValue(dataLine,
						"Ilość"));

				boolean isPolish = Boolean.parseBoolean(reader.getValue(
						dataLine, "Tanie bo polskie"));
				boolean isSecondhand = Boolean.parseBoolean(reader.getValue(
						dataLine, "Używany"));

				Item item;

				switch(category){
					case BOOKS -> {
						int pageAmount = Integer.parseInt(reader.getValue(dataLine, "Liczba stron"));
						boolean isHardCovered = Boolean.parseBoolean(reader.getValue(dataLine, "Twarda oprawa"));
						item = new Books(name, category, price, quantity, pageAmount, isHardCovered);
					}

					case ELECTRONICS -> {
						boolean isMobile = Boolean.parseBoolean(reader.getValue(dataLine, "Mobilny"));
						boolean hasWarranty = Boolean.parseBoolean(reader.getValue(dataLine, "Gwarancja"));
						item = new Electronics(name, category, price, quantity, isMobile, hasWarranty);
					}
					case FOOD -> {
						String dateString = reader.getValue(dataLine, "Data spożycia");
						DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
						LocalDate date = LocalDate.parse(dateString, formatter);
						item = new Food(name, category, price, quantity, date);
					}
					case MUSIC -> {
						MusicType musicType = MusicType.parse(reader.getValue(dataLine, "Typ"));
						boolean hasVideo = Boolean.parseBoolean(reader.getValue(dataLine, "Wideo"));
						item = new Music(name, category, price, quantity, musicType, hasVideo);
					}
					case SPORT -> item = new Sport(name, category, price, quantity);
                    default -> {continue;}
                }

				item.setPolish(isPolish);
				item.setSecondhand(isSecondhand);
				items.add(item);
			}

		} catch (IOException e) {
			e.printStackTrace();
		}

		return items;
	}

}
