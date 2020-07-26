package dev.sample.test.online.selenide;

import com.codeborne.selenide.Selenide;
import dev.sample.test.online.utils.ScreenshotUtils;

public class Pages {

  public static <PageObjectClass> PageObjectClass open(Class<PageObjectClass> pageObjectClass) {
    PageObjectClass page = Selenide.open("/", pageObjectClass);
    ScreenshotUtils.takeScreenshotInit();
    return page;
  }

  public static <PageObjectClass> PageObjectClass page(Class<PageObjectClass> pageObjectClass) {
    PageObjectClass page = Selenide.page(pageObjectClass);
    ScreenshotUtils.takeScreenshotInit();
    return page;
  }

}
