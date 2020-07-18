package images;

public class Invert extends ImageDecorator {

    public Invert(Image toInvert) {
        super(toInvert.getWidth(), toInvert.getHeight(), toInvert);
    }

    @Override
    public RGB get(int x, int y) {
        return this.img1.get(x, y).invert();
    }
}
