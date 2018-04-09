package ch.rs.IssueReported.util;

public enum VariableAnalyzer {



    /**
     * Returns the Cause of the Exception as a String
     */
    NORMAL,

    /**
     * Returns a censored String of the cause. This is usefull when handling stuff like
     * filenames, paths, credentials.
     */
    CENSORED {

        @Override
        public String getCausingObject(Exception e){
            return CENSORED_TEXT;
        }

    };

    private static final String CENSORED_TEXT = "<censored>";

    public String getCausingObject(Exception e){
        return e.getMessage();
    };


}
