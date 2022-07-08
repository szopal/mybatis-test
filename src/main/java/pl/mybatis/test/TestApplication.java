package pl.mybatis.test;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import pl.mybatis.test.dto.TestInfo;
import pl.mybatis.test.repository.TestInfoRepository;

import java.sql.Date;
import java.util.List;

/**
 * Test program
 * @author Lukasz.Szopa
 *
 */
@SpringBootApplication
@MapperScan({"pl.mybatis.test.dto", "pl.mybatis.test.repository"})
public class TestApplication implements CommandLineRunner {

	@Value("${spring.datasource.url}")
	private String dataSourceUrl;

	@Autowired
	private TestInfoRepository testInfoRepository;

	public static void main(String[] args) {
		System.exit(SpringApplication.exit(SpringApplication.run(TestApplication.class, args)));
	}

	/**
	 * Generate java component for table name list
	 * @param args args
	 * @throws Exception
	 */
	@Override
	public void run(String... args) throws Exception {
		List<TestInfo> testInfoList = testInfoRepository.findRecord("test", Date.valueOf("2022-04-08"), Date.valueOf("2022-12-15"));
		System.out.println(testInfoList);
	}



}
