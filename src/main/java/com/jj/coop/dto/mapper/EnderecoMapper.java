package com.jj.coop.dto.mapper;

import com.jj.coop.dto.EnderecoDTO;
import com.jj.coop.entity.Endereco;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring", uses = {})
public interface EnderecoMapper extends BaseMapper<Endereco, EnderecoDTO> {

    @InheritInverseConfiguration(name = "toDto")
    void fromDto(EnderecoDTO dto, @MappingTarget Endereco entity);

    default Endereco fromId(Long id) {
        if (id == null) {
            return null;
        }
        Endereco endereco = new Endereco();
        endereco.setId(id);
        return endereco;
    }
}
