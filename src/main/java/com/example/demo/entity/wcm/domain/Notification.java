package com.example.demo.entity.wcm.domain;

import com.example.demo.entity.wcm.domain.string.TableName;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;

import java.io.Serializable;
import java.time.Instant;

@JsonIgnoreProperties({"hibernateLazyInitializer"})
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = TableName.NOTIFICATION)
public class Notification extends Timestamped implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "noti_id", nullable = false)
    @JsonProperty(value = "id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "contract_histroy_id")
    private ContractHistory contractHistory;

    @JsonProperty(value = "message")
    private String notiMessage;

    // 계약서?

    @ColumnDefault("false")
    private Boolean isRead;

    private Instant readDate;

    @PrePersist
    public void prePersist(){
        this.isRead = (this.isRead == null ? false : this.isRead) ;
    }

}
