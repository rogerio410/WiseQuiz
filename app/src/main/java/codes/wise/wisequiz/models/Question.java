package codes.wise.wisequiz.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by rogermac on 01/05/17.
 */

public class Question implements Serializable {

    private String text;
    private List<Option> options;
    private int correctOptionIndex;

    public Question(String text, int correctOptionIndex, String... options) {
        this.text = text;
        this.correctOptionIndex = correctOptionIndex;
        this.options = new ArrayList<>();

        for (String optionText: options) {
            this.options.add(new Option(optionText));
        }
    }

    public List<Option> getOptions() {
        return Collections.unmodifiableList(this.options);
    }

    public int getCorrectOptionIndex() {
        return correctOptionIndex;
    }

    public String getText() {
        return text;
    }

    public static List<Question> fixtures(){
        //Questoes Forcenidas por Edvalva
        List<Question> questions = new ArrayList<>();

        //Platão pag. 222-224
        questions.add(new Question("Onde Nasceu Platão?", 1, "Éfeso", "Atenas", "Abdera"));
        questions.add(new Question("Qual o seu verdadeiro nome de Platão?", 0, "Aristócles", "Heráclito", "Demócrito"));
        questions.add(new Question("Platão foi discípulo de..", 1, "Aristócles", "Sócrates","Heráclito"));
        questions.add(new Question("A escola filosófica que Platão fundou chama-se..", 2, "Peripateia", "Liceu", "Academia"));
        questions.add(new Question("A doutrina de Platão é conhecida como..", 1, "Teoria do método", "Teoria das ideias", "Teoria sensível"));
        questions.add(new Question("Para ele há quantas realidades?", 1, "Duas", "Três", "Quatro"));
        questions.add(new Question("Como se chama aquele que segundo Platão operou na criação do mundo?", 1, "Primeiro motor", "Demiurgo", "Dualismo"));
        questions.add(new Question("São as duas realidades para Platão:", 2, "inteligível e ideias", "sensível e matéria", "sensível e inteligível"));
        questions.add(new Question("Para Platão o ser é:", 0, "transcendente", "imanente", "determinado"));
        questions.add(new Question("Como se chama a alegoria que Platão criou para explicar a teoria da realidade?", 1, "a saga de Édipo", "mito da caverna", "mito do oráculo"));

        //SOCRATES – Pagina 202-206; 220.
        questions.add(new Question("Sócrates nasceu em:", 1, "Abdera", "Atenas", "Mileto"));
        questions.add(new Question("Os filósofos que antecederam Sócrates chamam-se:", 2, "pós-socráticos", "anti-socráticos", "pré-socráticos"));
        questions.add(new Question("Em qual período de Sócrates?", 0, "Período clássico (séculos V e IV a.C.). ", "Período Medieval", "Período Helenístico"));
        questions.add(new Question("Uma das frases conhecidas dele é “Conhece-te a ti mesmo.", 0, "Sócrates", "Aristóteles", "Platão"));
        questions.add(new Question("O método socrático de aquisição da verdade consistia em: marque a incorreta.", 1,
                "Discurso caracterizado pela maiêutica",
                "Dialética em que as respostas são mais importantes.",
                "Induzir uma pessoa, por seu próprio raciocínio a solução de sua dúvida.",
                "Levar o interlocutor a entrar em contradição, chegando à conclusão de que o seu conhecimento é limitado."));
        questions.add(new Question("Como é chamado o método que é “arte de trazer à luz” (parto das ideias)?", 0,
                "Maiêutica", "Longas conversas", "Luz do pensamento", "Esforçar para adquirir conhecimento"));
        questions.add(new Question("Era pensamento e fazia parte da vida de Sócrates. Assinale o que for incorreto.", 1,
                "Repetia nada saber para, assim, não responder às questões que formulava e motivar seus interlocutores a darem conta de suas opiniões.",
                "O homem é um animal político.",
                "Contraiu inimizades de poderosos que o executaram sob a acusação de impiedade e de corromper a juventude."));
        questions.add(new Question("Sócrates foi acusado de", 0, "injusto como os deuses da cidade e corromper a juventude.",
                "Injusto com os pobres e desvalorização das leis.",
                "Manipulação do pensamento."));

        //ARISTÓTELES PAG. 225-229
        questions.add(new Question("Aristóteles nasceu em", 2, "Éfeso", "Atenas", "Estagira"));
        questions.add(new Question("Os discípulos de Aristóteles ficaram conhecidos como:", 0, "peripatéticos", "estagiritas", "efesianos"));
        questions.add(new Question("Qual a escola filosófica de Aristóteles", 1, "Academia", "Liceu", "Patrística"));
        questions.add(new Question("O pai de Aristóteles era médico chamado", 0, "Nicômaco", "Nicolau", "Bernabé"));
        questions.add(new Question("Para Aristóteles a ciência deve partir da realidade sensorial, chamada:", 1,
                "sensitivo", "empiria", "inatismo"));
        questions.add(new Question("A teoria da realidade de Aristóteles chama-se..", 2,
                "Teoria indutiva", "Teoria das ideias", "Hilemorfismo teleológico"));
        questions.add(new Question("Para Aristóteles, todas as coisas estariam constituídas de dois princípios inseparáveis:", 1,
                "sensível e matéria", "matéria e forma", "matéria e potência"));
        questions.add(new Question("Para Aristóteles o ser é:", 1, "transcendente", "imanente", "determinado"));
        questions.add(new Question("Para Aristóteles, a semente que pode vir a ser uma árvore é:", 1,
                "potência", "forma", "ato"));


        return questions;
    }
}
