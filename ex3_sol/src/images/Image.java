package images;

public interface Image {
    int getWidth();
    int getHeight();
    RGB get(int x, int y);
}

