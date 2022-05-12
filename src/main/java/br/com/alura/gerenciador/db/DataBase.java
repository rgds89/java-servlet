package br.com.alura.gerenciador.db;

import java.util.ArrayList;
import java.util.List;

import br.com.alura.gerenciador.domain.Company;

public class DataBase {
	
	private static List<Company> companies = new ArrayList<>();
	
	static {
		Company company = new Company();
		company.setName("Alura");
		Company company2 =  new Company();
		company2.setName("Google");
		Company company3 =  new Company();
		company3.setName("Caelum");
		companies.add(company);
		companies.add(company2);
		companies.add(company3);
	}

	public void add(Company company) {
		companies.add(company);
		
	}
	
	public List<Company> getCompanies(){
		return DataBase.companies;
	}

}
