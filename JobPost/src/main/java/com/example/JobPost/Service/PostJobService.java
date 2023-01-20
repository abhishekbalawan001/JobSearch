package com.example.JobPost.Service;

import com.example.JobPost.EntityJobPost.Jobpost;
import com.example.JobPost.EntityJobPost.Organisation;
import com.example.JobPost.EntityJobPost.Skill;
import com.example.JobPost.Repository.JobpostRepository;
import com.example.JobPost.Repository.OrganisationRepository;
import com.example.JobPost.Repository.SkillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostJobService {

    @Autowired
    JobpostRepository jobpostRepository;

    @Autowired
    OrganisationRepository organisationRepository;

    @Autowired
    SkillRepository skillRepository;

    public Organisation register(Organisation organisation){
        organisationRepository.save(organisation);
        return organisation;
    }

    public Jobpost createJobpost(Organisation organisation){
        Jobpost jobpost = organisation.getJobPosts().get(0);
        Optional optional = organisationRepository.findById(organisation.getOrganisationId());
        organisation = (Organisation) optional.get();
        organisation.getJobPosts().add(jobpost);
        organisationRepository.save(organisation);
        jobpost.setOrganisation(organisation);
        jobpostRepository.save(jobpost);

        List<Skill> skillList = jobpost.getRequiredSkills();
        if(skillList != null){
            for(Skill skill : skillList){
                skill.setJobpost(jobpost);
            }
            skillRepository.saveAll(skillList);
        }
        return jobpost;
    }
}
