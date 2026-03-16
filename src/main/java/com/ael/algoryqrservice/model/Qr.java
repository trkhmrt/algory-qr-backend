package com.ael.algoryqrservice.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

import java.util.List;

@Entity
@Table(name="tblQr")
@Data
public class Qr extends QrBaseModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long qrId; // 1

    private Long userId;

    private String text;

    private Integer height;

    private Integer width;

    @OneToMany(mappedBy="qr")
    private List<QrDetail> qrDetails;

}
