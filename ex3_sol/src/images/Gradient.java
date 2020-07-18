package images;

public class Gradient extends BaseImage {

    public Gradient(int width, int height, RGB start, RGB end) {
        super(width, height, start, end);
    }

    @Override
    public RGB get(int x, int y) {
        return RGB.mix(this.color2, this.color1, (double)x/super.Width);
    }
}
