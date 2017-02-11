package ch.adriankrebs.services.book.util.IO;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Adrian on 1/5/2017.
 */
public class Serialization {


    public static List<Animal> getAnimals(File dataFile) throws IOException,
            ClassNotFoundException {
        List<Animal> animals = new ArrayList<Animal>();
        try (ObjectInputStream in = new ObjectInputStream(
                new BufferedInputStream(new FileInputStream(dataFile)))) {
            while (true) {
                Object object = in.readObject();
                if (object instanceof Animal)
                    animals.add((Animal) object);
            }
        } catch (EOFException e) {// File end reached
        }
        return animals;
    }

    public static void createAnimalsFile(List<Animal> animals, File dataFile)
            throws IOException {
        try (ObjectOutputStream out = new ObjectOutputStream(
                new BufferedOutputStream(new FileOutputStream(dataFile)))) {
            for (Animal animal : animals)
                out.writeObject(animal);
        }
    }

    public static void main(String[] args) throws IOException,
            ClassNotFoundException {
        List<Animal> animals = new ArrayList<Animal>();
        animals.add(new Animal("Tommy Tiger", 5, 'T'));
        animals.add(new Animal("Peter Penguin", 8, 'P'));
        File dataFile = new File("animal.data");
        try{
            PrintWriter writer = new PrintWriter("animal.data", "UTF-8");
            writer.println("The first line");
            writer.println("The second line");
            writer.close();
        } catch (IOException e) {
            // do something
        }
        //createAnimalsFile(animals, dataFile);
        System.out.println(getAnimals(dataFile));
    }


    static class Animal implements Serializable {
        private static final long serialVersionUID = 1L;
        private String name;
        private int age;
        private char type;
        private transient String gender;

        public Animal(String name, int age, char type) {
            this.name = name;
            this.age = age;
            this.type = type;
        }

        // Custom Serialization
        private void writeObject(ObjectOutputStream os) throws Exception {
            os.defaultWriteObject();
            os.writeInt(gender.length());
            //write the state of bond objects}
            os.writeBoolean(gender.contains("F"));
        }

        private void readObject(ObjectInputStream os) throws Exception {
            os.defaultReadObject();
            int n = os.readInt();
            //read the state of bond objects.
        }
        public String getName() {
            return name;
        }

        public int getAge() {
            return age;
        }

        public char getType() {
            return type;
        }

        public String toString() {
            return "Animal [name=" + name + ", age=" + age + ", type=" + type + "]";
        }
    }
}
