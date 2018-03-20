package ch.rs.IssueReported.libhandler;


import ch.rs.IssueReported.credentials.Account;
import ch.rs.IssueReported.reportGenerator.IssueReport;
import ch.rs.IssueReported.reporter.ReportingUnit;

public class Initializer implements Runnable {

    private Account account;
    private String owner = "FancyJavaStuff";
    private String repository = "IssueReported";


    @Override
    public void run() {

        account = new Account("**********", "**********");
        ReportingUnit rUnit = new ReportingUnit(account);
        rUnit.getRepository(owner, repository);
        rUnit.reportIssueToRepository(new IssueReport());

    }
}
