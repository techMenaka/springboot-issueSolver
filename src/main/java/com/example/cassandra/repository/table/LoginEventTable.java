package com.example.cassandra.repository.table;

import java.sql.Timestamp;

/**
 * Created by Menaka on 10/14/16.
 */
public interface LoginEventTable {
    String PERSON_ID = "person_id";
    String EVENT_TIME = "event_time";
    String EVENT_CODE = "event_code";
    String IP_ADDRESS = "ip_address";
    String LOGIN_EVENT_TABLE = "login_event";

}
