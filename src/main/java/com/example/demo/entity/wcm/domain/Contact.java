package com.example.demo.entity.wcm.domain;

import com.example.demo.entity.wcm.domain.string.TableName;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;

import java.io.Serializable;

@JsonIgnoreProperties(ignoreUnknown = true)
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = TableName.CONTACT)
public class Contact extends Timestamped implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "contact_id", nullable = false)
    @JsonProperty(value = "id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "company_id")
    @JsonIgnore
    private Company company;

    @JoinColumn(name = "create_user_id")
    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    private User createUser;

    @JoinColumn(name = "update_user_id")
    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    private User updateUser;

    @Column(length = 50, nullable = false)
    @JsonProperty(value = "name")
    private String contactName;

    @Column(length = 50)
    @JsonProperty(value = "tel")
    private String contactTel;

    @Column(length = 200)
    @JsonProperty(value = "email")
    private String contactEmail;

    @Column(length = 200)
    @JsonProperty(value = "position")
    private String contactPosition;

    @JsonProperty(value = "description")
    private String contactDescription;

    @ColumnDefault("false")
    @Column
    private Boolean isDeleted;

    @ColumnDefault("false")
    @Column
    private Boolean isShare;

    @PrePersist
    public void prePersist(){
        this.isDeleted = (this.isDeleted == null) ? false : this.isDeleted ;
    }
}
