package dev.sample.test.online.page.signup;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;
import dev.sample.test.online.page.Parts;

public class UserEntryComplete extends Parts {

  public void isDisplayed() {
    $("h5").shouldHave(text("Created your account!!"));
  }

}
