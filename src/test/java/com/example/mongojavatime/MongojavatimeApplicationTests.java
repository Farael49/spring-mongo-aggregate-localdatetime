package com.example.mongojavatime;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MongojavatimeApplicationTests {
	@Autowired
	private TestJavaTimeRepository repository;

	@Autowired
	private MongoTemplate template;

	@Before
	public void init(){
		repository.deleteAll();
		repository.save(new TestJavaTime());
		repository.save(new TestJavaTime());
	}

	@Test
	public void contextLoads() {
	}

	@Test
	public void testWithRepositoryByLocalDateTime() {
		assertThat(repository.findByCreatedDateAfter(LocalDateTime.now().minusDays(30)).size(), is(2));
	}

	@Test
	public void testWithTemplateByLocalDateTime(){
		Query q = new Query();
		Criteria c = Criteria.where("createdDate").gt(LocalDateTime.now().minusDays(30));
		assertThat(template.find(q.addCriteria(c), TestJavaTime.class).size(), is(2));
	}


	@Test
	public void testWithTemplateByLocalDateTimeUsingAggregate(){
		Criteria c = Criteria.where("createdDate").gt(LocalDateTime.now().minusDays(30));
		assertThat(template.aggregate(Aggregation.newAggregation(Aggregation.match(c)),
				"TestJavaTime", TestJavaTime.class).getMappedResults().size(),
				is(2));
	}

	@Test
	public void testWithTemplateByJavaUtilDateUsingAggregate(){
		Calendar cal = Calendar.getInstance();
		cal.setTime(new Date());
		cal.add(Calendar.DATE, -30);
		Criteria c = Criteria.where("createdDate").gt(cal.getTime());
		assertThat(template.aggregate(Aggregation.newAggregation(Aggregation.match(c)),
				"TestJavaTime", TestJavaTime.class).getMappedResults().size(),
				notNullValue());
	}
}
