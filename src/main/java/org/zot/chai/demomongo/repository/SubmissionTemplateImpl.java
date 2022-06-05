package org.zot.chai.demomongo.repository;

import java.util.Comparator;
import java.util.List;

import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Component;
import org.zot.chai.demomongo.model.Submission;

@Component
public class SubmissionTemplateImpl implements SubmissionTemplate {
	
    MongoTemplate mongoTemplate;
    
	public SubmissionTemplateImpl(MongoTemplate mongoTemplate) {
		super();
		this.mongoTemplate = mongoTemplate;
	}


	@Override
	public String currentSubmissionId(String prefix) {
		
		Query query = new Query(Criteria.where("submissionId").regex(prefix));
		query.fields().include("submissionId");
		
		List<Submission> output = mongoTemplate.find(query, Submission.class);
		
		output.stream().forEach( s -> System.out.println(s));
		
		System.out.println(output.stream().map( s -> Long.valueOf(s.getSubmissionId().substring(3)))
				.sorted(Comparator.reverseOrder())
				.findFirst());
		
		return "";
	}

}
