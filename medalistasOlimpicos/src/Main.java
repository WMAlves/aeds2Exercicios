import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Classe Medalhista: representa um medalhista olímpico e sua coleção de medalhas nas Olimpíadas de Paris 2024
 */
class Medalhista {
    /** Para criar o vetor com no máximo 8 medalhas */
    private static final int MAX_MEDALHAS = 8;
    /** Nome do medalhista */
    private String name;
    /** Gênero do medalhista */
    private String gender;
    /** Data de nascimento do medalhista */
    private LocalDate birthDate;
    /** País do medalhista */
    private String country;
    /** Coleção de medalhas do medalhista */
    private Medalha[] medals;
    /** Contador de medalhas e índice para controlar o vetor de medalhas */
    private int medalCount;

    /**
     * Cria um medalhista olímpico. Nenhum dado precisa ser validado.
     * @param nome Nome do medalhista no formato "SOBRENONE nome"
     * @param genero Gênero do medalhista
     * @param nascimento Data de nascimento do medalhista
     * @param pais País do medalhista (conforme dados originais, em inglês)
     */
    public Medalhista(String nome, String genero, LocalDate nascimento, String pais){

        this.name = nome;
        this.gender = genero;
        this.birthDate = nascimento;
        this.country = pais;
    }

    /**
     * Inclui uma medalha na coleção do medalhista. Retorna a quantidade atual de medalhas do atleta.
     * @param medalha A medalha a ser armazenada.
     * @return A quantidade total de medalhas do atleta após a inclusão.
     */
    public int incluirMedalha(Medalha medalha){ if (medalCount < MAX_MEDALHAS) {
        if (medals == null) {
            medals = new Medalha[MAX_MEDALHAS];
        }
        medals[medalCount] = medalha;
        medalCount++;
    }
        return medalCount;
    }


    /**
     * Total de medalhas do atleta. É um número maior ou igual a 0.
     * @return Inteiro com o total de medalhas do atleta (>=0)
     */
    public int totalMedalhas(){
        //TODO lógica para retornar o total de medalhas do atleta

        incluirMedalha(medals[0]);
        System.out.println(medalCount + " medalhas");

        return 0;
    }

    /**
     * Retorna um relatório das medalhas do atleta conforme o tipo solicitado pelo parâmetro. Veja no
     * enunciado da atividade o formato correto deste relatório. Em caso de não possuir medalhas
     * deste tipo, a resposta deve ser "Nao possui medalha de TIPO".
     * @param tipo Tipo da medalha para o relatório
     * @return Uma string, multilinhas, com o relatório de medalhas daquele tipo. Em caso de não possuir
     * medalhas deste tipo, a resposta deve ser "Nao possui medalha de TIPO".
     */
    public String relatorioDeMedalhas(TipoMedalha tipo){
        //TODO lógica para gerar uma string conforme documentado acima
        StringBuilder relatorio = new StringBuilder();
        boolean possuiMedalha = false;

        for (int i = 0; i < medalCount; i++) {
            if (medals[i].getTipo() == tipo) {
                relatorio.append(medals[i].toString()).append("\n");
                possuiMedalha = true;
            }
        }

        if (!possuiMedalha) {
            return "Nao possui medalha de " + tipo.name();
        }

        return relatorio.toString();
    }

    /**
     * Retorna o nome do país do medalhista (conforme arquivo original em inglês.)
     * @return String contendo o nome do país do medalhista (conforme arquivo original em inglês, iniciais em maiúsculas.)
     */
    public String getPais(){
        return country;
    }

    /**
     * Retorna uma cópia da data de nascimento do medalhista.
     * @return LocalDate com a data de nascimento do medalhista.
     */
    public LocalDate getNascimento(){
        return LocalDate.from(birthDate);
    }

    /**
     * Deve retornar os dados pessoais do medalhista, sem as medalhas, conforme especificado no enunciado
     * da atividade.
     * @return String de uma linha, com os dados do medalhista, sem dados da medalha.
     */
    public String toString(){
        //TODO lógica para retornar uma string conforme documentação acima


        return "";
    }
}

/** Enumerador para medalhas de ouro, prata e bronze */
enum TipoMedalha {
    OURO,
    PRATA,
    BRONZE
}

/**
 * Representa uma medalha obtida nos Jogos Olímpicos de Paris em 2024.
 */
class Medalha {
    /** Tipo/cor da medalha conforme o enumerador */
    private TipoMedalha metalType;
    /** Data de obtenção da medalha */
    private LocalDate medalDate;
    /** Disciplina da medalha, conforme arquivo de dados */
    private String discipline;
    /** Evento da medalha, conforme arquivo de dados  */
    private String event;

    /** Cria uma medalha com os dados do parâmetro. Nenhum dado é validado */
    public Medalha(TipoMedalha tipo, LocalDate data, String disciplina, String evento){
        metalType = tipo;
        medalDate = data;
        discipline = disciplina;
        event = evento;

    }


    /**
     * Retorna o tipo de medalha, conforme o enumerador
     * @return TipoMedalha (enumerador) com o tipo/cor desta medalha
     */
    public TipoMedalha getTipo(){
        return metalType;
    }

    /**
     * Retorna uma string com o "relatório" da medalha de acordo com o especificado no enunciado do problema.
     * Contém uma linha que já formata a data da medalha no formato brasileiro. O restante deve ser implementado.
     */
    public String toString(){
        String dataFormatada = DateTimeFormatter.ofPattern("dd/MM/YYYY").format(medalDate);  //formata a data em DD/MM/AAAA

        String disciplinaFormatada = discipline;
        String eventFormatada = event;


        //TODO restante da lógica para criar um relatório de medalha conforme enunciado.
        return "";
    }
}

public class Main {

    // TODO código da classe deve ser implementado.
    public static void main(String[] args) {

        ArrayList<String> listaMedatlista = new ArrayList<>();

        //necessário baixar o arquivo medalistas e salvar no diretorio local
        File file = new File("C:\\Users\\998780\\Downloads\\medallists.csv");
        Scanner sc = null;

        try {
            sc = new Scanner(file);

            while (sc.hasNextLine()) {
                listaMedatlista.add(sc.nextLine());


            }
        }catch (IOException e){
            System.out.println("Erro" +e.getMessage());
        } finally {
            if (sc!=null){
                sc.close();
            }
            for (int i=0; i < listaMedatlista.size();i++){
                System.out.println(listaMedatlista.get(i));
            }


        }


    }


}





/*prompt do chat gpt


Olá estou com o seguinte código
E o seguinte anunciado, pode me ajudar



Leitura do arquivo de medalhistas
Crie classes e enumeradores, em Java, conforme o diagrama abaixo:

Seu programa deve ler um arquivo-texto chamado medallists.csv que, no
VERDE, localiza-se na pasta /tmp. A primeira linha desse arquivo deve ser
descartada, pois apenas informa os diversos campos presentes em cada uma
das linhas seguintes. Cada uma das linhas seguintes indica os dados de um
medalhista, separados por uma vírgula (‘,’).
Você deve preencher um vetor de objetos da classe
Medalhista com os dados
dos diversos atletas medalhistas informados nesse arquivo. Observe que um
medalhista pode ter conseguido mais de uma medalha. O vetor não deve conter
medalhistas repetidos.
Depois, seu programa deve processar a entrada padrão que apresenta várias
linhas, cada uma contendo o nome de um atleta e um tipo de medalha,
separados por uma vírgula (‘,’). A última linha da entrada contém a palavra
FIM.
Para cada linha lida da entrada padrão, seu programa deve exibir, na saída
padrão, várias linhas (veja o exemplo de saída esperada logo abaixo):
• na primeira, os dados do atleta.
• Nas seguintes, o relatório de medalhas desse atleta de acordo com o
pedido. Caso o atleta não tenha medalha daquela cor, deve ser impresso
o texto “Nao possui medalha de <TIPO DE MEDALHA>”.
• Em seguida, uma linha em branco antes do próximo atleta.
Exemplos
Entrada
LEAL Rayssa,BRONZE
BILES Simone,OURO
KOPECKY Lotte,PRATA
FIM
Saída esperada
LEAL Rayssa, FEMININO. Nascimento: 4/1/2008. Pais: Brazil
BRONZE – Skateboarding - Women's Street – 28/7/2024
BILES Simone, FEMININO. Nascimento: 14/03/1997. Pais:
United States
OURO - Artistic Gymnastics - Women's All-Around – 1/8/2024
OURO - Artistic Gymnastics - Women's Vault – 3/8/2024
OURO - Artistic Gymnastics - Women's Team – 30/7/2024
KOPECKY Lotte, FEMININO. Nascimento: 10/11/1995. Pais:
Belgium
Nao possui medalha de PRATA


import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Classe Medalhista: representa um medalhista olímpico e sua coleção de medalhas nas Olimpíadas de Paris 2024
 */
class Medalhista {
    /** Para criar o vetor com no máximo 8 medalhas */
    private static final int MAX_MEDALHAS = 8;
    /** Nome do medalhista */
    private String name;
    /** Gênero do medalhista */
    private String gender;
    /** Data de nascimento do medalhista */
    private LocalDate birthDate;
    /** País do medalhista */
    private String country;
    /** Coleção de medalhas do medalhista */
    private Medalha[] medals;
    /** Contador de medalhas e índice para controlar o vetor de medalhas */
    private int medalCount;

    /**
     * Cria um medalhista olímpico. Nenhum dado precisa ser validado.
     * @param nome Nome do medalhista no formato "SOBRENONE nome"
     * @param genero Gênero do medalhista
     * @param nascimento Data de nascimento do medalhista
     * @param pais País do medalhista (conforme dados originais, em inglês)
     */
    public Medalhista(String nome, String genero, LocalDate nascimento, String pais){

        this.name = nome;
        this.gender = genero;
        this.birthDate = nascimento;
        this.country = pais;
    }

    /**
     * Inclui uma medalha na coleção do medalhista. Retorna a quantidade atual de medalhas do atleta.
     * @param medalha A medalha a ser armazenada.
     * @return A quantidade total de medalhas do atleta após a inclusão.
     */
    public int incluirMedalha(Medalha medalha){
        //TODO código da lógica de inclusão de medalha no vetor do medalhista
        medalCount++;
        medals = new Medalha[MAX_MEDALHAS];

        return 0;
    }

    /**
     * Total de medalhas do atleta. É um número maior ou igual a 0.
     * @return Inteiro com o total de medalhas do atleta (>=0)
     */
    public int totalMedalhas(){
        //TODO lógica para retornar o total de medalhas do atleta

        incluirMedalha(medals[0]);
        System.out.println(medalCount + " medalhas");

        return 0;
    }

    /**
     * Retorna um relatório das medalhas do atleta conforme o tipo solicitado pelo parâmetro. Veja no
     * enunciado da atividade o formato correto deste relatório. Em caso de não possuir medalhas
     * deste tipo, a resposta deve ser "Nao possui medalha de TIPO".
     * @param tipo Tipo da medalha para o relatório
     * @return Uma string, multilinhas, com o relatório de medalhas daquele tipo. Em caso de não possuir
     * medalhas deste tipo, a resposta deve ser "Nao possui medalha de TIPO".
     */
    public String relatorioDeMedalhas(TipoMedalha tipo){
        //TODO lógica para gerar uma string conforme documentado acima
        return "";
    }

    /**
     * Retorna o nome do país do medalhista (conforme arquivo original em inglês.)
     * @return String contendo o nome do país do medalhista (conforme arquivo original em inglês, iniciais em maiúsculas.)
     */
    public String getPais(){
        return country;
    }

    /**
     * Retorna uma cópia da data de nascimento do medalhista.
     * @return LocalDate com a data de nascimento do medalhista.
     */
    public LocalDate getNascimento(){
        return LocalDate.from(birthDate);
    }

    /**
     * Deve retornar os dados pessoais do medalhista, sem as medalhas, conforme especificado no enunciado
     * da atividade.
     * @return String de uma linha, com os dados do medalhista, sem dados da medalha.
     */
    public String toString(){
        //TODO lógica para retornar uma string conforme documentação acima

        
        return "";
    }
}

/** Enumerador para medalhas de ouro, prata e bronze */
enum TipoMedalha {
    OURO,
    PRATA,
    BRONZE
}

/**
 * Representa uma medalha obtida nos Jogos Olímpicos de Paris em 2024.
 */
class Medalha {
    /** Tipo/cor da medalha conforme o enumerador */
    private TipoMedalha metalType;
    /** Data de obtenção da medalha */
    private LocalDate medalDate;
    /** Disciplina da medalha, conforme arquivo de dados */
    private String discipline;
    /** Evento da medalha, conforme arquivo de dados  */
    private String event;

    /** Cria uma medalha com os dados do parâmetro. Nenhum dado é validado */
    public Medalha(TipoMedalha tipo, LocalDate data, String disciplina, String evento){
        metalType = tipo;
        medalDate = data;
        discipline = disciplina;
        event = evento;

    }


    /**
     * Retorna o tipo de medalha, conforme o enumerador
     * @return TipoMedalha (enumerador) com o tipo/cor desta medalha
     */
    public TipoMedalha getTipo(){
        return metalType;
    }

    /**
     * Retorna uma string com o "relatório" da medalha de acordo com o especificado no enunciado do problema.
     * Contém uma linha que já formata a data da medalha no formato brasileiro. O restante deve ser implementado.
     */
    public String toString(){
        String dataFormatada = DateTimeFormatter.ofPattern("dd/MM/YYYY").format(medalDate);  //formata a data em DD/MM/AAAA

        String disciplinaFormatada = discipline;
        String eventFormatada = event;


        //TODO restante da lógica para criar um relatório de medalha conforme enunciado.
        return "";
    }
}

public class Main {

    // TODO código da classe deve ser implementado.
    public static void main(String[] args) {

        ArrayList<String> listaMedatlista = new ArrayList<>();

        //necessário baixar o arquivo medalistas e salvar no diretorio local
        File file = new File("C:\\Users\\998780\\Downloads\\medallists.csv");
        Scanner sc = null;

        try {
            sc = new Scanner(file);

            while (sc.hasNextLine()) {
                listaMedatlista.add(sc.nextLine());


            }
        }catch (IOException e){
            System.out.println("Erro" +e.getMessage());
        } finally {
            if (sc!=null){
                sc.close();
            }
            for (int i=0; i < listaMedatlista.size();i++){
                System.out.println(listaMedatlista.get(i));
            }


        }


    }


}









*/
