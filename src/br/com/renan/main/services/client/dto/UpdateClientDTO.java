package br.com.renan.main.services.client.dto;

public record UpdateClientDTO(
        String uuid,
        String cpf,
        String name,
        String tel,
        String street,
        String city,
        String state,
        Integer number
) {
}
