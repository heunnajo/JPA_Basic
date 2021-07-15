package hellojpa;

import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@MappedSuperclass//매핑된 슈퍼 클래스 : 매핑정보만 받는 슈퍼(부모)클래스?!
public abstract class BaseEntity {
    private String createdBy;
    private LocalDateTime createdDated;
    private String lastModified;
    private LocalDateTime lastModifiedDate;

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public LocalDateTime getCreatedDated() {
        return createdDated;
    }

    public void setCreatedDated(LocalDateTime createdDated) {
        this.createdDated = createdDated;
    }

    public String getLastModified() {
        return lastModified;
    }

    public void setLastModified(String lastModified) {
        this.lastModified = lastModified;
    }

    public LocalDateTime getLastModifiedDate() {
        return lastModifiedDate;
    }

    public void setLastModifiedDate(LocalDateTime lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }
}
