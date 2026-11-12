Projeto RPG Console/Sistema

Bem-vindo ao repositório do nosso sistema de RPG! Este projeto simula um ambiente de combate baseado em turnos, estruturado com conceitos de Programação Orientada a Objetos (POO), onde classes, atributos e métodos representam entidades e ações do jogo.

Sobre o Projeto

O sistema simula uma batalha em rodadas em que um grupo de quatro personagens enfrenta juntos um Ogro chefe, inimigo de todos. Cada personagem gerencia atributos como vida, estamina e ataque, além de habilidades especiais e de um item consumível de cura.

🎮 Mecânicas Principais
Turnos: a batalha acontece em rodadas. Em cada rodada, cada personagem vivo joga na sua vez (controlado pelo jogador) e, depois, o Ogro joga (controlado pelo computador).
Ações em Combate: no seu turno, o personagem pode atacar, usar a habilidade especial ou usar um consumível de cura.
Habilidades Especiais: gastam estamina. Se a estamina for insuficiente, o jogador escolhe outra ação.
Item Consumível (cura): recupera 40 pontos de vida, sem ultrapassar a vida inicial. Cada personagem possui 2 poções.
Derrota: quando um personagem sofre dano e sua vida chega a zero (0), ele é considerado derrotado.
Fim de Batalha: a batalha termina quando o Ogro é derrotado ou quando todo o grupo cai. O status de cada personagem é exibido no início de cada rodada.
👥 Personagens

Todos os personagens do grupo lutam do mesmo lado contra o Ogro. Os nomes abaixo são apenas dos personagens, não há separação entre heróis e vilões.

Classe	Personagem	Vida	Ataque	Estamina	Habilidade Especial	Custo
Espartano	Deimos	150	40	80	Lança de Mil Soldados (dobro de dano)	35
Bruxa	Yen	90	30	150	Rajada de Gelo (dano adicional)	20
Cyclope	Polifemo	200	60	100	Ataque Devastador	50
Fúria	Tisífone	70	20	120	Ataque Aéreo	5
Ogro (chefe)	Grumash	500	35	200	Pancada Esmagadora	30
Espartano: focado em combate corpo a corpo, com alta força, vida moderada e poucos pontos de estamina.
Bruxa: focada em combate à longa distância, com muita estamina, vida moderada e poucos pontos de força.
Cyclope: bruto e poderoso, com pontos elevados de força e vida.
Fúria: ágil, com muita estamina e pouca vida. Sua habilidade tem baixo custo.
Ogro: o chefe da batalha, com muita vida. Ataca um personagem aleatório a cada turno.
Modelagem Orientada a Objetos

O projeto foi estruturado utilizando a lógica de identificadores de POO:

Substantivos Comuns: representam as Classes e os Atributos (ex: Personagem, vida, estamina, ataque, curas).
Substantivos Próprios: representam os Objetos instanciados (ex: Deimos, Yen, Polifemo, Tisífone, Grumash).
Verbos e Locuções Verbais: representam os Métodos ou ações (ex: atacar(), receberDano(), usarConsumivel(), mostrarStatus(), usarHabilidade(), estaVivo()).

Estrutura de classes:

Personagem (classe abstrata, implementa a interface atacante) é a base de todos.
Espartano, Bruxa, Cyclope, Furia e Ogro herdam de Personagem e implementam a interface habilidadeEspecial.
Main controla as rodadas e os turnos (turnoJogador, turnoOgro).

O diagrama de classes está em diagrama.md.

Como Executar

O projeto é escrito em Java (é necessário ter o JDK instalado).

Clone este repositório:
git clone https://github.com/Ferreira034Wound/RPG
Abra a pasta do projeto no VS Code (ou na sua IDE de preferência).
Compile e execute pelo terminal:
javac Main.java
java Main
Durante a batalha, digite o número da ação desejada (1 - Atacar, 2 - Habilidade, 3 - Consumível) e pressione Enter. 
