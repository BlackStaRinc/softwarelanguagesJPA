package codespring.softwarelanguages.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import codespring.softwarelanguages.entities.concretes.ProgrammingTechnologies;

public interface ProgrammingTechnologiesRepository extends JpaRepository<ProgrammingTechnologies, Integer> {
    
}