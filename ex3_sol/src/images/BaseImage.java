package images;

public abstract class BaseImage implements Image {
    protected int Width, Height;
    protected RGB color1, color2;

    public BaseImage(int width, int height, RGB input1, RGB input2) {
        this.Width = width;
        this.Height = height;
        this.color1 = input1;
        this.color2 = input2;
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
