package images;

public class Mix extends BinaryImageDecorator {

    private double alpha;

    public Mix(Image base1, Image base2, double alpha) {
        super(Math.max(base1.getWidth(), base2.getWidth()), Math.max(base1.getHeight(), base2.getHeight()), base1, base2);
        this.alpha = alpha;
    }

    @Override
    public RGB get(int x, int y) {
        int width1 = img1.getWidth(), height1 = img1.getHeight();
        int width2 = img2.getWidth(), height2 = img2.getHeight();

        return (x <= width1 && x <= width2 && y <= height1 && y <= height2) ? //check x & y and return
                RGB.mix(img1.get(x, y), img2.get(x, y), this.alpha) : //call mix if good for both
                    (x <= width1 && y <= height1) ? img1.get(x, y) : //return first color
                        (x <= width2 && y <= height2) ? img2.get(x, y) : RGB.BLACK; //return second color
    }
}
