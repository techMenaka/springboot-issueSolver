package com.example.springBoot;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class IssueResolverApplicationTests {


    @Autowired
    IssueResolverApplication issueResolverApplication;

    ConfigurableApplicationContext context;

	@Test
	public void contextLoads() {
        context = SpringApplication.run(IssueResolverApplication.class);
    }

    @Test
    public void shouldInsertIntable() {
        issueResolverApplication.cassandraInsert(context);
    }

}
