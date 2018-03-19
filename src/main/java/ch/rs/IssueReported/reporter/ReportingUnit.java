package ch.rs.IssueReported.reporter;

import ch.rs.IssueReported.credentials.Account;
import ch.rs.IssueReported.credentials.CredentialsStore;

public class ReportingUnit {

    private String account;
    private String password;
    private Account submittionAccount;
    private Class<? extends CredentialsStore> credentialStore;

    public <T extends CredentialsStore> void setCredentialStore(Class<T> credentialStore){
        this.credentialStore = credentialStore;
    }

    public void reportHash() {

    }

    private void createErrorHash(){

    }

    private void submitNewIssue(){

    }

    private void submitExistingIssue(){

    }


    public void reportIssueToRepository(String repository){

    }

    private boolean checkErrorHash(){
        return true;
    }
}
