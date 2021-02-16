package com.vuclip;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

enum Status {
	SUCCESS, ERROR;
}

class Response {
	private Status status;
	private Map<String, Integer> data;
	private String message;

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public Map<String, Integer> getData() {
		return data;
	}

	public void setData(Map<String, Integer> data) {
		this.data = data;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}

class FunctionResponse {
	private Status status;
	private List<String> data;
	private String message;

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public List<String> getData() {
		return data;
	}

	public void setData(List<String> data) {
		this.data = data;
	}

}

public class test {

	public static void main(String[] args) {
		FunctionResponse stock = new test().getProducts("2014");
		System.out.print(stock.getMessage() + "  " + stock.getData());
	}

	public FunctionResponse getProducts(String year) {
		FunctionResponse response = new FunctionResponse();
		Response responseFromActualAPI = getActualAPI(); // Mocked
		Response responseFromForcastAPI = getForcastedAPI(); // Mocked
		try {

			CompletableFuture<Response> forcastedResponseFuture = CompletableFuture.supplyAsync(() -> {
				return responseFromForcastAPI;
			});

			CompletableFuture<Response> actualResponseFuture = CompletableFuture.supplyAsync(() -> {

				return responseFromActualAPI;
			});

			Response forcastedResponse = forcastedResponseFuture.get();
			Response actualResponse = actualResponseFuture.get();

			Map<String, Integer> mapping = new HashMap<String, Integer>();
			Set<Entry<String, Integer>> actualRecordEntry = actualResponse.getData().entrySet();
			actualRecordEntry.stream().map(entry -> entry.getKey())
					.forEach(key -> mapping.compute(key, (k, v) -> v == null ? 1 : ++v));

			Set<Entry<String, Integer>> forcastedRecordEntry = forcastedResponse.getData().entrySet();
			forcastedRecordEntry.stream().map(entry -> entry.getKey())
					.forEach(key -> mapping.compute(key, (k, v) -> v == null ? 1 : --v));

			if (mapping.entrySet().stream().map(entry -> entry.getValue()).anyMatch(x -> x != 0)) {
				response.setStatus(Status.ERROR);
				response.setMessage("Product Mismatch");
			} else {

				List<String> products = actualRecordEntry.stream()
						.filter(entry -> entry.getValue() > forcastedResponse.getData().get(entry.getKey()))
						.map(entry -> entry.getKey()).collect(Collectors.toList());

				response.setStatus(Status.SUCCESS);
				response.setMessage("Successfully retreived");
				response.setData(products);
			}
		} catch (Exception e) {

			response.setStatus(Status.ERROR);
			response.setMessage("API Error");
		}
		return response;

	}

	private Response getForcastedAPI() {
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("A", 1);
		map.put("B", 1);
		map.put("C", 2);
		Response response = new Response();
		response.setData(map);
		return response;
	}

	private Response getActualAPI() {
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("A", 1);
		map.put("B", 2);
		map.put("C", 3);
		// map.put("D", 3);
		Response response = new Response();
		response.setData(map);
		return response;
	}

}
