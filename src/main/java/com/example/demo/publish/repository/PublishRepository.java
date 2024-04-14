package com.example.demo.publish.repository;

import com.example.demo.publish.domain.Publish;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PublishRepository extends JpaRepository<Publish,Long> {
}
