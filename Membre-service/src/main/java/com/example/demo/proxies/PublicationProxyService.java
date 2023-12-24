package com.example.demo.proxies;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.demo.beans.PublicationBean;

@FeignClient(name = "PUBLICATION")
public interface PublicationProxyService {
	@GetMapping("/Publications/{id}")
	public PublicationBean findPublicationById(@PathVariable(name = "id") Long
	id);
}
