package ch.rs.IssueReported.util;

import com.sun.org.apache.bcel.internal.generic.NEW;

public enum TextCreator {

    DETAILED {
        public String generateText(Exception e){
            StringBuilder stringBuilder = getStringBuilder(e);


        }
    },


    MEDIUM{
        public String generateText(Exception e){

        }
    },


    LOW{
        public String generateText(Exception e){

        }
    },


    CRITICAL{
        public String generateText(Exception e){

        }
    };

    private static  VariableAnalyzer censorMode = VariableAnalyzer.NORMAL;
    private final static String TITLE = "Generated report for : ";
    private final static String CAUSE_TEXT = "The cause of this Exception was: ";
    private final static String DETAIL_TEXT= "Reporting detail is set to: ";
    private final static String STACKTRACE = "The StackTrace was: ";
    private final static String NEWLINE = System.lineSeparator();

    private String getMethodName(StackTraceElement stElement){
        return stElement.getMethodName();
    }

    private String getCause(Exception e){
        return censorMode.getCausingObject(e);
    }

    private static StringBuilder getStringBuilder(Exception e){
        return new StringBuilder()
                .append(TITLE)
                .append(e.getClass().getCanonicalName())
                .append(NEWLINE)
                .append(CAUSE_TEXT)
                .append(censorMode.getCausingObject(e))
                .append(NEWLINE)
                .append(DETAIL_TEXT)
                .append() //insert selected enum name
                .append(NEWLINE)
                .append(STACKTRACE)
                .append(NEWLINE);
    }

    public void setCensorMode(VariableAnalyzer mode){
        censorMode = mode;
    }

    String exception[] = e.getClass().getName().split("\\.");
    String exceptionName = exception[exception.length-1];
            System.out.println(exceptionName + " was thrown with the cause " + e.getMessage());
            for(StackTraceElement ste : e.getStackTrace()){
        System.out.println("Method name: " + ste.getMethodName());
        System.out.println("Class name: " + ste.getClassName());
        System.out.println("File name: " + ste.getFileName());
        System.out.println("at line: " + ste.getLineNumber());
        System.out.println("Is native method: " + ste.isNativeMethod());
        System.out.println(ste.toString());
        System.out.println("-----------------------------");
    }

}
