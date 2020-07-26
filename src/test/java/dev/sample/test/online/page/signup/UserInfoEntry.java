package dev.sample.test.online.page.signup;

import static com.codeborne.selenide.Condition.*;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import dev.sample.test.online.constant.Styles;
import dev.sample.test.online.page.Parts;
import dev.sample.test.online.selenide.Events;
import dev.sample.test.online.utils.ScreenshotUtils;

public class UserInfoEntry extends Parts {

  @FindBy(id = "username")
  private SelenideElement username;
  @FindBy(id = "email")
  private SelenideElement email;
  @FindBy(id = "password")
  private SelenideElement password;
  @FindBy(id = "passwordConfirm")
  private SelenideElement passwordConfirm;

  public void next(String username, String email, String password, String passwordConfirm) {
    // input
    this.username.val(username);
    this.email.val(email);
    this.password.val(password);
    this.passwordConfirm.val(passwordConfirm);

    Events.blur();

    // verify
    this.username.should(cssClass(Styles.VALIDATION_SUCCESSFULL));
    this.password.should(cssClass(Styles.VALIDATION_SUCCESSFULL));

    // action
    super.next();
  }

  public void verifyValidationError(String username, String email, String password, String passwordConfirm) {
    // input
    this.username.val(username);
    this.email.val(email);
    this.password.val(password);
    this.passwordConfirm.val(password);

    Events.blur();

    // verify
    this.username.should(cssClass(Styles.VALIDATION_FAILED));
    this.email.should(cssClass(Styles.VALIDATION_FAILED));
    this.password.should(cssClass(Styles.VALIDATION_FAILED));
    this.passwordConfirm.should(cssClass(Styles.VALIDATION_FAILED));
    ScreenshotUtils.takeScreenshotInvalidAfter();
  }

  public void clear() {
    this.username.clear();
    this.email.clear();
    this.password.clear();
    this.passwordConfirm.clear();
    Events.blur();
  }

}
