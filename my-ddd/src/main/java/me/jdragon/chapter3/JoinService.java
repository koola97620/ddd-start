package me.jdragon.chapter3;

import org.springframework.beans.InvalidPropertyException;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.Errors;

/**
 * @author choijaeyong on 2020/07/10.
 * @project my-ddd
 * @description
 */
public class JoinService {

  @Transactional
  public void join(JoinRequest joinReq, Errors errors) {
    new JoinRequestValidator().validate(joinReq, errors);
    checkEmpty(joinReq.getId(), "id");

    if (joinReq.getPassword().equals(joinReq.getConfirmPassword())) {
      throw new InvalidPasswordException();
    }


  }

  private void checkEmpty(String value, String id1) {
    if (value == null || value.isEmpty())
      throw new EmptyPropertyException();
  }

}
