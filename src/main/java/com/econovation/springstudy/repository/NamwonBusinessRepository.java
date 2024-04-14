package com.econovation.springstudy.repository;

import com.econovation.springstudy.entity.NamwonBusiness;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NamwonBusinessRepository extends JpaRepository<NamwonBusiness, Long> {

}
