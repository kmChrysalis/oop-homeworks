package images;

public class Superpose extends BinaryImageDecorator {

    public Superpose(Image base1, Image base2) {
        super(Math.max(base1.getWidth(), base2.getWidth()), Math.max(base1.getHeight(), base2.getHeight()), base1, base2);
     }

    @Override
    public RGB get(int x, int y) {
        int width1 = img1.getWidth(), height1 = img1.getHeight();
        int width2 = img2.getWidth(), height2 = img2.getHeight();
        RGB color1 = img1.get(x, y), color2 = img2.get(x, y);

        return (x <= width1 && x <= width2 && y <= height1 && y <= height2) ? //check x & y
            RGB.superpose(color1, color2) : //return super pose if good for both pictures
                (x <= width1 && y <= height1) ? color1 : //return color1
                        (x <= width2 && y <= height2) ? color2 ://color2
                                RGB.BLACK;
    }
}
