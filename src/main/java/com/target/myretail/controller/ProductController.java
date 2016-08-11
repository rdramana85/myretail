package com.target.myretail.controller;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.target.myretail.model.ProductPriceData;
import com.target.myretail.service.ProductDataAggregationService;
import com.target.myretail.service.ProductPriceUpdateService;
import com.target.myretail.transformer.Transformer;
import com.target.myretail.util.ValidationErrorBuilder;
import com.target.myretail.util.ValidationErrors;

@RestController
@RequestMapping("/myretail")
public class ProductController {

	@Autowired
	private ProductDataAggregationService productDataAggregationService;
	
	@Autowired
	private ProductPriceUpdateService productPriceUpdateService;
	
	@Autowired
	private Transformer transformer;
	
	@RequestMapping(value="v1/products/{id}", produces = {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<String> getProductNameAndPriceData(@PathVariable("id") @NotNull Long productId) throws Exception{
		return transformer.transform(productDataAggregationService.getProductPriceData(productId));
	}
	
	@RequestMapping(value="v1/products/{id}",method=RequestMethod.PUT, produces = {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<String> updatePriceData(@PathVariable("id") Long productId,@RequestBody @Valid ProductPriceData priceData) throws Exception{
		return productPriceUpdateService.updatePrice(productId,priceData);
	}
	
	@ExceptionHandler
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public ValidationErrors handleException(MethodArgumentNotValidException exception) {
        return ValidationErrorBuilder.fromBindingErrors(exception.getBindingResult());    
    }
	
}
