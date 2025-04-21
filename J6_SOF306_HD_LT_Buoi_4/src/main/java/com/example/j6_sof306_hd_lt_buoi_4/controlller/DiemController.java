package com.example.j6_sof306_hd_lt_buoi_4.controlller;

import com.example.j6_sof306_hd_lt_buoi_4.DTO.DiemDTO;
import com.example.j6_sof306_hd_lt_buoi_4.DTO.DiemDTOAdd;
import com.example.j6_sof306_hd_lt_buoi_4.entity.Diem;
import com.example.j6_sof306_hd_lt_buoi_4.entity.SinhVien;
import com.example.j6_sof306_hd_lt_buoi_4.exception.CustomExceptionHandler;
import com.example.j6_sof306_hd_lt_buoi_4.exception.NotFoundException;
import com.example.j6_sof306_hd_lt_buoi_4.repository.DiemRepository;
import com.example.j6_sof306_hd_lt_buoi_4.repository.SinhVienRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/diem")
public class DiemController {
    @Autowired
    private DiemRepository diemRepository;
    @Autowired
    private SinhVienRepository sinhVienRepository;
    @Autowired
    private CustomExceptionHandler customExceptionHandler;
    @GetMapping("/hien-thi")
    public List<DiemDTO> getAll() {
        return diemRepository.getData();
    }


    @GetMapping("/phan-Trang")
    public List<DiemDTO> getAllToPage(@RequestParam(value = "Page", required = false, defaultValue = "0") Integer Page) {
        Pageable pageable = PageRequest.of(Page, 5);
        return diemRepository.getDataPage(pageable).getContent();
    }

//    @GetMapping("/phan-Trang")
//    public List<DiemDTO> getAllToPage(@RequestParam(value = "Page") Integer Page){
//        Pageable pageable = PageRequest.of(Page, 5);
//        return diemRepository.getDataPage(pageable).getContent();
//    }


    @PostMapping("/add")
    public String addDiemSV(@RequestBody DiemDTOAdd diemDTOAdd) {
        Diem diem = new Diem();
        BeanUtils.copyProperties(diemDTOAdd, diem);
        SinhVien sinhVien = sinhVienRepository.findById(diemDTOAdd.getSinhVienID()).get();
        diem.setSinhVien(sinhVien);
        diemRepository.save(diem);
        return "Thêm sinh viên thành công";
    }

    @PutMapping("/update/{id}")
    public String updateDiemSV(@RequestBody DiemDTOAdd diemDTOAdd,
                            @PathVariable("id") Integer id) {
        Diem diem = new Diem();
        BeanUtils.copyProperties(diemDTOAdd, diem);
        SinhVien sinhVien = sinhVienRepository.findById(diemDTOAdd.getSinhVienID()).get();
        diem.setSinhVien(sinhVien);
        diem.setId(id);
        diemRepository.save(diem);
        return "Sửa sinh viên thành công";
    }


    @DeleteMapping("/dellete/{ma}")
    public String deleteDiemSV(@PathVariable("ma") String ma){
        diemRepository.deleteDiem(ma);
        return "Xóa thàng công";
    }

//    @GetMapping("/detail/{id}")
//    public DiemDTO detail(@PathVariable("id") Integer id){
//        return diemRepository.detail(id);
//    }

    @GetMapping("/detail/{id}")
    public DiemDTO detail(@PathVariable("id") Integer id) {
        DiemDTO diemDTO = diemRepository.detail(id);
        if (diemDTO == null) {
            throw new NotFoundException("Không tìm thấy điểm với ID: " + id);
        }
        return diemDTO;
    }
}
