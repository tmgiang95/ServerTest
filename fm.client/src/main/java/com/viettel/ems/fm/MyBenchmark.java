package com.viettel.ems.fm;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Mode;

public class MyBenchmark {

    @Benchmark
    @BenchmarkMode(Mode.Throughput)
    public void testMethod() {
        int a = 1;
        int b = 2;
        int sum = a + b;
    }

}
