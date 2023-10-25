package keeptrackscorebymaxheap;

import java.util.Scanner;

public class KeepTrackscoreByMaxHeap {

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        MaxHeapForPlayer h = new MaxHeapForPlayer();
        int n;
        while (true) {
            n = h.getChoice();
            switch (n) {
                case 1:
                    System.out.print("enter name :");
                    String name = sc.nextLine().trim();
                    System.out.print("enter scores : ");
                    int score = sc.nextInt();
                    sc.nextLine();
                    h.add(new Player(name, score));
                    System.out.println("add success");
                    break;

                case 2:
                    System.out.print("Enter top bao nhieu : ");
                    int m = sc.nextInt();
                    sc.nextLine(); 
                    for (int i = 0; i < m; i++) {
                        Player p = h.getMax();
                        if (p == null) {
                            System.out.println("hien tai chi co " + i + " nguoi choi!");
                            break;
                        } else {
                            System.out.println("top " + (i + 1) + " : " + p);
                        }
                    }
                    for (Player p : h.listBackUp) {
                        h.add(p);
                    }
                    h.listBackUp.clear();
            }
        }

    }

}
