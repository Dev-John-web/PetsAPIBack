package com.petshop.DTO;

import java.math.BigDecimal;

import com.petshop.entities.Servico;

public class ServicoDTO {

    private Long id;
    private String nome;
    private BigDecimal preco;

    public ServicoDTO() {
    }

    public ServicoDTO(Long id, String nome, BigDecimal preco) {
        this.id = id;
        this.nome = nome;
        this.preco = preco;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public void setPreco(BigDecimal preco) {
        this.preco = preco;
    }

    public static ServicoDTO convertToDTO(Servico servico) {

        return new ServicoDTO(
                servico.getId(),
                servico.getNome(),
                servico.getPreco());

    }

    public static Servico convertToEntity(ServicoDTO dto) {

        Servico servico = new Servico();

        servico.setId(dto.getId());
        servico.setNome(dto.getNome());
        servico.setPreco(dto.getPreco());

        return servico;

    }

}