package com.mubasher.assignment.payment.service;

import com.mubasher.assignment.PaymentApplication;
import com.mubasher.assignment.domain.dto.ListResponse;
import com.mubasher.assignment.domain.dto.PaymentMethodDto;
import com.mubasher.assignment.domain.dto.PaymentPlanDto;
import com.mubasher.assignment.domain.entity.PaymentMethod;
import com.mubasher.assignment.domain.entity.PaymentPlan;
import com.mubasher.assignment.domain.enums.CurrencyCode;
import com.mubasher.assignment.domain.enums.PaymentType;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.*;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

/**
 * @author Mubasher Usman
 */
@RunWith(SpringRunner.class)
@ContextConfiguration(classes = PaymentApplication.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class PaymentMethodConfigurationControllerTest {

	@LocalServerPort
	private int port;

	TestRestTemplate restTemplate = new TestRestTemplate();

	@Test
	public void testSearchPaymentMethod() {
		PaymentMethodDto creditCardDto = getPaymentMethodDto();
		String searchTerm = creditCardDto.getName();
		ResponseEntity<PaymentMethodDto> res = restTemplate.postForEntity(
				createURLWithPort(), creditCardDto, PaymentMethodDto.class);
		assertThat(res.getStatusCode().value(), equalTo(200));

		creditCardDto.setName("PayPal");
		res = restTemplate.postForEntity(createURLWithPort(), creditCardDto,
				PaymentMethodDto.class);
		assertThat(res.getStatusCode().value(), equalTo(200));

		Map<String, Object> urlVar = new HashMap<>();
		urlVar.put("name", searchTerm);
		ListResponse response = restTemplate.getForObject(createURLWithPort(),
				ListResponse.class, urlVar);
		assertThat(response, notNullValue());
		assertThat(response.getContent(), notNullValue());
		assertThat(response.getContent().size(), greaterThan(0));
		Map map = (Map) response.getContent().get(0);
		String name = (String) map.get("name");
		assertThat(name, equalTo(searchTerm));
	}

	private String createURLWithPort() {
		return "http://localhost:" + port + "api/v1/configuration/payment-method";
	}

	private PaymentMethodDto getPaymentMethodDto() {
		PaymentMethodDto dto = new PaymentMethodDto();
		dto.setDisplayName("Credit Card");
		dto.setName("Credit Card");
		dto.setPaymentType(PaymentType.CREDIT_CARD);
		List<PaymentPlanDto> list = new ArrayList<>(Arrays.asList(getPaymentPlansDto()));
		dto.setPaymentPlans(list);
		dto.setId(1L);
		return dto;
	}

	private PaymentPlanDto getPaymentPlansDto() {
		PaymentPlanDto dto = new PaymentPlanDto();
		dto.setCurrency(CurrencyCode.USD);
		dto.setDuration("Monthly");
		dto.setGrossAmount(new BigDecimal(20.00));
		dto.setTaxAmount(new BigDecimal(2.00));
		dto.setNetAmount(new BigDecimal(18.00));
		dto.setId(72L);
		return dto;
	}

	private PaymentMethod getPaymentMethod() {
		PaymentMethod paymentMethod = new PaymentMethod();
		paymentMethod.setDisplayName("Credit Card");
		paymentMethod.setName("Credit Card");
		paymentMethod.setPaymentType(PaymentType.CREDIT_CARD);
		List<PaymentPlan> list = new ArrayList<>(Arrays.asList(getPaymentPlan()));
		paymentMethod.setPaymentPlans(list);
		paymentMethod.setId(1L);
		return paymentMethod;
	}

	private PaymentPlan getPaymentPlan() {
		PaymentPlan paymentPlan = new PaymentPlan();
		paymentPlan.setCurrency(CurrencyCode.USD);
		paymentPlan.setDuration("Monthly");
		paymentPlan.setGrossAmount(new BigDecimal(20.00));
		paymentPlan.setTaxAmount(new BigDecimal(2.00));
		paymentPlan.setNetAmount(new BigDecimal(18.00));
		paymentPlan.setId(72L);
		return paymentPlan;
	}

}
