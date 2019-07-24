package com.springboot.tool.tool.core;

import org.junit.Before;
import org.mockito.MockitoAnnotations;

/**
 * @Author chenjunbin
 * @Date 2019/7/4
 * @Description
 */
public class BaseMockTest {
    @Before
    public void initMocks() {
        MockitoAnnotations.initMocks(this);
    }

}
