package com.example.spring_boot_mapstruct.dao.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.antlr.v4.runtime.misc.NotNull;
import org.hibernate.annotations.GenericGenerator;


import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
@EqualsAndHashCode
@Entity
public class Book implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(generator="uuid")
    @GenericGenerator (name="uuid", strategy="org.hibernate.id.UUIDGenerator")
    @Column(name="id", updatable=false, nullable=false)
    private UUID id;

    @NotNull
    @Column (name="name", nullable=false)
    private String name;

    @NotNull
    @Column (name="author", nullable=false)
    private String author;

    @NotNull
    @Column (name="published_date", nullable=false)
    private LocalDateTime publishedDate;

    @ManyToOne
    @JoinColumn(name="library_id", nullable=false)
    private Library library;

}

