package codespring.softwarelanguages.dataAccess.abstracts;

import java.util.List;

import codespring.softwarelanguages.entities.concretes.ProgrammingLanguage;

public interface ProgrammingLanguagesRepository {
    List<ProgrammingLanguage> getAll(); 
    ProgrammingLanguage getId(int id); 
    void pLanguageAdd(ProgrammingLanguage pLanguage);
    void pLanguageUpdate(ProgrammingLanguage pLanguage);
    void pLanguageDelete(int id);
}