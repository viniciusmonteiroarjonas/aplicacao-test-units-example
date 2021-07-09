package br.com.alura.tdd.modelo;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class FuncionarioTest {

    @Test
    public void deveCriarOModeloFuncionarioComSucesso() {
        Funcionario funcionario = new Funcionario();
        funcionario.setNome("Carlos Alberto Torres");
        funcionario.setSalario(new BigDecimal("10000"));
        funcionario.setDataAdmissao(LocalDate.now());

        assertNotNull(funcionario.getNome());
        assertNotNull(funcionario.getSalario());
        assertNotNull(funcionario.getDataAdmissao());

    }

}
