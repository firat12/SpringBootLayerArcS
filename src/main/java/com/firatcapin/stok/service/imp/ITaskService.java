package com.firatcapin.stok.service.imp;

import com.firatcapin.stok.dto.BaseDTO;
import com.firatcapin.stok.dto.TaskDetailDTO;
import com.firatcapin.stok.dto.TaskDTO;
import com.firatcapin.stok.exception.BadResourceException;
import com.firatcapin.stok.exception.ResourceNotFoundException;
import com.firatcapin.stok.model.Task;
import com.firatcapin.stok.model.TaskDetail;

import java.util.List;

public interface ITaskService {

    Boolean existsTaskById(Long id) throws ResourceNotFoundException;
    Long existsTaskDetailByTaskId(Long id) throws ResourceNotFoundException;
    Long taskCount();
    Long taskDetailCount();
    TaskDTO findTaskById(Long id) throws ResourceNotFoundException;
    List<TaskDTO> findAllTask() throws ResourceNotFoundException;
    List<TaskDetail> findAllTaskDetail(int pageNumber, int rowPerPage) throws ResourceNotFoundException;
    Task saveTask(TaskDTO task) throws BadResourceException, ResourceNotFoundException;
    TaskDetailDTO saveTaskDetail(TaskDetailDTO task) throws BadResourceException, ResourceNotFoundException;
    Task updateTask(TaskDTO task) throws BadResourceException, ResourceNotFoundException;
    void deleteTaskById(Long id) throws ResourceNotFoundException;

}
