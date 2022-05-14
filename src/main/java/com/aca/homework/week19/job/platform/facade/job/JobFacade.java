package com.aca.homework.week19.job.platform.facade.job;

import com.aca.homework.week19.job.platform.facade.job.request.JobHireRequestDto;
import com.aca.homework.week19.job.platform.facade.job.response.JobHireResponseDto;

public interface JobFacade {
    JobHireResponseDto hire(JobHireRequestDto dto);
}
