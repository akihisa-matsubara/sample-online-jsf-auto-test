package dev.sample.test.online.scenario.signup;

import static org.assertj.core.api.Assertions.*;
import dev.sample.common.code.GenderVo;
import dev.sample.common.util.CodeUtils;
import dev.sample.test.online.AbstractSelenideTest;
import dev.sample.test.online.page.signup.UserDetailEntry;
import dev.sample.test.online.page.signup.UserEntryInfoConfirm;
import dev.sample.test.online.page.signup.UserInfoEntry;
import dev.sample.test.online.page.top.TopPage;
import dev.sample.test.online.selenide.Pages;
import dev.sample.test.online.selenide.SelenideExtension;
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
class SignUpTest extends AbstractSelenideTest {

  @DisplayName("ユーザー登録シナリオテスト")
  @Nested
  class SignUpScenario {
    @DisplayName("正常系")
    @ParameterizedTest
    @CsvFileSource(resources = "/data/SignUpScenario.csv", numLinesToSkip = 1)
    void test(String testNo, String desc, String expected, String username, String email, String password, String nameKanji, String nameKana, String gender,
        String birthday, String addressZip, String address) {
      // --- setup -----
      // スクリーンショットの出力先変更
      setReportsFolder(testNo, desc);

      // --- execute ---
      // -- top page ---------------------------
      TopPage topPage = Pages.open(TopPage.class);
      topPage.signUp();

      // -- user info entry --------------------
      UserInfoEntry userInfoEntry = Pages.page(UserInfoEntry.class);
      userInfoEntry.next(username, email, password, password);

      // -- user detail entry ------------------
      UserDetailEntry userDetailEntry = Pages.page(UserDetailEntry.class);
      userDetailEntry.next(nameKanji, nameKana, CodeUtils.decode(gender, GenderVo.class), birthday, addressZip, address);

      // -- user entry info confirm ------------
      UserEntryInfoConfirm userEntryInfoConfirm = Pages.page(UserEntryInfoConfirm.class);
      userEntryInfoConfirm.confirmed();

      // -- user entry complete ----------------

      // --- verify ----
      assertThat(WebDriverRunner.url()).as(desc).contains(expected);
      // NOTE: verify the data in the Database
    }
  }

}
