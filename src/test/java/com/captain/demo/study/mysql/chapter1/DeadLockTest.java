package com.captain.demo.study.mysql.chapter1;

import com.captain.demo.database.mybatis.entity.TestSelectTable;
import com.captain.demo.fmouse.service.ITestSelectTableService;
import org.apache.commons.lang3.concurrent.BasicThreadFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Captain Wang
 * @time2020/8/27
 */
@RunWith(SpringRunner.class)
@SpringBootTest
class DeadLockTest {
    private final Executor executor = Executors.newFixedThreadPool(100, r -> {
        Thread t = new Thread(r);
        t.setDaemon(true);
        return t;
    });
    ScheduledExecutorService executorService = new ScheduledThreadPoolExecutor(100,
            new BasicThreadFactory.Builder().namingPattern("test-schedule-pool-%d").daemon(true).build());

    @Resource
    ITestSelectTableService testSelectTableService;

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void t1() throws InterruptedException {
        for (int i = 0; i < 100000; i++) {
            int B = i;
            executorService.execute(() -> {
                TestSelectTable testSelectTable = new TestSelectTable();
                testSelectTable.setCol1("E1_" + B);
                testSelectTable.setCol2("E2_" + B);
                testSelectTable.setCol3("E3_" + B);
                testSelectTable.setCol4("E4_" + B);
                testSelectTable.setCol5("E5_" + B);
                testSelectTable.setCol6("E6_" + B);
                testSelectTable.setCol7("E7_" + B);
                testSelectTable.setCol8("E8_" + B);
                testSelectTable.setCol9("E9_" + B);
                testSelectTableService.save(testSelectTable);
            });
        }
    }

    @Test
    void t2() throws InterruptedException {
        for (int i = 0; i < 100000; i++) {
            executorService.execute(() -> {
                TestSelectTable testSelectTable = new TestSelectTable();
                testSelectTable.setCol1("F");
                testSelectTable.setCol2("F");
                testSelectTable.setCol3("F");
                testSelectTable.setCol4("F");
                testSelectTable.setCol5("F");
                testSelectTable.setCol6("F");
                testSelectTable.setCol7("F");
                testSelectTable.setCol8("F");
                testSelectTable.setCol9("F");
                testSelectTableService.save(testSelectTable);
            });
        }
        while (true) {
            if (executorService.isTerminated()) {
                break;
            }
        }

//        executorService.awaitTermination(1l,TimeUnit.HOURS);
    }
}