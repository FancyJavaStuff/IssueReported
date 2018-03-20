package ch.rs.IssueReported.reporter;

import ch.rs.IssueReported.credentials.Account;
import ch.rs.IssueReported.credentials.CredentialsStore;
import ch.rs.IssueReported.reportGenerator.IssueReport;
import org.eclipse.egit.github.core.Issue;
import org.eclipse.egit.github.core.Repository;
import org.eclipse.egit.github.core.User;
import org.eclipse.egit.github.core.client.GitHubClient;
import org.eclipse.egit.github.core.service.IssueService;
import org.eclipse.egit.github.core.service.RepositoryService;

import java.io.IOException;

public class ReportingUnit {

    private String account;
    private String password;
    private Class<? extends CredentialsStore> credentialStore;
    private GitHubClient client;
    private Repository repo;

    public <T extends CredentialsStore> void setCredentialStore(Class<T> credentialStore){
        this.credentialStore = credentialStore;

    }

    public ReportingUnit(Account account) {
        this.account = account.getUsername();
        password = account.getPassword();
        client = new GitHubClient();
        client.setCredentials(this.account, password);
    }

    public void reportHash() {

    }

    private void createErrorHash(){

    }

    private void submitNewIssue(){

    }

    private void submitExistingIssue(){

    }

    public void getRepository(String owner, String repository){
        RepositoryService rServ = new RepositoryService();
        try {
            repo = rServ.getRepository(owner, repository);
            System.out.println(repo.getName());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }


    public void reportIssueToRepository(IssueReport report){
        try {
            IssueService issue = new IssueService(client);
            Issue issueReport = new Issue();
            User user = new User();
            user.setName("testUser");
            issueReport.setUser(new User());
            issueReport.setTitle(report.getTitle());
            issueReport.setBody(report.getBody());
            issue.createIssue(repo, issueReport);
            //issue.createIssue("FancyJavaStuff", "IssueReported", issueReport);
        } catch (IOException e) {
            System.out.println("@reportIssueToRepository " + e.getMessage());
        }


    }

    private boolean checkErrorHash(){
        return true;
    }
}
