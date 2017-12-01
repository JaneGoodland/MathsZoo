package com.janegoodlandmaths.www.mathszoo;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.BaseColumns;

/**
 * Created by Jamie on 27/08/2017.
 */

public final class FeedReaderContract {
    private FeedReaderContract() {}
    public static class FeedEntry implements BaseColumns {
        public static final String TABLE_NAME = "users";
        public static final String COLUMN_NAME_USERNAME = "username";
        public static final String COLUMN_NAME_PASSWORD = "password";
        public static final String HUNGERS_n1 = "hungers_n1";
        public static final String HUNGERS_n2 = "hungers_n2";
        public static final String HUNGERS_n3 = "hungers_n3";
        public static final String HUNGERS_n4 = "hungers_n4";
        public static final String HUNGERS_a1 = "hungers_a1";
        public static final String HUNGERS_a2 = "hungers_a2";
        public static final String HUNGERS_a3 = "hungers_a3";
        public static final String HUNGERS_a4 = "hungers_a4";
        public static final String HUNGERS_g1 = "hungers_g1";
        public static final String HUNGERS_g2 = "hungers_g2";
        public static final String HUNGERS_g3 = "hungers_g3";
        public static final String HUNGERS_g4 = "hungers_g4";
        public static final String HUNGERS_p1 = "hungers_p1";
        public static final String HUNGERS_p2 = "hungers_p2";
        public static final String HUNGERS_p3 = "hungers_p3";
        public static final String HUNGERS_p4 = "hungers_p4";
        public static final String HUNGERS_r1 = "hungers_r1";
        public static final String HUNGERS_r2 = "hungers_r2";
        public static final String HUNGERS_r3 = "hungers_r3";
        public static final String HUNGERS_r4 = "hungers_r4";
        public static final String HUNGERS_s1 = "hungers_s1";
        public static final String HUNGERS_s2 = "hungers_s2";
        public static final String HUNGERS_s3 = "hungers_s3";
        public static final String HUNGERS_s4 = "hungers_s4";
    }
    // SQL_CREATE_ENTRIES creates the table and the table names
    // It does NOT put in any data
    public static final String SQL_CREATE_ENTRIES =
            "CREATE TABLE IF NOT EXISTS "+ FeedEntry.TABLE_NAME +"("+
                    FeedEntry._ID + " INTEGER PRIMARY KEY, "+
                    FeedEntry.COLUMN_NAME_USERNAME+" TEXT," +
                    FeedEntry.COLUMN_NAME_PASSWORD+" TEXT," +
                    FeedEntry.HUNGERS_n1+" SMALLINT," +
                    FeedEntry.HUNGERS_n2+" SMALLINT," +
                    FeedEntry.HUNGERS_n3+" SMALLINT," +
                    FeedEntry.HUNGERS_n4+" SMALLINT," +
                    FeedEntry.HUNGERS_a1+" SMALLINT," +
                    FeedEntry.HUNGERS_a2+" SMALLINT," +
                    FeedEntry.HUNGERS_a3+" SMALLINT," +
                    FeedEntry.HUNGERS_a4+" SMALLINT," +
                    FeedEntry.HUNGERS_g1+" SMALLINT," +
                    FeedEntry.HUNGERS_g2+" SMALLINT," +
                    FeedEntry.HUNGERS_g3+" SMALLINT," +
                    FeedEntry.HUNGERS_g4+" SMALLINT," +
                    FeedEntry.HUNGERS_p1+" SMALLINT," +
                    FeedEntry.HUNGERS_p2+" SMALLINT," +
                    FeedEntry.HUNGERS_p3+" SMALLINT," +
                    FeedEntry.HUNGERS_p4+" SMALLINT," +
                    FeedEntry.HUNGERS_r1+" SMALLINT," +
                    FeedEntry.HUNGERS_r2+" SMALLINT," +
                    FeedEntry.HUNGERS_r3+" SMALLINT," +
                    FeedEntry.HUNGERS_r4+" SMALLINT," +
                    FeedEntry.HUNGERS_s1+" SMALLINT," +
                    FeedEntry.HUNGERS_s2+" SMALLINT," +
                    FeedEntry.HUNGERS_s3+" SMALLINT," +
                    FeedEntry.HUNGERS_s4+" SMALLINT)";

    public static final String SQL_DELETE_ENTRIES =
            "DROP TABLE IF EXISTS" + FeedEntry.TABLE_NAME;
}

