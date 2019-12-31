package stacksqueues;

/**
 * Created by dmalladi on 12/30/2019.
 */
public class MyStack<V> {

    private int maxSize;
    int top;
    V[] array;

    @SuppressWarnings("unchecked")
    public MyStack(int maxSize) {
        this.maxSize = maxSize;
        top = -1;
        array = (V[]) new Object[maxSize];
    }

    public void push(V data) {
        if (!isFull()) {
            top = top + 1;
            array[top] = data;
        }
    }

    public V pop() {
        if (!isEmpty()) {

            return array[top--];
        }
        return null;
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public boolean isFull() {
        return top == maxSize-1 ;
    }

    public V peek() {
        if (!isEmpty()) {
            return array[top];
        }
        return null;
    }
}
