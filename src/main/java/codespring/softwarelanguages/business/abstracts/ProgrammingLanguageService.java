package codespring.softwarelanguages.business.abstracts;

import java.util.List;

import codespring.softwarelanguages.entities.concretes.ProgrammingLanguage;

public interface ProgrammingLanguageService {

    List<ProgrammingLanguage> getAll();
    ProgrammingLanguage getId(int id) throws Exception;
    void pLanguageAdd(ProgrammingLanguage pLanguage)throws Exception;
    void pLanguageUpdate(ProgrammingLanguage pLanguage);
    void pLanguageDelete(int id);
}

