package me.jdragon.chapter3;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;


/**
 * @author choijaeyong on 2020/06/22.
 * @project my-ddd
 * @description
 */
public class EmailSet {
  private Set<Email> emails = new HashSet<>();

  private EmailSet() {

  }

  public EmailSet(Set<Email> emails) {
    this.emails.addAll(emails);
  }

  public Set<Email> getEmails() {
    return Collections.unmodifiableSet(emails);
  }

}
