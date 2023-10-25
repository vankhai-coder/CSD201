package keeptrackscorebymaxheap;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class MaxHeapForPlayer {

    private ArrayList<Player> list = new ArrayList<>();
    ArrayList<Player> listBackUp = new ArrayList<>();
    private Scanner sc = new Scanner(System.in);

    public void add(Player x) {
        list.add(x);
        int i = list.size() - 1;
        while (i != 0 && list.get(i).getScore() > list.get((i - 1) / 2).getScore()) {
            swap(i, (i - 1) / 2);
            i = (i - 1) / 2;
        }
    }

    public void swap(int a, int b) {
        Collections.swap(list, a, b);
    }

    public Player getMax() {
        if (list.isEmpty()) {
            return null;
        }
        if (list.size() == 1) {
            Player x = list.get(0);
            listBackUp.add(x);
            list.remove(0);
            return x;
        }
        // lay player max : 
        Player k = list.get(0);
        listBackUp.add(list.get(0));
        // thay doi va xoa : 
        swap(0, list.size() - 1);
        list.remove(list.size() - 1);
        // setup lai gia tri :
        int i = 0;
        while (true) {
            // neu co 2 con : 
            if (2 * i + 2 < list.size()) {
                // neu nho hon ca hai : 
                if (list.get(i).getScore() < list.get(2 * i + 1).getScore() && list.get(i).getScore() < list.get(2 * i + 2).getScore()) {
                    if (list.get(2 * i + 2).getScore() < list.get(2 * i + 1).getScore()) {
                        swap(i, 2 * i + 1);
                        i = 2 * i + 1;
                    } else {
                        swap(i, 2 * i + 2);
                        i = 2 * i + 2;
                    }
                } else {
                    // neu nho hon 1 trong 2 : 
                    if (list.get(i).getScore() < list.get(2 * i + 1).getScore()) {
                        swap(i, 2 * i + 1);
                        i = 2 * i + 1;
                    } else {
                        if (list.get(i).getScore() < list.get(2 * i + 2).getScore()) {
                            swap(i, 2 * i + 1);
                            i = 2 * i + 2;
                        } else {
                            // neu lon hon ca 2 : 
                            return k;
                        }
                    }

                }
            } else {
                // neu co 1 con : 
                if (2 * i + 1 < list.size()) {
                    if (list.get(i).getScore() < list.get(2 * i + 1).getScore()) {
                        swap(i, 2 * i + 1);
                    }
                    return k;

                } else {
                    // neu khong co oon : 
                    return k;
                }
            }
        }
    }
    public int getChoice (){
        System.out.println("\t==============");
        System.out.println("1.add player ");
        System.out.println("2.sout top n players ");
        System.out.print("Enter your choice :");
        int n = sc.nextInt(); 
        sc.nextLine(); 
        return n; 
    }

}
