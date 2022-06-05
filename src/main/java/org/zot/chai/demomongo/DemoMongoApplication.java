package org.zot.chai.demomongo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.zot.chai.demomongo.model.Submission;
import org.zot.chai.demomongo.repository.SubmissionRepository;
import org.zot.chai.demomongo.repository.SubmissionTemplate;

@SpringBootApplication
@EnableMongoRepositories
public class DemoMongoApplication implements CommandLineRunner {
	
	@Autowired
	SubmissionRepository submissionRepo;
	
	@Autowired
	SubmissionTemplate submissiontemplate;

	public static void main(String[] args) {
		SpringApplication.run(DemoMongoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
			
		for(Submission sb: submissionRepo.findAll()) {
			System.out.println(sb.getSubmissionId() + " => " + sb.getUser());
		}
		
		submissiontemplate.currentSubmissionId("FRP");
		
	}

}
