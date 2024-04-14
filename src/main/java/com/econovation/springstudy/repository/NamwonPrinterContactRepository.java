package com.econovation.springstudy.repository;

import com.econovation.springstudy.entity.NamwonPrinterContact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NamwonPrinterContactRepository extends JpaRepository<NamwonPrinterContact, Long> {

}
