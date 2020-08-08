package dev.sample.test.online.unit.signup;

import static com.codeborne.selenide.Condition.*;
import static org.assertj.core.api.Assertions.*;
import dev.sample.test.online.AbstractSelenideTest;
import dev.sample.test.online.constant.Styles;
import dev.sample.test.online.page.signup.UserInfoEntryPage;
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
class UserInfoEntryTest extends AbstractSelenideTest {

  @DisplayName("UserInfoEntryのテスト")
  @Nested
  class UserInfoEntry {
    @DisplayName("正常系 - 画面遷移")
    @ParameterizedTest
    @CsvFileSource(resources = "/data/UserInfoEntry.csv", numLinesToSkip = 1)
    void test(String testNo, String desc, String expected, String viewName, String jsonFileName, String username, String email, String password) {
      // --- setup -----
      // スクリーンショットの出力先変更
      setReportsFolder(testNo, desc);
      // -- test menu ---------------------------
      TestMenuPage testMenu = Pages.openTestMenu(TestMenuPage.class);
      testMenu.submit(viewName, jsonFileName);

      // --- execute ---
      // -- user info entry --------------------
      UserInfoEntryPage userInfoEntry = Pages.page(UserInfoEntryPage.class);
      userInfoEntry.input(username, email, password, password);

      // --- verify ----
      userInfoEntry.getUsername().should(cssClass(Styles.VALIDATION_SUCCESSFULL));
      userInfoEntry.getEmail().should(cssClass(Styles.VALIDATION_SUCCESSFULL));
      userInfoEntry.getPassword().should(cssClass(Styles.VALIDATION_SUCCESSFULL));
      userInfoEntry.next();
      ScreenshotUtils.takeScreenshotInit();
      assertThat(WebDriverRunner.url()).as(desc).contains(expected);
    }

    @DisplayName("準正常系 - 単項目チェック")
    @ParameterizedTest
    @CsvFileSource(resources = "/data/UserInfoEntry-singleItemCheck.csv", numLinesToSkip = 1)
    void testSingleItemCheck(String testNo, String desc, String viewName, String jsonFileName, String username, String email, String password) {
      // --- setup -----
      // スクリーンショットの出力先変更
      setReportsFolder(testNo, desc);
      // -- test menu ---------------------------
      TestMenuPage testMenu = Pages.openTestMenu(TestMenuPage.class);
      testMenu.submit(viewName, jsonFileName);

      // --- execute ---
      // -- user info entry --------------------
      UserInfoEntryPage userInfoEntry = Pages.page(UserInfoEntryPage.class);
      userInfoEntry.input(username, email, password, password);
      ScreenshotUtils.takeScreenshotInvalidAfter();

      // --- verify ----
      userInfoEntry.getUsername().should(cssClass(Styles.VALIDATION_FAILED));
      userInfoEntry.getEmail().should(cssClass(Styles.VALIDATION_FAILED));
      userInfoEntry.getPassword().should(cssClass(Styles.VALIDATION_FAILED));
      userInfoEntry.getPasswordConfirm().should(cssClass(Styles.VALIDATION_FAILED));
    }
  }

}
