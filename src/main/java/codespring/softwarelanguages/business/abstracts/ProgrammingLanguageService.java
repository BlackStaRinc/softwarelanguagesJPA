package codespring.softwarelanguages.business.abstracts;

import java.util.List;

import codespring.softwarelanguages.business.requests.CreatePLanguageRequest;
import codespring.softwarelanguages.business.responses.GetAllPLanguagesResponse;


public interface ProgrammingLanguageService {

    List<GetAllPLanguagesResponse> getAll();
    void add(CreatePLanguageRequest createPLanguageRequest)throws Exception;
    /*ProgrammingLanguage getId(int id) throws Exception;
    void pLanguageUpdate(ProgrammingLanguage pLanguage);
    void pLanguageDelete(int id);
    */
}

