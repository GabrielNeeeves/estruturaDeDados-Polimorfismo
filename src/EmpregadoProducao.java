public class EmpregadoProducao extends Empregado {

    private double valorUnitarioPeca;
    private int qunatidadePecasProduzidas;
    
    //CONSTRUTOR
    public EmpregadoProducao (
        String Nome,
        String Sobrenome,
        String CPF,
        int    Day,
        int    Month,
        int    Year,
        double  valorUnitarioPeca,
        int    quantidadePecasProduzidas)
    {
        super(Nome, Sobrenome, CPF, Day, Month, Year);
        setValorUnitario(valorUnitarioPeca);
        getQuantidadePecasProduzidas(quantidadePecasProduzidas);
    }
    
    public double getValorUnitario() {
        return valorUnitarioPeca;
    }
    public void setValorUnitario(double valorUnitario) {
        this.valorUnitarioPeca = valorUnitario;
    }
    public int getQuantidadePecasProduzidas() {
        return qunatidadePecasProduzidas;
    }
    public void getQuantidadePecasProduzidas(int qunatidadePecasProduzidas) {
        this.qunatidadePecasProduzidas = qunatidadePecasProduzidas;
    }
    
    @Override
    public double vencimentos() {
        return getQuantidadePecasProduzidas() * getValorUnitario();
    }

    public String toString() {
        return String.format( "%s: %s\n%s: %d; %s: %.2f",    
         "Empregado Producao", super.toString(),              
         "Quantidade de peças produzidas", getQuantidadePecasProduzidas(),                       
         "Valor Unitário", getValorUnitario() );
    }

    //MÉTODO PARA CALCULAR O SALÁRIO EM FUNÇÃO DE QUANTIDADE DE 'PEÇAS PRODUZIDAS' E 'PEÇAS VENDIDAS'
    public double calcularSalario(int quantiaPecas, double valorUnitario) {

        double salario = quantiaPecas * valorUnitario;
        return salario;
    }
}
