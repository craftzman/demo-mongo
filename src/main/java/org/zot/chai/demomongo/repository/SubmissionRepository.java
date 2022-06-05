package org.zot.chai.demomongo.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.zot.chai.demomongo.model.Submission;

public interface SubmissionRepository extends MongoRepository<Submission, String> {
	
	@Query("{prefix:'?0'}")
	Submission findLatestId(String prefix);
	
	@Query("{user:'?0'}")
	List<Submission> findByUser(String user);

}
