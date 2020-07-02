package me.jdragon.chapter3;

/**
 * @author choijaeyong on 2020/07/02.
 * @project my-ddd
 * @description
 */
public interface MemberRepository {

  Member findById(String memberId);
}
