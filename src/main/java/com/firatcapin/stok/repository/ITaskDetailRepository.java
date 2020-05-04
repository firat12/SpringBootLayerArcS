package com.firatcapin.stok.repository;

import com.firatcapin.stok.model.TaskDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface ITaskDetailRepository extends JpaRepository<TaskDetail, UUID> {

    List<TaskDetail> findByTaskId(Long taskId);

    @Query(value = "Select count(t) FROM TaskDetail t where t.task = :taskId")
    Long existsTaskById(@Param("taskId") Long taskId);

    /**
     * Yukardaki İşlemin 2. yazım şekli
     * @Query(value = "Select count(t) FROM TaskDetail t where t.task = ?0")
     * Long existsTaskById(Long taskId);
     */

}
