package com.firatcapin.stok.controller;

import com.firatcapin.stok.dto.TaskDTO;
import com.firatcapin.stok.exception.BadResourceException;
import com.firatcapin.stok.exception.ResourceNotFoundException;
import com.firatcapin.stok.model.Task;
import com.firatcapin.stok.service.imp.ITaskService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/task", produces = "application/json")
public class TaskController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    ITaskService _taskService;

    @RequestMapping(value = "/list")
    public List<TaskDTO> getAllTasks() throws ResourceNotFoundException{
        return _taskService.findAllTask();
    }

    @RequestMapping(value = "/list/{id}")
    public TaskDTO findById(@PathVariable Long id) throws ResourceNotFoundException, BadResourceException {
        return _taskService.findTaskById(id);
    }

    @RequestMapping(value = "/add" , method = RequestMethod.POST)
    public Task saveTask(@RequestBody TaskDTO request) throws ResourceNotFoundException, BadResourceException{
        return _taskService.saveTask(request);
    }

    @RequestMapping(value = "/update" , method = RequestMethod.PUT)
    public Task updateTask(@RequestBody TaskDTO request) throws ResourceNotFoundException, BadResourceException{
        return _taskService.updateTask(request);
    }

    @RequestMapping(value = "/delete/{id}" , method = RequestMethod.DELETE)
    public boolean deleteTask(@PathVariable Long id) throws ResourceNotFoundException {
        _taskService.deleteTaskById(id);
        return true;
    }

}
