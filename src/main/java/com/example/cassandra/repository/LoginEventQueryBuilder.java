package com.example.cassandra.repository;


import static com.datastax.driver.core.querybuilder.QueryBuilder.*;
import static com.example.cassandra.repository.table.LoginEventTable.*;

import com.datastax.driver.core.querybuilder.Insert;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 * Created by Menaka on 10/14/16.
 */
@Component
@Qualifier("loginEventQueryBuilder")
public class LoginEventQueryBuilder {

    public Insert addLoginEvent() {
        final Insert insert = insertInto(LOGIN_EVENT_TABLE)
            .values(
                new String[]{
                    PERSON_ID,
                    EVENT_TIME,
                    EVENT_CODE,
                    IP_ADDRESS
                },
                new Object[]{
                    bindMarker(),
                    bindMarker(),
                    bindMarker(),
                    bindMarker()
                }
            );

        //insert.using(ttl(bindMarker(TTL)));
        return insert;
    }
}
