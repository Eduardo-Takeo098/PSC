package com.GraphiFlow.project_PSC.entities;

import com.GraphiFlow.project_PSC.entities.enums.ProjectStatus;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Table;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;

@Entity
@Table(name = "tb_project")
public class Project implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = "GMT")
    private Instant moment;

    private Integer projectStatus;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private UserAdm client;

    public Project() {
    }

    public Project(Long id, Instant moment, ProjectStatus projectStatus,UserAdm client) {
        super();
        this.id = id;
        this.moment = moment;
        setProjectStatus(projectStatus);
        this.client = client;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Instant getMoment() {
        return moment;
    }

    public void setMoment(Instant moment) {
        this.moment = moment;
    }

    public ProjectStatus getProjectStatus() {
        return ProjectStatus.valueOf(projectStatus);
    }

    public void setProjectStatus(ProjectStatus projectStatus) {
        if (projectStatus != null) {
            this.projectStatus = projectStatus.getCode();
        }
    }

    public UserAdm getClient() {
        return client;
    }

    public void setClient(UserAdm client) {
        this.client = client;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Project project = (Project) o;
        return Objects.equals(id, project.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
