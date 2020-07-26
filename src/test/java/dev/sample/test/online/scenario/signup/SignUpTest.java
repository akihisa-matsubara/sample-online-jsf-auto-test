package dev.sample.test.online.scenario.signup;

import com.codeborne.selenide.junit5.ScreenShooterExtension;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import dev.sample.test.online.page.signup.UserDetailEntry;
import dev.sample.test.online.page.signup.UserEntryComplete;
import dev.sample.test.online.page.signup.UserEntryInfoConfirm;
import dev.sample.test.online.page.signup.UserInfoEntry;
import dev.sample.test.online.page.top.TopPage;
import dev.sample.test.online.scenario.AbstractSelenideTest;
import dev.sample.test.online.selenide.Pages;
import dev.sample.test.online.selenide.SelenideExtension;

@ExtendWith({ScreenShooterExtension.class, SelenideExtension.class})
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class SignUpTest extends AbstractSelenideTest {

  @DisplayName("ユーザー登録シナリオテスト")
  @Nested
  class SignUpScenario {
    @DisplayName("画面レイアウト確認・単項目チェックOK")
    @ParameterizedTest
    @CsvFileSource(resources = "/data/SignUpScenario.csv", numLinesToSkip = 1)
    void test(String testNo, String desc, String username, String email, String password, String nameKanji, String nameKana, String gender, String birthday,
        String addressZip, String address) {
      // スクリーンショットの出力先変更
      setReportsFolder(testNo, desc);

      // -- top page ---------------------------
      TopPage topPage = Pages.open(TopPage.class);
      topPage.signUp();

      // -- user info entry --------------------
      UserInfoEntry userInfoEntry = Pages.page(UserInfoEntry.class);
      userInfoEntry.next(username, email, password, password);

      // -- user detail entry ------------------
      UserDetailEntry userDetailEntry = Pages.page(UserDetailEntry.class);
      userDetailEntry.next(nameKanji, nameKana, gender, birthday, addressZip, address);

      // -- user entry info confirm ------------
      UserEntryInfoConfirm userEntryInfoConfirm = Pages.page(UserEntryInfoConfirm.class);
      userEntryInfoConfirm.confirmed();

      // -- user entry complete ----------------
      UserEntryComplete userEntryComplete = Pages.page(UserEntryComplete.class);
      userEntryComplete.isDisplayed();

    }
  }

  @DisplayName("ユーザー登録（単項目チェックNG）シナリオテスト")
  @Nested
  class SignUpValidationScenario {
    @DisplayName("単項目チェックNGメッセージ確認")
    @ParameterizedTest
    @CsvFileSource(resources = "/data/SignUpValidationScenario.csv", numLinesToSkip = 1)
    void test(String testNo, String desc, String username, String email, String password, String nameKanji, String nameKana, String addressZip,
        String address) {
      // スクリーンショットの出力先変更
      setReportsFolder(testNo, desc);

      // -- top page ---------------------------
      TopPage topPage = Pages.open(TopPage.class);
      topPage.signUp();

      // -- user info entry --------------------
      UserInfoEntry userInfoEntry = Pages.page(UserInfoEntry.class);
      userInfoEntry.verifyValidationError(username, email, password, password);
      userInfoEntry.clear();
      userInfoEntry.next();

      // -- user detail entry ------------------
      UserDetailEntry userDetailEntry = Pages.page(UserDetailEntry.class);
      userDetailEntry.verifyValidationError(nameKanji, nameKana, addressZip, address);
      userDetailEntry.clear();
      userDetailEntry.next();

      // -- user entry info confirm ------------
      // -- user entry complete ----------------

    }
  }
}
