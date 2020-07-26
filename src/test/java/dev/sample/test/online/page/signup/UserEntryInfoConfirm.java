package dev.sample.test.online.page.signup;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import dev.sample.test.online.page.Parts;

public class UserEntryInfoConfirm extends Parts {

  @FindBy(id = "editUserInfo")
  private SelenideElement editUserInfo;
  @FindBy(id = "editDetailInfo")
  private SelenideElement editDetailInfo;

}
