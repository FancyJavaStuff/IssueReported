package ch.rs.IssueReported.reporter;

import ch.rs.IssueReported.credentials.Account;
import ch.rs.IssueReported.credentials.CredentialsStore;
import ch.rs.IssueReported.reportGenerator.IssueReport;
import org.kohsuke.github.*;

import java.io.IOException;

public class ReportingUnitNew {

    private String username;
    private String password;
    private Class<? extends CredentialsStore> credentialStore;
    GitHub github;
    GHRepository repo;

    public <T extends CredentialsStore> void setCredentialStore(Class<T> credentialStore){
        this.credentialStore = credentialStore;

    }

    public ReportingUnitNew(Account account) {
        this.username = account.getUsername();
        password = account.getPassword();
        try {
            github = GitHub.connectUsingPassword(username, password);
        } catch (IOException e){
            System.out.println("reportingUnitNew " + e.getMessage());
        }
    }

    public void setRepository(String owner, String repositoryName){
        repo = getRepository(owner, repositoryName);
    }

    public void reportHash() {

    }

    private void createErrorHash(){

    }

    private void submitNewIssue(){

    }

    private void submitExistingIssue(){

    }

    private GHRepository getRepository(String owner, String repository){
        try {
            return github.getRepository(owner + "/" + repository);
        } catch (IOException e) {
            System.out.println("getRepository " + e.getMessage());
            return null;
        }
    }


    private GHIssue issueExist(String hashCode){

        try {
            for (GHIssue issue : repo.getIssues(GHIssueState.OPEN)) {
                if(issue.getTitle().split("IH]")[1].equals(hashCode)){
                    return  issue;
                }
            }
            return new GHIssue();
        }catch (IOException e){
            System.out.println("issueExist: " + e.getMessage());
            return new GHIssue();
        }
    }


    public void reportIssueToRepository(IssueReport  issueReport){
        GHIssue issue = issueExist(issueReport.getHashString());
        if(issue.getTitle() != null){
            try {
                issue.comment(issueReport.getCommentBody());
            } catch (IOException e){
                System.out.println("reportIssueToRepository " + e.getMessage());
            }
            return;
        }
        try {
            GHIssueBuilder issueBuilder = repo.createIssue(issueReport.getTitle());
            issueBuilder.body(issueReport.getBody());
            issueBuilder.create();
        } catch (IOException e) {
            System.out.println("reportIssueToRepository " + e.getMessage());
        }
    }

    private GHIssue getIssue(int issueId) {
        try {
            return repo.getIssue(issueId);
        } catch (IOException e) {
            System.out.println("getIssue " + e.getMessage());
            return new GHIssue();
        }
    }

    private boolean checkErrorHash(){
        return true;
    }
}
