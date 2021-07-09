package br.com.alura.tdd.service;

import br.com.alura.tdd.modelo.Desempenho;
import br.com.alura.tdd.modelo.Funcionario;
import org.junit.jupiter.api.*;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ReajusteServiceTest {

    private ReajusteService reajusteService;
    private Funcionario funcionario;

    // Roda Antes de cada test unit
    @BeforeEach
    public void inicializar(){
        System.out.println("Inicio");
        this.reajusteService = new ReajusteService();
        this.funcionario = new Funcionario("Jose Maria Pepe",  LocalDate.now(), new BigDecimal(1000));
    }

    // Roda após cada test unit
    @AfterEach
    public void finalizar() {
        System.out.println("Finalizar");
    }

    // Roda Antes de todos os test unit uma única vez
    @BeforeAll
    public static void antesDeTodos(){
        System.out.println("Antes de todos");
    }

    // Roda depois de todos os test unit uma única vez
    @AfterAll
    public static void depoisDeTodos(){
        System.out.println("Depois de Todos");
    }

    @Test
    public void ReajusteDeveSerDeTresPorCentoDoSalarioQuandoDesempenhoForADesejar(){
        reajusteService.concederReajuste(funcionario, Desempenho.A_DESEJAR);
        assertEquals(new BigDecimal("1030.00"), funcionario.getSalario());
;    }

    @Test
    public void ReajusteDeveSerDeQuinzePorCentoDoSalario(){
        reajusteService.concederReajuste(funcionario, Desempenho.BOM);
        assertEquals(new BigDecimal("1150.00"), funcionario.getSalario());
    }

    @Test
    public void ReajusteDeveSerDeVintePorCentoDoSalario(){
        reajusteService.concederReajuste(funcionario, Desempenho.OTIMO);
        assertEquals(new BigDecimal("1200.00"), funcionario.getSalario());
    }
}
