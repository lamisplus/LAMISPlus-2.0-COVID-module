package org.lamisplus.modules.covid.repository;

import org.lamisplus.modules.covid.domain.entity.CodeSet;
import org.lamisplus.modules.covid.domain.entity.Encounter;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CodeSetRepository extends JpaRepository<CodeSet, Integer> {
}
