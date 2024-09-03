package com.example.demo.entity.wcm.domain;

import com.example.demo.entity.wcm.domain.string.TableName;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;

import java.io.Serializable;

@JsonIgnoreProperties({"hibernateLazyInitializer"})
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = TableName.FILE)
public class File extends Timestamped implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "file_id", nullable = false)
    private Long id;
    private String fileUrl;

    private String originalName;

    private String extensionType;

    @Column(name = "file_uuid", nullable = false)
    private String fileUUID;

    @Column
    @ColumnDefault("false")
    private Boolean isDeleted;

    @JoinColumn(name = "contract_id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Contract contract;

    @JoinColumn(name = "create_user_id")
    @ManyToOne(fetch = FetchType.LAZY)
    private User user;

    @PrePersist
    public void prePersist() {
        this.isDeleted = (this.isDeleted == null ? false : this.isDeleted);
    }

}
