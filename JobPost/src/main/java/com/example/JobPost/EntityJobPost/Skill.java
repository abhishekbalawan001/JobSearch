package com.example.JobPost.EntityJobPost;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "skill")
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "skillId")
public class Skill {
    @GeneratedValue
    @javax.persistence.Id
    Integer skillId;


    String skillName;


    Integer yearsOfExperience;

    @ManyToOne
    @JoinColumn(name = "jobpost_id")
    private Jobpost jobpost;

    public Skill(){}

    public Skill(Integer skillId, String skillName, Integer yearsOfExperience, Jobpost jobpost) {
        this.skillId = skillId;
        this.skillName = skillName;
        this.yearsOfExperience = yearsOfExperience;
        this.jobpost = jobpost;
    }

    public Integer getSkillId() {
        return skillId;
    }

    public void setSkillId(Integer skillId) {
        this.skillId = skillId;
    }

    public String getSkillName() {
        return skillName;
    }

    public void setSkillName(String skillName) {
        this.skillName = skillName;
    }

    public Integer getYearsOfExperience() {
        return yearsOfExperience;
    }

    public void setYearsOfExperience(Integer yearsOfExperience) {
        this.yearsOfExperience = yearsOfExperience;
    }

    public Jobpost getJobpost() {
        return jobpost;
    }

    public void setJobpost(Jobpost jobpost) {
        this.jobpost = jobpost;
    }

    @Override
    public String toString() {
        return "Skill{" +
                "skillId=" + skillId +
                ", skillName='" + skillName + '\'' +
                ", yearsOfExperience=" + yearsOfExperience +
                ", jobpost=" + jobpost +
                '}';
    }
}
