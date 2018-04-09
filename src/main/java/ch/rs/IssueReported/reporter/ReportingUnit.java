package ch.rs.IssueReported.reporter;

import ch.rs.IssueReported.credentials.Account;
import ch.rs.IssueReported.reportGenerator.IssueReport;
import ch.rs.IssueReported.util.VariableAnalyzer;
import org.kohsuke.github.*;

import java.io.IOException;

/**
 * https://github.com/git/git/blob/master/README#L18-L20
 * ^use above link to highlight lines in code. This will allow the reporter
 * to create direct links to the line that caused the issue.
 *
 */

public class ReportingUnit {

    private String username;
    private String password;
    private VariableAnalyzer censoringMode = VariableAnalyzer.NORMAL;
    GitHub github;
    GHRepository repo;

    public ReportingUnit(Account account) {
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

    private GHRepository getRepository(String owner, String repository){
        try {
            return github.getRepository(owner + "/" + repository);
        } catch (IOException e) {
            System.out.println("getRepository " + e.getMessage());
            return null;
        }
    }

    public String createText(){

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

    private String getCause(Exception e){
        return censoringMode.getCausingObject(e);
    }

    private GHIssue getIssue(int issueId) {
        try {
            return repo.getIssue(issueId);
        } catch (IOException e) {
            System.out.println("getIssue " + e.getMessage());
            return new GHIssue();
        }
    }

    public void setCensoring(VariableAnalyzer mode){
        censoringMode = mode;
    }

    private boolean checkErrorHash(){
        return true;
    }
}
