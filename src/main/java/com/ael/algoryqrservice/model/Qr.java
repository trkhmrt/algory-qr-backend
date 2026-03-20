package com.ael.algoryqrservice.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;
import tools.jackson.databind.JsonNode;

import java.util.List;

@Entity
@Table(name="tblQr")
@Data
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class Qr extends QrBaseModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long qrId; // 1

    private Long userId;

    private String qrName;

    @ManyToOne
    @JoinColumn(name = "qr_type_id")
    private QrType qrType;

    @JdbcTypeCode(SqlTypes.JSON)
    @Column(columnDefinition = "jsonb")
    private JsonNode details;


}
