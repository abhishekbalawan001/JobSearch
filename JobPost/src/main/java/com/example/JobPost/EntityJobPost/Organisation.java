package com.example.JobPost.EntityJobPost;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import org.hibernate.validator.constraints.Length;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Table(name = "organisation")
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "organisationId")
public class Organisation {
    @GeneratedValue
    @javax.persistence.Id
    Integer organisationId;

    @NotEmpty(message = "Organisation name is mandatory")
    String organisationName;

    @NotEmpty(message = "Description field is mandatory")
    @Length(max = 1000)
    String description;

    @NotNull(message = "Location is mandatory")
    String location;

    @OneToMany(mappedBy = "organisation")
    List<Jobpost> jobPosts;

    public Organisation(){}

    public Organisation(Integer organisatonId, String organisationName, String description, String location, List<Jobpost> jobPosts) {
        this.organisationId = organisatonId;
        this.organisationName = organisationName;
        this.description = description;
        this.location = location;
        this.jobPosts = jobPosts;
    }

    public Integer getOrganisationId() {
        return organisationId;
    }

    public void setOrganisationId(Integer organisatonId) {
        this.organisationId = organisatonId;
    }

    public String getOrganisationName() {
        return organisationName;
    }

    public void setOrganisationName(String organisationName) {
        this.organisationName = organisationName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public List<Jobpost> getJobPosts() {
        return jobPosts;
    }

    public void setJobPosts(List<Jobpost> jobPosts) {
        this.jobPosts = jobPosts;
    }

    @Override
    public String toString() {
        return "Organisation{" +
                "organisationId=" + organisationId +
                ", organisationName='" + organisationName + '\'' +
                ", description='" + description + '\'' +
                ", location='" + location + '\'' +
                ", jobPosts=" + jobPosts +
                '}';
    }
}
