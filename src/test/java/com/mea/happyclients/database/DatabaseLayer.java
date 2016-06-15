package com.mea.happyclients.database;

/**
 * Manages data creation, retreival and management.
 */
public class DatabaseLayer {

    private DatabaseLayer dbLayer = null;

    private DatabaseLayer() {

    }

    public DatabaseLayer getInstance() {
        if (dbLayer == null) {
            dbLayer = new DatabaseLayer();
        }

        return dbLayer;
    }

}
