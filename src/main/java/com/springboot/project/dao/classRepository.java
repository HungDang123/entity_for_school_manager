package com.springboot.project.dao;

import com.springboot.project.entity.classs;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface classRepository extends JpaRepository<classs, String> {
    @Query("select c,count(st) from classs c inner join c.school s inner join c.students st where c.school.id = :id group by c")
    public List<Object[]> findAllClasssWithStudentCount(@Param("id") String id);

    @Query("select c,count(st) from classs c inner join c.school s inner join c.students st group by c")
    public List<Object[]> findAllClasssWithStudentCount();

    //    @Query("select c from classs c where c.school.id =:id")
    public List<classs> findAllBySchoolId(String schoolId);
}
