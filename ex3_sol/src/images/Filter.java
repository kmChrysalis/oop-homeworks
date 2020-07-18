package images;

public class Filter extends ImageDecorator {

    private RGB filter;

    public Filter(Image base, RGB filter){
        super(base.getWidth(), base.getHeight(), base);
        this.filter = filter;
    }

    public RGB get(int x, int y){
       return this.img1.get(x, y).filter(this.filter);
    }
}