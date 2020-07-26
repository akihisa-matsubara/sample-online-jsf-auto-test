package dev.sample.test.online.selenide;

import com.codeborne.selenide.Selenide;

public class Events {

  public static void blur() {
    Selenide.executeJavaScript("document.activeElement.blur()");
  }

}
