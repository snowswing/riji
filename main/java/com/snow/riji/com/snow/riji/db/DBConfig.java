package com.snow.riji.com.snow.riji.db;

public class DBConfig {
    public static final String DB_NAME = "health_diary.db";
    public static final int DB_VERSION = 0x00000001;

    public static class SportRecord {

        public static final String TABLE_SPORT = "soprt_record";
        public static final String ID = "id";
        public static final String SPORTNAME = "sport_name";
        public static final String SPORTTIME = "sport_time";
        public static final String FINISHPERSCENT = "finish_percent";
        public static final String SPORTDATE = "sport_date";

        public static final String CREATE_SPORT_RECORD_SQL = "create table if not exists " + TABLE_SPORT
                + "("
                + ID + " integer primary key autoincrement, "
                + SPORTDATE+"text"
                + SPORTNAME + " text, "
                + SPORTTIME + " text, "
                + FINISHPERSCENT + " integer "
                + ");";
    }

    public static class PainRecord {

        public static final String TABLE_PAIN = "pain_record";

        public static final String ID = "id";
        public static final String PAINPART = "pain_part";
        public static final String PAINTIME = "pain_time";
        public static final String PAINLEVEL = "pain_level";
        public static final String SPORTDATE = "pain_date";

        public static final String CREATE_PAIN_RECORD_SQL = "create table if not exists " + TABLE_PAIN
                + "("
                + ID + " integer primary key autoincrement, "
                + PAINPART+"text"
                + PAINTIME + " text, "
                + PAINLEVEL + " integer, "
                + SPORTDATE + " text "
                + ");";
    }

    public static class DrugRecord {

        public static final String TABLE_DRUG = "drug_record";

        public static final String ID = "id";
        public static final String DRUGNAME = "drug_name";
        public static final String DRUGTIME = "drug_time";
        public static final String COUNTONCE = "count_once";
        public static final String DURGDATE = "drug_date";

        public static final String CREATE_DRUG_RECORD_SQL = "create table if not exists " + TABLE_DRUG
                + "("
                + ID + " integer primary key autoincrement, "
                + DRUGNAME+"text"
                + DRUGTIME + " text, "
                + COUNTONCE + " integer, "
                + DURGDATE + " text "
                + ");";
    }

    public static class DietRecord {

        public static final String TABLE_DIET = "diet_record";

        public static final String ID = "id";
        public static final String DIETNAME = "diet_name";
        public static final String DIETTIME = "diet_time";
        public static final String DIETHEAT = "diet_heat";
        public static final String DIETDATE = "diet_date";

        public static final String CREATE_DIET_RECORD_SQL = "create table if not exists " + TABLE_DIET
                + "("
                + ID + " integer primary key autoincrement, "
                + DIETNAME+"text"
                + DIETTIME + " text, "
                + DIETHEAT + " integer, "
                + DIETDATE + " text "
                + ");";
    }
    /*
    public static class DietRecord {

        public static final String TABLE_DIET = "sport_pic";

        public static final String ID = "id";
        public static final String PART = "part";
        public static final String ISUP = "is_up";
        public static final String ISLEFT = "is_left";
        public static final String PIC = "pic";
        public static final String NAME = "name";

        public static final String CREATE_PIC_RECORD_SQL = "create table if not exists " + TABLE_NAME
                + "("
                + ID + " integer primary key autoincrement, "
                + PART + " integer, "
                + ISUP + " integer, "
                + ISLEFT + " integer, "
                + NAME + " text, "
                + PIC + " blob "
                + ");";
    }*/
}
