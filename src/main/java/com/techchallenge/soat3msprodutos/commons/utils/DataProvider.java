package com.techchallenge.soat3msprodutos.commons.utils;

import java.time.LocalDate;
import java.time.LocalDateTime;

public interface DataProvider {
    LocalDate obterDataAtutal();

    LocalDateTime obterDataHoraAtual();
}
