package com.example.demo.junit;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BasicSalaryCalculatorTest {
	
BasicSalaryCalculator basicSalaryCalculator=new BasicSalaryCalculator();

@BeforeEach
void init() {
	basicSalaryCalculator=new BasicSalaryCalculator(); 
}

@Test
void testBasicSalaryWithValidSalary() {
	double basicSalary=4000;
	basicSalaryCalculator.setBasicSalary(basicSalary);
	
	double expectedSocialInsurance=basicSalary*0.25;
	assertEquals(expectedSocialInsurance, basicSalaryCalculator.getSocialInsurance());

	double expectedAdditionalBonus=basicSalary*0.1;
	assertEquals(expectedAdditionalBonus, basicSalaryCalculator.getAdditionalBonus());
	
	double expectedGross=basicSalary+expectedAdditionalBonus+expectedSocialInsurance;
	assertEquals(expectedGross, basicSalaryCalculator.getGrossSalary());
}

@DisplayName("Test BasicSalaryCalculator with invalid salary")
@Test
void testBasicSalaryWithInvalidSalary() {
	double basicSalary=-100;
	assertThrows(IllegalArgumentException.class, ()->{
		basicSalaryCalculator.setBasicSalary(basicSalary);
	});
}
@AfterEach
void tearDown() {
	basicSalaryCalculator=null;
}
}
