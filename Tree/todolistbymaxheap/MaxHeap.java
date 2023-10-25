package todolistbymaxheap;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class MaxHeap {

    ArrayList<Task> list = new ArrayList<>();
    Scanner sc = new Scanner(System.in);

    public void add(Task x) {
        list.add(x);
        int i = list.size() - 1;
        while (i != 0 && list.get(i).getPri() > list.get((i - 1) / 2).getPri()) {
            swap(i, (i - 1) / 2);
            i = (i - 1) / 2;
        }
    }

    public void swap(int a, int b) {
        Collections.swap(list, a, b);

    }

    public Task getMax() {
        if (list.isEmpty()) {
            return null;
        }
        if (list.size() == 1) {
            Task x = list.get(0);
            list.remove(0);
            return x;
        }
        // lay task max : 
        Task k = list.get(0);
        // thay doi va xoa : 
        swap(0, list.size() - 1);
        list.remove(list.size() - 1);
        // setup lai gia tri :
        int i = 0;
        while (true) {
            // neu co 2 con : 
            if (2 * i + 2 < list.size()) {
                // neu nho hon ca hai : 
                if (list.get(i).getPri() < list.get(2 * i + 1).getPri() && list.get(i).getPri() < list.get(2 * i + 2).getPri()) {
                    if (list.get(2 * i + 2).getPri() < list.get(2 * i + 1).getPri()) {
                        swap(i, 2 * i + 1);
                        i = 2 * i + 1;
                    } else {
                        swap(i, 2 * i + 2);
                        i = 2 * i + 2;
                    }
                } else {
                    // neu nho hon 1 trong 2 : 
                    if (list.get(i).getPri() < list.get(2 * i + 1).getPri()) {
                        swap(i, 2 * i + 1);
                        i = 2 * i + 1;
                    } else {
                        if (list.get(i).getPri() < list.get(2 * i + 2).getPri()) {
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
                    if (list.get(i).getPri() < list.get(2 * i + 1).getPri()) {
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

    public static void main(String[] args) {
        MaxHeap heap = new MaxHeap();
        for (int i = 0; i < 5; i++) {
            System.out.print("enter task name : ");
            String name = heap.sc.nextLine().trim();
            System.out.print("Enter priority :");
            int n = heap.sc.nextInt();
            heap.sc.nextLine();
            Task task = new Task(name, n);
            heap.add(task);
        }
        System.out.println("thu tu uu tien : ");
        while (true) {
            Task x = heap.getMax();
            if (x == null) {
                break;
            }
            System.out.println(x);

        }
    }
}
