/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tree_posfix_khai;

/**
 *
 * @author FPTSHOP
 */
public class Node {

    String value;
    Node left, fight;

    public Node(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getFight() {
        return fight;
    }

    public void setFight(Node fight) {
        this.fight = fight;
    }
    

}
