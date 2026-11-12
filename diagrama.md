```mermaid
classDiagram
       class Personagem {
        -nome String
        -vida int
        -estamina int
        -ataque int
        +atacar(alvo)
        +receber_dano(valor)
        +mostrar_status()
        +usar_consumivel
       }

       class Espartano {
       
        +__init__(nome, vida, estamina, ataque)
        +usar_habilidade(alvo)

       }

        class Bruxa {

        +__init__(nome, vida, estamina, ataque)
        +usar_habilidade(alvo)

        }

        class Cyclope{

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
   

