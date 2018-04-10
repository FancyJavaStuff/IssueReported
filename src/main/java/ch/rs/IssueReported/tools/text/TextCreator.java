package ch.rs.IssueReported.tools.text;

public class TextCreator {

    private DetailLevel textDetail = DetailLevel.DETAILED;
    private CensorLevel censorMode = CensorLevel.NORMAL;

    private final String NEWLINE = System.lineSeparator();

    private String getMethodName(StackTraceElement stElement){
        return stElement.getMethodName();
    }

    private String getCause(Exception e){
        return censorMode.getCausingObject(e);
    }

    public void setCensorMode(CensorLevel mode){
        censorMode = mode;
    }

    public void setDetailLevel(DetailLevel level){ textDetail = level;}

}
