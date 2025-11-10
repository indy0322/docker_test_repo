package com.docker.test.docker_test_be.service;

import com.docker.test.docker_test_be.dto.CalcDTO;
import com.docker.test.docker_test_be.entity.Calc;
import com.docker.test.docker_test_be.repository.CalcRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
@RequiredArgsConstructor
public class CalcService {

    private final CalcRepository calcRepository;

    public Integer add(CalcDTO calc){

        Calc newCalc = new Calc();
        newCalc.setNum1(calc.getNum1());
        newCalc.setNum2(calc.getNum2());
        newCalc.setSum(calc.getNum1() + calc.getNum2());

        calcRepository.save(newCalc);

        return calc.getNum1() + calc.getNum2();
    }
}
