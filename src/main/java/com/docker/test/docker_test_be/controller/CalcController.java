package com.docker.test.docker_test_be.controller;

import com.docker.test.docker_test_be.dto.CalcDTO;
import com.docker.test.docker_test_be.entity.Calc;
import com.docker.test.docker_test_be.service.CalcService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("calc")
@RequiredArgsConstructor
public class CalcController {

    private final CalcService calcService;

    @PostMapping("add")
    public ResponseEntity<Integer> add(@RequestBody CalcDTO calc){
        int result = calcService.add(calc);
        return ResponseEntity.ok(result);
    }
}
