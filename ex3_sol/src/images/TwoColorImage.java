package images;

public class TwoColorImage extends BaseImage {
    private TwoDFunc f;

    public TwoColorImage(int width, int height, RGB input1, RGB input2, TwoDFunc func) {
        super(width, height, input1, input2);
        this.f = func;
    }

    @Override
    public RGB get(int x, int y) {
        double alpha = f.f((double)x / getWidth(), (double)y / getHeight());
        return (alpha <= 0) ? this.color1 ://alpha < 0 return color 1
                (alpha >= 1) ? this.color2 : //alpha > 1 return color 2
                        RGB.mix(this.color2, this.color1, alpha); //
    }
}
