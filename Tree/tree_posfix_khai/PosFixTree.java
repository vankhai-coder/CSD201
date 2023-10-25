package tree_posfix_khai;

import java.util.LinkedList;
import java.util.Scanner;

public class PosFixTree {
    
    Node root;
    Scanner sc;
    
    public PosFixTree() {
        this.root = null;
        this.sc = new Scanner(System.in);
    }
    
    public LinkedList<Node> createList(String string) {
        LinkedList<Node> list = new LinkedList<>();
        String[] parts = string.trim().split("\\s+");
        
        for (String part : parts) {
            Node newNode = new Node(part);
            list.add(newNode);
        }
        return list;
    }
    
    public String getString() {
        System.out.print("Enter string : ");
        return sc.nextLine();
    }
    
    public void createeTree(LinkedList<Node> list) {
        if (list.size() <= 2) {
            this.root = null;
            return;
        }
        
        for (int i = 0; i < list.size(); i++) {
            if (list.size() == 1) {
                this.root = list.get(0);
                return;
            }
            if (i == list.size() - 2) {
                this.root = null;                
                return;
            }
            if (isNumber(list.get(i)) && isNumber(list.get(i + 1)) && isOperator(list.get(i + 2))) {
                list.get(i + 2).left = list.get(i);
                list.get(i + 2).fight = list.get(i + 1);
                list.remove(i);
                list.remove(i);
                i = -1;
            }
            
        }
    }
    
    
    public boolean isNumber(Node x) {
        return x.left != null || (x.value.matches("\\d+"));
    }
    
    public boolean isOperator(Node x) {
        return (x.value.equals("+") || x.value.equals("-")
                || x.value.equals("*") || x.value.equals("/")) && x.left == null;
    }

    public boolean isOper(Node x) {
        return x.value.equals("+")|| x.value.equals("-")|| x.value.equals("*")|| x.value.equals("/");
    }
    
    public double execute(Node root) {
        if (isOper(root)) {
            switch (root.value.charAt(0)) {
                case '+' -> {
                    return execute(root.left) + execute(root.fight);
                }
                case '-' -> {
                    return execute(root.left) - execute(root.fight);
                }
                case '*' -> {
                    return execute(root.left) * execute(root.fight);
                }
                case '/' -> {
                    return execute(root.left) / execute(root.fight);
                }
            }
        }
        return Double.parseDouble(root.value);
    }
    
    public static void main(String[] args) {
        PosFixTree p = new PosFixTree();
        while (true) {
            p.root = null;            
            p.createeTree(p.createList(p.getString()));
            if (p.root == null) {
                System.out.println("can not create tree by this string !");
            } else {
                System.out.println("create successful");
                System.out.println("Result is : " + p.execute(p.root));
            }
        }
    }
}
