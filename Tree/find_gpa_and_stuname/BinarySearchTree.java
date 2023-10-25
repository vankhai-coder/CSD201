package find_gpa_and_stuname;

import java.util.Scanner;

public class BinarySearchTree {

    Node root;
    Scanner sc = new Scanner(System.in);

    public Node createStu() {
        System.out.print("Enter name :");
        String name = fixString(sc.nextLine());
        System.out.print("Enter gpa :");
        float gpa = sc.nextFloat();
        sc.nextLine();
        Node newStu = new Node(name, gpa);
        return newStu;
    }
    class Node {

    String name;
    float gpa;
    Node left, right;

    public Node(String name, float gpa) {
        this.name = name;
        this.gpa = gpa;
    }

    @Override
    public String toString() {
        return "Studnet{" + "name=" + name + ", gpa=" + gpa + '}';
    }
    

}


    public void addStu(Node stu) {
        if (this.root == null) {
            this.root = stu;
        } else {
            Node current = root;
            while (true) {
                if (stu.name.compareTo(current.name) >0) {
                    if (current.right == null) {
                        current.right = stu;
                        break;
                    } else {
                        current = current.right;
                    }
                } else {
                    if (stu.name.compareTo(current.name)<0) {
                        if (current.left == null) {
                            current.left = stu;
                            break;
                        } else {
                            current = current.left;
                        }
                    } else {
                        System.out.println("this student already exsit!");
                        break;
                    }
                }

            }
        }
    }

    public String fixString(String name) {
        return name.replaceAll("\\s+", " ").toUpperCase().trim();
    }

    public void findAllMaxGpa(Node x, Node root) {
        if (root != null) {
            if (x.gpa == root.gpa) {
                System.out.println(root);
            }
            findAllMaxGpa(x, root.left);
            findAllMaxGpa(x, root.right);
        }
    }

    public Node findMaxGpa(Node root) {
        if (root != null) {
            return findMaxNodeInThree(root, findMaxGpa(root.right), findMaxGpa(root.left));
        } else {
            Node k = new Node("", 0);
            return k;
        }

    }

    public Node findMaxNodeInThree(Node a, Node b, Node c) {
        if (a.gpa >= b.gpa && a.gpa >= c.gpa) {
            return a;
        } else {
            if (b.gpa >= a.gpa && b.gpa >= c.gpa) {
                return b;
            } else {
                return c;
            }
        }
    }

    public Node findStu(Node root, String name) {
        if (root == null) {
            return null;
        } else {
            if (root.name.compareTo(name) == 0) {
                return root;
            } else {
                if (root.name.compareTo(name) >1) {
                    return findStu(root.left, name);
                } else {
                    return findStu(root.right, name);
                }
            }
        }
    }

    public int getSelected() {
        System.out.println("==========================");
        System.out.println("1. Add new student ");
        System.out.println("2. Find student by name ");
        System.out.println("3. Find highest GPA ");
        System.out.println("Other -> Exit !");
        System.out.print("Enter your choice : ");
        int n = sc.nextInt();
        sc.nextLine();
        return n;
    }
    public String getName (){
        System.out.print("Enter student name :");
        return  fixString(sc.nextLine());
    }

    public static void main(String[] args) {
        BinarySearchTree b = new BinarySearchTree();
        int n;
        boolean khai = true;
        while (khai) {
            n = b.getSelected();
            switch (n) {
                case 1:
                    Node newStu = b.createStu();
                    b.addStu(newStu);
                    break;
                case 2:
                    String name = b.getName();
                    System.out.println( b.findStu(b.root, name));
                    break;
                case 3:
                    System.out.println("Hishest GPA is : ");
                    b.findAllMaxGpa(b.findMaxGpa(b.root), b.root);
                    break;
                default:
                    khai = false;
            }

        }
    }

}
