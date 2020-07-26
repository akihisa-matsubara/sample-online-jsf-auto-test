package dev.sample.test.online.utils;

import static com.codeborne.selenide.Selenide.*;

public class ScreenshotSupport {

  /** screenshot name format. */
  private static final String SS_FORMAT = "%03d-%s-%s";

  /** screenshot counter. */
  private static int ssCounter = 1;

  public static void takeScreenshot(String action) {
    screenshot(String.format(SS_FORMAT, ssCounter, title().replaceAll(" ", "_"), action));
    ssCounter++;
  }

  //NOTE: 縦スクロールのみ対応、画像結合未対応
  public static void takeScreenshotFull(String action) {
    executeJavaScript("$(window).scrollTop(0)");
    takeScreenshot(action);

    int windowHeight = ((Long) executeJavaScript("return $(window).height()")).intValue();
    int formHeight = ((Long) executeJavaScript("return $('#mainForm')[0].scrollHeight")).intValue();
    for (int i = 0; i < formHeight / windowHeight; i++) {
      executeJavaScript("$(window).scrollTop(" + (windowHeight * (i + 1)) + ")");
      takeScreenshot(action);
    }
  }

  public static void clear() {
    ssCounter = 1;
  }

}
