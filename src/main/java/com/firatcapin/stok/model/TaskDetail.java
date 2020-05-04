package com.firatcapin.stok.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

@Entity
@Table(name = "TASK_DETAIL")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TaskDetail extends  BaseModel{
    /*@Id
    @GeneratedValue(generator = "task_detail_gen")
    @SequenceGenerator(name = "task_detail_gen", sequenceName = "task_detail_seq", initialValue = 1000)
    private Long id;*/

    @Column(name = "title")
    @NotEmpty(message = "Başlık bos birakilamaz.")
    private String description;

    @Column(name = "year")
    @Min(value = 2020, message = "2020 den küçük gorev yili olamaz.")
    private int year;

    @Column(name = "year")
    @Email(message = "Hatali email")
    private String email;

    @Column(name = "phone")
    @Pattern(regexp ="[0-9\\s]{12}", message = "Geçersiz numara")
    private String phone;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "TASK_ID", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private Task task;
}
