import java.util.Locale;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Locale.setDefault(Locale.US);
		Scanner scanner = new Scanner(System.in);

		System.out.print("Digite sua renda anual com salário: ");
		double rendaAnual = scanner.nextDouble();
		System.out.print("Digite sua renda anual com prestação de serviço: ");
		double rendaPrestacao = scanner.nextDouble();
		System.out.print("Digite sua renda anual com ganho de capital: ");
		double rendaCapital = scanner.nextDouble();
		System.out.print("Gastos médicos: ");
		double gastosMedicos = scanner.nextDouble();
		System.out.print("Gastos educacionais: ");
		double gastosEducacionais = scanner.nextDouble();

		System.out.println();
		System.out.println("RELATÓRIO DE IMPOSTO DE RENDA");
		System.out.println();

		double rendaMensal = rendaAnual / 12;
		double impostoAnual;

		if (rendaMensal < 3000.00) {
			impostoAnual = 0;
		} else if (rendaMensal < 5000.00) {
			impostoAnual = 10;
		} else {
			impostoAnual = 20;
		}

		double impostoSalario = rendaAnual * impostoAnual / 100;
		System.out.println("CONSOLIDADO DE RENDA:");
		System.out.printf("Imposto sobre salário: %.2f ", impostoSalario);

		double impostoPJ;

		if (rendaPrestacao <= 0) {
			impostoPJ = 0;
		} else {
			impostoPJ = 15;
		}

		double impostoPrestacao = rendaPrestacao * impostoPJ / 100;
		System.out.println();
		System.out.printf("Imposto sobre serviços: %.2f ", impostoPrestacao);

		double impostoCapital;

		if (rendaCapital <= 0) {
			impostoCapital = 0;
		} else {
			impostoCapital = 20;
		}

		double impostoCapital2 = rendaCapital * impostoCapital / 100;
		System.out.println();
		System.out.printf("Imposto sobre ganho de capital: %.2f ", impostoCapital2);

		double impostoBruto = (impostoSalario + impostoPrestacao + impostoCapital2);
		System.out.println();

		double maximoDedutivel = impostoBruto * 0.3;
		System.out.println();

		double gastoDedutivel = gastosMedicos + gastosEducacionais;
		System.out.println("DEDUÇÕES:");
		System.out.printf("Máximo dedutível: %.2f%n", maximoDedutivel);
		System.out.printf("Gastos dedutíveis: %.2f", gastoDedutivel);

		System.out.println();
		System.out.println();
		System.out.println("RESUMO:");
		System.out.printf("Imposto bruto total: %.2f%n", impostoBruto);

		double abatimento;

		if (maximoDedutivel > gastoDedutivel) {
			abatimento = gastoDedutivel;
		} else {
			abatimento = maximoDedutivel;
		}
		
		System.out.printf("Abatimento: %.2f%n", abatimento);
		System.out.printf("Imposto devido: %.2f", impostoBruto - abatimento);
		
		scanner.close();
	}

}
