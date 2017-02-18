package com.buddybuild.bbandroidsampletests;

import java.math.RoundingMode;
import java.text.DecimalFormat;

/**
 * Interval timer for test purposes
 */
class TestTimer {
   private long nanoStart;
   private long nanoInterval;

   void start() {
      nanoStart = System.nanoTime();
   }

   void stop() {
      nanoInterval = System.nanoTime() - nanoStart;
   }

   /**
    * @return the time that passed in seconds to 3 fixed decimal places
    */
   String time() {
      stop();
      DecimalFormat df = new DecimalFormat("0.000");//rounding and formatting
      df.setRoundingMode(RoundingMode.CEILING);
      double d = (double) (nanoInterval);
      String time = df.format(d / 1000000000D);
      return time;
   }
}