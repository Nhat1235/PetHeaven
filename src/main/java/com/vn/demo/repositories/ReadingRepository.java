package com.vn.demo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.vn.demo.model.ReadingInfo;

@Repository
public interface ReadingRepository extends JpaRepository<ReadingInfo, Integer> {
	
    @Query(value="Select * From READING_INFO WHERE CODE = :code",nativeQuery = true)
	List<ReadingInfo> findByCode(@Param("code")String code);
    
    @Query(value="select * from READING_INFO order by DATE desc",nativeQuery = true)
    List<ReadingInfo> OrderByDateDesc();
    
    @Query(value = "select * from READING_INFO inner join CATEGORY on READING_INFO.CATEGORYID=CATEGORY.ID where CATEGORY.id=:code",nativeQuery = true)
    List<ReadingInfo> findBycategory(@Param("code")String code);
}
