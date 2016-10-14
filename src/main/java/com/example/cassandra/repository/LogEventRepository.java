package com.example.cassandra.repository;

import static com.example.cassandra.repository.table.LoginEventTable.*;

import com.datastax.driver.core.*;
import com.example.cassandra.LoginEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.cassandra.core.CassandraOperations;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.Date;

import lombok.Getter;

/**
 * Created by Menaka on 10/14/16.
 */
@Component
public class LogEventRepository {

    protected CassandraOperations cassandraOperations;

    private LoginEventQueryBuilder loginEventQueryBuilder;

    public LogEventRepository(CassandraOperations cassandraOperations,
        LoginEventQueryBuilder loginEventQueryBuilder) {
        this.cassandraOperations = cassandraOperations;
        this.loginEventQueryBuilder = loginEventQueryBuilder;
    }

    public void executeLogEventQuery(LoginEvent loginEvent) {

        final BoundStatement loginEventStmt = new BoundStatement(getPrepareStatement());

        loginEventStmt.bind();
        loginEventStmt.setString(PERSON_ID, loginEvent.getPk().getPersonId());
        loginEventStmt.setDate(EVENT_TIME, loginEvent.getPk().getEventTime());
        loginEventStmt.setInt(EVENT_CODE, loginEvent.getEventCode());
        loginEventStmt.setString(IP_ADDRESS, loginEvent.getIpAddress());

        cassandraOperations.execute(loginEventStmt);
    }

    private PreparedStatement getPrepareStatement() {
        return cassandraOperations.getSession().prepare(loginEventQueryBuilder.addLoginEvent());
    }


}
