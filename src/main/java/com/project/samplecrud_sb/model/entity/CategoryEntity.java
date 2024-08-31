package com.project.samplecrud_sb.model.entity;

import com.project.samplecrud_sb.infrastructure.model.entity.BaseAuditEntity;
import com.project.samplecrud_sb.model.entity.listener.CategoryEntityListener;
import jakarta.persistence.*;
import org.hibernate.proxy.HibernateProxy;

import java.util.Objects;

@Entity(name = "Category")
@Table(name = "categories")
@EntityListeners(CategoryEntityListener.class)
public class CategoryEntity extends BaseAuditEntity {

    @Column(nullable = false,length = 30,unique = true)
    private String name;

    @Column(length = 100)
    private String description;

    public String getName() {
        return name;
    }

    public String getDescription()
    {
        return description;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public final boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        Class<?> oEffectiveClass = o instanceof HibernateProxy ? ((HibernateProxy) o).getHibernateLazyInitializer().getPersistentClass() : o.getClass();
        Class<?> thisEffectiveClass = this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass() : this.getClass();
        if (thisEffectiveClass != oEffectiveClass) return false;
        CategoryEntity that = (CategoryEntity) o;
        return getId() != null && Objects.equals(getId(), that.getId());
    }

    @Override
    public final int hashCode() {
        return this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass().hashCode() : getClass().hashCode();
    }

    //jpa entities lifecycle events:
//    @PrePersist
//    public void beforeSave(){
//        Logger log = Logger.getLogger(this.getClass().getName());
//        log.info("Before Category persisted Id:"+this.getId()+"  Name:"+this.getName()+" and Description:"+
//                this.getDescription());
//    }
//
//    @PostPersist
//    public void afterSave(){
//        Logger log = Logger.getLogger(this.getClass().getName());
//        log.info("After Category persisted Id:"+this.getId()+"  Name:"+this.getName()+" and Description:"+
//                this.getDescription());
//    }
//
//    @PreUpdate
//    public void beforeUpdate(){
//        Logger log = Logger.getLogger(this.getClass().getName());
//        log.info("Before Category Merged Id:"+this.getId()+"  Name:"+this.getName()+" and Description:"+
//                this.getDescription());
//    }
//
//    @PostUpdate
//    public void afterUpdate(){
//        Logger log = Logger.getLogger(this.getClass().getName());
//        log.info("After Category Merged Id:"+this.getId()+"  Name:"+this.getName()+" and Description:"+
//                this.getDescription());
//    }
//
//    @PreRemove
//    public void beforeRemove(){
//        Logger log = Logger.getLogger(this.getClass().getName());
//        log.info("Before Category Removed Id:"+this.getId()+"  Name:"+this.getName()+" and Description:"+
//                this.getDescription());
//    }
//
//    @PostRemove
//    public void afterRemove(){
//        Logger log = Logger.getLogger(this.getClass().getName());
//        log.info("After Category Removed Id:"+this.getId()+"  Name:"+this.getName()+" and Description:"+
//                this.getDescription());
//    }
//
//    @PostLoad
//    public void load(){
//        Logger log = Logger.getLogger(this.getClass().getName());
//        log.info("After Category Loaded Id:"+this.getId()+"  Name:"+this.getName()+" and Description:"+
//                this.getDescription());
//    }
}
