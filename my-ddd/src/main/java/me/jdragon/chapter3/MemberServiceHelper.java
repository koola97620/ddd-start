package me.jdragon.chapter3;

/**
 * @author choijaeyong on 2020/07/02.
 * @project my-ddd
 * @description
 */
public class MemberServiceHelper {
  public static Member findExistingMember(MemberRepository repo, String memberId) {
    Member member = repo.findById(memberId);
    if (member == null)
      throw new NoMemberException(memberId);
    return member;
  }

}
