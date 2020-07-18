package images;

public class RGB {
    private double[] color = new double[3];

    public static final RGB BLACK = new RGB(0);
    public static final RGB WHITE = new RGB(1);
    public static final RGB RED = new RGB(1,0,0);
    public static final RGB GREEN = new RGB(0,1,0);
    public static final RGB BLUE = new RGB(0,0,1);

    public RGB(double red, double green, double blue) {
        this.color[0] = red > 1 ? 1 : red; //check for legality of numbers and save
        this.color[1] = green > 1 ? 1 : green;
        this.color[2] = blue > 1 ? 1 : blue;
    }

    public RGB(double grey) { //use main constructor to save color
        this(grey, grey, grey);
    }
    public double getRed() {
        return this.color[0];
    }

    public double getGreen() {
        return this.color[1];
    }

    public double getBlue() {
        return this.color[2];
    }

    //all functions just calculatin and returning color

    public RGB invert() {
        return new RGB(1 - this.color[0],
                        1 - this.color[1],
                        1 - this.color[2]);
    }

    public RGB filter(RGB filter) {
        return new RGB(this.color[0] * filter.color[0],
                        this.color[1] * filter.color[1],
                        this.color[2] * filter.color[2]);
    }

    public static RGB superpose(RGB rgb1, RGB rgb2) {
        return new RGB(rgb1.color[0] + rgb2.color[0],
                        rgb1.color[1] + rgb2.color[1],
                        rgb1.color[2] + rgb2.color[2]);
    }

    public static RGB mix(RGB rgb1, RGB rgb2, double alpha) {
        return new RGB(alpha * rgb1.color[0] + (1 - alpha) * rgb2.color[0],
                       alpha * rgb1.color[1] + (1 - alpha) * rgb2.color[1],
                       alpha * rgb1.color[2] + (1 - alpha) * rgb2.color[2]);
    }

    public String toString() {
        return String.format("<%.4f, %.4f, %.4f>", this.color[0], this.color[1], this.color[2]);
    }



}
