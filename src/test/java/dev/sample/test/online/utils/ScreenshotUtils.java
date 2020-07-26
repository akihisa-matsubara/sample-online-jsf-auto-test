package dev.sample.test.online.utils;

import dev.sample.test.online.enumeration.Actions;

public class ScreenshotUtils {

  public static void takeScreenshotInit() {
    ScreenshotSupport.takeScreenshotFull(Actions.INIT.getDescription());
  }

  public static void takeScreenshotInvalidAfter() {
    ScreenshotSupport.takeScreenshotFull(Actions.VALIDATION.getDescription());
  }

  public static void takeScreenshotActionBefore(Actions action) {
    ScreenshotSupport.takeScreenshotFull("before_" + action.getDescription() + "_action");
  }

}
