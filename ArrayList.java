import java.lang.*;
public class ArrayList<T> implements List<T> {

    private T[] arr;
    private int size;

    public ArrayList() {
        arr = (T[]) new Object[10];
        size = 0;
    }

    public void add(T item) {
        if (size == arr.length) {
            grow();
        }

        arr[size++] = item;
    }

    public void add(int pos, T item) {
        if (size == arr.length) {
            grow();
        }

        System.arraycopy(arr, pos, arr, pos + 1, size - pos);

        arr[pos] = item;
        size++;
    }

    public T get(int pos) {
        return arr[pos];
    }

    public T remove(int pos) {
        T temp = arr[pos];
        size--;
        System.arraycopy(arr, pos + 1, arr, pos, size - pos);
        return temp;
    }

    public int size() {
        return size;
    }

    // Double Array Size
    public void grow() {
        T[] tempArr = (T[]) new Object[arr.length * 2];

        System.arraycopy(arr, 0, tempArr, 0, arr.length);

        arr = tempArr;
    }
}
