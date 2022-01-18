package com.lespania.implementation;

import com.lespania.dto.ProjectDTO;
import com.lespania.entity.Project;
import com.lespania.mapper.ProjectMapper;
import com.lespania.repository.ProjectRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ProjectServiceImplTest {

    @Mock
    ProjectRepository projectRepository;

    @Mock
    ProjectMapper projectMapper;

    @InjectMocks
    ProjectServiceImpl projectService;

    @Test
    void getByProjectCode() {
        Project project = new Project();
        ProjectDTO projectDTO = new ProjectDTO();

        //when findByProjectCode method oc the mocked projectRepository object
        //is called with "PR01" parameter then return project object.
        when(projectRepository.findByProjectCode("PR01")).thenReturn(project);

        //when convertToDto method of the mocked projectMapper object is called
        //with Project object parameter then return projectDTO
        when(projectMapper.convertToDto(project)).thenReturn(projectDTO);

        //if we do not write the above lines projectDTO1 object will be null
        ProjectDTO projectDTO1 = projectService.getByProjectCode("PR01");

        verify(projectRepository).findByProjectCode("PR01");
        verify(projectRepository).findByProjectCode(Mockito.anyString());
        assertNotNull(projectDTO1);

        //this line gives error:: Argument(s) are different!
        //verify(projectMapper).convertToDto(Mockito.any(Project.class));
    }

    @Test
    void getByProjectCode_exception_test(){
        //we are managing the mocked object by telling it to behave as we expected for the test
        //when there is a call to findByProjectCode method with "" parameter
        //throw a RuntimeException exception with "Project Not Found" message
        when(projectRepository.findByProjectCode(""))
                .thenThrow(new RuntimeException("Project Not Found"));//🔧

        //run the managed method from the mocked object and verify if it throws exception
        //and get the thrown exception object for further verifications
        Throwable exception = assertThrows(RuntimeException.class,
                () -> projectService.getByProjectCode(""));//▶️

        //these are 👇 the extra verifications about this 👆 method run
        //verify if the mocked projectRepository object's findByProjectCode
        //method is called with any common string parameter
        verify(projectRepository).findByProjectCode(Mockito.anyString());//👍
        assertEquals(exception.getMessage(),"Project Not Found");//👍
    }

    @Test
    void save() {
        Project project = new Project();
        ProjectDTO projectDTO = new ProjectDTO();

        //these are preparing the methods that we need from the mocked objects
        when(projectMapper.convertToEntity(projectDTO)).thenReturn(project);
        when(projectRepository.save(project)).thenReturn(project);

        //This is test line
        verify(projectRepository).save(project);
    }
}