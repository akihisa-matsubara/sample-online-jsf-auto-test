package dev.sample.test.online.scenario;

import com.codeborne.selenide.Configuration;

public abstract class AbstractSelenideTest {

  /** report path format. */
  private static final String REPORT_PATH_FORMAT = "test-results/reports/%s/%s_%s";

  // report
  public void setReportsFolder(String testNo, String desc) {
    Configuration.reportsFolder = String.format(REPORT_PATH_FORMAT, this.getClass().getSimpleName(), testNo, desc);
  }

}
