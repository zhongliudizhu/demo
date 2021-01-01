package com.example.demo.task;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
public class LambdaTest {
    private static List<Job> jobList = new ArrayList<>();

    static {
        jobList.add(new Job("1", "a"));
        jobList.add(new Job("2", "b"));
        jobList.add(new Job("3", "c"));
        jobList.add(new Job("4", "d"));
        jobList.add(new Job("5", "e"));
    }

    public static void main(String[] args) {

        List<String> collect = jobList.stream().map(Job::getName).collect(Collectors.toList());
        log.info("list is {}", collect);

        jobList.removeIf(s -> collect.contains(s.getName()));
        jobList.forEach(System.out::println);

    }


}

@Data
@AllArgsConstructor
class Job {
    private String name;
    private String address;


}