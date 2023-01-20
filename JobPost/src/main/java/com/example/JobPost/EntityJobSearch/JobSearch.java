package com.example.JobPost.EntityJobSearch;
import org.springframework.stereotype.Component;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.util.List;

@Component
public class JobSearch {

    String location;

    @Min(0)
    @Max(100)
    Integer yearsOfExperience;

    List<String> skills;

    public JobSearch(){}

    public JobSearch(String location, Integer yearsOfExperience, List<String> skills) {
        this.location = location;
        this.yearsOfExperience = yearsOfExperience;
        this.skills = skills;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Integer getYearsOfExperience() {
        return yearsOfExperience;
    }

    public void setYearsOfExperience(Integer yearsOfExperience) {
        this.yearsOfExperience = yearsOfExperience;
    }

    public List<String> getSkills() {
        return skills;
    }

    public void setSkills(List<String> skills) {
        this.skills = skills;
    }
}
