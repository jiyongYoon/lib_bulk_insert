package com.example.demo.entity.wcm.domain;

import com.example.demo.entity.wcm.domain.enumeration.ReviewOption;
import com.example.demo.entity.wcm.domain.string.TableName;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;
import org.antlr.v4.runtime.misc.NotNull;
import org.hibernate.annotations.ColumnDefault;

import java.io.Serializable;

@JsonIgnoreProperties(ignoreUnknown = true)
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = TableName.TEMPLATE_CONTRACT)
public class TemplateContract extends Timestamped implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "template_id", nullable = false)
    private Long id;

    @Column(name = "template_name")
    private String templateName;

    @Column(name = "template_details")
    private String templateDetails;

    @Column
    @ColumnDefault("false")
    private Boolean isDeleted;

    @JoinColumn(name = "create_user_id")
    @ManyToOne(fetch = FetchType.LAZY)
    private User createUser;

    @JoinColumn(name = "update_user_id")
    @ManyToOne(fetch = FetchType.LAZY)
    private User updateUser;

    @Column
    private int deadLine;

    @Column
    @Enumerated(EnumType.STRING)
    private ReviewOption reviewOption;

    @Column
    private String workspaceCode;


    @PrePersist
    public void prePersist() {
        this.isDeleted = (this.isDeleted == null ? false : this.isDeleted);
    }
}
