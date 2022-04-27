package entities;

public class TaxPayer {
	private Double salaryIncome;
	private Double servicesincome;
	private Double capitalIncome;
	private Double healthSpening;
	private Double educationSpending;

	public TaxPayer(Double salaryIncome, Double servicesincome, Double capitalIncome, Double healthSpening,
			Double educationSpending) {
		this.salaryIncome = salaryIncome;
		this.servicesincome = servicesincome;
		this.capitalIncome = capitalIncome;
		this.healthSpening = healthSpening;
		this.educationSpending = educationSpending;
	}

	public Double getSalaryIncome() {
		return salaryIncome;
	}

	public Double getServicesincome() {
		return servicesincome;
	}

	public Double getCapitalIncome() {
		return capitalIncome;
	}

	public Double getHealthSpening() {
		return healthSpening;
	}

	public Double getEducationSpending() {
		return educationSpending;
	}

	public Double salaryTax() {
		if (salaryIncome > 60000.00) {
			return salaryIncome / 100 * 20;
		} else if (salaryIncome > 36000.00) {
			return salaryIncome / 100 * 10;
		} else {
			return 0.0;
		}
	}

	public Double servicesTax() {
		return servicesincome / 100 * 15;
	}

	public Double capitalTax() {
		return capitalIncome / 100 * 20;
	}

	public Double grossTax() {
		return salaryTax() + servicesTax() + capitalTax();
	}

	public Double taxRebate() {
		if ((healthSpening + educationSpending) < (grossTax() / 100 * 30)) {
			return healthSpening + educationSpending;
		} else {
			return grossTax() / 100 * 30;
		}
	}

	public Double netTax() {
		return grossTax() - taxRebate();
	}

}
