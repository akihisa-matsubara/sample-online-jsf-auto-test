package dev.sample.test.online.page;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import dev.sample.test.online.enumeration.Actions;
import dev.sample.test.online.utils.ScreenshotUtils;

public abstract class Parts {

  // header
  @FindBy(id = "headerLogo")
  private SelenideElement headerLogo;
  @FindBy(id = "logIn")
  private SelenideElement logIn;
  @FindBy(id = "signUp")
  private SelenideElement signUp;

  // footer
  @FindBy(id = "footerLogo")
  private SelenideElement footerLogo;

  // button
  @FindBy(id = "back")
  private SelenideElement back;
  @FindBy(id = "next")
  private SelenideElement next;
  @FindBy(id = "confirmed")
  private SelenideElement confirmed;
  @FindBy(id = "goToTopPage")
  private SelenideElement goToTopPage;

  public void headerLogo() {
    ScreenshotUtils.takeScreenshotActionBefore(Actions.HEADER_LOGO);
    this.headerLogo.click();
  }

  public void login() {
    ScreenshotUtils.takeScreenshotActionBefore(Actions.LOGIN);
    this.logIn.click();
  }

  public void signUp() {
    ScreenshotUtils.takeScreenshotActionBefore(Actions.SIGN_UP);
    this.signUp.click();
  }

  public void footerLogo() {
    ScreenshotUtils.takeScreenshotActionBefore(Actions.FOOTER_LOGO);
    this.footerLogo.click();
  }

  public void back() {
    ScreenshotUtils.takeScreenshotActionBefore(Actions.BACK);
    this.back.click();
  }

  public void next() {
    ScreenshotUtils.takeScreenshotActionBefore(Actions.NEXT);
    this.next.click();
  }

  public void confirmed() {
    ScreenshotUtils.takeScreenshotActionBefore(Actions.CONFIRMED);
    this.confirmed.click();
  }

  public void goToTopPage() {
    ScreenshotUtils.takeScreenshotActionBefore(Actions.GO_TO_TOP_PAGE);
    this.goToTopPage.click();
  }

}
