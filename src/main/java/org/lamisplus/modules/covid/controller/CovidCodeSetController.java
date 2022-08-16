package org.lamisplus.modules.covid.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.lamisplus.modules.covid.domain.dto.PatientStatusDTO;
import org.lamisplus.modules.covid.domain.entity.CodeSet;
import org.lamisplus.modules.covid.service.CodeSetService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/covid/patientstatus")
public class CovidCodeSetController {
    private final CodeSetService service;

    @GetMapping("/vaccination-status-codeset")
    public List<CodeSet> GetVaccinationStatusCodeset(){
        return service.GetVaccinationStatusCodeSet();
    }

    @GetMapping("/current-status-codeset")
    public List<CodeSet> GetCurrentStatusCodeset(){
        return service.GetCurrentStatusCodeSet();
    }
}
