package com.aca.classwork.week6.qa;

public class MaximumTestExecution extends TestExecution {
    public MaximumTestExecution() {
        super("Max function test");
    }

    @Override
    public Result execute() {
        final int max = Math.max(9,99);
        if(max == 99){
            return Result.PASS;
        }
        return Result.FAIL;
    }
}
