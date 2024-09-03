package com.example.demo.entity.wcm.domain;

import com.example.demo.entity.wcm.domain.string.TableName;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;


@JsonIgnoreProperties(ignoreUnknown = true)
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@ Table(name = TableName.WORKSPACE)
public class Workspace extends Timestamped {

    @Id
    @Column(name = "workspace_id", nullable = false, unique = true)
    private String id;

    @Column(nullable = false)
    private String name;

    private String description;

    private Boolean isDeleted;

    private String imageUrl;


    @PrePersist
    public void prePersist() {
        this.isDeleted = (this.isDeleted == null ? false : this.isDeleted);
    }

}
