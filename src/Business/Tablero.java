package Business;

public class Tablero {
    private int[] config;
    private int size;

    public Tablero (int size) {
        this.config = new int[size];
        this.size = size;
    }

    public int[] getConfig() {
        return config;
    }

    public void setConfig(int[] config) {
        this.config = config;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
}
