package com.example.JobPost.EntityJobPost;
import com.fasterxml.jackson.annotation.*;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Table(name = "jobpost")
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "jobPostingId")
public class Jobpost {

    @GeneratedValue
    @javax.persistence.Id
    Integer jobPostingId;

    @NotEmpty(message = "Title is mandatory")
    String title;

    @NotEmpty(message = "Description is mandatory")
    @Length(max = 1000)
    String description;

    @NotNull(message = "Requirements field is mandatory")
    @Length(max = 1000)
    String requirements;

    @OneToMany(mappedBy = "jobpost")
    List<Skill> requiredSkills;

    @NotEmpty(message = "Location can not be empty")
    String location;

    @Min(value = 0, message = "Experience can not be negative")
    @Max(value = 100, message = "Experience can not be more than 100")
    Integer yearsOfExperience;

    @ManyToOne
    @JoinColumn(name = "organisation_id")
    Organisation organisation;

    public Jobpost(){}

    public Jobpost(Integer jobPostingId, String title, String description, String requirements, List<Skill> requiredSkills, String location, Integer yearsOfExperience, Organisation organisation) {
        this.jobPostingId = jobPostingId;
        this.title = title;
        this.description = description;
        this.requirements = requirements;
        this.requiredSkills = requiredSkills;
        this.location = location;
        this.yearsOfExperience = yearsOfExperience;
        this.organisation = organisation;
    }

    public Integer getJobPostingId() {
        return jobPostingId;
    }

    public void setJobPostingId(Integer jobPostingId) {
        this.jobPostingId = jobPostingId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getRequirements() {
        return requirements;
    }

    public void setRequirements(String requirements) {
        this.requirements = requirements;
    }

    public List<Skill> getRequiredSkills() {
        return requiredSkills;
    }

    public void setRequiredSkills(List<Skill> requiredSkills) {
        this.requiredSkills = requiredSkills;
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

    public Organisation getOrganisation() {
        return organisation;
    }

    public void setOrganisation(Organisation organisation) {
        this.organisation = organisation;
    }

    @Override
    public String toString() {
        return "Jobpost{" +
                "jobPostingId=" + jobPostingId +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", requirements='" + requirements + '\'' +
                ", requiredSkills=" + requiredSkills +
                ", location='" + location + '\'' +
                ", yearsOfExperience=" + yearsOfExperience +
                ", organisation=" + organisation +
                '}';
    }
}
