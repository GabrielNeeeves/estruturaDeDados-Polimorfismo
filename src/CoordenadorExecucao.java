// ----------------------------------------
// Prof.: CARLOS - FATEC S. J. Rio Preto
// Disc.: IED-001 - ESTRUTURAS DE DADOS
// Lab. : POLIMORFISMO e INTERFACES em JAVA
// Ano/S: 2024/1S
// ----------------------------------------
 
// classe principal (faz o papel efetivo de 'main',
// sendo instanciada pelo programa principal do projeto)
// -----------------------------------------------------

// importação do pacote que contém o código para uso do teclado
import java.time.LocalDate;
import java.time.Month;
import java.util.Scanner;

// classe coordenadora da execução dos testes
public class CoordenadorExecucao {

    // método que realiza todos os testes
    public void executaTudo() {

        // criação de um objeto 'Scanner' para a interação com o teclado
        Scanner teclado = new Scanner(System.in);

        // declaração de constantes para uso no menu
        final int PROCESSAMENTO_INDIVIDUAL = 1;
        final int PROCESSAMENTO_POLIMORFICO = 2;
        final int EXIBICAO_NOME_CLASSE = 3;
        final int SAIR = 9;

        // cria objetos das subclasses
        EmpregadoAssalariado assalariado
                = new EmpregadoAssalariado(
                    "Carlos", 
                    "Filho", 
                    "111.111.111-11",
                    13,
                    8,
                    1979,
                    800.00);

        EmpregadoHorista horista
                = new EmpregadoHorista(
                    "Marcos", 
                    "Neto", 
                    "222.222.222-22",
                    33,
                    3,
                    1991,
                    16.75, 
                    40);

        EmpregadoComissionado comissionado
                = new EmpregadoComissionado(
                        "Renato",
                        "Sobrinho", 
                        "333.333.333-33",
                        5,
                        13,
                        1998,
                        10000,
                        .06);

        EmpregadoComissionadoMaisFixo comissionadoMaisFixo
                = new EmpregadoComissionadoMaisFixo(
                        "Robert",
                        "Junior",
                        "444.444.444-44",
                        25,
                        10, //10
                        2001,
                        5000,
                        .04,
                        300);
        
        //CRIAR 'EmpregadoProducao' da Tarefa
        EmpregadoProducao empregadoProducao = new EmpregadoProducao(
        "Gabriel",
        "Neves",
        "555.555.555-55",
        24,
        5,
        2004,
        3,
        700);

        // cria um array Employee de quatro elementos
        Empregado empregados[] = new Empregado[5];

        // inicializa o array com Employees          
        empregados[0] = assalariado;
        empregados[1] = horista;
        empregados[2] = comissionado;
        empregados[3] = comissionadoMaisFixo;
        empregados[4] = empregadoProducao;

        // declaração de variáveis a serem usadas (independentemente da Atividade)
        int escolha;

        // menu de escolha da Atividade a ser executada
        do {
            // apresentação das opções de escolha
            System.out.println("\n");
            System.out.println("Escolha uma das opções abaixo:");
            System.out.println("1 - Atividade 1: Processamento INDIVIDUAL  de vários tipos de objetos 'Empregado'");
            System.out.println("2 - Atividade 2: Processamento POLIMÓRFICO de vários tipos de objetos 'Empregado'");
            System.out.println("3 - Atividade 3: Exibição do nome da classe efetiva de cada objeto da classe 'Empregado'");
            System.out.println("9 - Sair");

            System.out.print("\nDigite aqui a sua opção: ");
            // coleta da opção digitada
            escolha = teclado.nextInt();
            teclado.nextLine();

            // avaliação da opção e acionamento da respectiva Atividade
            switch (escolha) {

                case PROCESSAMENTO_INDIVIDUAL:
                    System.out.println("\nAtividade 1: Processamento INDIVIDUAL  de vários tipos de objetos 'Empregado'");
                    System.out.println("-----------------------------------------------------------------------------");

                    System.out.println("Empregados processados individualmente:\n");

                    System.out.printf("%s\n%s: $%,.2f\n\n",
                            assalariado, "Vencimentos", assalariado.vencimentos());
                    System.out.printf("%s\n%s: $%,.2f\n\n",
                            horista, "Vencimentos", horista.vencimentos());
                    System.out.printf("%s\n%s: $%,.2f\n\n",
                            comissionado, "Vencimentos", comissionado.vencimentos());
                    System.out.printf("%s\n%s: $%,.2f\n\n",
                            comissionadoMaisFixo,
                            "Vencimentos", comissionadoMaisFixo.vencimentos());
                
                        // empregadoProducao da Tarefa
                        System.out.printf("%s\n%s: $%,.2f\n\n",
                        empregadoProducao,
                        "Vencimentos", empregadoProducao.vencimentos());

                    break;

                case PROCESSAMENTO_POLIMORFICO:
                    System.out.println("\nAtividade 2: Processamento POLIMÓRFICO de vários tipos de objetos 'Empregado'");
                    System.out.println("-----------------------------------------------------------------------------");

                    System.out.println("Empregados processados polimorficamente::\n");

                    // processa genericamente cada elemento no empregados
                    for (Empregado empregadoAtual : empregados) {
                        System.out.println(empregadoAtual); // invoca toString

                        // determina se elemento é um 'EmpregadoComissionadoMaisFixo'
                        if (empregadoAtual instanceof EmpregadoComissionadoMaisFixo) {
                            // 'downcast' da referência de 'Empregado' para
                            // referência a 'EmpregadoComissionadoFixo'
                            EmpregadoComissionadoMaisFixo empregado = (EmpregadoComissionadoMaisFixo) empregadoAtual;

                            double salarioBaseAnterior = empregado.getSalarioBase();
                            empregado.setSalarioBase(1.10 * salarioBaseAnterior);
                            System.out.printf(
                                    "Novo salário base com 10%% de aumento é: $%,.2f\n",
                                    empregado.getSalarioBase());
                        } // fim do if

                        //CRIAR VARIÁVEL PRA PEGAR A DATA USANDO ATUAL
                        // USANDO a lib 'LocalDate'
                        LocalDate dataAtual = LocalDate.now();
                        
                        if (empregadoAtual.getDataNascimento().getMonth() == dataAtual.getMonthValue()) {

                                // var empregadoTeste = var (empregadoAtual);
                                
                                System.out.println(empregadoAtual.getNome()+" faz aniversário neste mês! Portanto, ganha um bônus de 100 reais.");
                                System.out.printf("Salário com bônus de R$100: $%.2f", empregadoAtual.vencimentos()+100);
                                System.out.println(); //QUEBRAR A LINHA NÉ
                        }

                        System.out.printf(
                                "Vencimentos $%,.2f\n\n", empregadoAtual.vencimentos());
                    } // for final

                    break;

                case EXIBICAO_NOME_CLASSE:
                    System.out.println("\nAtividade 3: Exibição do nome da classe efetiva de cada objeto da classe 'Empregado'");
                    System.out.println("--------------------------------------------------------------------------------------");

                    System.out.println("Nome da classe efetiva de cada Empregado no vetor 'empregados':");

                    // obtém o nome do tipo de cada objeto no array empregados
                    for (int j = 0; j < empregados.length; j++) {
                        System.out.printf("empregados[%d] é um %s\n", j,
                                empregados[j].getClass().getName());
                    }

                    break;

                case SAIR:
                    System.out.println("\nSair ...\n");
                    break;

                default:
                    System.out.println("\nOpção inválida !  Tente novamente ...\n");
            }

        } while (escolha != SAIR);

        teclado.close();

        // aciona método para exibição dos dados do autor do trabalho
        Autor autor = new Autor();
        autor.exibeDadosAutor(
                "ESTRUTURAS DE DADOS - 2024/1S",
                "POLIMORFISMO e INTERFACES em JAVA",
                "GABRIEL NEVES FERREIRA",
                "121 092 231 1 021");

    }

}

