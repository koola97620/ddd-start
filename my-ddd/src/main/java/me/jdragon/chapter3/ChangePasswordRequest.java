package me.jdragon.chapter3;

/**
 * @author choijaeyong on 2020/07/03.
 * @project my-ddd
 * @description
 */
public class ChangePasswordRequest {
  private String memberId;
  private String curPw;
  private String newPw;


  public String getMemberId() {
    return memberId;
  }

  public String getCurPw() {
    return curPw;
  }

  public String getNewPw() {
    return newPw;
  }
}
