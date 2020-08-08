package dev.sample.test.online.page.signup;

import dev.sample.test.online.page.Parts;
import com.codeborne.selenide.SelenideElement;
import lombok.Getter;
import org.openqa.selenium.support.FindBy;

@Getter
public class UserEntryInfoConfirmPage extends Parts {

  @FindBy(id = "editUserInfo")
  private SelenideElement editUserInfo;
  @FindBy(id = "editDetailInfo")
  private SelenideElement editDetailInfo;

}
