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
    checkEmpty(joinRequest.getId() , "id", errors);
    checkEmpty(joinRequest.getName(), "name", errors);
    try {
      joinService.join(joinRequest);
      return "successview";
    } catch (EmptyPropertyException e) {

      return "error";
    } catch (InvalidPasswordException e) {
      return "error";
    }

  }

  private void checkEmpty(String id, String id1, Errors errors) {

  }


}
