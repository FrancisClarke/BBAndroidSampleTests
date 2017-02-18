package com.buddybuild.bbandroidsampletests;

/**
 * Extra logging for tests, indicating when the tests and test suites start and stop
 * along with the status and the duration
 */

public class TestLog {
   TestTimer timer = new TestTimer();
   static String methodName, theApp, theExecutor, className;
   long lineNum;
   Boolean success;

   public static void mainHeader(String app, String executor) {//suite start message
      theApp = app;
      theExecutor = executor;
      System.out.println("Buddybuild Starting Test Suite: Gradle Test Run :" + theApp + "}");
      System.out.println("Buddybuild Starting Test Suite: Gradle Test " + theExecutor + "}");
   }

   public static void header(String suite) {//suite start message
      className = suite;
      System.out.println("Buddybuild Starting Test Suite: " + className + "}");
      System.out.println("");
   }

   public static void footer(String suite) {//suite end message
      System.out.println("Buddybuild Finished Test Suite: " + suite + "}");
   }

   public static void mainFooter() {//suite end message, not called automatically
      System.out.println("Buddybuild Finished Test Suite: Gradle Test Run :" + theApp + "}");
      System.out.println("Buddybuild Finished Test Suite: Gradle Test " + theExecutor + "}");
   }

   /**
    * print test time taken and Success/Failure
    */
   public void ended() {
      String time = timer.time();
      if(success)
         System.out.println("Buddybuild Finished Test: " + methodName + " [" + time + "s] - SUCCESS");
   }

   /**
    * print start message and start timer
    */
   public void started(String name) {
      methodName = name;
      System.out.println("Buddybuild Starting Test: " + methodName);
      success = true;
      timer.start();
   }

   /**
    * print fail message and throw error
    */
   public void fail() {
      String time = timer.time();
      //custom error message
      System.out.println("Buddybuild Finished Test: " + methodName + " [" + time + "s] - FAILURE");
      System.out.println("");
      System.out.println( className + " > "+methodName+ " FAILED");
      //has to be an assertion error to print this:
      System.out.println( "   java.lang.AssertionError at " + methodName+ ".java:"+lineNum);
   }
}
