package me.jdragon.chapter3;

/**
 * @author choijaeyong on 2020/07/02.
 * @description
 */
public class ChangePasswordService {
  private MemberRepository memberRepository;

  public void changePassword(String memberId, String currentPw, String newPw) {
    //Member member = memberRepository.findById(memberId);
    Member member = MemberServiceHelper.findExistingMember(memberRepository, memberId);
    if (member == null) throw new NoMemberException(memberId);
    member.changePassword(currentPw,newPw);
  }

  public void changePassword(ChangePasswordRequest req) {
    Member existingMember = MemberServiceHelper
        .findExistingMember(memberRepository, req.getMemberId());
    existingMember.changePassword(req.getCurPw(), req.getNewPw());
  }

}
