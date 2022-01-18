package com.lespania.service;

import com.lespania.dto.ProjectDTO;
import com.lespania.entity.Project;
import com.lespania.entity.User;

import java.util.List;

public interface ProjectService {

    ProjectDTO getByProjectCode(String code);

    List<ProjectDTO> listAllProjects();

    Project save(ProjectDTO dto);

    void update(ProjectDTO dto);

    void delete(String code);

    void complete(String projectCode);

    List<ProjectDTO> listAllProjectDetails();

    List<ProjectDTO> readAllByAssignedManager(User user);
}
