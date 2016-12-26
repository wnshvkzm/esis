package com.daou.go.integration.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.daou.go.integration.domain.CgMail;

@Repository
public abstract interface CgMailRepository extends JpaRepository<CgMail, Long>{
}
