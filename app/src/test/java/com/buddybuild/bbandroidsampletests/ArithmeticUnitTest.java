package com.buddybuild.bbandroidsampletests;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ArithmeticUnitTest extends TestLog {
   static String className;

   @BeforeClass
   public static void onceExecutedBefore() {
      mainHeader("app:testDebugUnitTest","Executor 1");
      className=Thread.currentThread().getStackTrace()[1].getClassName();//package+className, can be refactored
      header(className);
   }

   @Test
   public void addition_isCorrect() throws Exception {
      started( "addition_isCorrect");
      try {
         assertEquals(4, 2 + 2);
      } catch (java.lang.AssertionError e) {
         lineNum=new Throwable().getStackTrace()[0].getLineNumber();
         success = false;
         fail();
      }
      ended();
   }

   @Test
   public void subtraction_isCorrect() throws Exception {
      started("subtraction_isCorrect");
      try {
         assertEquals(2, 4 - 2);
      } catch (java.lang.AssertionError e) {
         lineNum=new Throwable().getStackTrace()[0].getLineNumber();
         success = false;
         fail();
      }
      ended();
   }

   @Test
   public void multiplication_isCorrect() throws Exception {
      started("multiplication_isCorrect");
      try {
         assertEquals(2, 1 * 2);
      } catch (java.lang.AssertionError e) {
         lineNum=new Throwable().getStackTrace()[0].getLineNumber();
         success = false;
         fail();
      }
      ended();
   }

   @Test
   public void division_isCorrect() throws Exception {
      started("division_isCorrect");
      try {
         assertEquals(2, 4 / 2);
      } catch (java.lang.AssertionError e) {
         lineNum=new Throwable().getStackTrace()[0].getLineNumber();
         success = false;
         fail();
      }
      ended();
   }

   @AfterClass
   public static void onceExecutedAfter() {
      footer(className);
   }
}