package com.minghua.study.mybatis;

import org.junit.ClassRule;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.rule.OutputCapture;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author: minghua
 * @date: 2018/5/30 16:59
 * @modified By:
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class AppTest {
    @ClassRule
    public static OutputCapture out = new OutputCapture();

    public void test() {
        String output = out.toString();
        assertThat(output).contains("");
    }
}