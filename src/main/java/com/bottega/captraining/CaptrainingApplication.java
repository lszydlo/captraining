package com.bottega.captraining;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class CaptrainingApplication {

	public static void main(String[] args) {
		SpringApplication.run(CaptrainingApplication.class, args);
	}

	@Component
	@Scope(scopeName = "prototype")
	static class AddressValidator {

		private final List<Checker> checkers;
		private List<CheckResult> results = new ArrayList<>();

		AddressValidator(List<Checker> checkers) {
			System.out.println("Construct Validator");
			this.checkers = checkers;
		}

		void validate(AddAddressRequest request) {
			for (Checker checker : checkers) {
				System.out.println("checking");
				CheckResult result = checker.check(request);
				results.add(result);
			}
		}

		public List<CheckResult> getResults() {
			return results;
		}

		static class CheckResult {
		}
	}

	private  interface Checker {
		AddressValidator.CheckResult check(AddAddressRequest request);
	}

	@Component
	static class CityChecker implements Checker {

		@Override
		public AddressValidator.CheckResult check(AddAddressRequest request) {
			return new AddressValidator.CheckResult();
		}

	}




	@Aspect
	@Component
	public static class NotVeryUsefulAspect {


		@Before("execution(* addAddress(..))")
		public void logSomethingBefore1(JoinPoint jp) {

			System.out.println("Before1: " + jp);
		}

		@Around("execution(* addAddress(..))")
		public Object logSomethingAround(ProceedingJoinPoint pjp) throws Throwable {

			System.out.println("Around before: " + pjp);
			Object proceed = pjp.proceed();
			System.out.println("Around after: " + pjp);
			return proceed;
		}
	}
}
