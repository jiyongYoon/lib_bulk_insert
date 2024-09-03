package com.example.demo.entity.wcm.domain;


import com.example.demo.entity.wcm.domain.enumeration.ReviewStepType;
import com.example.demo.entity.wcm.domain.string.TableName;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;

import java.util.List;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = TableName.TEMPLATE_REVIEW_META_INFO)
public class TemplateReviewCustomMeta extends  Timestamped {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "review_meta_id", nullable = false)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User createUser;
    @Column
    private String name;

    @Column
    @Enumerated(EnumType.STRING)
    private ReviewStepType reviewStepType ;

    @Column
    @Builder.Default
    @ColumnDefault("false")
    private Boolean isDeleted=Boolean.FALSE;

    @OneToMany(mappedBy = "metaInfo")
    private List<TemplateReviewCustom> templateReviewCustom;
}
