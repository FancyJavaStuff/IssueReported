package ch.rs.IssueReported.reportGenerator;


public class IssueReport {

    private String title;
    private String text;
    private int hashCode;

    public IssueReport(){
        generateReport();
    }

    public IssueReport(Exception e){
        generateTitle(e);
    }

    private  void generateTitle(Exception e){
        String causeClass[] = e.getClass().toString().split("\\.");
        title = causeClass[causeClass.length-1];
        System.out.println(title);
    }

    private void generateReport(){
        title = "Testreport";
        text = "This is a different test Report. Its supposed to be used to experiment with the GitHub API.";
        hashCode = text.hashCode();
    }

    public String getTitle(){
        return "[IR]" + title + " [IH]" + hashCode;
    }

    public String getBody(){
        return text;
    }

    public String getHashString(){ return String.valueOf(hashCode);}

    public String getCommentBody(){
        return "This Error has occured again in the following circumstances:\n" + text;
    }

}
