package dev.sample.test.online.selenide;

import dev.sample.common.code.CodeVo;
import dev.sample.common.util.CodeUtils;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import com.codeborne.selenide.SelenideElement;

public class Items {

  public static <CD extends CodeVo> Map<String, Integer> getIndexMap(Class<CD> codeType) {
    return getIndexMap(codeType.getEnumConstants());
  }

  public static <CD extends CodeVo> Map<String, Integer> getIndexMap(CodeVo[] vos) {
    Map<String, Integer> codeMap = new ConcurrentHashMap<>();
    for (int i = 0; i < vos.length; i++) {
      codeMap.put(vos[i].getCode(), i);
    }

    return codeMap;
  }

  public static <CD extends CodeVo> CD getRadioCode(List<SelenideElement> radioElements, Class<CD> codeType) {
    return CodeUtils.decode(radioElements.stream()
        .filter(SelenideElement::isSelected)
        .findFirst().get().val(), codeType);
  }

  public static void setRadioCode(List<SelenideElement> radioElements, Map<String, Integer> indexMap, CodeVo vo) {
    radioElements.get(indexMap.get(vo.getCode())).parent().click();
  }

}
