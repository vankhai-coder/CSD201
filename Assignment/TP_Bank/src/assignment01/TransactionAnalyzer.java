
package assignment01;

import java.util.ArrayList;

public class TransactionAnalyzer {

    private Usser user;
    private ArrayList<Transaction> list;

    public TransactionAnalyzer(Usser user, ArrayList<Transaction> list) {
        this.user = user;
        this.list = list;
    }

    public ArrayList<Transaction> getList() {
        return list;
    }

    public Usser getUser() {
        return user;
    }
    
}
