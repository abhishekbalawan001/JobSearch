package com.example.JobPost.Service;

import com.example.JobPost.EntityJobPost.Jobpost;
import com.example.JobPost.EntityJobSearch.JobSearch;
import com.example.JobPost.Repository.JobpostRepository;
import com.example.JobPost.Repository.OrganisationRepository;
import com.example.JobPost.Repository.SkillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SearchJobService {

    @Autowired
    JobpostRepository jobpostRepository;

    @Autowired
    OrganisationRepository organisationRepository;

    @Autowired
    SkillRepository skillRepository;

    public List<Jobpost> searchJobs(JobSearch jobSearch){

        List<String> skills = jobSearch.getSkills();
        Integer yearsOfExperience = jobSearch.getYearsOfExperience();
        String location = jobSearch.getLocation();

        if(skills != null && yearsOfExperience != null && location != null){
            return searchByLocationAndSkillsAndExperience(location, skills, yearsOfExperience);
        }
        else if(skills != null && yearsOfExperience != null){
            return searchBySkillsAndExperience(skills, yearsOfExperience);
        }
        else if(yearsOfExperience != null && location != null){
            return searchByLocationAndExperience(location, yearsOfExperience);
        }
        else if(skills != null && location != null){
            return searchByLocationAndSkills(location, skills);
        }
        else if(skills != null){
            return searchJobsBySkills(skills);
        }
        else if(location != null){
            return searchJobsByLocation(location);
        }
        else if(yearsOfExperience != null){
            return searchJobsByYearsOfExperience(yearsOfExperience);
        }
        return null;
    }

    public List<Jobpost> searchJobsBySkills(List<String> skills){
        return jobpostRepository.findJobpostBySkills(skills);
    }

    public List<Jobpost> searchJobsByYearsOfExperience(Integer years) {
        return jobpostRepository.findJobpostByYearsOfExperience(years);
    }

    public List<Jobpost> searchJobsByLocation(String location){
        return jobpostRepository.findJobpostByLocation(location);
    }

    public List<Jobpost> searchBySkillsAndExperience(List<String> skills, Integer years){
        return jobpostRepository.findJobpostBySkillsAndExperience(skills, years);
    }

    public List<Jobpost> searchByLocationAndExperience(String location, Integer years){
        return jobpostRepository.findJobpostByLocationAndExperience(years, location);
    }

    public List<Jobpost> searchByLocationAndSkills(String location, List<String> skills){
        return jobpostRepository.findJobpostBySkillsAndLocation(skills, location);
    }

    public List<Jobpost> searchByLocationAndSkillsAndExperience(String location, List<String> skills, Integer yearsOfExperience){
        return jobpostRepository.findJobpostBySkillsAndLocationAndExperience(skills, location, yearsOfExperience);
    }

}
