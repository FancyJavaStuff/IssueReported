package ch.rs.IssueReported.reportGenerator;


public class IssueReport {

    private String title;
    private String text;
    private int hashCode;

    public IssueReport(){
        generateReport();
    }

    public IssueReport(Exception e){

    }

    private void generateReport(){
        title = "Testreport";
        hashCode = this.hashCode();
        text = "This is a test Report. Its supposed to be used to experiment with the GitHub API.";
    }

    public String getTitle(){
        return title;
    }

    public String getBody(){
        return text + "\n" + "hasCode: " + hashCode;
    }

}
