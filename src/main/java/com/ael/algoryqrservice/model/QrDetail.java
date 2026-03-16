package com.ael.algoryqrservice.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="tblQrDetails")
public class QrDetail extends QrBaseModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long qrDetailId;

    private String detailName;

    @ManyToOne
    @JoinColumn(name = "QR_ID")
    private Qr qr;

    @ManyToOne
    @JoinColumn(name = "QR_TYPE_ID")
    private QrType qrType;



}
