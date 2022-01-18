package com.lespania.converter;

import com.lespania.dto.TaskDTO;
import com.lespania.service.TaskService;
import org.springframework.boot.context.properties.ConfigurationPropertiesBinding;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
@ConfigurationPropertiesBinding
public class TaskDtoConverter implements Converter<String, TaskDTO> {

    private TaskService taskService;

    public TaskDtoConverter(TaskService taskService) {
        this.taskService = taskService;
    }

    @Override
    public TaskDTO convert(String source) {
        Long id = Long.parseLong(source);
        return taskService.findById(id);
    }
}
