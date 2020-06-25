package me.jdragon.chapter3;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * @author choijaeyong on 2020/06/25.
 * @project my-ddd
 * @description
 */
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="image_type")
@Table(name="image")
public abstract class Image {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name ="image_id")
  private Long id;

  @Column(name = "image_path")
  private String path;

  @Temporal(TemporalType.TIMESTAMP)
  @Column(name="upload_time")
  private Date uploadTime;

  protected Image() {}
  public Image(String path) {
    this.path = path;
    this.uploadTime = new Date();
  }

  protected String getPath() {
    return path;
  }

  public Date getUploadTime() {
    return uploadTime;
  }

  public abstract String getURL();
  public abstract boolean hasThumbnail();
  public abstract String getThumbnailURL();

}
