package com.example.j6_sof306_hd_lt_buoi_4.DTO;

import com.example.j6_sof306_hd_lt_buoi_4.entity.Diem;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class DiemDTO {
    private Integer id;
    private String maDiem;
    private String monHoc;
    private BigDecimal diemSo;
    private String maSinhVien;
    private String hoTen;

    public DiemDTO() {
    }

    public DiemDTO(Integer id, String maDiem, String monHoc, BigDecimal diemSo, String maSinhVien, String hoTen) {
        this.id = id;
        this.maDiem = maDiem;
        this.monHoc = monHoc;
        this.diemSo = diemSo;
        this.maSinhVien = maSinhVien;
        this.hoTen = hoTen;
    }
}
