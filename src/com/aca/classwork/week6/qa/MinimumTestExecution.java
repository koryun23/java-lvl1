package com.aca.classwork.week6.qa;

public class MinimumTestExecution extends TestExecution{
    public MinimumTestExecution(){
        super("Min function test");
    }
    @Override
    public Result execute() {
        int min = Math.min(9,99);
        if(min == 9){
            return Result.PASS;
        }
        return Result.FAIL;
    }
}
