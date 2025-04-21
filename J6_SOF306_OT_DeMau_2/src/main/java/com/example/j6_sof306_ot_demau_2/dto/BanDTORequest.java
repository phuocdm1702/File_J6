package com.example.j6_sof306_ot_demau_2.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BanDTORequest {
    private String ma;
    private String hoTen;
    private LocalDate ngaySinh;
    private Integer moiQuanHeID;
}
