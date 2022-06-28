package br.com.alura.gerenciador.db;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import br.com.alura.gerenciador.domain.Company;

public class DataBase {

	private static List<Company> companies = new ArrayList<>();
	private static Long sequentialKey = 1l;

	public void add(Company company) {
		company.setId(DataBase.sequentialKey++);
		companies.add(company);

	}

	public List<Company> getCompanies() {
		return DataBase.companies;
	}

	public void removeCompany(long id) {
		Iterator<Company> it = companies.iterator();
		while (it.hasNext()) {
			Company company = it.next();
			if (company.getId().equals(id)) {
				it.remove();
			}
		}
	}

}
