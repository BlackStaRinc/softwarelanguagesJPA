package codespring.softwarelanguages.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import codespring.softwarelanguages.entities.concretes.ProgrammingLanguages;

public interface ProgrammingLanguagesRepository extends JpaRepository<ProgrammingLanguages, Integer> {
    
}