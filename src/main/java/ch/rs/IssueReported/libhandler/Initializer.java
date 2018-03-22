package ch.rs.IssueReported.libhandler;


import ch.rs.IssueReported.credentials.Account;
import ch.rs.IssueReported.reportGenerator.IssueReport;
import ch.rs.IssueReported.reporter.ReportingUnitNew;
import jdk.internal.org.objectweb.asm.ClassReader;

import java.io.*;
import java.util.Arrays;

public class Initializer implements Runnable {

    private Account account;
    private String owner = "FancyJavaStuff";
    private String repository = "IssueReported";


    @Override
    public void run() {

        account = new Account("", "");
        ReportingUnitNew rUnit = new ReportingUnitNew(account);
        rUnit.setRepository(owner, repository);
        //rUnit.reportIssueToRepository(new IssueReport());
       // new IssueReport(new IOException());
        //new IssueReport(new NullPointerException());
        try{
            String test[] = {"one","two","three"};
            System.out.println(test[4]);
        } catch (ArrayIndexOutOfBoundsException e) {
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

    }
}
