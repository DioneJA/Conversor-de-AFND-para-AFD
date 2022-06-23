# Conversor-de-AFND-para-AFD
Conversor simples de AFND para AFD. Exemplo de arquivo a ser lido pelo programa:<br>
Teste.txt{<br>
          q0,q1,q2,q3 //Estados<br>
          0,1 //Alfabeto, o programa só aceita alfabetos de 0 e 1<br>
          q0,0,q0 //Inicio transições<br>
          q0,1,q0<br>
          q0,1,q1<br>
          q1,0,q2<br>
          q2,1,q3<br>
          q3,0,q3<br>
          q3,1,q3 //Fim transições<br>
          >q0 //Estado inicial<br>
          *q3 //Estados finais<br>
}
