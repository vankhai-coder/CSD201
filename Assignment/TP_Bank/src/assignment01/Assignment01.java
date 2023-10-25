package assignment01;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import CSDL.MaxHeapForDate;
import CSDL.MaxHeapForDouble;
import CSDL.MinHeapForDate;
import CSDL.MinHeapForDouble;

public class Assignment01 {

    private Scanner sc = new Scanner(System.in);

    public Usser createUser() {
        System.out.print("Enter name :");
        String name = sc.nextLine().trim();
        System.out.print("Enter account number :");
        String accountNumber = sc.nextLine().trim();
        System.out.print("Enter balance :");
        double balance = sc.nextDouble();
        return new Usser(name, accountNumber, balance);
    }

    public LocalDate createDate() {
        Random ran = new Random();
        int year = ran.nextInt(24) + 2000;
        int month = ran.nextInt(12) + 1;
        int day = ran.nextInt(Month.of(month).length(true)) + 1;
        return LocalDate.of(year, month, day);
    }

    public ArrayList createTransaction() {
        Random random = new Random();
        // tao 5 transaction ngau nhien :
        ArrayList list = new ArrayList();
        for (int i = 0; i < 5; i++) {
            LocalDate date = createDate();
            double amount = Math.round((random.nextDouble() * 100) * 100.0) / 100.0;
            String type = (random.nextBoolean()) ? "deposit" : "withdraw";
            list.add(new Transaction(date, amount, type));
        }
        return list;

    }

    public int getChoice() {
        System.out.println("================-=========");
        System.out.println("1.Calculate_balance_history");
        System.out.println("2.Find_min_max_balance");
        System.out.println("3.Find_top_deposits_and_withdrawals");
        System.out.println("4.Find_mean_transaction");
        System.out.println("5.Find_most_frequent_transactions");
        System.out.print("Enter your choice :");
        return sc.nextInt();
    }

    public void find_top_deposits_and_withdrawals(ArrayList<Transaction> list) {
        // find top 3 withdraw :
        ArrayList<Transaction> listDraw = getListWithdraw(list);
        MaxHeapForDouble maxHeap = new MaxHeapForDouble();
        for (Transaction t : listDraw) {
            maxHeap.add(t.getAmount());
        }
        System.out.println("\tTop 3 Withdraw :");
        for (int i = 0; i < 3; i++) {
            System.out.println("top " + (i + 1) + " : " + maxHeap.getMax());
        }
        // find top 3 deposit : 
        ArrayList<Transaction> listDeposit = getListDeposit(list);
        MaxHeapForDouble maxDeposit = new MaxHeapForDouble();
        for (Transaction t : listDeposit) {
            maxDeposit.add(t.getAmount());
        }
        System.out.println("\tTop 3 Deposit :");
        for (int i = 0; i < 3; i++) {
            System.out.println("top " + (i + 1) + " : " + maxDeposit.getMax());
        }

    }

    public ArrayList calculate_balance_history(TransactionAnalyzer x) {
        ArrayList<Double> listBalance = new ArrayList();
        MaxHeapForDate heap = new MaxHeapForDate();
        // tao heap : 
        for (Transaction t : x.getList()) {
            heap.add(t);
        }
        // tinh toan : 
        if (heap.xemMax() == null) {
            return listBalance;
        }
        listBalance.add((heap.xemMax().getType().equals("deposit")) ? (x.getUser().getBalance() + heap.getMax().getAmount()) : (x.getUser().getBalance() - heap.getMax().getAmount()));
        while (true) {
            Transaction tran = heap.getMax();
            if (tran == null) {
                return listBalance;
            } else {
                listBalance.add(tran.getType().equals("deposit") ? (listBalance.get(listBalance.size() - 1) + tran.getAmount()) : (listBalance.get(listBalance.size() - 1) - tran.getAmount()));
            }
        }
    }

    public ArrayList getListDeposit(ArrayList<Transaction> list) {
        ArrayList listDepo = new ArrayList();
        for (Transaction t : list) {
            if (t.getType().equals("deposit")) {
                listDepo.add(t);
            }
        }
        return listDepo;
    }

    public ArrayList getListWithdraw(ArrayList<Transaction> list) {
        ArrayList listDraw = new ArrayList();
        for (Transaction t : list) {
            if (!t.getType().equals("deposit")) {
                listDraw.add(t);
            }
        }
        return listDraw;
    }

    public void find_min_max_balance(ArrayList<Double> list) {
        // tao max heap :
        MaxHeapForDouble maxHeap = new MaxHeapForDouble();
        for (double d : list) {
            maxHeap.add(d);
        }
        System.out.println("Max Balance : " + maxHeap.getMax());
        // tao min heap :
        MinHeapForDouble minHeap = new MinHeapForDouble();
        for (double d : list) {
            minHeap.add(d);
        }
        System.out.println("Min Balance : " + minHeap.getMin());

    }

    public void find_most_frequent_transactions(ArrayList<Transaction> list) {
        MinHeapForDate minHeap = new MinHeapForDate();
        for (Transaction t : list) {
            minHeap.add(t);
        }
        System.out.println("Most frequent transation is : " +minHeap.getMin());
    }

    public static void main(String[] args) {
        Assignment01 a = new Assignment01();
        TransactionAnalyzer tran = new TransactionAnalyzer(a.createUser(), a.createTransaction());
        int n;
        while (true) {
            n = a.getChoice();
            switch (n) {
                case 1:
                    for (Transaction t : tran.getList()) {
                        System.out.println(t);
                    }
                    System.out.println(a.calculate_balance_history(tran));
                    break;
                case 2:
                    a.find_min_max_balance(a.calculate_balance_history(tran));
                    break;
                case 3:
                    a.find_top_deposits_and_withdrawals(tran.getList());
                    break;
                case 4: 
                case 5: 
                    a.find_most_frequent_transactions(tran.getList());
                    break;

            }

        }

    }
}
