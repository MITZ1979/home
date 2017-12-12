package sss.entity;

import org.junit.Test;

import static org.junit.Assert.*;

public class BoyTest {
    @Test
    public void getName() throws Exception {
        Boy boy = new Boy();
        boy.setName("erha");

        assert boy.getName().equals("erha");
    }

}