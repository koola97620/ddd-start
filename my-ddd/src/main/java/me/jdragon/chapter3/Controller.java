package me.jdragon.chapter3;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author choijaeyong on 2020/07/7.
 * @project my-ddd
 * @description
 */

@org.springframework.stereotype.Controller
public class Controller {

  @Autowired
  private JoinService joinService;

  @RequestMapping
  public String join(JoinRequest joinRequest, Errors errors) {
    new JoinRequestValidator().validate(joinRequest, errors);
    if (errors.hasErrors()) return "formViewr";
//    checkEmpty(joinRequest.getId() , "id", errors);
//    checkEmpty(joinRequest.getName(), "name", errors);
    try {
      joinService.join(joinRequest , errors);
      return "successview";
    } catch (EmptyPropertyException e) {

      return "formView";
    } catch (InvalidPasswordException e) {
      return "formView";
    }

  }

  private void checkEmpty(String id, String id1, Errors errors) {

  }


}
