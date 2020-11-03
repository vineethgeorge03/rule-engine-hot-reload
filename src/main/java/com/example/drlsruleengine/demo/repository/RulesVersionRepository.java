package com.example.drlsruleengine.demo.repository;

import com.example.drlsruleengine.demo.entity.RuleVersion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RulesVersionRepository extends JpaRepository<RuleVersion, Integer> {
}
