package dev.sample.test.online.page.signup;

import static com.codeborne.selenide.Condition.*;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import dev.sample.common.code.GenderVo;
import dev.sample.test.online.constant.Styles;
import dev.sample.test.online.page.Parts;
import dev.sample.test.online.selenide.Events;
import dev.sample.test.online.utils.ScreenshotUtils;

public class UserDetailEntry extends Parts {

  public static Map<String, Integer> genderOrderMap;

  static {
    genderOrderMap = new ConcurrentHashMap<String, Integer>();
    for (int i = 0; i < GenderVo.values().length; i++) {
      genderOrderMap.put(GenderVo.values()[i].getCode(), i);
    }
  }

  @FindBy(id = "nameKanji")
  private SelenideElement nameKanji;
  @FindBy(id = "nameKana")
  private SelenideElement nameKana;
  @FindBy(name = "gender")
  private List<SelenideElement> gender;
  @FindBy(id = "birthday")
  private SelenideElement birthday;
  @FindBy(id = "addressZip")
  private SelenideElement addressZip;
  @FindBy(id = "address")
  private SelenideElement address;

  public void next(String nameKanji, String nameKana, String gender, String birthday, String addressZip, String address) {
    // input
    this.nameKanji.val(nameKanji);
    this.nameKana.val(nameKana);
    this.gender.get(genderOrderMap.get(gender)).parent().click();
    this.birthday.val(birthday);
    this.addressZip.val(addressZip);
    this.address.val(address);

    Events.blur();

    // verify
    this.nameKanji.should(cssClass(Styles.VALIDATION_SUCCESSFULL));
    this.nameKana.should(cssClass(Styles.VALIDATION_SUCCESSFULL));
    this.birthday.should(cssClass(Styles.VALIDATION_SUCCESSFULL));
    this.addressZip.should(cssClass(Styles.VALIDATION_SUCCESSFULL));
    this.address.should(cssClass(Styles.VALIDATION_SUCCESSFULL));

    // action
    super.next();
  }

  public void verifyValidationError(String nameKanji, String nameKana, String addressZip, String address) {
    // input
    this.nameKanji.val(nameKanji);
    this.nameKana.val(nameKana);
    this.addressZip.val(addressZip);
    this.address.val(address);

    Events.blur();

    // verify
    this.nameKanji.should(cssClass(Styles.VALIDATION_FAILED));
    this.nameKana.should(cssClass(Styles.VALIDATION_FAILED));
    this.addressZip.should(cssClass(Styles.VALIDATION_FAILED));
    this.address.should(cssClass(Styles.VALIDATION_FAILED));
    ScreenshotUtils.takeScreenshotInvalidAfter();
  }

  public void clear() {
    this.nameKanji.clear();
    this.nameKana.clear();
    // gender doesn't clear
    this.birthday.clear();
    this.addressZip.clear();
    this.address.clear();
    Events.blur();
  }

}
