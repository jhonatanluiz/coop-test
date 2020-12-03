package com.jj.coop.dto.mapper;

import com.jj.coop.dto.TelefoneDTO;
import com.jj.coop.entity.Telefone;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;


@Mapper(componentModel = "spring", uses = {})
public interface TelefoneMapper extends BaseMapper<Telefone, TelefoneDTO> {

    @InheritInverseConfiguration(name = "toDto")
    void fromDto(TelefoneDTO dto, @MappingTarget Telefone entity);

    default Telefone fromId(Long id) {
        if (id == null) {
            return null;
        }
        Telefone telefone = new Telefone();
        telefone.setId(id);
        return telefone;
    }
}
