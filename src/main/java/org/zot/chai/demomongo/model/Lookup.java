package org.zot.chai.demomongo.model;

import java.util.Date;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.lang.NonNull;

@Document("submission-lookup")
public record Lookup(@NonNull String prefix,@NonNull long counter, @NonNull Date lastUpdate) {}
