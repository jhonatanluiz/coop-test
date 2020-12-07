package com.jj.coop.mapper;

import com.jj.coop.dto.ClienteDTO;
import com.jj.coop.entity.Cliente;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {
        TelefoneMapper.class,
        EmailMapper.class
       // EnderecoMapper.class
})
public interface ClienteMapper extends BaseMapper<Cliente, ClienteDTO> {

    default Cliente fromId(Long id) {
        if (id == null) {
            return null;
        }
        Cliente cliente = new Cliente();
        cliente.setId(id);
        return cliente;
    }
}
