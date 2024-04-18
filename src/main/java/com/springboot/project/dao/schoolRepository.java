package com.springboot.project.dao;

import com.springboot.project.entity.school;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface schoolRepository extends JpaRepository<school,String> {
@Query("select s, COUNT(st), s.typeOfSchool, sum(sc.fee) from school s inner join s.list c inner join c.students st inner join st.studentCards sc group by s")
    public List<Object[]> findAllSchoolWithStudentCount();
}
