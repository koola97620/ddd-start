package me.jdragon.chapter3;

/**
 * @author choijaeyong on 2020/06/14.
 * @project my-ddd
 * @description
 */
public interface CategoryRepository {

  Category findById(Long categoryId);
}
