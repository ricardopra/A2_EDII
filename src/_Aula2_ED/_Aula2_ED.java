package _Aula2_ED;

import java.util.ArrayList;
import java.util.Scanner;

public class _Aula2_ED {
    private ArrayList<Veiculo> veic = new ArrayList<>();
    private Scanner ler = new Scanner(System.in);

    public static void main(String[] args) {
        _Aula2_ED loja = new _Aula2_ED();
        System.exit(0);
    }

    public _Aula2_ED() {
        simularLeituraDeDados();
        System.out.println("Resultados: \n");
        mediaPrecosCaminhoesVendidos();
        veiculoMaisCaroMaisBarato();
        mediaPrecosDeUmTipoDeVeiculo();
        listarTodosOsVeiculosDaLoja();
        contarVeiculosPorTipo();
    }

    public void simularLeituraDeDados() {
        veic.add(new Veiculo("ABC-1L34","Honda","GL 1800", 2023, 150000f,"moto"));
        veic.add(new Veiculo("DEF-2K45","Volvo","Scania X", 2015, 179000f,"caminhão"));
        veic.add(new Veiculo("EDF-1P34","Audi","A4", 2019, 234000f,"carro"));
        veic.add(new Veiculo("FGE-2A45","Ford","Focus", 2018, 89000f,"carro"));
        veic.add(new Veiculo("ABD-1B34","Fiat","Track Gls", 2022, 112000f,"carro"));
        veic.add(new Veiculo("DGF-2C45","Volvo","Scania X", 2024, 220000f,"caminhão"));
        veic.add(new Veiculo("FGP-2M45","Ford","Focus", 2021, 120000f,"carro"));
        veic.add(new Veiculo("ABC-1234","Honda","GL 1000", 2024, 140000f,"moto"));
        veic.add(new Veiculo("AEF-2Q45","Volvo","Scania X", 2019, 195000f,"caminhão"));
        veic.add(new Veiculo("IGN-1W45","Ford","Focus", 2020, 110000f,"carro"));
    }

    public void mediaPrecosCaminhoesVendidos() {
        float soma = 0;
        int contador = 0;
        for (Veiculo v : veic) {
            if (v.getTipo().equalsIgnoreCase("caminhão")) {
                soma += v.getPreco();
                contador++;
            }
        }
        if (contador > 0) {
            System.out.printf("Média dos preços dos caminhões: R$ %.2f\n", soma / contador);
        } else {
            System.out.println("Não existem caminhões na loja.");
        }
    }

    public void veiculoMaisCaroMaisBarato() {
        if (veic.isEmpty()) {
            System.out.println("Não há veículos cadastrados!");
            return;
        }
        Veiculo maisCaro = veic.get(0);
        Veiculo maisBarato = veic.get(0);
        for (Veiculo v : veic) {
            if (v.getPreco() > maisCaro.getPreco()) {
                maisCaro = v;
            }
            if (v.getPreco() < maisBarato.getPreco()) {
                maisBarato = v;
            }
        }
        System.out.println("Mais caro: " + maisCaro);
        System.out.println("Mais barato: " + maisBarato);
    }

    public void mediaPrecosDeUmTipoDeVeiculo() {
        System.out.print("Digite o tipo de veículo (carro, caminhão, moto): ");
        String tipo = ler.nextLine();
        float soma = 0;
        int contador = 0;
        for (Veiculo v : veic) {
            if (v.getTipo().equalsIgnoreCase(tipo)) {
                soma += v.getPreco();
                contador++;
            }
        }
        if (contador > 0) {
            System.out.printf("Média dos preços dos veículos do tipo %s: R$ %.2f\n", tipo, soma / contador);
        } else {
            System.out.println("Não existem veículos desse tipo na loja.");
        }
    }

    public void listarTodosOsVeiculosDaLoja() {
        if (veic.isEmpty()) {
            System.out.println("Não há veículos cadastrados!");
            return;
        }
        System.out.println("Veículos cadastrados:");
        for (Veiculo v : veic) {
            System.out.println(v);
        }
    }

    public void contarVeiculosPorTipo() {
        int carros = 0, motos = 0, caminhoes = 0;
        for (Veiculo v : veic) {
            switch (v.getTipo().toLowerCase()) {
                case "carro": carros++; break;
                case "moto": motos++; break;
                case "caminhão": caminhoes++; break;
            }
        }
        System.out.println("Total de veículos por tipo:");
        System.out.println("Carros: " + carros);
        System.out.println("Motos: " + motos);
        System.out.println("Caminhões: " + caminhoes);
    }
}

class Veiculo {
    private String placa;
    private String marca;
    private String modelo;
    private int ano;
    private float preco;
    private String tipo;

    public Veiculo(String placa, String marca, String modelo, int ano, float preco, String tipo) {
        this.placa = placa;
        this.marca = marca;
        this.modelo = modelo;
        this.ano = ano;
        this.preco = preco;
        this.tipo = tipo;
    }

    public String getTipo() {
        return tipo;
    }

    public float getPreco() {
        return preco;
    }

    @Override
    public String toString() {
        return "Placa: " + placa + ", Marca: " + marca + ", Modelo: " + modelo +
               ", Ano: " + ano + ", Preço: R$ " + preco + ", Tipo: " + tipo;
    }
}
