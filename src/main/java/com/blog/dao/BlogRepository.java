package com.blog.dao;

import com.blog.pojo.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BlogRepository extends JpaRepository<Blog,Long> , JpaSpecificationExecutor<Blog> {
    @Query("select b from Blog b where b.published=true")
    Page<Blog> findByPublished(Pageable pageable);
    @Query("select b from Blog b where b.recommend=true")
    List<Blog> findTop(Pageable pageable);
    @Query("select function('date_format',b.updateTime,'%Y') as year from Blog b group by function('date_format',b.updateTime,'%Y') order by function('date_format',b.updateTime,'%Y') desc ")
    List<String> findGroupYear();
    @Query("select b from Blog b where function('date_format',b.updateTime,'%Y')=?1")
    List<Blog> findByYear(String year);
}
