package images;

public class Circle extends BaseImage {

    private int centerX, centerY, radius;

    public Circle(int width, int height, int centerX, int centerY, int radius, RGB center, RGB outside) {
        super(width, height, center, outside);
        this.centerX = centerX;
        this.centerY = centerY;
        this.radius = radius;
    }

    public Circle(int size, int radius, RGB center, RGB outside) {
        this(size, size, size/2, size/2, radius, center, outside); //use first constructor
    }
	
	@Override
    public RGB get(int x, int y) {
        double distance = (Math.sqrt(Math.pow(this.centerX - x, 2) + Math.pow(this.centerY - y, 2)) / radius) ; //calculate distance
        return (distance < 1) ? RGB.mix(this.color2, this.color1, distance) : //check and return
                RGB.mix(this.color1, this.color2, 0); //if distance big too much, will put 0 to it
    }
}

