package dev.sample.test.online.unit.signup;

import static com.codeborne.selenide.Condition.*;
import static org.assertj.core.api.Assertions.*;
import dev.sample.common.code.GenderVo;
import dev.sample.common.util.CodeUtils;
import dev.sample.test.online.AbstractSelenideTest;
import dev.sample.test.online.constant.Styles;
import dev.sample.test.online.page.signup.UserDetailEntryPage;
import dev.sample.test.online.page.test.TestMenuPage;
import dev.sample.test.online.selenide.Pages;
import dev.sample.test.online.selenide.SelenideExtension;
import dev.sample.test.online.utils.ScreenshotUtils;
import com.codeborne.selenide.WebDriverRunner;
import com.codeborne.selenide.junit5.ScreenShooterExtension;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

@ExtendWith({ScreenShooterExtension.class, SelenideExtension.class})
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class UserDetailEntryTest extends AbstractSelenideTest {

  @DisplayName("UserDetailEntryのテスト")
  @Nested
  class UserDetailEntry {
    @DisplayName("正常系 - 画面遷移")
    @ParameterizedTest
    @CsvFileSource(resources = "/data/UserDetailEntry.csv", numLinesToSkip = 1)
    void test(String testNo, String desc, String expected, String viewName, String jsonFileName, String nameKanji, String nameKana, String gender,
        String birthday, String addressZip, String address) {
      // --- setup -----
      // スクリーンショットの出力先変更
      setReportsFolder(testNo, desc);
      // -- test menu ---------------------------
      TestMenuPage testMenu = Pages.openTestMenu(TestMenuPage.class);
      testMenu.submit(viewName, jsonFileName);

      // --- execute ---
      // -- user info entry --------------------
      UserDetailEntryPage userDetailEntry = Pages.page(UserDetailEntryPage.class);
      userDetailEntry.input(nameKanji, nameKana, CodeUtils.decode(gender, GenderVo.class), birthday, addressZip, address);

      // --- verify ----
      userDetailEntry.getNameKanji().should(cssClass(Styles.VALIDATION_SUCCESSFULL));
      userDetailEntry.getNameKana().should(cssClass(Styles.VALIDATION_SUCCESSFULL));
      userDetailEntry.getBirthday().should(cssClass(Styles.VALIDATION_SUCCESSFULL));
      userDetailEntry.getAddressZip().should(cssClass(Styles.VALIDATION_SUCCESSFULL));
      userDetailEntry.getAddress().should(cssClass(Styles.VALIDATION_SUCCESSFULL));
      userDetailEntry.next();
      ScreenshotUtils.takeScreenshotInit();
      assertThat(WebDriverRunner.url()).as(desc).contains(expected);
    }

    @DisplayName("準正常系 - 単項目チェック")
    @ParameterizedTest
    @CsvFileSource(resources = "/data/UserDetailEntry-singleItemCheck.csv", numLinesToSkip = 1)
    void testSingleItemCheck(String testNo, String desc, String viewName, String jsonFileName, String nameKanji, String nameKana, String gender,
        String birthday, String addressZip, String address) {
      // --- setup -----
      // スクリーンショットの出力先変更
      setReportsFolder(testNo, desc);
      // -- test menu ---------------------------
      TestMenuPage testMenu = Pages.openTestMenu(TestMenuPage.class);
      testMenu.submit(viewName, jsonFileName);

      // --- execute ---
      // -- user info entry --------------------
      UserDetailEntryPage userDetailEntry = Pages.page(UserDetailEntryPage.class);
      userDetailEntry.input(nameKanji, nameKana, CodeUtils.decode(gender, GenderVo.class), birthday, addressZip, address);
      ScreenshotUtils.takeScreenshotInvalidAfter();

      // --- verify ----
      userDetailEntry.getNameKanji().should(cssClass(Styles.VALIDATION_FAILED));
      userDetailEntry.getNameKana().should(cssClass(Styles.VALIDATION_FAILED));
      userDetailEntry.getBirthday().should(cssClass(Styles.VALIDATION_FAILED));
      userDetailEntry.getAddressZip().should(cssClass(Styles.VALIDATION_FAILED));
      userDetailEntry.getAddress().should(cssClass(Styles.VALIDATION_FAILED));
    }
  }

}
