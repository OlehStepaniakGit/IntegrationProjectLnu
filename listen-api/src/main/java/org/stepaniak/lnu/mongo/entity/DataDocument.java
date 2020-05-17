package org.stepaniak.lnu.mongo.entity;

import org.bson.Document;

public class DataDocument extends Document {
    public DataDocument(Data data) {
        super();
        this.put("content",data.getContent());
        this.put("date",data.getDate());
    }
}
