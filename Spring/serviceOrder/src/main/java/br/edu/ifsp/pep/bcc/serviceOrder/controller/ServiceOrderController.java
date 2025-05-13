package br.edu.ifsp.pep.bcc.serviceOrder.controller;

import br.edu.ifsp.pep.bcc.serviceOrder.mapper.ServiceOrderMapper;
import br.edu.ifsp.pep.bcc.serviceOrder.service.ServiceOrderService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Provider;

@Slf4j
@RestController
@RequestMapping("service-order")
@RequiredArgsConstructor
public class ServiceOrderController {
    private final ServiceOrderService service;
    private final ServiceOrderMapper mapper;


}
