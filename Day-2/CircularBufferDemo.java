import java.util.Arrays;

// Circular Buffer Implementation
class CircularBuffer {
    private int[] buffer;
    private int size;
    private int start;
    private int end;
    private boolean isFull;

    // Constructor to initialize buffer with given size
    public CircularBuffer(int capacity) {
        this.buffer = new int[capacity];
        this.size = capacity;
        this.start = 0;
        this.end = 0;
        this.isFull = false;
    }

    // Method to insert an element into the buffer
    public void insert(int value) {
        buffer[end] = value;
        end = (end + 1) % size;

        if (isFull) {
            start = (start + 1) % size; // Overwrite oldest element
        }

        isFull = (end == start);
    }

    // Method to get the current state of the buffer
    public int[] getBufferContents() {
        if (!isFull && end == start) {
            return new int[0]; // Return empty array if buffer is empty
        }

        int[] result = new int[size];
        int index = 0;
        int i = start;

        do {
            result[index++] = buffer[i];
            i = (i + 1) % size;
        } while (i != end || isFull && index < size);

        return Arrays.copyOf(result, index);
    }

    // Method to display buffer contents
    public void displayBuffer() {
        System.out.println("Buffer: " + Arrays.toString(getBufferContents()));
    }
}

// Main class naemd CircularBufferDemoto test Circular Buffer
public class CircularBufferDemo {
    public static void main(String[] args) {
        CircularBuffer buffer = new CircularBuffer(3);

        buffer.insert(1);
        buffer.insert(2);
        buffer.insert(3);
        buffer.displayBuffer(); 

        buffer.insert(4); 
        buffer.displayBuffer();

        buffer.insert(5); 
        buffer.displayBuffer(); 
    }
}
