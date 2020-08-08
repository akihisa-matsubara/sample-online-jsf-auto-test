package dev.sample.test.online.page.signup;

import dev.sample.test.online.page.Parts;
import dev.sample.test.online.selenide.Events;
import com.codeborne.selenide.SelenideElement;
import lombok.Getter;
import org.openqa.selenium.support.FindBy;

@Getter
public class UserInfoEntryPage extends Parts {

  @FindBy(id = "username")
  private SelenideElement username;
  @FindBy(id = "email")
  private SelenideElement email;
  @FindBy(id = "password")
  private SelenideElement password;
  @FindBy(id = "passwordConfirm")
  private SelenideElement passwordConfirm;

  public void input(String username, String email, String password, String passwordConfirm) {
    setUsernameVal(username);
    setEmailVal(email);
    setPasswordVal(password);
    setPasswordConfirm(passwordConfirm);

    Events.blur();
  }

  public void next(String username, String email, String password, String passwordConfirm) {
    input(username, email, password, passwordConfirm);
    super.next();
  }

  public void clear() {
    username.clear();
    email.clear();
    password.clear();
    passwordConfirm.clear();

    Events.blur();
  }

  public String getUsernameVal() {
    return username.val();
  }

  public void setUsernameVal(String username) {
    this.username.val(username);
  }

  public String getEmailVal() {
    return email.val();
  }

  public void setEmailVal(String email) {
    this.email.val(email);
  }

  public String getPasswordVal() {
    return password.val();
  }

  public void setPasswordVal(String password) {
    this.password.val(password);
  }

  public String getPasswordConfirmVal() {
    return passwordConfirm.val();
  }

  public void setPasswordConfirm(String passwordConfirm) {
    this.passwordConfirm.val(passwordConfirm);
  }

}
