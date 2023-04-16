import java.io.*;
import java.util.ArrayList;

public class ReadWriteFile<T> {
    public ArrayList<T> readFromFile(String filename) throws IOException, ClassNotFoundException {
        try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(filename))) {
            return (ArrayList<T>) objectInputStream.readObject();
        }
    }
    public void writeToFile(String filename, ArrayList<T> data) throws IOException {
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(filename))) {
            objectOutputStream.writeObject(data);
        }
    }
}