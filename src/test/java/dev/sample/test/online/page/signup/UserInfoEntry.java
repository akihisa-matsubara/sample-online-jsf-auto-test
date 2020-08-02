package dev.sample.test.online.page.signup;

import dev.sample.test.online.page.Parts;
import dev.sample.test.online.selenide.Events;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;

public class UserInfoEntry extends Parts {

  @FindBy(id = "username")
  private SelenideElement username;
  @FindBy(id = "email")
  private SelenideElement email;
  @FindBy(id = "password")
  private SelenideElement password;
  @FindBy(id = "passwordConfirm")
  private SelenideElement passwordConfirm;

  public void input(String username, String email, String password, String passwordConfirm) {
    setUsername(username);
    setEmail(email);
    setPassword(password);
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

  public String getUsername() {
    return username.val();
  }

  public void setUsername(String username) {
    this.username.val(username);
  }

  public String getEmail() {
    return email.val();
  }

  public void setEmail(String email) {
    this.email.val(email);
  }

  public String getPassword() {
    return password.val();
  }

  public void setPassword(String password) {
    this.password.val(password);
  }

  public String getPasswordConfirm() {
    return passwordConfirm.val();
  }

  public void setPasswordConfirm(String passwordConfirm) {
    this.passwordConfirm.val(passwordConfirm);
  }

}
