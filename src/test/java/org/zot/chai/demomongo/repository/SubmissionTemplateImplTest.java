package org.zot.chai.demomongo.repository;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.test.context.junit.jupiter.SpringExtension;

//@DataMongoTest
//@ImportAutoConfiguration(exclude = EmbeddedMongoAutoConfiguration.class)
@ExtendWith(SpringExtension.class)
class SubmissionTemplateImplTest {
	
	Logger logger = LoggerFactory.getLogger(SubmissionTemplateImplTest.class);
		
	MongoTemplate mongoTemplate;
	
//	@Autowired
//	private SubmissionRepository submissionRepository;

	private SubmissionTemplate submissionTemplate;
	
	
//	@Test
//    void test(@Autowired MongoTemplate mongoTemplate) {
////		
//////		submissionTemplate = new SubmissionTemplateImpl(mongoTemplate);
////        
////		// given
////        DBObject objectToSave = BasicDBObjectBuilder.start()
////            .add("submissionId", "DEP0000000001")
////            .add("user", "uw1")
////            .get();
////
////        // when
//////        mongoTemplate.save(objectToSave, "submission");
////
////
////        // then
//////        assertThat(mongoTemplate.findAll(DBObject.class, "submission")).extracting("key")
//////            .containsOnly("value");
//    }
	
//	@Test
//    void test(@Autowired MongoTemplate mongoTemplate) {
//		
//		submissionTemplate = new SubmissionTemplateImpl(mongoTemplate);
//		
//		final Submission dep = new Submission("DEP0000000001","uw1");
//		final Submission frp = new Submission("FRP0000000001","uw2");
//		
//		Query query = new Query(Criteria.where("submissionId").regex("DEP"));
//		
//        // given
////        DBObject objectToSave = BasicDBObjectBuilder.start()
////            .add("submissionId", "DEP0000000020")
////            .add("user", "uw1")
////            .get();
//
//        // when
//        mongoTemplate.save(dep, "submission-test");
//        mongoTemplate.save(frp, "submission-test");
//
//        // then
////        assertThat(mongoTemplate.findAll(Submission.class, "submission-test")).extracting("submissionId")
////            .containsOnly("DEP0000000001");
//        assertThat(mongoTemplate.findAll(Submission.class, "submission-test")).extracting("submissionId")
//        	.contains("DEP0000000001","FRP0000000001");
//        
//        assertThat(mongoTemplate.findAll(Submission.class, "submission-test")).extracting("user")
//        	.contains("uw1","uw2");
//        
////		assertEquals("30", submissionTemplate.currentSubmissionId("DEP"));       
//        
//        assertEquals(2, mongoTemplate.find(query, Submission.class).size());     
//        
//        logger.info("Current id => {} ", submissionTemplate.generateSubmissionId("DEP"));	
////        logger.info("Repo.findByUser => {} ", submissionRepository.findByUser("uw1"));
////        logger.info("Repo.findAll => {} ", submissionRepository.findAll());
//        
//		mongoTemplate.getDb().getCollection("submission-test").drop();
//		
//    }
	
	@Test
	void test(/* @Autowired MongoTemplate mongoTemplate */) {
		
	}

}
