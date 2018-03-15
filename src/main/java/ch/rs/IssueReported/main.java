package ch.rs.IssueReported;

import ch.rs.IssueReported.reporter.ReportingUnit;

public class main {

    public static void main(String args[]){
        ReportingUnit repo = new ReportingUnit();
        repo.reportHash();
        System.out.println(repo.hashCode());
    }

}
