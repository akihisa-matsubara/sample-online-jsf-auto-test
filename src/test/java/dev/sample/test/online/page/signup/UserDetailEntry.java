package dev.sample.test.online.page.signup;

import dev.sample.common.code.GenderVo;
import dev.sample.test.online.page.Parts;
import dev.sample.test.online.selenide.Events;
import dev.sample.test.online.selenide.Items;
import java.util.List;
import java.util.Map;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;

public class UserDetailEntry extends Parts {

  private static Map<String, Integer> genderIndexMap;

  static {
    genderIndexMap = Items.getIndexMap(GenderVo.class);
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

  public void input(String nameKanji, String nameKana, GenderVo gender, String birthday, String addressZip, String address) {
    setNameKanji(nameKanji);
    setNameKana(nameKana);
    setGender(gender);
    setBirthday(birthday);
    setAddressZip(addressZip);
    setAddress(address);

    Events.blur();
  }

  public void next(String nameKanji, String nameKana, GenderVo gender, String birthday, String addressZip, String address) {
    input(nameKanji, nameKana, gender, birthday, addressZip, address);
    super.next();
  }

  public void clear() {
    nameKanji.clear();
    nameKana.clear();
    // gender can't clear
    birthday.clear();
    addressZip.clear();
    address.clear();

    Events.blur();
  }

  public String getNameKanji() {
    return nameKanji.val();
  }

  public void setNameKanji(String nameKanji) {
    this.nameKanji.val(nameKanji);
  }

  public String getNameKana() {
    return nameKana.val();
  }

  public void setNameKana(String nameKana) {
    this.nameKana.val(nameKana);
  }

  public GenderVo getGender() {
    return Items.getRadioCode(this.gender, GenderVo.class);
  }

  public void setGender(GenderVo gender) {
    Items.setRadioCode(this.gender, genderIndexMap, gender);
  }

  public String getBirthday() {
    return birthday.val();
  }

  public void setBirthday(String birthday) {
    this.birthday.val(birthday);
  }

  public String getAddressZip() {
    return addressZip.val();
  }

  public void setAddressZip(String addressZip) {
    this.addressZip.val(addressZip);
  }

  public String getAddress() {
    return address.val();
  }

  public void setAddress(String address) {
    this.address.val(address);
  }

}
