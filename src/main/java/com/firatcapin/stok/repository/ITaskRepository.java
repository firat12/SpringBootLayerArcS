package com.firatcapin.stok.repository;

import com.firatcapin.stok.dto.TaskDTO;
import com.firatcapin.stok.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.JpaCountQueryCreator;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface ITaskRepository extends JpaRepository<Task, UUID> {

    @Query("SELECT new com.firatcapin.stok.dto.TaskDTO(t.id, t.title, t.summary, t.createdAt) FROM Task t")
    List<TaskDTO> getAllTask();
}
