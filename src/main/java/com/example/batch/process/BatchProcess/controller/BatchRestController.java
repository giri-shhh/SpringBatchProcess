package com.example.batch.process.BatchProcess.controller;

import org.springframework.batch.core.*;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/")
class BatchRestController {

    @Autowired
    private JobLauncher jobLauncher;

    @Autowired
    private Job job;

    @GetMapping
    public BatchStatus requestBatchRun() throws JobParametersInvalidException, JobExecutionAlreadyRunningException, JobRestartException, JobInstanceAlreadyCompleteException {

        Map<String, JobParameter> jobParameterMap = new HashMap<>();

        jobParameterMap.put("time", new JobParameter(System.currentTimeMillis()));

        JobParameters parameters = new JobParameters(jobParameterMap);
        JobExecution jobExecution = jobLauncher.run(job, parameters);

        return jobExecution.getStatus();
    }
}
