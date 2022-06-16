package ken.ball.inventory.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.vladmihalcea.hibernate.type.json.JsonStringType;
import lombok.Data;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.Version;
import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@MappedSuperclass
@TypeDefs({
        @TypeDef(name="json", typeClass = JsonStringType.class),
})
public class AbstractAudit implements Serializable {

    @CreatedBy
    @Column(name = "created_by", nullable = false, length = 255)
    protected String createdBy;

    @CreatedDate
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    @Column(name = "created_datetime", nullable = false)
    protected LocalDateTime createdDateTime = LocalDateTime.now();

    @LastModifiedBy
    @Column(name = "last_modified_by", nullable = false, length = 255)
    protected String lastModifiedBy;

    @LastModifiedDate
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    @Column(name = "last_modified_datetime", nullable = false)
    protected LocalDateTime lastModifiedDateTime = LocalDateTime.now();

    @Version
    @Column(name = "version")
    protected Integer version;
}
