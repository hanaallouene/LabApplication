package com.example.demo.proxies;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.demo.beans.EvenementBean;

@FeignClient(value = "EVENT" ,url = "http://localhost:9000", path = "/EVENT")
public interface EvenementProxyService {
	@GetMapping("/evenements/{id}")
	public EvenementBean findEvenementById(@PathVariable(name = "id") Long
	id);
}
