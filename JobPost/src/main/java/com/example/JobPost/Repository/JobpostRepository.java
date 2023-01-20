package com.example.JobPost.Repository;

import com.example.JobPost.EntityJobPost.Jobpost;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface JobpostRepository extends JpaRepository<Jobpost, Integer> {

    @Query("select u from Jobpost u JOIN u.requiredSkills v where v.skillName in (:skills)")
    List<Jobpost> findJobpostBySkills(@Param("skills") List<String> skills);

    @Query("select u from Jobpost u where u.yearsOfExperience <= :years")
    List<Jobpost> findJobpostByYearsOfExperience(@Param("years") Integer yearsOfExperience);

    List<Jobpost> findJobpostByLocation(String location);

    @Query("select u from Jobpost u JOIN u.requiredSkills v where v.skillName in (:skills) and u.yearsOfExperience <= :years")
    List<Jobpost> findJobpostBySkillsAndExperience(@Param("skills") List<String> skills, @Param("years") Integer years);

    @Query("select u from Jobpost u where u.yearsOfExperience <= :years and u.location = :location")
    List<Jobpost> findJobpostByLocationAndExperience(@Param("years") Integer years, @Param("location") String location);

    @Query("select u from Jobpost u JOIN u.requiredSkills v where v.skillName in (:skills) and u.location <= :location")
    List<Jobpost> findJobpostBySkillsAndLocation(@Param("skills") List<String> skills, @Param("location") String location);

    @Query("select u from Jobpost u JOIN u.requiredSkills v where v.skillName in (:skills) and u.location <= :location and u.yearsOfExperience <= :years")
    List<Jobpost> findJobpostBySkillsAndLocationAndExperience(@Param("skills") List<String> skills, @Param("location") String location, @Param("years") Integer years);
}
