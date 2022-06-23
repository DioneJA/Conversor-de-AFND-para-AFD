# Conversor-de-AFND-para-AFD
Conversor simples de AFND para AFD. Exemplo de arquivo a ser lido pelo programa:&nbsp;
Teste.txt{&nbsp;
          q0,q1,q2,q3 //Estados&nbsp;
          0,1 //Alfabeto, o programa só aceita alfabetos de 0 e 1&nbsp;
          q0,0,q0 //Inicio transições&nbsp;
          q0,1,q0&nbsp;
          q0,1,q1&nbsp;
          q1,0,q2&nbsp;
          q2,1,q3&nbsp;
          q3,0,q3&nbsp;
          q3,1,q3 //Fim transições&nbsp;
          >q0 //Estado inicial&nbsp;
          *q3 //Estados finais&nbsp;
}
