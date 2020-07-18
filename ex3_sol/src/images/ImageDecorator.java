package images;

public abstract class ImageDecorator implements Image { //extends BaseImage

    protected Image img1;
    protected int Width;
    protected int Height;

    public ImageDecorator(int width, int height, Image input) {
        this.Width = width;
        this.Height = height;
        this.img1 = input;
    }

    @Override
    public int getWidth() {
        return this.Width;
    }

    @Override
    public int getHeight() {
        return this.Height;
    }

    public abstract RGB get(int x, int y);
}