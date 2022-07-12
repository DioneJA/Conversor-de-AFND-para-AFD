<h1>Conversor-de-AFND-para-AFD</h1>
<p>Conversor simples de AFND para AFD. Feito 100% em Java para a Disciplina de Linguagens formais e automatos.</p>
<h2>Instruções de uso: </h2>
<p><b>OBS: O programa só aceita alfabeto de 0 e 1, sendo facilmente alterável para qualquer tipo de alfabeto, desde que contenha apenas 2 itens.</b></p>
<p>- Baixe o repositório ou clone ele. Na pasta existe também um executável, para facilitar o uso.</p>
<p>- Coloque o projeto no NetBeans ou Eclipse e execute-o. Caso esteja utilizando o executável, basta apenas, executá-lo</p>
<p>- Na primeira tela, selecione o arquivo .txt com a AFND a ser lida</p>
<p><b>Exemplo de AFND no arquivo .txt a ser lido pelo programa:</b></p><br>
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
&nbsp;&nbsp;         *q3 //Estado(s) finais<br>
&nbsp;
<p> - Após isto, selecione o diretório onde será salvo o resultado (AFD) do programa.</p>
<p><b>OBS: O resultado sairá em um arquivo .txt, no mesmo padrão da AFD, o qual possui um exemplo logo acima. Na pasta do projeto está incluso um AFND e um executável do programa.</b></p>
