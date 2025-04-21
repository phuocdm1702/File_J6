package com.example.j6_sof306_ot_demau_2.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.Nationalized;

import java.time.LocalDate;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table(name = "moi_quan_he")
public class MoiQuanHe {
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "ma")
    private String ma;

    @Column(name = "loai_quan_he")
    private String loaiQuanHe;

    @Column(name = "ngay_bat_dau")
    private LocalDate ngayBatDau;

}