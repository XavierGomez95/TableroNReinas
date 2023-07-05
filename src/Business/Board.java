package Business;

public class Board {
    private final int[] config;
    private final int size;

    public Board (int size) {
        this.config = new int[size];
        this.size = size;
    }

    public int[] getConfig() {
        return config;
    }

    public int getSize() {
        return size;
    }
}
