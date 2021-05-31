package tn.enis.service;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

/**
 * Session Bean implementation class CalcService
 */
@Stateless
@LocalBean
public class CalcService {

	public int add(int a, int b) {
		return a + b;
	}
	public int mult(int a, int b) {
		return a * b;
	}
}
