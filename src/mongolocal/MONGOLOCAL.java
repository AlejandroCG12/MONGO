/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mongolocal;

import com.mongodb.MongoClient;
import java.net.UnknownHostException;
import java.sql.Connection;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Momo
 */
public class MONGOLOCAL {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("Prueba conexión MongoDB");
        MongoClient mongo = crearConexion();
        if (mongo != null) {
            System.out.println("Lista de bases de datos: ");
            printDatabases(mongo);
 
        } else {
            System.out.println("Error: Conexión no establecida");
        }
    }
        
    private static MongoClient crearConexion(){
        MongoClient mongo = null;
        try {
            mongo = new MongoClient("localhost", 27017);
        } catch (Exception e) {
          e.printStackTrace();
        }
 
        return mongo;
    }
 
    /**
     * Clase que imprime por pantalla todas las bases de datos MongoDB.
     * @param mongo conexión a MongoDB
     */
    private static void printDatabases(MongoClient mongo) {
        List dbs = mongo.getDatabaseNames();
        for (Object db : dbs) {
            System.out.println(" - " + db);
        }
    }
}
