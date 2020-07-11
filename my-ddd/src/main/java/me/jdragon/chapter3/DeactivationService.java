package me.jdragon.chapter3;

import sun.security.util.Password;

/**
 * @author choijaeyong on 2020/07/11.
 * @project my-ddd
 * @description
 */
public class DeactivationService {

  private MemberRepository memberRepository;
  private PasswordEncoder passwordEncoder;

  public DeactivationService(MemberRepository memberRepository, PasswordEncoder passwordEncoder) {
    this.memberRepository = memberRepository;
    this.passwordEncoder = passwordEncoder;
  }

  public void deactivate(String memberId, String pwd) {
    Member member = memberRepository.findById(memberId);
    checkMember(member);


  }

  private void checkMember(Member member) {

  }

}
