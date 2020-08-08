package dev.sample.test.online.page.test;

import dev.sample.test.online.page.Parts;
import dev.sample.test.online.selenide.Events;
import dev.sample.test.online.selenide.Items;
import java.util.Optional;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;

public class TestMenuPage extends Parts {

  @FindBy(id = "viewName")
  private SelenideElement viewName;
  @FindBy(xpath = "//div[@id='viewName-field']/div/input")
  private SelenideElement viewNameDropdownTrigger;
  @FindBy(id = "jsonFileName")
  private SelenideElement jsonFileName;
  @FindBy(xpath = "//div[@id='jsonFileName-field']/div/input")
  private SelenideElement jsonFileNameDropdownTrigger;
  @FindBy(id = "jsonFile")
  private SelenideElement jsonFile;
  @FindBy(id = "jsonValue")
  private SelenideElement jsonValue;

  public void input(String viewName, String jsonFileName) {
    setViewName(viewName);
    Optional.ofNullable(jsonFileName).ifPresent(s -> setJsonFileName(s));
    Events.blur();
  }

  public void submit(String viewName, String jsonFileName) {
    input(viewName, jsonFileName);
    super.submit();
  }

  public void clear() {
    viewName.clear();
    jsonFileName.clear();
    jsonFile.clear();
    jsonValue.clear();

    Events.blur();
  }

  public String getViewName() {
    return viewName.val();
  }

  public void setViewName(String viewName) {
    viewNameDropdownTrigger.click();
    Items.selectDropdownByInnerText(viewName);
  }

  public String getJsonFileName() {
    return jsonFileName.val();
  }

  public void setJsonFileName(String jsonFileName) {
    jsonFileNameDropdownTrigger.click();
    Items.selectDropdownByInnerText(jsonFileName);
  }

  public String getJsonValue() {
    return jsonValue.val();
  }

  public void setJsonValue(String jsonValue) {
    this.jsonValue.val(jsonValue);
  }

}
