package pl.edu.agh.dronka.shop.model.items;

import pl.edu.agh.dronka.shop.model.Category;
import pl.edu.agh.dronka.shop.model.Item;

public class Music extends Item {
    private MusicType musicType;
    private boolean hasVideo;

    public Music(String name, Category category, int price, int quantity, MusicType musicType, boolean hasVideo) {
        super(name, category, price, quantity);
        this.musicType = musicType;
        this.hasVideo = hasVideo;
    }
    public Music(){category = Category.MUSIC;}
    public MusicType getMusicType() {
        return musicType;
    }

    public boolean hasVideo() {
        return hasVideo;
    }

    public void setMusicType(MusicType musicType) {
        this.musicType = musicType;
    }

    public void setHasVideo(boolean hasVideo) {
        this.hasVideo = hasVideo;
    }
}
