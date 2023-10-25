package assignment;

import java.io.BufferedReader;
import java.io.FileReader;

/**271 379
 *
 * @author FPTSHOP
 */
public class AssignMent {

    MaxHeapBYYear heap = new MaxHeapBYYear();

    public void readFileAndCreateHeap() {
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader("books.csv.txt"));

            String line;

            while ((line = reader.readLine()) != null) {
                String[] parts = line.split("\";\"");
                String isbn = parts[0];
                String bookTitle = parts[1];
                String bookAuthor = parts[2];
                int yearOfPublication = Integer.parseInt(parts[3].replaceAll("\"",""));
                String publisher = parts[4];
                String imageS = parts[5];
                String imageM = parts[6];
                String imageL = parts[7];
                heap.add(new Book(isbn, bookTitle, bookAuthor, publisher, imageS, imageM, imageL, yearOfPublication));
            }                    

        } catch (Exception e) {
            System.out.println("Loi doc file !");
        } finally {
            try {
                if (reader != null) {
                    reader.close();
                }
            } catch (Exception e) {
                System.out.println("Loi dong file");
            }
          
        }
    }

    public void display() {
        System.out.println("\t Top 10 books :");
        for (int i = 0; i < 10; i++) {
            System.out.println(heap.getMax());
        }
    }

    public static void main(String[] args) {
        AssignMent a = new AssignMent();
        a.readFileAndCreateHeap();
        a.display();
    }

}
