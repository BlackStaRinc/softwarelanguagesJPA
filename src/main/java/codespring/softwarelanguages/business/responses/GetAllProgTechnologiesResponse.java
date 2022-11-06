package codespring.softwarelanguages.business.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAllProgTechnologiesResponse {
    private int id;
    private String name;
    private int p_lang_id;
}
