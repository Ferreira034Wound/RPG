import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

interface habilidadeEspecial{
    void usarHabilidade(Personagem alvo);
}

interface atacante{
    void atacar(Personagem alvo);
}

abstract class Personagem implements atacante {
    protected String nome;
    protected int vida;
    protected int vidaMaxima;
    protected int ataque;
    protected int estamina;
    protected int curas = 2; // quantidade de consumíveis de cura

    public Personagem(String nome, int vida, int ataque, int estamina) {
        this.nome = nome;
        this.vida = vida;
        this.vidaMaxima = vida;
        this.ataque = ataque;
        this.estamina = estamina;
    }

    @Override
    public void atacar(Personagem alvo) {
        System.out.println(this.nome + " atacou " + alvo.nome + "!");
        alvo.receberDano(this.ataque);
    }

    //Consumível: cura
    public boolean usarConsumivel() {
        if (curas <= 0) {
            System.out.println(this.nome + " não tem mais poções de cura.");
            return false;
        }
        curas--;
        int cura = 40;
        this.vida = Math.min(this.vida + cura, this.vidaMaxima);
        System.out.println(this.nome + " usou uma poção de cura e agora tem " + this.vida + " de vida. (restam " + curas + ")");
        return true;
    }

    public boolean estaVivo() {
        return this.vida > 0;
    }

//Não vira interface
    public void receberDano(int valor) {
        this.vida -= valor;
        System.out.println(this.nome + " recebeu " + valor + " de dano!");

        if (this.vida <= 0) {
            System.out.println(this.nome + " foi derrotado. :/");
        }
    }

//Não vira interface
    public void mostrarStatus() {
        System.out.println(this.nome + " possui " + this.vida + " de vida.");
    }
}

//Espartano
class Espartano extends Personagem implements habilidadeEspecial {
    public Espartano(String nome, int vida, int ataque, int estamina) {
        super(nome, vida, ataque, estamina);
        this.estamina = estamina;
    }
@Override
    public void usarHabilidade(Personagem alvo) {
        if (estamina >= 35) {
            int dano = this.ataque * 2;
            this.estamina -= 35;
            System.out.println(this.nome + " usou habilidade: Lança de mil soldados!");
            alvo.receberDano(dano);
        } else {
            System.out.println(this.nome + " Estamina insuficiente para a habilidade.");
        }
    }
}


//BRUXA

class Bruxa extends Personagem implements habilidadeEspecial {
    public Bruxa(String nome, int vida, int ataque, int estamina) {
        super(nome, vida, ataque, estamina);
        this.estamina = estamina;
    }

@Override
    public void usarHabilidade(Personagem alvo) {

        if (estamina >= 20) {
            int dano = this.ataque + 10;
            this.estamina -= 20;
            System.out.println(this.nome + " usou habilidade: Rajada de gelo!");
            alvo.receberDano(dano);

        } else {
            System.out.println(this.nome + " Estamina insuficiente para a habilidade.");
        }
    }
}


//CYCLOPE
class Cyclope extends Personagem implements habilidadeEspecial {
    public Cyclope(String nome, int vida, int ataque, int estamina){
        super(nome, vida, ataque, estamina);

    }
@Override
    public void usarHabilidade(Personagem alvo) {

            if(this.estamina >= 50){
            int dano = this.ataque + 65;
            estamina -= 50;
            System.out.println(this.nome + " usou habilidade: Ataque devastador!");
            alvo.receberDano(dano);
            } else {
                System.out.println(this.nome + " Estamina insuficiente para a habilidade.");
            }

    }
}


//FURIA
class Furia extends Personagem implements habilidadeEspecial {
    public Furia(String nome, int vida, int ataque, int estamina){
        super(nome, vida, ataque, estamina);
    }

@Override
    public void usarHabilidade(Personagem alvo) {

            if(this.estamina >= 5){
            int dano = this.ataque + 5;
            estamina -= 5;
            System.out.println(this.nome + " usou habilidade: Ataque aéreo!");
            alvo.receberDano(dano);

            } else {
                System.out.println(this.nome + " Estamina insuficiente para a habilidade.");
            }

    }
}


//OGRO CHEFE (inimigo geral)
class Ogro extends Personagem implements habilidadeEspecial {
    public Ogro(String nome, int vida, int ataque, int estamina){
        super(nome, vida, ataque, estamina);
    }

@Override
    public void usarHabilidade(Personagem alvo) {

            if(this.estamina >= 30){
            int dano = this.ataque + 40;
            estamina -= 30;
            System.out.println(this.nome + " usou habilidade: Pancada esmagadora!");
            alvo.receberDano(dano);

            } else {
                System.out.println(this.nome + " Estamina insuficiente para a habilidade.");
            }

    }
}

        //Objetos
public class Main{
    static Scanner scanner = new Scanner(System.in);
    static Random random = new Random();

    public static void main(String[] args) {

        //Personagens
        Espartano espartano = new Espartano("Deimos", 150, 40, 80);
        Bruxa bruxa = new Bruxa("Yen", 90, 30, 150);
        Cyclope cyclope = new Cyclope("Polifemo", 200, 60, 100);
        Furia furia = new Furia("Tisífone", 70, 20, 120);

        //Chefe
        Ogro ogro = new Ogro("Grumash", 500, 35, 200);

        List<Personagem> grupo = new ArrayList<>();
        grupo.add(espartano);
        grupo.add(bruxa);
        grupo.add(cyclope);
        grupo.add(furia);

        System.out.println("=== BATALHA CONTRA O OGRO CHEFE ===");
        int rodada = 0;

        while (temVivos(grupo) && ogro.estaVivo()) {
            rodada++;
            System.out.println("\n========== RODADA " + rodada + " ==========");
            for (Personagem p : grupo) {
                if (p.estaVivo()) p.mostrarStatus();
            }
            ogro.mostrarStatus();

            // Turno de cada personagem
            for (Personagem p : grupo) {
                if (!p.estaVivo()) continue;
                if (!ogro.estaVivo()) break;
                turnoJogador(p, ogro);
            }

            // Turno do ogro
            if (ogro.estaVivo() && temVivos(grupo)) {
                turnoOgro(ogro, grupo);
            }
        }

        System.out.println("\n=== FIM DA BATALHA ===");
        if (ogro.estaVivo()) {
            System.out.println("O ogro " + ogro.nome + " venceu em " + rodada + " rodadas!");
        } else {
            System.out.println("O ogro " + ogro.nome + " foi derrotado em " + rodada + " rodadas!");
        }
    }

    // ---------- Turnos ----------

    static void turnoJogador(Personagem p, Personagem ogro) {
        System.out.println("\n--- Turno de " + p.nome + " --- (vida: " + p.vida + " | estamina: " + p.estamina + " | curas: " + p.curas + ")");
        boolean agiu = false;

        while (!agiu) {
            System.out.println("1 - Atacar");
            System.out.println("2 - Habilidade especial");
            System.out.println("3 - Usar consumível (cura)");
            int opcao = lerInt("Escolha: ");

            if (opcao == 1) {
                p.atacar(ogro);
                agiu = true;
            } else if (opcao == 2) {
                int estaminaAntes = p.estamina;
                ((habilidadeEspecial) p).usarHabilidade(ogro);
                // se a estamina mudou, a habilidade foi usada
                agiu = p.estamina != estaminaAntes;
                if (!agiu) System.out.println("Escolha outra ação.");
            } else if (opcao == 3) {
                agiu = p.usarConsumivel();
                if (!agiu) System.out.println("Escolha outra ação.");
            } else {
                System.out.println("Opção inválida.");
            }
        }
    }

    static void turnoOgro(Personagem ogro, List<Personagem> grupo) {
        System.out.println("\n--- Turno de " + ogro.nome + " ---");

        List<Personagem> vivos = new ArrayList<>();
        for (Personagem p : grupo) {
            if (p.estaVivo()) vivos.add(p);
        }
        Personagem alvo = vivos.get(random.nextInt(vivos.size()));

        int estaminaAntes = ogro.estamina;
        if (random.nextInt(100) < 50) {
            ((habilidadeEspecial) ogro).usarHabilidade(alvo);
        }
        // se não usou a habilidade (sorteio ou sem estamina), ataca normalmente
        if (ogro.estamina == estaminaAntes) {
            ogro.atacar(alvo);
        }
    }

    // ---------- Auxiliares ----------

    static boolean temVivos(List<Personagem> equipe) {
        for (Personagem p : equipe) {
            if (p.estaVivo()) return true;
        }
        return false;
    }

    static int lerInt(String mensagem) {
        System.out.print(mensagem);
        while (!scanner.hasNextInt()) {
            scanner.next();
            System.out.print("Digite um número: ");
        }
        return scanner.nextInt();
    }
}
