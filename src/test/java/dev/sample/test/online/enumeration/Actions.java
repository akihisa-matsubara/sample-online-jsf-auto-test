package dev.sample.test.online.enumeration;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum Actions {

  // condition
  INIT("initial_display"),
  VALIDATION("validation"),

  // navigation menu
  HEADER_LOGO("click_header_logo_link"),
  LOGIN("click_login_link"),
  SIGN_UP("click_sign_up_link"),
  FOOTER_LOGO("click_footer_logo_link"),

  // common action
  BACK("click_back_button"),
  NEXT("click_next_button"),
  CONFIRMED("click_confirmed_button"),
  GO_TO_TOP_PAGE("click_go_to_top_page_button"),
  ;

  private String description;

}
