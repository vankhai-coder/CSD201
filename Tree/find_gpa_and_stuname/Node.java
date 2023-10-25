
package find_gpa_and_stuname;

/**
 *
 * @author FPTSHOP
 */
public class Node {

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
