package dev.sample.test.online.page.signup;

import dev.sample.common.code.GenderVo;
import dev.sample.test.online.page.Parts;
import dev.sample.test.online.selenide.Events;
import dev.sample.test.online.selenide.Items;
import java.util.List;
import java.util.Map;
import com.codeborne.selenide.SelenideElement;
import lombok.Getter;
import org.openqa.selenium.support.FindBy;

@Getter
public class UserDetailEntryPage extends Parts {

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
    setNameKanjiVal(nameKanji);
    setNameKanaVal(nameKana);
    setGenderVal(gender);
    setBirthdayVal(birthday);
    setAddressZipVal(addressZip);
    setAddressVal(address);

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

  public String getNameKanjiVal() {
    return nameKanji.val();
  }

  public void setNameKanjiVal(String nameKanji) {
    this.nameKanji.val(nameKanji);
  }

  public String getNameKanaVal() {
    return nameKana.val();
  }

  public void setNameKanaVal(String nameKana) {
    this.nameKana.val(nameKana);
  }

  public GenderVo getGenderVal() {
    return Items.getRadioCode(this.gender, GenderVo.class);
  }

  public void setGenderVal(GenderVo gender) {
    Items.setRadioCode(this.gender, genderIndexMap, gender);
  }

  public String getBirthdayVal() {
    return birthday.val();
  }

  public void setBirthdayVal(String birthday) {
    this.birthday.val(birthday);
  }

  public String getAddressZipVal() {
    return addressZip.val();
  }

  public void setAddressZipVal(String addressZip) {
    this.addressZip.val(addressZip);
  }

  public String getAddressVal() {
    return address.val();
  }

  public void setAddressVal(String address) {
    this.address.val(address);
  }

}
