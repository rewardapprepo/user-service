package org.coffeeapp.rewardapp.UserService.repository;

import org.coffeeapp.rewardapp.UserService.entities.UserEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends CrudRepository<UserEntity, Long>
{
	UserEntity findByEmail( String email );

	List<UserEntity> findByRewardsIn(List<Long> rewardId);
}