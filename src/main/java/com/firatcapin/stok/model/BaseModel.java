package com.firatcapin.stok.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Type;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

@MappedSuperclass // JPA'ya bu sınıfın bir varlığın üst sınıfı olduğunu ve niteliklerinin varlıkla eşleştirilmesi gerektiğini söylüyor.
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(
        value = {"createdAt", "updatedAt", "isActive"},
        allowGetters = true
)
@Getter
@Setter
public abstract class BaseModel implements Serializable {
    /**
     * PostgreSQL'in UUID desteği vardır. bu nedenle yaygın olarak kullanılan otomatik artış tamsayısı yerine bu yapıyı kullanalım
     * UUID, guvenlik önlemi için önemlidir. ormalde veri artışıyla sağlanan şey artık zorlanmaya başlanılıyor.
     */
    @Id
    @Type(type = "pg-uuid")
    private UUID id;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_at", nullable = false, updatable = false)
    @CreatedDate
    private Date createdAt;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "updated_at", nullable = false)
    @LastModifiedDate
    private Date updatedAt;

    @Column(name = "isActive", nullable = false, updatable = false)
    private Boolean isActive;


    public BaseModel() {
        this.id = UUID.randomUUID();
    }
}
