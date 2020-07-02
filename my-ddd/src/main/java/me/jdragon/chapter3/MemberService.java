package me.jdragon.chapter3;

/**
 * @author choijaeyong on 2020/07/02.
 * @project my-ddd
 * @description
 */
public class MemberService {
  private MemberRepository memberRepository;
  private Notifier notifier;

  public void changePassword(String memberId, String currentPw, String newPw) {
    Member member = findExistingMember(memberId);
    member.changePassword(currentPw,newPw);
  }

  public void initializePassword(String memberId) {
    Member member = findExistingMember(memberId);
    String newPassword = member.initializePassword();
    notifier.notifyNewPassword(member, newPassword);
  }

  public void leave(String memberId, String curPw) {
    Member member = findExistingMember(memberId);
    member.leave();
  }

  private Member findExistingMember(String memberId) {
    Member member = memberRepository.findById(memberId);
    if (member == null)
      throw new NoMemberException(memberId);
    return member;
  }


}
