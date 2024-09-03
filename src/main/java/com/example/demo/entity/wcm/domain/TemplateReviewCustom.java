package com.example.demo.entity.wcm.domain;


import com.example.demo.entity.wcm.domain.enumeration.ReviewType;
import com.example.demo.entity.wcm.domain.string.TableName;
import jakarta.persistence.*;
import lombok.*;


@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = TableName.TEMPLATE_REVIEW_CUSTOM)
public class TemplateReviewCustom extends Timestamped {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "review_custom_id", nullable = false)
    private Long id;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "review_meta_id")
    TemplateReviewCustomMeta metaInfo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User reviewUser;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "dept_id")
    private Dept dept;

    @Enumerated(EnumType.STRING)
    private ReviewType reviewType;
    private Integer reviewOrder;
}
