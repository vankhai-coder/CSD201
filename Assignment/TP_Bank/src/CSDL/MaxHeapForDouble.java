
package CSDL;

import java.util.ArrayList;
import java.util.Collections;

public class MaxHeapForDouble {

    ArrayList<Double> list = new ArrayList<>();

    public void add(double x) {
        list.add(x);
        int i = list.size() - 1;
        while (i != 0 && list.get(i) > list.get((i - 1) / 2)) {
            swap(i, (i - 1) / 2);
            i = (i - 1) / 2;
        }
    }

    public void swap(int a, int b) {
        Collections.swap(list, a, b);
    }

    public Double getMax() {
        if (list.isEmpty()) {
            return null;
        }
        if (list.size() == 1) {
            double x = list.get(0);
            list.remove(0);
            return x;
        }
        // lay x max : 
        double k = list.get(0);
        // thay doi va xoa : 
        swap(0, list.size() - 1);
        list.remove(list.size() - 1);
        // setup lai gia tri :
        int i = 0;
        while (true) {
            // neu co 2 con : 
            if (2 * i + 2 < list.size()) {
                // neu nho hon ca hai : 
                if (list.get(i) < list.get(2 * i + 1) && list.get(i) < list.get(2 * i + 2)) {
                    if (list.get(2 * i + 2) < list.get(2 * i + 1)) {
                        swap(i, 2 * i + 1);
                        i = 2 * i + 1;
                    } else {
                        swap(i, 2 * i + 2);
                        i = 2 * i + 2;
                    }
                } else {
                    // neu nho hon 1 trong 2 : 
                    if (list.get(i) < list.get(2 * i + 1)) {
                        swap(i, 2 * i + 1);
                        i = 2 * i + 1;
                    } else {
                        if (list.get(i) < list.get(2 * i + 2)) {
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
                    if (list.get(i) < list.get(2 * i + 1)) {
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
}
