package cn.com.thread.repository;


import cn.com.thread.entity.ExampleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface  ExampleRepository extends JpaRepository<ExampleEntity, Long> {

    @Query(value="select name from student  where id = ?1",nativeQuery = true)
    String getNameByClassId(String id);

}
