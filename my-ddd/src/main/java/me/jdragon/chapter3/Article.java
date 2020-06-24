package me.jdragon.chapter3;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.SecondaryTable;
import javax.persistence.Table;

/**
 * @author choijaeyong on 2020/06/24.
 * @project my-ddd
 * @description
 */

@Entity
@Table(name = "article")
@SecondaryTable(
    name = "article_content", pkJoinColumns = @PrimaryKeyJoinColumn(name="id")
)
public class Article {
  @Id
  private Long id;

  private String title;

  @AttributeOverrides({
      @AttributeOverride(name="content",column = @Column(table="article_content")),
      @AttributeOverride(name="contentType",column = @Column(table="article_content"))
  })
  private ArticleContent content;

}
