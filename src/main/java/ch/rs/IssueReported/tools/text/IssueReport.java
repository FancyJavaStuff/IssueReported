package ch.rs.IssueReported.tools.text;

public class IssueReport {

    private final String NEW_ISSUE = "A new Exception has been thrown: ";
    private final String EXISTING_ISSUE = "This Exception has occuren again: ";
    private final String DETAIL_LEVEL = "The set detail level is: ";
    private final String CENSORING_MODE = "The set Censor Mode is: ";
    
    private final String NEW_ISSUE_TITLE ="Issue ";
    
    private final String ISSUE_HASH = " [IH]";
    
    private DetailLevel textDetail = DetailLevel.DETAILED;
    private CensorLevel censorMode = CensorLevel.NORMAL;
    
    private String title;

    /**
     * To compare Issues, the HashCode should be generated out of
     * the line number, the class it happened in and the thrown exception
     * This way, one can change Detial level aswell as Censoring,
     * and the issue will still report to the already existing issue on Github.
     */
    private int issueHash;
    
    private final String NEWLINE = System.lineSeparator();
    
    private StringBuilder textGenerator;

    public void generateNewIssueText(Exception e){
        generateIssueStringBuilder(e);
        generateIssueHash(e);
        generateIssueTitle(e);
        generateBody(e);
    };
    
    public void generatCommentOnIssueText(Exception e){
        generateCommentStringBuilder(e);
        generateIssueHash(e);
        generateBody(e);
    };
    
    private void generateBody(Exception e){
        for(StackTraceElement ste : e.getStackTrace()){
            textGenerator.append(textDetail.getDetails(ste));
        }
    }
    
    private void generateIssueTitle(Exception e){
        title = new StringBuilder()
                .append(NEW_ISSUE_TITLE)
                .append(e.getClass())
                .append(ISSUE_HASH)
                .append(issueHash)
                .toString();
    }
    
    private void generateIssueStringBuilder(Exception e){
        textGenerator = new StringBuilder()
                            .append(NEW_ISSUE)
                            .append(e.getClass())
                            .append(DETAIL_LEVEL)
                            .append(textDetail.name())
                            .append(NEWLINE)
                            .append(CENSORING_MODE)
                            .append(censorMode.name())
                            .append(NEWLINE)
                            .append(NEWLINE);
    }
    
    private void generateCommentStringBuilder(Exception e){
        textGenerator = new StringBuilder()
                            .append(EXISTING_ISSUE)
                            .append(e.getClass())
                            .append(DETAIL_LEVEL)
                            .append(textDetail.name())
                            .append(NEWLINE)
                            .append(CENSORING_MODE)
                            .append(censorMode.name())
                            .append(NEWLINE)
                            .append(NEWLINE);
    }
    
    private void generateIssueHash(Exception e){
        issueHash = new StringBuilder()
                        .append(e.getClass())
                        .append(e.getStackTrace()[0].getLineNumber())
                        .append(e.getStackTrace()[0].getClassName())
                        .toString().hashCode();
    }
    
    

    private String getCause(Exception e){
        return censorMode.getCausingObject(e);
    }

    public void setCensorMode(CensorLevel mode){
        censorMode = mode;
    }

    public void setDetailLevel(DetailLevel level){ 
        textDetail = level;
    }

}
