package me.jdragon.chapter3;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;

/**
 * @author choijaeyong on 2020/06/25.
 * @project my-ddd
 * @description
 */
@Entity
@DiscriminatorColumn("II")
public class InternalImage extends Image {


}
