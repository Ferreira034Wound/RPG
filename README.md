# 🛡️ Projeto RPG Console/Sistema

Bem-vindo ao repositório do nosso sistema de **RPG**! Este projeto simula um ambiente de combate baseado em turnos, estruturado com conceitos de Programação Orientada a Objetos (POO), onde classes, atributos e métodos representam entidades e ações do jogo.

---

## 📜 Sobre o Projeto

O sistema simula confrontos entre **Heróis** e **Vilões**, gerenciando atributos vitais como vida, estamina e força, além de mecânicas de combate, habilidades especiais e itens consumíveis.

### 🎮 Mecânicas Principais
* **Ações em Combate:** Durante a batalha, os personagens podem *atacar*, *defender*, *receber dano* ou *usar um consumível*.
* **Itens Consumíveis:** Podem ser utilizados para recuperar parte da vida ou da estamina do personagem.
* **Fim de Batalha:** Ao término de cada confronto, o jogador pode visualizar o status atualizado de cada personagem.
* **Derrota:** Quando um personagem sofre dano e sua vida chega a zero ($0$), ele é considerado derrotado.

---

## 👥 Tipos de Personagens

O RPG divide-se em dois grandes lados, contendo quatro classes principais de personagens:

### 🦸 Heróis
1. **O Espartano**
   * **Estilo:** Focado em combate corpo a corpo. Possui uma armadura resistente.
   * **Atributos:** Alta força, vida moderada e poucos pontos de estamina.
   * **Habilidade Especial:** *Lança de Mil Soldados* (causa o dobro de dano).

2. **A Bruxa**
   * **Estilo:** Focado em combate à longa distância com uma grande reserva energética.
   * **Atributos:** Muita estamina, vida moderada e poucos pontos de força.
   * **Habilidade Especial:** *Rajada de Gelo* (causa dano adicional).

### 🦹 Vilões
1. **O Cyclope**
   * **Estilo:** Inimigo bruto e poderoso, porém extremamente lento.
   * **Atributos:** Pontos elevados de força e vida.
   * **Habilidade Especial:** *Ataque Devastador*.

2. **As Fúrias**
   * **Estilo:** Inimigas ágeis que atuam em grupo, exigindo baixo custo de habilidade.
   * **Atributos:** Muita estamina, mas com poucos pontos de vida.
   * **Habilidade Especial:** *Ataque Aéreo*.

---

## 🧠 Modelagem Orientada a Objetos

O projeto foi estruturado utilizando a lógica de identificadores de POO:

* **Substantivos Comuns:** Representam as **Classes** e os **Atributos** (ex: `Personagem`, `Vida`, `Estamina`, `Força`, `Armadura`).
* **Substantivos Próprios:** Representam os **Objetos** instanciados (ex: `Espartano`, `Bruxa`, `Cyclope`, `Fúrias`).
* **Verbos e Locuções Verbais:** Representam os **Métodos** ou ações (ex: `atacar()`, `defender()`, `receberDano()`, `usarConsumivel()`, `mostrarStatus()`).

---

## 🚀 Como Executar

*(Instruções de instalação, compilação e execução do código dependem da linguagem escolhida para a implementação, como Java, Python, C# ou C++).*

1. Clone este repositório:
   ```bash
   git clone https://github.com/seu-usuario/seu-repositorio-rpg.git
   ```
2. Abra o projeto na sua IDE de preferência.
3. Execute a classe principal para iniciar o sistema de combate.

---

## 🤝 Contribuindo
Contribuições, sugestões de melhorias na modelagem ou novas classes de personagens são sempre bem-vindas! Sinta-se à vontade para abrir uma *issue* ou enviar um *pull request*.