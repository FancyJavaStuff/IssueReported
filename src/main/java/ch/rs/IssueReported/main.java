package ch.rs.IssueReported;

import ch.rs.IssueReported.libhandler.Initializer;

public class main {

    public static void main (String args[]){
        Thread t = new Thread(new Initializer());
        t.start();
    }
}
