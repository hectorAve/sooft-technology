package com.soft.technology.transactions_management.infrastructure.adapter;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;


@RunWith(SpringRunner.class)
@SpringBootTest
class TransaccionesRepositoryH2Test {

    @Autowired
    private TransaccionesCrudRepository transaccionesCrudRepository;

    @Test
    void when_repository_find_transactions_by_fecha_then_return_success() {
        Calendar cal = Calendar.getInstance();
        cal.setTime(new Date());
        cal.set(Calendar.DAY_OF_MONTH, 1);

        List<Long> cuits = transaccionesCrudRepository.findByFechaTransaccionAfter(cal.getTime());

        assertThat(cuits).hasSize(5);
        Assert.assertNotNull(cuits.get(0));
    }
}