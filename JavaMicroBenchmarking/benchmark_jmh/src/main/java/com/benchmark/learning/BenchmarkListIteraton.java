package com.benchmark.learning;

import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.infra.Blackhole;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Random;
import java.util.concurrent.TimeUnit;

@State(Scope.Benchmark)
@OutputTimeUnit(TimeUnit.MICROSECONDS)
public class BenchmarkListIteraton {


    @Param({"1000","2000000"})
    int length;

    Integer[] integerArray;
    ArrayList<Integer> arrayList;
    LinkedList<Integer> linkedList;

    @Setup(Level.Trial)
    public void setup() {
        integerArray = new Integer[length];
        arrayList = new ArrayList<>(length);
        linkedList = new LinkedList<>();

        final Random ran = new Random();
        for(int i=0;i<length;i++) {
            int value = ran.nextInt();
            integerArray[i] = value;
            arrayList.add(value);
            linkedList.add(value);
        }
    }


    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @Fork(1)
    public void arrayList(Blackhole blackhole) {

        for(Integer value: arrayList) {
            blackhole.consume(value);
        }
    }

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @Fork(1)
    public void integerArray(Blackhole blackhole) {
        for(Integer value: integerArray) {
            blackhole.consume(value);
        }
    }

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @Fork(1)
    public void linkedList(Blackhole blackhole) {
        for(Integer value: linkedList) {
            blackhole.consume(value);
        }
    }




}
