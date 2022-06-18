package org.zot.chai.demomongo.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;
import org.zot.chai.demomongo.model.Submission;

@Repository
public interface SubmissionRepository extends MongoRepository<Submission, String> {
	
	@Query("{prefix:'?0'}")
	Submission findLatestId(String prefix);
	
	@Query("{user:'?0'}")
	List<Submission> findByUser(String user);
	
	@Query(value= "{submissionId : {$regex : ?0}}", fields="{submissionId : 1}")
	List<Submission> findBySubmissionIdStartingWith(String prefix);

}
