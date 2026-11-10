interface habilidadeEspecial{
    void usarHabilidade(Personagem alvo);
}

interface atacante{
    void atacar(Personagem alvo);
}

abstract class Personagem {
    protected String nome;
    protected int vida;
    protected int ataque;
    protected int estamina;

    public Personagem(String nome, int vida, int ataque, int estamina) {
        this.nome = nome;
        this.vida = vida;
        this.ataque = ataque;
        this.estamina = estamina;
    }


//Não vira interface
    public void receberDano(int valor) {
        this.vida -= valor;
        System.out.println(this.nome + " recebeu " + valor + " de dano!");

        if (this.vida <= 0) {
            System.out.println(this.nome + " foi derrotado. :/");
        }
    }

//Não viRA INTERFACE
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

class Bruxa extends Personagem {
    public Bruxa(String nome, int vida, int ataque, int estamina) {
        super(nome, vida, ataque, estamina);
        this.estamina = estamina;
    }

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
class Cyclope extends Personagem{
    public Cyclope(String nome, int vida, int ataque, int estamina){
        super(nome, vida, ataque, estamina);

    }
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
class Furia extends Personagem{
    public Furia(String nome, int vida, int ataque, int estamina){
        super(nome, vida, ataque, estamina);
    }

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

        //Objetos
public class Main{
    public static void main(String[] args) {

        //Heróis
        Espartano espartano = new Espartano("Deimos", 150, 40, 80);
        Bruxa bruxa = new Bruxa("Yen", 90, 30, 150);
        //Vilões
        Cyclope cyclope = new Cyclope("Polifemo", 200, 60, 100);
        Furia furia = new Furia("Tisífone", 70, 20, 120);
    }
}
