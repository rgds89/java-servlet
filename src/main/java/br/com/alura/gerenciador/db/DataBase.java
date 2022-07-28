package br.com.alura.gerenciador.db;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import br.com.alura.gerenciador.domain.Company;
import br.com.alura.gerenciador.domain.User;

public class DataBase {

	private static List<Company> companies = new ArrayList<>();
	private static List<User> users = new ArrayList<>();
	private static Long sequentialKey = 1l;

	static {
		Company cp1 = new Company();
		cp1.setId(sequentialKey++);
		cp1.setName("Alura");
		cp1.setOpenDate(new Date());
		
		Company cp2 = new Company();
		cp2.setId(sequentialKey++);
		cp2.setName("Caelum");
		cp2.setOpenDate(new Date());
		
		User user1 = new User();
		user1.setLogin("rogersilva");
		user1.setPassword("roger1234");

		companies.addAll(Arrays.asList(cp1, cp2));
		users.addAll(Arrays.asList(user1));
	}

	public void add(Company company) {
		company.setId(DataBase.sequentialKey++);
		companies.add(company);

	}

	public List<Company> getCompanies() {
		return DataBase.companies;
	}

	public void removeCompany(Long id) {
		Iterator<Company> it = companies.iterator();
		while (it.hasNext()) {
			Company company = it.next();
			if (company.getId().equals(id)) {
				it.remove();
			}
		}
	}

	public Company getCompanyById(Long id) {
		Iterator<Company> it = companies.iterator();
		while (it.hasNext()) {
			Company company = it.next();
			if (company.getId().equals(id)) {
				return company;
			}
		}
		return null;
	}

	public User existUser(String login, String password) {
		for (User u : users) {
			if (u.isEquals(login, password)) {
				return u;
			}
		}
		return null;
	}

}
