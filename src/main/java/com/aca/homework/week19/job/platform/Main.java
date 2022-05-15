package com.aca.homework.week19.job.platform;

import com.aca.homework.week19.job.platform.facade.invitation.InvitationFacade;
import com.aca.homework.week19.job.platform.facade.invitation.request.InvitationAcceptDto;
import com.aca.homework.week19.job.platform.facade.invitation.request.InvitationRejectDto;
import com.aca.homework.week19.job.platform.facade.invitation.request.InvitationRequestDto;
import com.aca.homework.week19.job.platform.facade.job.JobFacade;
import com.aca.homework.week19.job.platform.facade.job.request.JobHireRequestDto;
import com.aca.homework.week19.job.platform.facade.organization.OrganizationFacade;
import com.aca.homework.week19.job.platform.facade.organization.request.OrganizationRegistrationRequestDto;
import com.aca.homework.week19.job.platform.facade.user.UserFacade;
import com.aca.homework.week19.job.platform.facade.user.request.UserSignUpRequestDto;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories
@SpringBootApplication
public class Main {
    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(Main.class, args);
        InvitationFacade invitationFacade = context.getBean(InvitationFacade.class);
        JobFacade jobFacade = context.getBean(JobFacade.class);
        OrganizationFacade organizationFacade = context.getBean(OrganizationFacade.class);
        UserFacade userFacade = context.getBean(UserFacade.class);
        System.out.println(userFacade.signUp(new UserSignUpRequestDto("John", "Williams")));
        System.out.println(userFacade.signUp(new UserSignUpRequestDto("Jack", "Smith")));
        System.out.println(userFacade.signUp(new UserSignUpRequestDto("Lisa", "Simpson")));
        System.out.println(organizationFacade.register(new OrganizationRegistrationRequestDto("ACA")));
        System.out.println(organizationFacade.register(new OrganizationRegistrationRequestDto("Google")));
        System.out.println(invitationFacade.sendInvitation(new InvitationRequestDto(1L, 1L)));
        System.out.println(invitationFacade.sendInvitation(new InvitationRequestDto(2L, 1L)));
        System.out.println(invitationFacade.sendInvitation(new InvitationRequestDto(3L, 2L)));
        System.out.println(invitationFacade.acceptInvitation(new InvitationAcceptDto(1L, 1L)));
        System.out.println(invitationFacade.rejectInvitation(new InvitationRejectDto(2L, 2L)));
        System.out.println(jobFacade.hire(new JobHireRequestDto(1L, 1L)));
        System.out.println(invitationFacade.rejectInvitation(new InvitationRejectDto(1L, 1L)));
    }
}
