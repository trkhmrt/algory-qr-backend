package com.ael.algoryqrservice.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name="tblQrType")
public class QrType extends QrBaseModel{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long qrTypeId;

    private String typeName;

    @OneToMany(mappedBy = "qrType")
    private List<QrDetail> qrDetails;

}
