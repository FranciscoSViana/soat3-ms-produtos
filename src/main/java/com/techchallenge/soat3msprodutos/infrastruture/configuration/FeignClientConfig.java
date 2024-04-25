package com.techchallenge.soat3msprodutos.infrastruture.configuration;

import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Configuration;

import static com.techchallenge.soat3msprodutos.Soat3MsProdutosApplication.PACKAGE;

@Configuration
@EnableFeignClients(PACKAGE)
public class FeignClientConfig {
}
