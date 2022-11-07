package codespring.softwarelanguages.business.abstracts;

import java.util.List;

import codespring.softwarelanguages.business.requests.CreatePTechnologyRequest;
import codespring.softwarelanguages.business.requests.DeletePTechnologyRequest;
import codespring.softwarelanguages.business.requests.UpdatePTechnologyRequest;
import codespring.softwarelanguages.business.responses.GetAllPTechnologiesResponse;
import codespring.softwarelanguages.business.responses.GetIdPTechnologiesResponse;


public interface ProgrammingTechService {

    List<GetAllPTechnologiesResponse> getAll();
    GetIdPTechnologiesResponse getId(int id);
    void add(CreatePTechnologyRequest createPTechnologyRequest)throws Exception;
    void update(UpdatePTechnologyRequest updatePTechnologyRequest)throws Exception;
    void delete(DeletePTechnologyRequest deletePTechnologyRequest);
}

