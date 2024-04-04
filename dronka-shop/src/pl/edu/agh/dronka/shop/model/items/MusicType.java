package pl.edu.agh.dronka.shop.model.items;

public enum MusicType {
    RAP, POP, DISCOPOLO, HIPHOP, OTHER;

    public static MusicType parse(String str){
        return switch (str) {
            case "RAP" -> RAP;
            case "POP" -> POP;
            case "DISCOPOLO" -> DISCOPOLO;
            case "HIPHOP" -> HIPHOP;
            default -> OTHER;
        };
    }
}
