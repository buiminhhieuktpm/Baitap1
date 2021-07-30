package com.repository;



import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.entity.User;
@Repository
public interface UserRepository extends PagingAndSortingRepository<User, Integer>{
	@Query(value="SELECT * FROM user u where u.username =?1",nativeQuery = true)
	public User findByName(String name);
}
