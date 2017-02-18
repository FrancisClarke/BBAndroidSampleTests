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
public class FailUnitTest extends TestLog {

   @BeforeClass
   public static void onceExecutedBefore() {
      header(Thread.currentThread().getStackTrace()[1].getClassName());//package+className, can be refactored
   }

   @Test
   public void assert_IsNotCorrect() throws Exception {
      started("assert_IsNotCorrect");
      try {
         assertEquals(4, 3);
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