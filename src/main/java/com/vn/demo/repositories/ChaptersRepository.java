package com.vn.demo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.vn.demo.model.Chapter;

public interface ChaptersRepository extends JpaRepository<Chapter, Integer> {

	@Query(value = "select * from CHAPTERS inner join Reading_info on chapters.infoid = reading_info.idread where Code=:code", nativeQuery = true)
	public List<Chapter> findChapterName(@Param("code") String code);

	@Query(value = "select * from CHAPTERS inner join Reading_info on chapters.infoid = reading_info.idread where id=:code", nativeQuery = true)
	public List<Chapter> findDetail(@Param("code") String code);
}
