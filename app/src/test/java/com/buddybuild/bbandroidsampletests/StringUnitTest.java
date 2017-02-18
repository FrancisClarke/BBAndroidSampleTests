package com.buddybuild.bbandroidsampletests;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class StringUnitTest extends TestLog {
   static String className;

   @BeforeClass
   public static void onceExecutedBefore() {
      className=Thread.currentThread().getStackTrace()[1].getClassName();//package+className, can be refactored
      header(className);
   }
   @Test
   public void length_isCorrect() {
      started("length_isCorrect");
      try {
         assertEquals(4, "test".length());
      } catch (java.lang.AssertionError e) {
         lineNum=new Throwable().getStackTrace()[0].getLineNumber();
         success = false;
         fail();
      }
      ended();
   }

   @Test
   public void substring_isCorrect() {
      started("substring_isCorrect");
      try {
         assertEquals("ha", "sha".substring(1));
      } catch (java.lang.AssertionError e) {
         lineNum=new Throwable().getStackTrace()[0].getLineNumber();
         success = false;
         fail();
      }
      ended();
   }

   @Test
   public void indexOf_isCorrect() {
      started("indexOf_isCorrect");
      try {
         assertEquals(3, "hello".indexOf("lo"));
      } catch (java.lang.AssertionError e) {
         lineNum=new Throwable().getStackTrace()[0].getLineNumber();
         success = false;
         fail();
      }
      ended();
   }

   @AfterClass
   public static void onceExecutedAfter() {
      mainFooter();
      footer(className);
   }
}