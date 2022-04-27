package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import entities.TaxPayer;

public class Program {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		List<TaxPayer> taxPayerList = new ArrayList<>();
		
		System.out.print("Quantos contribuintes você vai digitar? ");
		int n = sc.nextInt();
		
		for(int i = 0; i < n; i++) {
			System.out.println();
			System.out.printf("Digite os dados do %do contribuinte:%n", i + 1);
			System.out.print("Renda anual com salário: ");
			double salaryIncome = sc.nextDouble();
			while (salaryIncome < 0) {
				System.out.print("Valor inválido! tente novament: ");
				salaryIncome = sc.nextDouble();
			}
			System.out.print("Renda anual com prestação de serviço: ");
			double servicesincome = sc.nextDouble();
			while (servicesincome < 0) {
				System.out.print("Valor inválido! tente novament: ");
				servicesincome = sc.nextDouble();
			}
			System.out.print("Renda anual com ganho de capital: ");
			double capitalIncome = sc.nextDouble();
			while (capitalIncome < 0) {
				System.out.print("Valor inválido! tente novament: ");
				capitalIncome = sc.nextDouble();
			}
			System.out.print("Gastos médicos: ");
			double healthSpening = sc.nextDouble();
			while (healthSpening < 0) {
				System.out.print("Valor inválido! tente novament: ");
				healthSpening = sc.nextDouble();
			}
			System.out.print("Gastos educacionais: ");
			double educationSpending = sc.nextDouble();
			while (educationSpending < 0) {
				System.out.print("Valor inválido! tente novament: ");
				educationSpending = sc.nextDouble();
			}
			taxPayerList.add(new TaxPayer(salaryIncome, servicesincome, capitalIncome, healthSpening, educationSpending));
		}
		
		for (TaxPayer taxPayer : taxPayerList) {
			System.out.println();
			System.out.printf("Resumo do %do contribuinte:%n", taxPayerList.indexOf(taxPayer) + 1);
			System.out.printf("Imposto bruto total: %.2f%n", taxPayer.grossTax());
			System.out.printf("Abatimento: %.2f%n", taxPayer.taxRebate());
			System.out.printf("Imposto devido: %.2f%n", taxPayer.netTax());
		}
		
		sc.close();
	}

}
