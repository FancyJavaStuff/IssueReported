package ch.rs.IssueReported.libhandler;


import ch.rs.IssueReported.credentials.Account;
import ch.rs.IssueReported.reportGenerator.IssueReport;
import ch.rs.IssueReported.reporter.ReportingUnit;

import java.io.IOException;

public class Initializer implements Runnable {

    private Account account;
    private String owner = "FancyJavaStuff";
    private String repository = "IssueReported";


    @Override
    public void run() {

        account = new Account("", "");
        ReportingUnit rUnit = new ReportingUnit(account);
        rUnit.setRepository(owner, repository);
        rUnit.reportIssueToRepository(new NullPointerException());
        rUnit.reportIssueToRepository(new IOException());
        rUnit.reportIssueToRepository(new IndexOutOfBoundsException());

        }

}
