package com.aca.homework.week14.objectmapper;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;

class CommitAnalyzerTest {

    private CommitAnalyzer commitAnalyzer;


    @BeforeEach
    public void init() {
        commitAnalyzer = new CommitAnalyzer();
    }

    @Test
    public void testCount() {
        Assertions.assertEquals(
                301,
                commitAnalyzer.count(new File(
                        CommitAnalyzer.getPath() + "\\commits-data.txt"
                )));
    }
}