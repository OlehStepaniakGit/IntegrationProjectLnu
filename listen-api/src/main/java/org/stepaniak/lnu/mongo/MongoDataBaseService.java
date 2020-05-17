package org.stepaniak.lnu.mongo;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.stepaniak.lnu.mongo.entity.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class MongoDataBaseService {
    private final static String HOST = "localhost";
    private final static int PORT = 27017;
    private final static String DATABASE = "IntegrationDB";
    private final static String COLLECTION = "News";

    private MongoClient mongoClient;
    private MongoDatabase mongoDatabase;
    private MongoCollection mongoCollection;

    public MongoDataBaseService() {
        this.mongoClient = new MongoClient(HOST, PORT);
        this.mongoDatabase = mongoClient.getDatabase(DATABASE);
        this.mongoCollection = mongoDatabase.getCollection(COLLECTION);
    }

    public List<Data> findAll(){
        MongoCursor<Document> cursor = mongoCollection.find().iterator();
        List<Data> dataList =  new ArrayList<>();
        while (cursor.hasNext()){
            Document document = cursor.next();
            Data data =  new Data(document.get("content").toString(),document.get("date").toString());
            dataList.add(data);
        }
        return dataList;
    }

    public void writeMany(List<Data> dataList){
        dataList.removeAll(this.findAll());

        List<Document> documents =  new ArrayList<>(10);

        Consumer<Data> consumer = (element)->{
            Document document =  new Document();
            document.put("content",element.getContent());
            document.put("date",element.getDate());
            documents.add(document);
        };

        dataList.forEach(consumer);

        if (!documents.isEmpty()){
            mongoCollection.insertMany(documents);
            System.out.println("Data saved!");
            dataList.clear();
            documents.clear();
        }
    }
}
