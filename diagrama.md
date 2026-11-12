```mermaid
classDiagram
       class Personagem {
        -nome String
        -vida int
        -estamina int
        -ataque int
        +defender
        +atacar(alvo)
        +receber_dano(valor)
        +mostrar_status()
        +usar_consumivel
       }

       class Espartano {
       
       -armadura
        +__init__(nome, vida, estamina, ataque)
        +usar_habilidade(alvo)

       }

        class Bruxa {

        -reserva
        +__init__(nome, vida, estamina, ataque)
        +usar_habilidade(alvo)

        }

        class Cyclope{

        -lentidao
        +__init__(nome, vida, estamina, ataque)

        }

        class Furia{

        -agilidade
        +__init__(nome, vida, estamina, ataque)

        }

        Personagem <|-- Espartano : herda
        Personagem <|-- Bruxa : herda
        Personagem <|-- Cyclope : herda
        Personagem <|-- Furia : herda
   

