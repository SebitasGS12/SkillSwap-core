package com.skillswap.skillswap_core.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name="imagen")
@Data
public class Imagen {

    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Integer imagenID;
    private Boolean estado;

	@Lob
    @Column(columnDefinition = "LONGBLOB")
	private byte[] contenido;

}
