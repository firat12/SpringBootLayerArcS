package com.firatcapin.stok.service;

import com.firatcapin.stok.dto.BaseDTO;
import com.firatcapin.stok.dto.TaskDetailDTO;
import com.firatcapin.stok.dto.TaskDTO;
import com.firatcapin.stok.exception.BadResourceException;
import com.firatcapin.stok.exception.ResourceNotFoundException;
import com.firatcapin.stok.model.Task;
import com.firatcapin.stok.model.TaskDetail;
import com.firatcapin.stok.repository.ITaskDetailRepository;
import com.firatcapin.stok.repository.ITaskRepository;
import com.firatcapin.stok.service.imp.ITaskService;
import com.firatcapin.stok.util.BaseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.*;

@Service
@Transactional
public class TaskService implements ITaskService {

    @Autowired
    ITaskRepository _taskRepo;

    @Autowired
    ITaskDetailRepository _taskDetailRepo;

    @Override
    public Boolean existsTaskById(Long id) throws ResourceNotFoundException {
        return _taskRepo.existsById(UUID.fromString(id.toString()));
    }

    @Override
    public Long existsTaskDetailByTaskId(Long id) throws ResourceNotFoundException {
        return _taskDetailRepo.existsTaskById(id);
    }

    @Override
    public TaskDTO findTaskById(Long id) throws ResourceNotFoundException{

        TaskDTO dto = new TaskDTO();

        Task task = _taskRepo.findById(UUID.fromString(id.toString())).orElseThrow(() -> new ResourceNotFoundException("Görev Bilgisi Bulunamadı."));

        dto.setId(Long.parseLong(task.getId().toString()));
        dto.setCreatedAt(task.getCreatedAt());

        return dto;
    }

    @Override
    public List<TaskDTO> findAllTask() {
        List<TaskDTO> tasks = new ArrayList<>();
        tasks = _taskRepo.getAllTask();
        return tasks;
    }

    @Override
    public Long taskCount() {
        return _taskRepo.count();
    }

    @Override
    public void deleteTaskById(Long id) throws ResourceNotFoundException {
        if (!existsTaskById(id)) {
            throw new ResourceNotFoundException(id + " numaralı görev bilgis bulunamadı.");
        }
        else {
            _taskRepo.deleteById(UUID.fromString(id.toString()));
        }
    }

    @Override
    public Long taskDetailCount() {
        return _taskDetailRepo.count();
    }

    @Override
    public List<TaskDetail> findAllTaskDetail(int pageNumber, int rowPerPage) throws ResourceNotFoundException {
        List<TaskDetail> _detail = new ArrayList<>();
        _taskDetailRepo.findAll(PageRequest.of(pageNumber - 1, rowPerPage)).forEach(_detail::add);
        return _detail;
    }

    @Override
    public Task saveTask(TaskDTO task) throws BadResourceException, ResourceNotFoundException {
        if(BaseUtil.isEmpty(task.getTitle())){
            if(task.getId() != null && existsTaskById(task.getId())){
                throw new ResourceNotFoundException(task.getId() + " Numaralıı Kayıt Var . Tekrar Kayıt Yapılamaz.");
            }

            Task _entity = new Task();
            _entity.setSummary(task.getSummary());
            _entity.setTitle(task.getTitle());
            _entity.setIsActive(true);
            return _taskRepo.save(_entity);

        } else {
            BadResourceException ex = new BadResourceException(" Task Kayıt İşlemi Başarısız.");
            ex.addErrorMessage(" Zorunlu alanalrı giriniz.");
            throw ex;
        }
    }

    @Override
    public TaskDetailDTO saveTaskDetail(TaskDetailDTO task) throws BadResourceException, ResourceNotFoundException {
        return null;
    }

    @Override
    public Task updateTask(TaskDTO task) throws BadResourceException, ResourceNotFoundException {
        if (!BaseUtil.isEmpty(task.getTitle())) {
            return  _taskRepo.findById(UUID.fromString(task.getId().toString()))
                    .map(model -> {
                        model.setIsActive(true);
                        model.setTitle(task.getTitle());
                        model.setSummary(task.getSummary());
                        model.setUpdatedAt(new Date());

                        return  _taskRepo.save(model);

                    }).orElseThrow(() -> new ResourceNotFoundException("Güncellencek Task Bilgisi Bulunamadı"));
        }
        else {
            BadResourceException ex = new BadResourceException(" Task Kayıt İşlemi Başarısız.");
            ex.addErrorMessage(" Zorunlu alanları giriniz.");
            throw ex;
        }
    }
}
