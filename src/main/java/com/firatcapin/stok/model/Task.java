package com.firatcapin.stok.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
@Table(name = "TASK")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE) // Onbellek yapılndırması sağlamak için kullanılır. Eşzamansız bir önbellek mekanizmasıdır.veri bütünlüü sorunlarını önlemek için
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Task extends BaseModel {
    //@GeneratedValue(strategy=GenerationType.AUTO)
    /*@Id
    @GeneratedValue(generator = "task_gen")
    @SequenceGenerator(name = "task_gen", sequenceName = "task_seq", initialValue = 1000)
    private Long id;*/

    @Column(name = "TITLE")
    @NotEmpty(message = "Başlık bos birakilamaz.")
    private String title;

    @Column(name = "SUMMARY")
    @NotEmpty(message = "Başlık bos birakilamaz.")
    private String summary;

}
