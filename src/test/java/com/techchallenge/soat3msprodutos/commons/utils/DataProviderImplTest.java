package com.techchallenge.soat3msprodutos.commons.utils;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;



@ExtendWith(MockitoExtension.class)
public class DataProviderImplTest {

    @Test
    void obterDataAtutal_DeveRetornarDataAtual() {
        LocalDate dataAtualEsperada = LocalDate.now();
        DataProviderImpl dataProvider = new DataProviderImpl();

        LocalDate dataAtual = dataProvider.obterDataAtutal();

        assertEquals(dataAtualEsperada, dataAtual);
    }

    @Test
    void obterDataHoraAtual_DeveRetornarDataHoraAtual() {
        LocalDateTime dataHoraAtualEsperada = LocalDateTime.now();
        DataProviderImpl dataProvider = new DataProviderImpl();

        LocalDateTime dataHoraAtual = dataProvider.obterDataHoraAtual();

        assertEquals(dataHoraAtualEsperada, dataHoraAtual);
    }
}
