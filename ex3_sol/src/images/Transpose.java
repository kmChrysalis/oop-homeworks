package images;

public class Transpose extends ImageDecorator {

    public Transpose(Image transposed) {
        super(transposed.getHeight(), transposed.getWidth(), transposed);
    }

    @Override
    public RGB get(int x, int y) {
        return this.img1.get(y, x);
    }
}
