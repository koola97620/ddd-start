package me.jdragon.chapter3;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * @author choijaeyong on 2020/06/27.
 * @project my-ddd
 * @description
 */

@Embeddable
public class Image {
  @Column(name = "image_type")
  private String imageType;

  @Column(name = "image_path")
  private String path;

  @Temporal(TemporalType.TIMESTAMP)
  @Column(name = "upload_time")
  private Date uploadTime;

  public boolean hasThumbnail() {
    if (imageType.equals("II")) {
      return true;
    } else  {
      return false;
    }
  }

}
