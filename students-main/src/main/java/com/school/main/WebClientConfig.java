package com.school.main;

import java.security.Signer;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpHeaders;
import org.springframework.http.client.reactive.ReactorClientHttpConnector;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.ClientRequest;
import org.springframework.web.reactive.function.client.ExchangeFilterFunction;
import org.springframework.web.reactive.function.client.ExchangeFilterFunctions;
import org.springframework.web.reactive.function.client.WebClient;

import io.netty.channel.ChannelOption;
import io.netty.handler.timeout.ReadTimeoutHandler;
import io.netty.handler.timeout.WriteTimeoutHandler;
import reactor.core.publisher.Mono;
import reactor.netty.http.client.HttpClient;
import reactor.netty.tcp.TcpClient;

@Component
public class WebClientConfig {

	private static final String BASE_URL = "http://localhost:";
	private static final Logger logger = LoggerFactory.getLogger(WebClientConfig.class);

	@Bean
	public WebClient defaultWebClient() {

		/*
		 * var tcpClient =
		 * TcpClient.create().option(ChannelOption.CONNECT_TIMEOUT_MILLIS, 2_000)
		 * .doOnConnected(connection -> connection.addHandlerLast(new
		 * ReadTimeoutHandler(2)) .addHandlerLast(new WriteTimeoutHandler(2)));
		 */

		return WebClient.builder().baseUrl(BASE_URL)
				//.clientConnector(new ReactorClientHttpConnector(HttpClient.from(tcpClient)))
				//.filter(ExchangeFilterFunctions.basicAuthentication("rieckpil", UUID.randomUUID().toString()))
				.filter(authHeader("Gagan - xyz"))
				.filter(logRequest())
				.filter(logResponse()).build();

	}

	private ExchangeFilterFunction logRequest() {
		return (clientRequest, next) -> {
			logger.info("Request: {} {}", clientRequest.method(), clientRequest.url());
			logger.info("--- Http Headers: ---");
			clientRequest.headers().forEach(this::logHeader);
			logger.info("--- Http Cookies: ---");
			clientRequest.cookies().forEach(this::logHeader);
			return next.exchange(clientRequest);
		};
	}

	private ExchangeFilterFunction logResponse() {
		return ExchangeFilterFunction.ofResponseProcessor(clientResponse -> {
			logger.info("Response: {}", clientResponse.statusCode());
			clientResponse.headers().asHttpHeaders()
					.forEach((name, values) -> values.forEach(value -> logger.info("{}={}", name, value)));
			return Mono.just(clientResponse);
		});
	}

	private void logHeader(String name, List<String> values) {
		values.forEach(value -> logger.info("{}={}", name, value));
	}

	/*
	 * public Mono<ClientRequest> injectHeader(final ClientRequest clientRequest) {
	 * final String dateString =
	 * ZonedDateTime.now().format(DateTimeFormatter.RFC_1123_DATE_TIME);
	 * 
	 * final String authHeader = buildAuthHeaderForRequest( clientRequest.method(),
	 * clientRequest.url().getPath(), clientRequest.url().getQuery(), dateString);
	 * 
	 * 
	 * return Mono.just(ClientRequest.from(clientRequest) .header(HttpHeaders.DATE,
	 * dateString) .header(HttpHeaders.AUTHORIZATION, "Token") .build()); }
	 */
	
	private ExchangeFilterFunction authHeader(String token) {
	    return (request, next) -> next.exchange(ClientRequest.from(request).headers((headers) -> {
	      headers.setBearerAuth(token);
	    }).build());
	}
}
