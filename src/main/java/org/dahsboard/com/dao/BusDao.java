package org.dahsboard.com.dao;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import org.apache.log4j.Logger;
import org.bson.Document;
import org.bson.conversions.Bson;
import org.dahsboard.com.model.Bus;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;


@Repository
@Component
public class BusDao {

    private static Logger log = Logger.getLogger(BusDao.class);

    MongoClient mongoClient;
    MongoCollection<Document> coll;


    public  MongoCollection<Document>  dbConnection() {
        // Mongodb initialization parameters.
        int port_no = 27017;
        String host_name = "localhost", db_name = "sampleDB", db_coll_name = "product";

        // Mongodb connection string.
        String client_url = "mongodb://" + host_name + ":" + port_no + "/" + db_name;
        MongoClientURI uri = new MongoClientURI(client_url);

        // Connecting to the mongodb server using the given client uri.
        mongoClient = new MongoClient(uri);

        // Fetching the database from the mongodb.
        MongoDatabase db = mongoClient.getDatabase(db_name);

        // Fetching the collection from the mongodb.
        coll = db.getCollection(db_coll_name);

        return  coll;
    }

        //Fetching in all products
    public  String getAllBuses() {
        log.info("Fetching all products from the collection");
        System.out.println("Fetching all products from the collection");

        // Performing a read operation on the collection.
        FindIterable<Document> fi = dbConnection().find();
        MongoCursor<Document> cursor = fi.iterator();
        StringBuilder stringBuilder = new StringBuilder();
        try {
            while(cursor.hasNext()) {
                log.info(cursor.next());
                stringBuilder.append(cursor.next().toJson());
            }
        } finally {
            cursor.close();
        }

        return stringBuilder.toString();
    }

    // Fetch a selective Bus from the mongo collection.
    public String getSelectiveBus(int product) {
        log.info("Fetching a particular document from the collection");
        // Performing a read operation on the collection.
        FindIterable<Document> fi = dbConnection().find();
        MongoCursor<Document> cursor = fi.iterator();

        try {
            log.info(cursor.next().toJson());
        } finally {
            cursor.close();
        }

        return cursor.next().toJson();
    }

    public String putProduct(Bus bus) {

        log.info("Modifying a particular document from the collection");
        // Performing a read operation on the collection.
        FindIterable<Document> fi = dbConnection().find((Bson) bus);


        dbConnection().replaceOne((Bson) bus,fi.first());

        FindIterable<Document> fiUpdate  = dbConnection().find((Bson) bus);

        try {
            log.info(fiUpdate.iterator().next().toJson());
        } finally {
            fiUpdate.iterator().close();
        }

        return fiUpdate.iterator().next().toJson();
    }
}
