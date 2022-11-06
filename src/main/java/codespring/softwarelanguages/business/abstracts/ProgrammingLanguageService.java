package codespring.softwarelanguages.business.abstracts;

import java.util.List;

import codespring.softwarelanguages.business.requests.CreateProgLanguageRequest;
import codespring.softwarelanguages.business.responses.GetAllProgLanguagesResponse;


public interface ProgrammingLanguageService {

    List<GetAllProgLanguagesResponse> getAll();
    void pLanguageAdd(CreateProgLanguageRequest createProgLanguageRequest)throws Exception;
    /*ProgrammingLanguage getId(int id) throws Exception;
    void pLanguageUpdate(ProgrammingLanguage pLanguage);
    void pLanguageDelete(int id);
    */
}

