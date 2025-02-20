// Importing the required classes.
import java.io.*;

public class PipedStreamExample {

    public static void main(String[] args) {
        try {
            // Creating piped input and output streams.
            PipedOutputStream pipeOut = new PipedOutputStream();
            PipedInputStream pipeIn = new PipedInputStream(pipeOut);

            // Creating a writer thread.
            Thread writerThread = new Thread(new DataWriter(pipeOut));

            // Creating a reader thread.
            Thread readerThread = new Thread(new DataReader(pipeIn));

            // Starting both threads.
            writerThread.start();
            readerThread.start();

            // Ensuring both threads finish execution.
            writerThread.join();
            readerThread.join();

        } catch (IOException | InterruptedException e) {
            System.err.println("Error in piped stream communication: " + e.getMessage());
        }
    }
}

// Runnable class for writing data to the PipedOutputStream.
class DataWriter implements Runnable {
    private final PipedOutputStream outputStream;

    public DataWriter(PipedOutputStream outputStream) {
        this.outputStream = outputStream;
    }

    @Override
    public void run() {
        try (outputStream) {
            String message = "Hello from Writer Thread!";
            outputStream.write(message.getBytes());
            System.out.println("Writer Thread: Data written to pipe.");
        } catch (IOException e) {
            System.err.println("Writer Thread Error: " + e.getMessage());
        }
    }
}

// Runnable class for reading data from the PipedInputStream
class DataReader implements Runnable {
    private final PipedInputStream inputStream;

    public DataReader(PipedInputStream inputStream) {
        this.inputStream = inputStream;
    }

    
    public void run() {

        try (inputStream) {
            byte[] buffer = new byte[1024];
            int bytesRead = inputStream.read(buffer);
            String receivedData = new String(buffer, 0, bytesRead);
            System.out.println("Reader Thread: Received Data - " + receivedData);
        } catch (IOException e) {
            System.err.println("Reader Thread Error: " + e.getMessage());
        }
    }
}
