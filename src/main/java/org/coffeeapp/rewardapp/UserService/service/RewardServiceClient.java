package org.coffeeapp.rewardapp.UserService.service;

import org.coffeeapp.rewardapp.UserService.model.RewardResponseModel;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(name="reward-ws")
public interface RewardServiceClient
{
	@GetMapping("/rewards")
	public List<RewardResponseModel> getRewardsByUserId( @RequestParam("userId") Long userId );
}
