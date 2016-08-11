package com.target.myretail.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.web.client.AsyncRestTemplate;

import com.target.myretail.model.ProductAttributeData;
import com.target.myretail.service.ProductAttributeService;

@Service("productAttributeService")
public class ProductAttributeServiceImpl implements ProductAttributeService {

	@Value("${product.domain.attribute.service.url.prefix}")
	private String urlPrefix;
	
	@Value("${product.domain.attribute.service.url.suffix}")
	private String urlSuffix;

	@Autowired
	private AsyncRestTemplate asyncRestTemplate;

	@Override
	public ListenableFuture<ResponseEntity<ProductAttributeData>> getProductAttributeData(
			Long productId) {
		HttpMethod method = HttpMethod.GET;
		Class<ProductAttributeData> responseType = ProductAttributeData.class;
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.TEXT_PLAIN);
		HttpEntity<String> requestEntity = new HttpEntity<String>("params",
				headers);
		return asyncRestTemplate.exchange(urlPrefix+productId+urlSuffix, method, requestEntity,
				responseType);
	}
}
