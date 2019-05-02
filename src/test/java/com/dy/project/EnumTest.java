package com.dy.project;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

import com.dy.common.domain.Auth;
import com.dy.common.domain.Status;

public class EnumTest {

	@Test
	public void 테스트() throws Exception {
		Status status = Status.Y;

		String firstValue = status.getFirstValue();
		boolean secondValue = status.isSecondValue();
		
		assertThat(status, is(Status.Y));
		assertThat(firstValue, is("1"));
		assertThat(secondValue, is(true));
	}

	@Test
	public void 테스트2() throws Exception {
		Auth auth = Auth.M;

		String role = auth.getRole();
		System.out.println(role);
	}

}
