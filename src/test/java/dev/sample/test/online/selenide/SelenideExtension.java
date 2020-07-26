package dev.sample.test.online.selenide;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.extension.BeforeAllCallback;
import org.junit.jupiter.api.extension.BeforeEachCallback;
import org.junit.jupiter.api.extension.ExtensionContext;
import dev.sample.test.online.utils.ScreenshotSupport;

public class SelenideExtension implements BeforeAllCallback, BeforeEachCallback {

  @Override
  public void beforeAll(ExtensionContext context) throws Exception {
    // ベースURLを変更する (デフォルト:http://localhost:8080)
    Configuration.baseUrl = "http://localhost:9080/sample-online-jsf-webapp";
    // 利用ブラウザを変更する場合（デフォルト：Chrome）
    // Configuration.browser = Browsers.FIREFOX;
    // テストを実行した後、ブラウザーウィンドウは開いたままにする場合
    // Configuration.holdBrowserOpen = true;
    // 起動時にwindowサイズを最大化
    Configuration.startMaximized = true;
    // windowサイズを変更する場合（デフォルト：1366x768）
    // Configuration.browserSize = "1024x768";
    // Proxyサーバー利用する場合
    // Configuration.proxyEnabled = true;
    // Configuration.proxyHost = "127.0.0.1";
    // Configuration.proxyPort = 8888;
    // Selenium Gridを使用する場合
    // Configuration.remote = "http://localhost:5678/wd/hub";

  }

  @Override
  public void beforeEach(ExtensionContext context) throws Exception {
    ScreenshotSupport.clear();
  }

}
