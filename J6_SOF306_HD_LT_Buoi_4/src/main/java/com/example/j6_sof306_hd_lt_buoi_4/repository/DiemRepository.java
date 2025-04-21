package com.example.j6_sof306_hd_lt_buoi_4.repository;

import com.example.j6_sof306_hd_lt_buoi_4.DTO.DiemDTO;
import com.example.j6_sof306_hd_lt_buoi_4.entity.Diem;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface DiemRepository extends JpaRepository<Diem, Integer> {
    @Query(
            """
                    select new com.example.j6_sof306_hd_lt_buoi_4.DTO.DiemDTO 
                    (
                    diem.id,
                    diem.maDiem,
                    diem.monHoc,
                    diem.diemSo,
                    diem.sinhVien.maSinhVien,
                    diem.sinhVien.hoTen
                    )
                    from Diem diem 
                    """
    )
    List<DiemDTO> getData();

    @Query(
            """
                    select new com.example.j6_sof306_hd_lt_buoi_4.DTO.DiemDTO 
                    (
                    diem.id,
                    diem.maDiem,
                    diem.monHoc,
                    diem.diemSo,
                    diem.sinhVien.maSinhVien,
                    diem.sinhVien.hoTen
                    )
                    from Diem diem 
                    """
    )
    Page<DiemDTO> getDataPage(Pageable pageable);


    @Modifying
    @Transactional
    @Query("DELETE FROM Diem d WHERE d.maDiem = ?1")
    void deleteDiem(String ma);

    @Query(
            """
                    select new com.example.j6_sof306_hd_lt_buoi_4.DTO.DiemDTO 
                    (
                    diem.id,
                    diem.maDiem,
                    diem.monHoc,
                    diem.diemSo,
                    diem.sinhVien.maSinhVien,
                    diem.sinhVien.hoTen
                    )
                    from Diem diem 
                    WHERE diem.id =?1
                    """
    )
    DiemDTO detail(Integer id);


}
