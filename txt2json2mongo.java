import com.mongodb.BasicDBObject;
import com.mongodb.BulkWriteOperation;
import com.mongodb.BulkWriteResult;
import com.mongodb.Cursor;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.ParallelScanOptions;

import java.util.List;
import java.util.Set;

import static java.util.concurrent.TimeUnit.SECONDS;

      public class txt2json2mongo {
               
               public static void main(String[] args) {

  //  try {
    
     MongoClient mongoClient = new MongoClient("localhost" , 27017 );

     //to connect to a replica set, with auto-discovery of the primary, supply a seed list of members
     //MongoClient mongoClient = new MongoClient(Arrays.asList(new ServerAddress("localhost", 27017),
     //                                      new ServerAddress("localhost", 27018),
     //                                    new ServerAddress("localhost", 27019)));

     DB db = mongoClient.getDB( "accern_db" );
     System.out.println("Connect to database successfully");
     
     // If the name and password are set to database, use the below thing.
     //boolean auth = db.authenticate(myUserName, myPassword);

     //retrieve any colletion if already exists
     //Set<String> colls = db.getCollectionNames();

     for (String s : colls) {
   
                  System.out.println(s);

             }

     //get a collection to use
     DBCollection coll = db.getCollection("txt2json2mongo");

     //setting write concern
     mongoClient.setWriteConcern(WriteConcern.JOURNALED);
     
     //insert Document
     BufferedReader br = null;
		try {
			String sCurrentLine;
 
			br = new BufferedReader(new FileReader("100lines.txt"));
 
			while ((sCurrentLine = br.readLine()) != null) {
				 i++;
				 String str = Integer.toString(i);
				 BasicDBObject doc = new BasicDBObject("title", sCurrentLine);
				System.out.print(s);
				System.out.print("  ");
				System.out.println(sCurrentLine);
				coll.insert(doc);
       }
       }catch (IOException e) {
             e.printStackTrace();
        }

     //to show the first document
     DBObject myDoc = coll.findOne(); {
              System.out.println(myDoc);
              }
              
     //count the number of documents
     System.out.println(coll.getCount());


mongoClient.close()

