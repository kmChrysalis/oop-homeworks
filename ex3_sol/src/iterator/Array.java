package iterator;

public class Array implements Iterator {
    private int[] arr;
    private int index;

    public Array(int[] arr) {
        this.arr = arr;
        this.index = 0;
    }

    @Override
    public boolean hasNext() { //method to check if we has next number in array
        return index < this.arr.length;
    }

    @Override
    public int next() { //try return this array with index, and ++
       try {
           return arr[index++];
       }
       catch (IndexOutOfBoundsException e) { ///catch probable exception, and thow new one
           throw new IndexOutOfBoundsException("Index Out Of Bounds Exception");
       }
    }
}
