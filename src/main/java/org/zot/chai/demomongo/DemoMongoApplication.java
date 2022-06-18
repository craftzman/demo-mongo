package org.zot.chai.demomongo;

import java.util.Objects;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
public class DemoMongoApplication  implements CommandLineRunner {
	
	Logger logger = LoggerFactory.getLogger(DemoMongoApplication.class);
	
	@Autowired
	SubmissionRepository submissionRepository;
	
	@Autowired
	SubmissionTemplate submissiontemplate;

	public static void main(String[] args) {
		SpringApplication.run(DemoMongoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		submissionRepository.findAll().stream().filter(Objects::nonNull)
			.map(Submission::getSubmissionId)
			.forEach(logger::info);

		logger.info("The current Submission id is => {} ", submissiontemplate.generateSubmissionId("DEL"));	
		logger.info("findBySubmissionIdStartWith => {}", submissionRepository.findBySubmissionIdStartingWith("FRP"));
	}
	
}
