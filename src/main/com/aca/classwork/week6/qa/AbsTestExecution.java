package com.aca.classwork.week6.qa;

public class AbsTestExecution extends TestExecution{
    public AbsTestExecution(){
        super("Absolute function test");
    }

    @Override
    public Result execute() {
        if(Math.abs(-9) != 8){
            return Result.FAIL;
        }
        return Result.PASS;
    }
}
