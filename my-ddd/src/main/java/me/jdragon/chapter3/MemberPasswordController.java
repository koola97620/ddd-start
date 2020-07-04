package me.jdragon.chapter3;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import sun.plugin.liveconnect.SecurityContextHelper;

/**
 * @author choijaeyong on 2020/07/04.
 * @project my-ddd
 * @description
 */

@Controller
@RequestMapping("/member/changePassword")
public class MemberPasswordController {

  @Autowired
  private ChangePasswordService changePasswordService;

  @RequestMapping(method = RequestMethod.POST)
  public String submit(ChangePasswordRequest changePwdReq) {
    changePasswordService.changePassword(changePwdReq);
    return "";
  }
}
