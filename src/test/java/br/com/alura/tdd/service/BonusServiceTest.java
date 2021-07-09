package br.com.alura.tdd.service;

import br.com.alura.tdd.modelo.Funcionario;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class BonusServiceTest {

    @Test
    public void bonusDeveRetornarUmaExceptionParaFuncionarioComSalarioAlto() {
        BonusService bonusService = new BonusService();
       assertThrows(
               IllegalArgumentException.class,
               () -> bonusService.calcularBonus(new Funcionario("Jose Maria Pepe",  LocalDate.now(), new BigDecimal(12000))));
    }

    @Test
    public void bonusDeveriaSer10PorCentoDoSalario() {
        BonusService bonusService = new BonusService();
        BigDecimal bonus = bonusService.calcularBonus(new Funcionario("Jose Maria Pepe",  LocalDate.now(), new BigDecimal(2500)));

        assertEquals(new BigDecimal("250.00"), bonus);
    }

    @Test
    public void bonusDeveriaSer100ParaSalarioDeAteDezMil() {
        BonusService bonusService = new BonusService();
        BigDecimal bonus = bonusService.calcularBonus(new Funcionario("Jose Maria Pepe",  LocalDate.now(), new BigDecimal(10000)));

        assertEquals(new BigDecimal("1000.00"), bonus);
    }



}
