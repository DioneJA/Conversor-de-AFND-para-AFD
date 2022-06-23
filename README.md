# Conversor-de-AFND-para-AFD
Conversor simples de AFND para AFD. Exemplo de arquivo a ser lido pelo programa:<br>
&nbsp;Teste.txt{<br>
&nbsp;&nbsp;         q0,q1,q2,q3 //Estados<br>
&nbsp;&nbsp;         0,1 //Alfabeto, o programa só aceita alfabetos de 0 e 1<br>
&nbsp;&nbsp;         q0,0,q0 //Inicio transições<br>
&nbsp;&nbsp;         q0,1,q0<br>
&nbsp;&nbsp;         q0,1,q1<br>
&nbsp;&nbsp;         q1,0,q2<br>
&nbsp;&nbsp;         q2,1,q3<br>
&nbsp;&nbsp;         q3,0,q3<br>
&nbsp;&nbsp;         q3,1,q3 //Fim transições<br>
&nbsp;&nbsp;         >q0 //Estado inicial<br>
&nbsp;&nbsp;         *q3 //Estados finais<br>
&nbsp;}
