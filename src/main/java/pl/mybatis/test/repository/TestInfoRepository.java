package pl.mybatis.test.repository;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import pl.mybatis.test.dto.TestInfo;

import java.sql.Date;
import java.util.List;

@Mapper
@Repository
public interface TestInfoRepository {

  public List<TestInfo> findRecord(@Param("testValue") String testValue, @Param("myDateFrom") Date myDateFrom, @Param("myDateTo") Date myDateTo);
}
