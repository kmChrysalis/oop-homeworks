package images;

public abstract class BinaryImageDecorator extends ImageDecorator implements Image {

    protected Image img2; //save only second image bc we extend ImageDecorator, first one will be there

    public BinaryImageDecorator(int width, int height, Image input1, Image input2) {
        super(width, height, input1);
        this.img2 = input2;
    }
}
