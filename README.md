# Conversor-de-AFND-para-AFD
Conversor simples de AFND para AFD. Exemplo de arquivo a ser lido pelo programa:
Teste.txt{
          q0,q1,q2,q3 //Estados
          0,1 //Alfabeto, o programa só aceita alfabetos de 0 e 1
          q0,0,q0 //Inicio transições
          q0,1,q0
          q0,1,q1
          q1,0,q2
          q2,1,q3
          q3,0,q3
          q3,1,q3 //Fim transições
          >q0 //Estado inicial
          *q3 //Estados finais
}
