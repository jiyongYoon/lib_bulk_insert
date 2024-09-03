package com.example.demo.entity.wcm.domain;

import com.example.demo.entity.wcm.domain.string.TableName;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;


@JsonIgnoreProperties({"hibernateLazyInitializer"})
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = TableName.OPTION_LIST)
public class OptionList extends Timestamped {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "option_id", nullable = false)
    @JsonProperty(value = "id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "template_id")
    @JsonIgnore
    private TemplateContract templateContract;

    @Column
    @JsonProperty(value = "name")
    private String optionName;

    @Column
    @JsonProperty(value = "type")
    private String optionType;

    @Column
    @JsonProperty(value = "default")
    private String optionDefault;

    @Column
    @ColumnDefault("false")
    private Boolean isDeleted;

    @PrePersist
    public void prePersist() {
        this.isDeleted = (this.isDeleted == null ? false : this.isDeleted);
    }
}
