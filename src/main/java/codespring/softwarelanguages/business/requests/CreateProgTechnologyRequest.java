package codespring.softwarelanguages.business.requests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateProgTechnologyRequest {
    private String name;
    private int p_lang_id;
}
