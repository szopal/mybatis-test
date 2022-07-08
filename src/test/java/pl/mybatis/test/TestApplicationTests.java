package pl.mybatis.test;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import pl.mybatis.test.repository.TestInfoRepository;

import java.sql.Date;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@ActiveProfiles("test")
class TestApplicationTests {

	@Autowired
	private TestInfoRepository testInfoRepository;

	@Test
	void testSql() {
		assertThat(testInfoRepository.findRecord("test", Date.valueOf("1998-01-01"), Date.valueOf("2050-12-31"))).isNotEmpty();
	}

}
