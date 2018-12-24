package com.coderbd.repo;

import com.coderbd.entity.Test;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface TestRepo extends JpaRepository<Test, Long>{

}
