package com.jj.coop.mapper;

import com.jj.coop.dto.EmailDTO;
import com.jj.coop.entity.Email;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;


@Mapper(componentModel = "spring", uses = {})
public interface EmailMapper extends BaseMapper<Email, EmailDTO> {

    @InheritInverseConfiguration(name = "toDto")
    void fromDto(EmailDTO dto, @MappingTarget Email entity);

    default Email fromId(Long id) {
        if (id == null) {
            return null;
        }
        Email email = new Email();
        email.setId(id);
        return email;
    }
}
