package codespring.softwarelanguages.business.abstracts;

import java.util.List;

import codespring.softwarelanguages.business.requests.CreateProgTechnologyRequest;
import codespring.softwarelanguages.business.responses.GetAllProgTechnologiesResponse;


public interface ProgrammingTechService {

    List<GetAllProgTechnologiesResponse> getAllTech();
    void pTechnologyAdd(CreateProgTechnologyRequest createProgTechnologyRequest)throws Exception;
    /*ProgrammingLanguage getId(int id) throws Exception;
    void pLanguageUpdate(ProgrammingLanguage pLanguage);
    void pLanguageDelete(int id);
    */
}

