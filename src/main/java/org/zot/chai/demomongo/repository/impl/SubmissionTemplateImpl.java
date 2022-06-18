package org.zot.chai.demomongo.repository.impl;

import java.util.Date;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.mongodb.core.FindAndModifyOptions;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;
import org.zot.chai.demomongo.model.Lookup;
import org.zot.chai.demomongo.repository.SubmissionTemplate;

@Component
public class SubmissionTemplateImpl implements SubmissionTemplate {
	
	Logger logger = LoggerFactory.getLogger(SubmissionTemplateImpl.class);
	
    private MongoTemplate mongoTemplate;
    
	public SubmissionTemplateImpl(MongoTemplate mongoTemplate) {
		super();
		this.mongoTemplate = mongoTemplate;
	}


	@Override
	public String generateSubmissionId(String prefix) {
		
		logger.info("generateSubmissionId with prefix: {}", prefix);
		Query query = new Query(Criteria.where("prefix").is(prefix));
		Update update = new Update().inc("counter", 1);
		update.currentDate("lastUpdate");
		
		FindAndModifyOptions option = new FindAndModifyOptions();
		option.upsert(true);
		option.returnNew(true);
		
		Lookup current = mongoTemplate.findAndModify(query, update, option,Lookup.class);
		logger.info("current : {} ",current);
		
		//Just to prevent sonar warning, current object should never be null.
		if(current == null) {
			current = new Lookup(prefix, 1L,new Date());
		}
				
		return createSubmissionId(prefix, current.counter());
	}
	
	private String createSubmissionId(@NonNull String prefix,@NonNull long seq) {
		logger.info("createSubmissionId for prefix: {} and number: {}", prefix, seq);
		return prefix.concat( StringUtils.leftPad(String.valueOf(seq), 10, '0'));
	}

}
